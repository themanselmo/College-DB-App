package model;
import java.util.Scanner;
public class Address {
	private String streetNumber;
	private String streetName;
	private String city;
	private String state;
	private String zip;
	private Scanner scan = new Scanner(System.in);
	
	// main constructor
	public Address(String streetNumber, String streetName, String city, String state, String zip) {
		super();
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		boolean b = isValidZipcode(zip);
		while (b == false) {
			this.zip = checkZip(zip);
			if(isValidZipcode(this.zip)) {
				b = true;
			}
		}
	}

	// returns a deep copy
	public Address(Address address) {
		this.streetNumber = address.getStreetNumber();
		this.streetName = address.getStreetName();
		this.city = address.getCity();
		this.state = address.getState();
		this.zip = address.getZip();
	}

	public String checkZip(String zip) {
	String newZip;
	try {
		if(zip.length() != 4) {
			throw new IncorrectZipCodeException("Input a correct Zipcode please: ");
		} else {
			newZip = zip;
		}
	} catch (IncorrectZipCodeException e) {
		System.out.println(zip);
		System.out.println(e.getMessage());
		newZip = scan.nextLine();
	}
	return newZip;
		
	}
	
	public boolean isValidZipcode(String zip) {
		if(zip.length() == 5) {
			return true;
		} else {
			return false;
		}
	}
	
	// getters & setters
	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "Address [streetNumber=" + streetNumber + ", streetName=" + streetName + ", city=" + city + ", state="
				+ state + ", zip=" + zip + "]";
	}

}
