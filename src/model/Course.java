package model;

import java.io.Serializable;

public class Course implements Serializable {

	private String courseTitle;
	private String courseNumber;
	private String textbookISBN;
	private int numberOfCredits;
	private String facultyID;

	// main constructor
	public Course(String courseTitle, String courseNumber, String textbookISBN, int numberOfCredits, String facultyID) {
		super();
		this.courseTitle = courseTitle;
		this.courseNumber = courseNumber;
		this.textbookISBN = textbookISBN;
		this.numberOfCredits = numberOfCredits;
		this.facultyID = facultyID;
	}

	// returns a deep copy
	public Course(Course course) {
		this.courseTitle = course.getCourseTitle();
		this.courseNumber = course.getCourseNumber();
		this.textbookISBN = course.getTextbookISBN();
		this.numberOfCredits = course.getNumberOfCredits();
		this.facultyID = course.getFacultyID();
	}

	// getters & setters
	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getTextbookISBN() {
		return textbookISBN;
	}

	public void setTextbookISBN(String textbookISBN) {
		this.textbookISBN = textbookISBN;
	}

	public int getNumberOfCredits() {
		return numberOfCredits;
	}

	public void setNumberOfCredits(int numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}

	public String getFacultyID() {
		return facultyID;
	}

	public void setFacultyID(String facultyID) {
		this.facultyID = facultyID;
	}

	@Override
	public String toString() {
		return "Course [courseTitle=" + courseTitle + ", courseNumber=" + courseNumber + ", textbookISBN="
				+ textbookISBN + ", numberOfCredits=" + numberOfCredits + ", facultyID=" + facultyID + "]";
	}

}
