package com.metacube.shoppingAppAPI.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.metacube.shoppingAppAPI.factory.ConnectionFactory;
import com.metacube.shoppingAppAPI.factory.QueryFactory;
import com.metacube.shoppingAppAPI.model.Category;

public class CategoryDao {
	private static CategoryDao instance = null;
	public static CategoryDao getInstance(){
		if(instance == null){
			instance = new CategoryDao();
		}
	return instance;
	}
	
	public ArrayList<Category> getAllCategory() throws SQLException,Exception{
		Connection conn = null;
		PreparedStatement preStmt = null;
		
		try {
			ConnectionFactory conFactory = new ConnectionFactory();
			conn = conFactory.getConnection();
			preStmt = conn.prepareStatement(QueryFactory.getAllCategoryQuery());
			ResultSet result = preStmt.executeQuery();
			ArrayList<Category> list = new ArrayList<Category>();
			while(result.next()) {
				Category category = new Category(result.getInt(1),result.getString(2));				
				list.add(category);
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