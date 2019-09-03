package factory;

/**
 * This class contain database query
 * @author Sabir
 *
 */
public class DatabaseQuery {

	//This is for checking user access
	public static final String CHECK_LOGIN = "SELECT login(?,?);";
	//This is for getting all products
	public static final String GET_ALL_PRODUCTS = "CALL getAllProducts();";
	//This is for adding product
	public static final String ADD_PRODUCT = "CALL AddProduct(?,?,?);";
	//This is for getting products from cart
	public static final String GET_CART = "CALL GetCart(?);";
	//This is for updating cart
	public static final String UPDATE_CART = "CALL UpdateCart(?,?,?);";
}
