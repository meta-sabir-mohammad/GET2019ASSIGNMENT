package dto;

import java.util.ArrayList;

/**
 * This class represent Cart
 * @author Sabir
 *
 */
public class Cart {

	//This represent cart id
	private int cartId;
	//This contain all products in cart
	private ArrayList<Product> products = new ArrayList<Product>();
	//This represent total price of cart
	private double total;

	/**
	 * This method return the cart id
	 * @return the cartId
	 */
	public int getCartId() {
		return cartId;
	}

	/**
	 * This method set the cart id
	 * @param cartId the cartId to set
	 */
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	/**
	 * This method return the List of products in cart
	 * @return the products
	 */
	public ArrayList<Product> getProducts() {
		return products;
	}

	/**
	 * This method set the List of products in cart
	 * @param products the products to set
	 */
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	/**
	 * This method return the total of cart
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * This method set the total of cart
	 * @param totalthe total to set
	 */
	public void setTotal(double total) {
		this.total = total;
	}

	/**
	 * This method calculate cart total
	 */
	public void calculateTotal() {

		double totalPrice = 0.0;
		for (Product product : products) {
			totalPrice += product.getPrice()*product.getQuantity();
		}
		this.setTotal(totalPrice);
	}
}
