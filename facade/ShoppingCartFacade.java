package facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ShoppingCartDAO;
import dto.Cart;
import dto.Product;
import dto.User;

/**
 * This class represent the ShoppingCartFacade
 * @author Sabir
 *
 */
public class ShoppingCartFacade {

	//Singleton object of ShoppingCartFacade
	private static ShoppingCartFacade shoppingCartFacade = null;

	/**
	 * This method return the object of ShoppingCartFacade
	 * @return object of ShoppingCartFacade
	 */
	public static ShoppingCartFacade getInstance() {

		if (shoppingCartFacade == null) {
			shoppingCartFacade = new ShoppingCartFacade();
		}
		return shoppingCartFacade;
	}

	/**
	 * This method get all product details
	 * @return List of products containing detail about products
	 */
	public List<Product> getAllProducts() {

		ShoppingCartDAO shoppingCartDAO = ShoppingCartDAO.getInstance();
		try {
			return shoppingCartDAO.getAllProducts();
		} catch (Exception e) {
			List<Product> productsList = new ArrayList<Product>();
			return productsList;
		}
	}

	/**
	 * This method add product to cart of user
	 * @param product object of Product containing details about product
	 * @param user object of User containing user name of user
	 * @return true if product is added else false
	 */
	public boolean addProductToCart(Product product, User user) {

		try {
			ShoppingCartDAO shoppingCartDAO = ShoppingCartDAO.getInstance();
			return shoppingCartDAO.addProductToCart(product, user);
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * This method return all the products from users cart
	 * @param user object of User containing details about user
	 * @return Object of Cart containing details about cart
	 */
	public Cart getCart(User user) {

		ShoppingCartDAO shoppingCartDAO = ShoppingCartDAO.getInstance();
		try {
			Cart cart = shoppingCartDAO.getCart(user);
			cart.calculateTotal();
			return cart;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * This method update product quantity in cart
	 * @param user object of User containing user name
	 * @param product object of Product containing details about product
	 * @return true if product quantity updated else false
	 */
	public boolean updateProductQuantity(User user, Product product) {

		ShoppingCartDAO shoppingCartDAO = ShoppingCartDAO.getInstance();
		try {
			return shoppingCartDAO.updateProductQuantity(user, product);
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * This method remove product from cart
	 * @param user object of User containing user name
	 * @param product object of Product containing detail about product
	 * @return true if product is removed else false
	 */
	public boolean removeProductFromCart(User user, Product product) {

		ShoppingCartDAO shoppingCartDAO = ShoppingCartDAO.getInstance();
		try {
			return shoppingCartDAO.removeProductFromCart(user, product);
		} catch (Exception e) {
			return false;
		}
	}
}
