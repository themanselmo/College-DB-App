package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TESTING {

	public static void main(String[] args) {
		
		PersonBag pBag = new PersonBag(10);
		File studentData = new File("Data/Students.txt");
		if(studentData != null) {
			try {
				Scanner scanner = new Scanner(studentData);
				while (scanner.hasNextLine()) {
					String line = scanner.nextLine();
					String[] nameTokens = line.split("[ ]+");
					Name name = new Name(nameTokens[0], nameTokens[1], nameTokens[2]);
					String phone = scanner.nextLine();
					String tempAddress = scanner.nextLine();
					String[] addressTokens = tempAddress.split("[,]+");
					String streetNumber = tempAddress.substring(0, tempAddress.indexOf(" "));
					Address address = new Address(streetNumber, addressTokens[0], addressTokens[1],
							addressTokens[2], addressTokens[3].trim());
					String major = scanner.nextLine();
					Student s = new Student(name, phone, address, major);
					pBag.insert(s);
				}
			} catch (FileNotFoundException e1) {	
				Tools.failureAlert("Failed to import file...");
			}
		}
		
		pBag.displayStudents();
	}

}
