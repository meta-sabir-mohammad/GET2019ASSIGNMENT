package com.metacube.shoppingAppAPI.rest;

import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.metacube.shoppingAppAPI.model.Category;
import com.metacube.shoppingAppAPI.model.Product;
import com.metacube.shoppingAppAPI.service.Service;
@Path("/request")
public class RestAPI {
	
	Service service = Service.getInstance();
	@Path("/products")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Product> getAllElements(){
		return service.getAllProducts();
	}
	
	@GET
	@Path("/products/{categoryName}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Product> getAllProductsOfParticularCategory(@PathParam("categoryName") String categoryName){
		return service.getAllProductsOfParticularCategory(categoryName);
	}
	
	@GET
	@Path("/categories")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Category> getAllCategory(){
		return service.getAllCategory();
	}
}	