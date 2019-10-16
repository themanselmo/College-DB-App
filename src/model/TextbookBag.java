package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TextbookBag implements Serializable {

	private Textbook[] TBArray;
	private int nElems;

	// bag constructor
	public TextbookBag(int maxSize) {
		nElems = 0;
		TBArray = new Textbook[maxSize];
	}

	// method to add a book to the bag
	public void add(Textbook textBook) {
		TBArray[nElems++] = textBook;
	}

	// finds textbook by comparing isbn numbers
	// throughout the array
	public Textbook findByISBN(String isbn) {
		int indexAt = -1;
		for (int i = 0; i < nElems; i++) {
			if (TBArray[i].getIsbn().equals(isbn)) {
				indexAt = i;
			}
		}
		if (indexAt == -1) {
			return null;
		} else {
			return TBArray[indexAt];
		}
	}

	// finds textbook by comparing isbn numbers
	// throughout the array and then removes it by copying
	// the element at j+1 over the element at j
	// and finally cutting nElems length by 1
	public Textbook removeByISBN(String isbn) {
		int indexAt = -1;
		for (int i = 0; i < nElems; i++) {
			if (TBArray[i].getIsbn().equals(isbn)) {
				indexAt = i;
			}
		}
		if (indexAt == -1) {
			return null;
		} else {
			Textbook temp = TBArray[indexAt];
			for (int j = indexAt; j < nElems; j++) {
				TBArray[j] = TBArray[j + 1];
			}
			nElems--;
			return temp;
		}
	}

	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.println(TBArray[i]);

		}
	}

	public void save() {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("Data/TextbookBag.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(TBArray);
			oos.writeObject(nElems);
			oos.close();
		} catch (IOException e) {
			Tools.failureAlert("Falure saving file...");
		}
	}

	public void load() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("Data/TextbookBag.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			TBArray = (Textbook[]) (ois.readObject());
			nElems = (int) (ois.readObject());
			ois.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			Tools.failureAlert("Falure loading file...");
		} catch (ClassNotFoundException e) {
		}
	}
}
