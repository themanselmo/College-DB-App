package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// "Master Bag" for courses in the college
// each student should refer to the index in their course
// bags (being the name of the class) and then search through
// the master bag for the course and its information
public class CourseBag implements Serializable{

	private Course[] cArray;
	private int nElems;

	// constructor for the CourseBag class
	public CourseBag(int maxSize) {
		nElems = 0;
		cArray = new Course[maxSize];
	}

	// method to add courses to the array
	public void add(Course course) {
		cArray[nElems++] = course;
	}

	public Course findByCourseNumber(String courseNumber) {
		int indexAt = -1;
		for (int i = 0; i < nElems; i++) {
			if (cArray[i].getCourseNumber().equals(courseNumber)) {
				indexAt = i;
			}
		}
		if (indexAt == -1) {
			return null;
		} else {
			return cArray[indexAt];
		}
	}

	public Course removeByCourseNumber(String courseNumber) {
		int indexAt = -1;
		for (int i = 0; i < nElems; i++) {
			if (cArray[i].getCourseNumber().equals(courseNumber)) {
				indexAt = i;
			}
		}
		if (indexAt == -1) {
			return null;
		} else {
			Course temp = cArray[indexAt];
			for (int j = indexAt; j < nElems; j++) {
				cArray[j] = cArray[j + 1];
			}
			nElems--;
			return temp;
		}
	}

	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.println(cArray[i]);
		}
	}

	public int getNumberOfCreds(int index) {
		return cArray[index].getNumberOfCredits();
	}

	public String getCourseNumber(int index) {
		return cArray[index].getCourseNumber();
	}

	public int getLengthOfBag() {
		return nElems;
	}
	
	public void save() {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("Data/CourseBag.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(cArray);
			oos.writeObject(nElems);
			oos.close();
		} catch (IOException e) {
			Tools.failureAlert("Falure saving file...");
		}
	}

	public void load() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("Data/CourseBag.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			cArray = (Course[]) (ois.readObject());
			nElems = (int) (ois.readObject());
			ois.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			Tools.failureAlert("Falure loading file...");
		} catch (ClassNotFoundException e) {
		}
	}
}
