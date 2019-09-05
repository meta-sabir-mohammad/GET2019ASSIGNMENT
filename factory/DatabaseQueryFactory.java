package com.bookstore.factory;

/**
 * This is database query factory class
 * @author Sabir
 *
 */
public class DatabaseQueryFactory {

	//This query find and return book by title
	public static final String GET_BOOK_BY_TITLE = "{CALL getBookByTitle(?)}";
	//This query return all books
	public static final String GET_ALL_BOOKS = "{CALL getAllBooks()}";
	//This query add book
	public static final String ADD_BOOK = "{CALL addBook(?,?,?,?)}";
	//This query delete book by id
	public static final String DELETE_BOOK_BY_ID = "{CALL deleteBook(?)}";
	//This query delete all books
	public static final String DELETE_ALL_BOOK = "{CALL deleteAllBook()}";
}
