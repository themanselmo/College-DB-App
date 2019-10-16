package model;
 import java.io.Serializable;
// account for grades A+, A-, etc when calculating grades
import java.util.Arrays;

public class Student extends Person implements Serializable {

	private String major;
	private Grade[] coursesTook;
	private int numTaken;
	private Grade[] coursesTaking;
	private int numTaking;
	private Grade[] coursesToTake;
	private int numToTake;
	private CourseBag[] bagOCourses;

	// main constructor
	public Student(Name name, String phone, Address address, String major) {
		super(name, phone, address);
		this.major = major;
		this.coursesTook = new Grade[5];
		numTaken = 0;
		this.coursesTaking = new Grade[5];
		numTaking = 0;
		this.coursesToTake = new Grade[5];
		numToTake = 0;
	}

	// returns a deep copy
	public Student(Student student) {
		super(student.getName(), student.getPhone(), student.getAddress());
		setId(student.getId());
		this.major = student.getMajor();
		this.coursesTook = student.getCoursesTook();
		this.coursesTaking = student.getCoursesTaking();
		this.coursesToTake = student.getCoursesToTake();
	}

	// getters & setters
	public CourseBag[] getBagOCourses() {
		return bagOCourses;
	}

	public void setBagOCourses(CourseBag[] bagOCourses) {
		this.bagOCourses = bagOCourses;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	// taken course methods
	public Grade[] getCoursesTook() {
		return coursesTook;
	}

	public void setCoursesTook(Grade[] coursesTook) {
		this.coursesTook = coursesTook;
	}

	public void addTakenCourse(Grade takenCourse) {
		coursesTook[numTaken++] = takenCourse;
	}

	public void displayCoursesTook() {
		System.out.println(this.getName().getFirstName() + " completed the following:");
		for (int i = 0; i < coursesTook.length; i++) {
			System.out.print(coursesTook[i] + " ");
		}
		System.out.println("\n");
	}

	// current course methods
	public Grade[] getCoursesTaking() {
		return coursesTaking;
	}

	public void setCoursesTaking(Grade[] coursesTaking) {
		this.coursesTaking = coursesTaking;
	}

	public void addCurrentCourse(Grade currentCourse) {
		coursesTaking[numTaking++] = currentCourse;
	}

	public void displayCoursesTaking() {
		System.out.println(this.getName().getFirstName() + "'s classes currently are:");
		for (int i = 0; i < coursesTaking.length; i++) {
			System.out.print(coursesTaking[i] + " ");
		}
		System.out.println("\n");
	}

	// future course methods
	public Grade[] getCoursesToTake() {
		return coursesToTake;
	}

	public void setCoursesToTake(Grade[] coursesToTake) {
		this.coursesToTake = coursesToTake;
	}

	public void addFutureCourse(Grade futureCourse) {
		coursesToTake[numToTake++] = futureCourse;
	}

	public void displayCoursesToTake() {
		System.out.println(this.getName().getFirstName() + " has to take these courses:");
		for (int i = 0; i < coursesToTake.length; i++) {
			System.out.print(coursesToTake[i] + " ");
		}
		System.out.println("\n");
	}

	// getCredits method to calculate number of credits
	// taken, taking, and needs to take
	public int getCredits(Grade[] array, CourseBag courseBag) {
		int numberOfCredits = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null) {
				String course = array[i].getCourseNumber();
				for (int j = 0; j < courseBag.getLengthOfBag(); j++) {
					if (course.equals(courseBag.getCourseNumber(j))) {
						numberOfCredits += courseBag.getNumberOfCreds(j);
					}
				}
			}
		}
		return numberOfCredits;
	}

	// getGPA method to calculate the students GPA based
	// off of their coursesTook array
	public double getGPA(Grade[] coursesTook, CourseBag courseBag) {
		double GPA = 0.0;
		double totalPoints = 0;
		double credits = getCredits(coursesTook, courseBag);
		for (int i = 0; i < coursesTook.length; i++) {
			if (coursesTook[i] != null) {
				double letterGToNumber;
				if (coursesTook[i].getCourseLetterGrade().equals("A+")) {
					letterGToNumber = 4.0;
				} else if (coursesTook[i].getCourseLetterGrade().equals("A")) {
					letterGToNumber = 3.5;
				} else if (coursesTook[i].getCourseLetterGrade().equals("B+")) {
					letterGToNumber = 3.0;
				} else if (coursesTook[i].getCourseLetterGrade().equals("B-")) {
					letterGToNumber = 2.5;
				} else if (coursesTook[i].getCourseLetterGrade().equals("C")) {
					letterGToNumber = 2.0;
				} else if (coursesTook[i].getCourseLetterGrade().equals("C-")) {
					letterGToNumber = 1.5;
				} else if (coursesTook[i].getCourseLetterGrade().equals("D")) {
					letterGToNumber = 1.0;
				} else {
					letterGToNumber = 0.0;
				}
				totalPoints += letterGToNumber
						* getCreditForCourse(coursesTook[i].getCourseNumber(), coursesTook, courseBag);
			}
		}
		GPA = totalPoints / credits;
		
		return GPA;
	}

	public int getCreditForCourse(String courseNumber, Grade[] array, CourseBag courseBag) {
		int creditForCourse = 0;
		for (int j = 0; j < courseBag.getLengthOfBag(); j++) {
			if (courseNumber.equals(courseBag.getCourseNumber(j))) {
				creditForCourse = courseBag.getNumberOfCreds(j);
			}
		}
		return creditForCourse;
	}

	@Override
	public String toString() {
		return "Student [major=" + major + ", coursesTook=" + Arrays.toString(coursesTook) + ", coursesTaking="
				+ Arrays.toString(coursesTaking) + ", coursesToTake=" + Arrays.toString(coursesToTake) + "]";
	}

}
