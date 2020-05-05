/** 
 * Book is a class for book details created from the title, year and
 * isbn identification.
 * 
 * We establish three field variables:
 * title, a string for the book's title
 * year, an int for the year the book was released
 * isbn, a string for the books unique identifier
 * 
 * @author Chirag Bhatti
 * @version 20/10/2018
 */

public class Book {
	private String title;
	private int year;
	private String isbn;
	
	/** 
	 * Book is a constructor for a simple book created with the details:
	 * 
	 * @param title is the name of the book as String
	 * @param year is the year the book was released as int
	 * @param isbn is the unique identification code as String
	 */
	
	public Book (String title, int year, String isbn) {
		this.title 	= title;
		this.year 	= year;
		this.isbn 	= isbn;
	}
	
	/* 
	 * Getters to obtain parts of the details of a Book
	 */
	
	/**
	 * @return the title of a Book as String
	 */
	public String getTitle() {
		return title;
	}
	
	/** 
	 * @return the year the Book was released as int
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * @return the isbn code of the Book as String
	 */
	public String getIsbn() {
		return isbn;
	}
	
	/*
	 * Setters to set the details of a Book
	 */
	
	/**
	 * Sets the title of a Book
	 * @param title
	 */
	public void setTitle (String title) {
		this.title = title;
	}
	
	/** 
	 * Sets the year of a Book
	 * @param year
	 */
	public void setYear (int year) {
		this.year = year;
	}
	
	/**
	 * Sets the isbn code of a Book
	 * @param isbn
	 */
	public void setIsbn (String isbn) {
		this.isbn = isbn;
	}
	
	/**
	 * toString to define how to print Book details
	 * @return the print type of a Book
	 */
	public String toString() {
		return "Book title: " + title + " \u007c" + " Book year: " + year + " \u007c" + " Book isbn " + isbn;
	}
	
}
