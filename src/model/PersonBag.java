package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

public class PersonBag implements Serializable {

	private Person[] personArray;
	private int nElems;

	// constructor for creating a PersonBag object with a max size
	public PersonBag(int maxSize) {
		nElems = 0;
		personArray = new Person[maxSize];
	}

	// adds a new person to the bag and increases the number
	// of elements
	public void insert(Person person) {
		personArray[nElems++] = person;
	}

	// returns the person found by comparing
	// the id's of each person throughout the array
	public Person findById(String id) {
		int indexAt = -1;
		for (int i = 0; i < nElems; i++) {
			if (personArray[i].getId().equals(id)) {
				indexAt = i;
			}
			if (indexAt == -1) {
				return null;
			}
		}
		return personArray[indexAt];
	}

	// finds student by given id number
	public Person findStudentById(String id) {
		int indexAt = -1;
		for (int i = 0; i < nElems; i++) {
			if (personArray[i].getClass().equals(Student.class)) {
				if (personArray[i].getId().equals(id)) {
					indexAt = i;
				}
			}
			if (indexAt == -1) {
				return null;
			}
		}
		return personArray[indexAt];

	}

	// returns the person found with the matching id
	// then goes through the remainder of the array
	// moving each element left 1 and finally cutting
	// the size of nElems by 1.
	public Person removeById(String id) {
		int indexAt = -1;
		for (int i = 0; i < nElems; i++) {
			if (personArray[i].getId().equals(id)) {
				indexAt = i;
			}
		}
		if (indexAt == -1) {
			return null;
		} else {
			Person temp = personArray[indexAt];
			for (int j = indexAt; j < nElems; j++) {
				personArray[j] = personArray[j + 1];
			}
			nElems--;
			return temp;
		}

	}

	// displays each object in the array
	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.println(personArray[i] + ", id= " + personArray[i].getId());
		}
	}
	
	// displays students in the consol
	public void displayStudents() {
		for (int i = 0; i < nElems; i++) {
			if (personArray[i].getClass() == Student.class) {
				System.out.println(personArray[i].getName() + ", id= " + personArray[i].getId());
			}
		}
	}

	public String StudentArrayToString() {
		String value = "";
		
		for(int i = 0; i < nElems; i++) {
			value+=personArray[i] + "\n";
		}
		
		return value;
	}
	
	public void displayFaculty() {
		for (int i = 0; i < nElems; i++) {
			if (personArray[i].getClass() == Faculty.class) {
				System.out.println(personArray[i].getName() + ", id= " + personArray[i].getId());
			}
		}
	}

	// returns a copy of the array
	public Person[] getPersonArray() {
		return Arrays.copyOf(personArray, nElems);
	}

	public void save() {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("Data/PersonBag.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(personArray);
			oos.writeObject(nElems);
			oos.close();
		} catch (IOException e) {
			Tools.failureAlert("Falure saving file...");
			e.printStackTrace();
		}
	}

	public void load() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("Data/PersonBag.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			personArray = (Person[]) (ois.readObject());
			nElems = (int) (ois.readObject());
			ois.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			Tools.failureAlert("Falure loading file...");
		} catch (ClassNotFoundException e) {
		}
	}
}
