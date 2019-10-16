package model;

import java.io.Serializable;
import java.util.Scanner;

public class Person implements Serializable{

	private Name name;
	private String id;
	private String phone;
	private Address address;
	private static int idCounter = 1;
	private Scanner scan = new Scanner(System.in);

	// main constructor
	public Person(Name name, String phone, Address address) {
		super();
		this.id = String.valueOf(idCounter++);
		this.address = address;
		this.name = name;
		boolean b = isValidPhoneNumber(phone);
		while (b == false) {
			this.phone = checkPhone(phone);
			if (isValidPhoneNumber(this.phone)) {
				b = true;
			}
		}
		if (b == true) {
			this.phone = phone.replaceAll("[(]?(\\d{3})[)]?[.-]?(\\d{3})[-.]?(\\d{4})", "($1)$2-$3");
		}

	}

	// returns a deep copy
	public Person(Person person) {
		this.name = person.getName();
		this.id = person.getId();
		this.phone = person.getPhone();
		this.address = person.getAddress();
	}

	public Person(String firstName, String lastName) {
		this.name = new Name(firstName, lastName, " ");
	}

	// method that checks if the phone number entered is correct
	// and formats it properly
	public String checkPhone(String phone) {
		try {
			if (phone.matches("[(]?(\\d{3})[)]?[.-]?(\\d{3})[-.]?(\\d{4})") == false) {
				throw new IncorrectPhoneNumberException("Input a correct phone number please: ");
			}
		} catch (IncorrectPhoneNumberException e) {
			System.out.println(e.getMessage());
			phone = scan.nextLine();
			phone = phone.replaceAll("[(]?(\\d{3})[)]?[.-]?(\\d{3})[-.]?(\\d{4})", "($1)$2-$3");
		}
		return phone;
	}

	// simply returns if the phone entered is valid or not
	public boolean isValidPhoneNumber(String phone) {
		if (phone.matches("[(]?(\\d{3})[)]?[.-]?(\\d{3})[-.]?(\\d{4})") == true) {
			return true;
		} else {
			return false;
		}
	}

	// getters & setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", phone=" + phone + ", address=" + address + "]";
	}

}
