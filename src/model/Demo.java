// College Organizer
// Written by Max E. Anselmo
// 11-7-2017

package model;

public class Demo {

	public static void main(String[] args) {

		// course objects
//		Course cse100 = new Course("Programming Fundamentals", "100", "1234", 4, "1");
//		Course cse200 = new Course("Object Oriented Programming", "200", "1235", 4, "1");
//		Course cse300 = new Course("Data Structures", "300", "1236", 4, "1");
//		Course mat101 = new Course("Algebra", "101", "2234", 3, "2");
//		Course mat201 = new Course("PreCalc", "201", "2235", 3, "2");
//		Course mat301 = new Course("Calculus", "301", "2236", 4, "2");
//		Course cst102 = new Course("Introduction to C++", "102", "3234", 3, "3");
//		Course cst202 = new Course("Advanced C#", "202", "3235", 4, "3");
//		Course cst302 = new Course("Video Game Programming", "302", "3236", 4, "3");

		// demonstrating the CourseBag Class
//		CourseBag bagOfCourses = new CourseBag(10);
//		bagOfCourses.add(cse100);
//		bagOfCourses.add(cse200);
//		bagOfCourses.add(cse300);
//		bagOfCourses.add(mat101);
//		bagOfCourses.add(mat201);
//		bagOfCourses.add(mat301);
//		bagOfCourses.add(cst102);
//		bagOfCourses.add(cst202);
//		bagOfCourses.add(cst302);
		// System.out.println("-------------------------");
		// System.out.println("The course bag demo:");
		// bagOfCourses.display();
		// System.out.println();
		// System.out.println(bagOfCourses.findByCourseNumber("100"));
		// System.out.println();
		// bagOfCourses.removeByCourseNumber("100");
		// bagOfCourses.display();
		// System.out.println("--------------------------");

		// faculty objects
//		Name facultyName1 = new Name("Ben", "Chen", 'A');
//		Address facultyAddress1 = new Address("100", "Coding Lane", "BetaVille", "XQ", "12345");
//		Faculty f1 = new Faculty(facultyName1, "1234565321", facultyAddress1, "23 office lane", 9000000, "Professor");
//		Name facultyName2 = new Name("Carlos", "Falcon", 'E');
//		Address facultyAddress2 = new Address("67", "Longwood Road", "Middle Island", "NY", "11412");
//		Faculty f2 = new Faculty(facultyName2, "6312324521", facultyAddress2, "25 office lane", 100000, "Professor");
//		Name facultyName3 = new Name("Sean", "Hughes", 'M');
//		Address facultyAddress3 = new Address("45", "Cisco Avenue", "Bellport", "NY", "11123");
//		Faculty f3 = new Faculty(facultyName3, "6316782456", facultyAddress3, "67 office lane", 20,
//				"High School Teacher");

		// student objects
//		Name studentName1 = new Name("Max", "Anselmo", 'E');
//		Address studentAddress1 = new Address("23", "Wakefield Avenue", "Coram", "NY", "11727");
//		Student s1 = new Student(studentName1, "6311234567", studentAddress1, "CS");
//		System.out.println(s1.getPhone());
//		Grade p1c1 = new Grade("100", "A");
//		Grade p1c2 = new Grade("101", "B");
//		Grade p1c3 = new Grade("102", "A");
//		s1.addTakenCourse(p1c1);
//		s1.addTakenCourse(p1c2);
//		s1.addTakenCourse(p1c3);
//		// s1.displayCoursesTook();
//		Grade p1c4 = new Grade("200", "C");
//		Grade p1c5 = new Grade("201", "A");
//		Grade p1c6 = new Grade("202", "B");
//		s1.addCurrentCourse(p1c4);
//		s1.addCurrentCourse(p1c5);
//		s1.addCurrentCourse(p1c6);
//		// s1.displayCoursesTaking();
//		Grade p1c7 = new Grade("300", "A");
//		Grade p1c8 = new Grade("301", "A");
//		Grade p1c9 = new Grade("302", "A");
//		s1.addFutureCourse(p1c7);
//		s1.addFutureCourse(p1c8);
//		s1.addFutureCourse(p1c9);
		// s1.displayCoursesToTake();
		// System.out.println(s1.getCredits(s1.getCoursesTook(), bagOfCourses));
		// System.out.println(s1.getGPA(s1.getCoursesTook(), bagOfCourses));
//		Name studentName2 = new Name("Brianna", "Gonclaves", 'L');
//		Address studentAddress2 = new Address("12", "Dreamland Road", "Ridge", "NY", "11232");
//		Student s2 = new Student(studentName2, "6312223142", studentAddress2, "PSY");
		// s2.displayCoursesTook();
		// s2.displayCoursesTaking();
		// s2.displayCoursesToTake();
//		Name studentName3 = new Name("Andres", "Cerquera", 'D');
//		Address studentAddress3 = new Address("13", "Halliday Road", "Coram", "NY", "11727");
//		Student s3 = new Student(studentName3, "6311234567", studentAddress3, "CST");
		// s3.displayCoursesTook();
		// s3.displayCoursesTaking();
		// s3.displayCoursesToTake();

		// demonstrating the PersonBag Class
//		PersonBag bagOfPersons = new PersonBag(10);
//		bagOfPersons.insert(s1);
//		bagOfPersons.insert(s2);
//		bagOfPersons.insert(s3);
//		bagOfPersons.insert(f1);
//		bagOfPersons.insert(f2);
//		bagOfPersons.insert(f3);
		// System.out.println("------------------------");
		// System.out.println("The person bag demo:");
		// bagOfPersons.display();
		// System.out.println();
		// System.out.println(bagOfPersons.findById("0"));
		// bagOfPersons.removeById("1");
		// System.out.println();
		// bagOfPersons.display();
		// System.out.println("------------------------");

		// demonstrating the TextbookBag Class
//		Name author1 = new Name("Java", "Man", 'O');
//		Textbook TB1 = new Textbook("Advanced Java", author1, "JavaInc", "1234", 100.0);
//		Name author2 = new Name("C#", "Man", 'Q');
//		Textbook TB2 = new Textbook("Advanced C#", author2, "C#Inc", "4567", 50.0);
//		TextbookBag bagOfBooks = new TextbookBag(10);
//		bagOfBooks.add(TB1);
//		bagOfBooks.add(TB2);
		// System.out.println("------------------------");
		// System.out.println("The textbook bag demo:");
		// bagOfBooks.display();
		// System.out.println();
		// System.out.println(bagOfBooks.findbyIsbn("1234"));
		// System.out.println();
		// bagOfBooks.removeByIsbn("1234");
		// bagOfBooks.display();
		// System.out.println("------------------------");

//		System.out.println(bagOfPersons.findById("2").getName());
		
		
		
	}
}
