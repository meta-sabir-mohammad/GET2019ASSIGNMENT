package com.bookstore.controller;

import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.bookstore.dto.Book;
import com.bookstore.service.BookStoreService;

/**
 * This is controller class for book store
 * This class contain all rest methods
 * @author Sabir
 *
 */
@Path("/Book")
public class BookStoreController {
	
	/**
	 * This REST method find and return book for given title
	 * @param title title of book
	 * @return object of book as JSON
	 * @throws Exception exception related to database, other general exception
	 */
	@GET
	@Path("/get/{title}")
	@Produces(MediaType.APPLICATION_JSON)
	public Book getBookByTitle(@PathParam("title") String title) throws Exception{
		
		BookStoreService bookStoreService = BookStoreService.getInstance();
		try {
			return bookStoreService.getBookByTitle(title);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * This REST method returns all books
	 * @return List of books as JSON
	 * @throws Exception exception related to database, other general exception
	 */
	@GET
	@Path("/getall")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getAllBooks() throws Exception{
		
		BookStoreService bookStoreService = BookStoreService.getInstance();
		try {
			return bookStoreService.getAllBooks();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * This REST method add book
	 * @param book object of book which need to be added
	 * @return true if added else false
	 * @throws Exception exception related to database, other general exception
	 */
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean addBook(Book book) throws Exception{
		
		BookStoreService bookStoreService = BookStoreService.getInstance();
		try {
			return bookStoreService.addBook(book);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * This REST method delete book by id
	 * @param id id of book
	 * @return true if book deleted else false
	 * @throws Exception exception related to database, other general exception
	 */
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean deleteBookById(@PathParam("id") int id) throws Exception{
		
		BookStoreService bookStoreService = BookStoreService.getInstance();
		try {
			return bookStoreService.deleteBookById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * This REST method delete all books
	 * @return true if all books deleted else false
	 * @throws Exception exception related to database, other general exception 
	 */
	@DELETE
	@Path("/deleteall")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean deleteAllBooks() throws Exception{
		
		BookStoreService bookStoreService = BookStoreService.getInstance();
		try {
			return bookStoreService.deleteAllBooks();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}