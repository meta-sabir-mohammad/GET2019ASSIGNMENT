package com.metacube.shoppingAppAPI.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.metacube.shoppingAppAPI.factory.ConnectionFactory;
import com.metacube.shoppingAppAPI.factory.QueryFactory;
import com.metacube.shoppingAppAPI.model.Product;

public class ProductDao {
	
	private static ProductDao instance = null;
	public static ProductDao getInstance(){
		if(instance == null){
			instance = new ProductDao();
		}
	return instance;
	}
	public ArrayList<Product> getAllProducts() throws SQLException,Exception{
		Connection conn = null;
		PreparedStatement preStmt = null;
		
		try {
			ConnectionFactory conFactory = new ConnectionFactory();
			conn = conFactory.getConnection();
			preStmt = conn.prepareStatement(QueryFactory.getAllProductsQuery());
			ResultSet result = preStmt.executeQuery();
			ArrayList<Product> list = new ArrayList<Product>();
			while(result.next()) {
				Product product = new Product(result.getInt(1) , result.getString(2) , result.getDouble(3) , result.getString(4));				
				list.add(product);
			}
			return list;
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}	
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				throw e;
			}
		}
	}
	
	public ArrayList<Product> getAllProductsOfParticularCategory(String categoryName) throws SQLException,Exception{
		Connection conn = null;
		PreparedStatement preStmt = null;
		
		try {
			ConnectionFactory conFactory = new ConnectionFactory();
			conn = conFactory.getConnection();
			preStmt = conn.prepareStatement(QueryFactory.getAllProductsQueryOfParticularCategory());
			preStmt.setString(1,categoryName);
			ResultSet result = preStmt.executeQuery();
			ArrayList<Product> list = new ArrayList<Product>();
			while(result.next()) {
				Product product = new Product(result.getInt(1) , result.getString(2) , result.getDouble(3) , result.getString(4));				
				list.add(product);
			}
			return list;
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}	
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				throw e;
			}
		}
	}
}