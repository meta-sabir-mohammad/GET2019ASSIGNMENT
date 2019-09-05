package com.bookstore.dto;

/**
 * This represent book
 * @author Sabir
 *
 */
public class Book {

	//This represent id of book
	private int id;
	//This represent title of book
	private String title;
	//This represent writer of book
	private String writer;
	//This represent publisher of book
	private String publisher;
	//This represent published year of book
	private int publishedYear;
	
	/**
	 * This method return id of book
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * This method set the id of book
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * This method return title of book
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * This method set the title of book
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * This method return writer of book
	 * @return the writer
	 */
	public String getWriter() {
		return writer;
	}
	
	/**
	 * This method set the writer of book
	 * @param writer the writer to set
	 */
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	/**
	 * This method return the publisher of book
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}
	
	/**
	 * This method set the publisher of book
	 * @param publisher the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	/**
	 * This method return the published year of book
	 * @return the publishedYear
	 */
	public int getPublishedYear() {
		return publishedYear;
	}
	
	/**
	 * This method set the published year of book
	 * @param publishedYear the publishedYear to set
	 */
	public void setPublishedYear(int publishedYear) {
		this.publishedYear = publishedYear;
	}
}
