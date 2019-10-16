package model;

public class Name {

	private String firstName;
	private String lastName;
	private String middleInitial;

	// main constructor
	public Name(String firstName, String lastName, String middleInitial) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleInitial = middleInitial;
	}

	// returning a deep copy
	public Name(Name name) {
		this.firstName = name.getFirstName();
		this.lastName = name.getLastName();
		this.middleInitial = name.getMiddleInitial();
	}

	// getters & setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	@Override
	public String toString() {
		return "Name [firstName=" + firstName + ", lastName=" + lastName + ", middleInitial=" + middleInitial + "]";
	}

}
