package factory;

public class DatabaseQuery {

	public static final String CHECK_LOGIN = "SELECT login(?,?);";
	public static final String GET_ALL_PRODUCTS = "CALL getAllProducts();";
	public static final String ADD_PRODUCT = "CALL AddProduct(?,?,?);";
	public static final String GET_CART = "CALL GetCart(?);";
	public static final String UPDATE_CART = "CALL UpdateCart(?,?,?);";
}
