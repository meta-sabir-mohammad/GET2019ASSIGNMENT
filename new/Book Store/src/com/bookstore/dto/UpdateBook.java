package com.bookstore.dto;

/**
 * This class contain details for book update
 * @author Sabir
 *
 */
public class UpdateBook {

	//This represent id of book
	private int id;
	//This represent publisher of book
	private String publisher;

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
	 * This method return publisher of book
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
	
}
