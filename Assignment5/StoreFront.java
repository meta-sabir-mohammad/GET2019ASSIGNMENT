package Assignment5;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represent store front and contain method related to it
 * @author Sabir
 *
 */
public class StoreFront {

	/**
	 * This method find and return all shipped orders of given user
	 * @param userId id of user
	 * @return List of all shipped orders of user
	 * @throws SQLException when exception occur while querying database
	 * @throws Exception Other general exception 
	 */
	public List<Order> getAllOrdersOfUser(int userId) throws SQLException,Exception{

		try{
			StoreFrontDAO storeFrontDAO = new StoreFrontDAO();
			List<Order> ordersList = storeFrontDAO.getAllShippedOrdersOfUser(userId);
			return ordersList;
		}catch(SQLException e){
			System.out.println(e);
			throw e;
		}catch(Exception e){
			System.out.println(e);
			throw e;
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

		try{
			StoreFrontDAO storeFrontDAO = new StoreFrontDAO();
			boolean result = storeFrontDAO.addImagesOfProduct(imageList);
			return result;
		}catch(SQLException e){
			System.out.println(e);
			throw e;
		}catch(Exception e){
			System.out.println(e);
			throw e;
		}
	}
	
	/**
	 * This method mark products inactive which are not purchased in last one year
	 * @return number of products mark inactive
	 * @throws SQLException when exception occur while querying database
	 * @throws Exception other general exception
	 */
	public int deleteNotPurchasedProducts() throws SQLException,Exception{

		try{
			StoreFrontDAO storeFrontDAO = new StoreFrontDAO();
			int result = storeFrontDAO.deleteNotPurchasedProducts();
			return result;
		}catch(SQLException e){
			System.out.println(e);
			throw e;
		}catch(Exception e){
			System.out.println(e);
			throw e;
		}

	}
	
	/**
	 * This method find and return all top category's and their total child's
	 * @return list of category type containing name of top category and their total child's
	 * @throws SQLException when querying database 
	 * @throws Exception other general exception
	 */
	public List<Category> getParentCategorysAndTotalChilds() throws SQLException,Exception{

		try{
			StoreFrontDAO storeFrontDAO = new StoreFrontDAO();
			List<Category> result = storeFrontDAO.getParentCategorysAndTotalChilds();
			return result;
		}catch(SQLException e){
			System.out.println(e);
			throw e;
		}catch(Exception e){
			System.out.println(e);
			throw e;
		}
	}

	public static void main(String args[]){

		StoreFront storeFront = new StoreFront();
		try{
			List<Order> ordersList = new ArrayList<Order>();
			ordersList = storeFront.getAllOrdersOfUser(4);
			for(Order order : ordersList){
				System.out.println(order.getOrderId());
				System.out.println(order.getOrderDate());
				System.out.println(order.getOrderTotal());
			}
			
			List<Image> imageList = new ArrayList<Image>();
			Image image = new Image();
			image.setProductId(1);
			image.setImageUrl("www.product1.com/image1");
			imageList.add(image);
			image = new Image();
			image.setProductId(2);
			image.setImageUrl("www.product2.com/image2");
			imageList.add(image);
			System.out.println(storeFront.addImagesOfProduct(imageList));
			System.out.println(storeFront.deleteNotPurchasedProducts());
			
			List<Category> categoryList = new ArrayList<Category>();
			categoryList = storeFront.getParentCategorysAndTotalChilds();
			for(Category category : categoryList){
				System.out.println(category.getCategoryName());
				System.out.println(category.getTotalChlidCategory());
			}
		}catch(Exception e){

		}
	}
}
