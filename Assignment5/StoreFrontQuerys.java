package Assignment5;

/**
 * This class contain all the database query
 * @author Sabir
 *
 */
public class StoreFrontQuerys {

	//This query return details about shipped products in orders purchase by given user 
	public static final String GET_ALL_SHIPPED_ORDERS_OF_USER = "SELECT orders.OrderId AS 'Id',orders.OrderDate AS 'Order Date',SUM(orderedproducts.Quantity*product.Price) AS 'Order Total' FROM shopper INNER JOIN orders ON shopper.shopperId = orders.ShopperId INNER JOIN orderedproducts ON orders.OrderId = orderedproducts.OrderId INNER JOIN orderstatus ON orderedproducts.OrderId = orderstatus.OrderId AND orderedproducts.ProductId = orderstatus.ProductId INNER JOIN product ON orderstatus.ProductId = product.ProductId WHERE shopper.ShopperId = ? AND orderstatus.Status = 'Shipped' GROUP BY orders.OrderId;" ;
	
	//This query insert image url into database for product
	public static final String INSERT_IMAGE_OF_PRODUCT = "INSERT INTO images(ProductId,Url) VALUES (?,?);";
	
	//This query return top category names and their total child category's 
	public static final String GET_TOP_CATEGORY_NAME_AND_CHILDS = "SELECT table1.CategoryName AS 'Title', Count(table2.CategoryId) AS 'Total Childs' FROM category table1 INNER JOIN category table2 ON table1.categoryId = table2.ParentcategoryId WHERE table1.ParentcategoryId = 0 GROUP BY table1.categoryName ORDER BY table1.CategoryName;";
	
	//This query mark inactive all the products which are not purchased in one year
	public static final String DELETE_NOT_PURCHASED_PRODUCTS = "UPDATE Product LEFT JOIN orderstatus ON product.productId = orderstatus.productId LEFT JOIN orders ON orderstatus.orderid = orders.orderId SET product.status = 'Inactive' WHERE product.Status = 'Active' AND orders.OrderDate IS NULL OR orders.OrderDate < DATE_SUB(NOW(),INTERVAL 365 DAY);";
}
