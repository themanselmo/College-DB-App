package model;

import java.io.Serializable;

public class Textbook implements Serializable {

	private String title;
	private Name author;
	private String publisher;
	private String isbn;
	private double price;

	// main constructor
	public Textbook(String title, Name author, String publisher, String isbn, double price) {
		super();
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.isbn = isbn;
		this.price = price;
	}

	// returns a deep copy
	public Textbook(Textbook textbook) {
		this.title = textbook.getTitle();
		this.author = textbook.getAuthor();
		this.publisher = textbook.getPublisher();
		this.isbn = textbook.getIsbn();
		this.price = textbook.getPrice();
	}

	// getters & setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Name getAuthor() {
		return author;
	}

	public void setAuthor(Name author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Textbook [title=" + title + ", author=" + author + ", publisher=" + publisher + ", isbn=" + isbn
				+ ", price=" + price + "]";
	}

}
