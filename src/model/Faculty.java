package model;

import java.io.Serializable;

public class Faculty extends Person implements Serializable {

	private Address officeAddress;
	private double salary;
	private String title;

	// main constructor
	public Faculty(Name name, String phone, Address address, Address officeAddress, double salary, String title) {
		super(name, phone, address);
		this.officeAddress = officeAddress;
		this.salary = salary;
		this.title = title;
	}

	// returns a deep copy
	public Faculty(Faculty faculty) {
		super(faculty.getName(), faculty.getPhone(), faculty.getAddress());
		setId(faculty.getId());
		this.officeAddress = faculty.getOfficeAddress();
		this.salary = faculty.getSalary();
		this.title = faculty.getTitle();
	}

	// getters & setters
	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Faculty [officeAddress=" + officeAddress + ", salary=" + salary + ", title=" + title + "]";
	}

}
