package Assignment5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * This is Data Access Object class
 * This class query database and wrap result
 * @author Sabir
 *
 */
public class StoreFrontDAO {

	/**
	 * This method find and return all shipped orders of given user
	 * @param userId id of user
	 * @return List of all shipped orders of user
	 * @throws SQLException when exception occur while querying database
	 * @throws Exception Other general exception 
	 */
	public List<Order> getAllShippedOrdersOfUser(int userId) throws SQLException,Exception {

		Connection connection = null;
		try {
			connection = ConnectionFactory.getConnection();
			PreparedStatement preStmt;
			preStmt = connection.prepareStatement(StoreFrontQuerys.GET_ALL_SHIPPED_ORDERS_OF_USER);
			System.out.println(StoreFrontQuerys.GET_ALL_SHIPPED_ORDERS_OF_USER);
			preStmt.setInt(1, userId);
			ResultSet result = preStmt.executeQuery();
			List<Order> ordersList = new ArrayList<Order>();
			while(result.next()){
				Order order = new Order();
				order.setOrderId(result.getInt(1));
				order.setOrderDate(result.getDate(2));
				order.setOrderTotal(result.getDouble(3));
				ordersList.add(order);
			}
			return ordersList;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		finally{
			connection.close();
		}

	}

	/**
	 * This method add batch of images for products
	 * @param imageList list of images
	 * @return true if added successfully else false
	 * @throws SQLException when exception occur querying database
	 * @throws Exception other general exception
	 */
	public boolean addImagesOfProduct(List<Image> imageList) throws SQLException,Exception{

		Connection connection = null;
		try {
			connection = ConnectionFactory.getConnection();
			PreparedStatement preStmt;
			preStmt = connection.prepareStatement(StoreFrontQuerys.INSERT_IMAGE_OF_PRODUCT);
			for(Image image : imageList){
				preStmt.setInt(1, image.getProductId());
				preStmt.setString(2, image.getImageUrl());
				preStmt.addBatch();
			}	
			int result[] = preStmt.executeBatch();
			for(int queryExecuted : result){
				if(queryExecuted == 0){
					return false;
				}
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		finally{
			connection.close();
		}
	}
	
	/**
	 * This method mark products inactive which are not purchased in last one year
	 * @return number of products mark inactive
	 * @throws SQLException when exception occur while querying database
	 * @throws Exception other general exception
	 */
	public int deleteNotPurchasedProducts() throws SQLException,Exception{
		
		Connection connection = null;
		try {
			connection = ConnectionFactory.getConnection();
			PreparedStatement preStmt;
			preStmt = connection.prepareStatement(StoreFrontQuerys.DELETE_NOT_PURCHASED_PRODUCTS);
			int result = preStmt.executeUpdate();
			int numberOfUseLessRow = 2;
			return (result-numberOfUseLessRow);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		finally{
			connection.close();
		}
	}
	
	/**
	 * This method find and return all top category's and their total child's
	 * @return list of category type containing name of top category and their total child's
	 * @throws SQLException when querying database 
	 * @throws Exception other general exception
	 */
	public List<Category> getParentCategorysAndTotalChilds() throws SQLException,Exception{
		
		Connection connection = null;
		try {
			connection = ConnectionFactory.getConnection();
			PreparedStatement preStmt;
			preStmt = connection.prepareStatement(StoreFrontQuerys.GET_TOP_CATEGORY_NAME_AND_CHILDS);
			ResultSet result = preStmt.executeQuery();
			List<Category> categoryList = new ArrayList<Category>();
			while(result.next()){
				Category category = new Category();
				category.setCategoryName(result.getString(1));
				category.setTotalChlidCategory(result.getInt(2));
				categoryList.add(category);
			}
			return categoryList;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		finally{
			connection.close();
		}
	}
}
