package facade;

import java.util.ArrayList;
import java.util.List;

import dao.ShoppingCartDAO;
import dto.Cart;
import dto.Product;
import dto.User;

public class ShoppingCartFacade {

	private static ShoppingCartFacade shoppingCartFacade = null;

	public static ShoppingCartFacade getInstance() {

		if (shoppingCartFacade == null) {
			shoppingCartFacade = new ShoppingCartFacade();
		}
		return shoppingCartFacade;
	}

	public List<Product> getAllProducts() {

		ShoppingCartDAO shoppingCartDAO = ShoppingCartDAO.getInstance();
		try {
			return shoppingCartDAO.getAllProducts();
		} catch (Exception e) {
			List<Product> productsList = new ArrayList<Product>();
			return productsList;
		}
	}

	public boolean addProductToCart(Product product, User user) {

		try {
			ShoppingCartDAO shoppingCartDAO = ShoppingCartDAO.getInstance();
			return shoppingCartDAO.addProductToCart(product, user);
		} catch (Exception e) {
			return false;
		}
	}

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

	public boolean updateProductQuantity(User user, Product product) {

		ShoppingCartDAO shoppingCartDAO = ShoppingCartDAO.getInstance();
		try {
			return shoppingCartDAO.updateProductQuantity(user, product);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean removeProductFromCart(User user, Product product) {

		ShoppingCartDAO shoppingCartDAO = ShoppingCartDAO.getInstance();
		try {
			return shoppingCartDAO.removeProductFromCart(user, product);
		} catch (Exception e) {
			return false;
		}
	}
}
