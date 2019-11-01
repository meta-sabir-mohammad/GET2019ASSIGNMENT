package com.metacube.shoppingAppAPI.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.metacube.shoppingAppAPI.dao.CategoryDao;
import com.metacube.shoppingAppAPI.dao.ProductDao;
import com.metacube.shoppingAppAPI.model.Category;
import com.metacube.shoppingAppAPI.model.Product;

public class Service {
	
	private static Service instance = null;
	ProductDao productDao = ProductDao.getInstance();
	CategoryDao categoryDao = CategoryDao.getInstance();
	
	public static Service getInstance(){
		if(instance == null){
			instance = new Service();
		}
	return instance;
	}

	public ArrayList<Product> getAllProducts(){
		try {
			return productDao.getAllProducts();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Product> getAllProductsOfParticularCategory(String categoryName) {
		try {
			return productDao.getAllProductsOfParticularCategory(categoryName);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Category> getAllCategory() {
		try {
			return categoryDao.getAllCategory();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}	