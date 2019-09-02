package dto;

import java.util.ArrayList;

public class Cart {

	private int cartId;
	private ArrayList<Product> products = new ArrayList<Product>();
	private double total;

	/**
	 * @return the cartId
	 */
	public int getCartId() {
		return cartId;
	}

	/**
	 * @param cartId
	 *            the cartId to set
	 */
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	/**
	 * @return the products
	 */
	public ArrayList<Product> getProducts() {
		return products;
	}

	/**
	 * @param products
	 *            the products to set
	 */
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	/**
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(double total) {
		this.total = total;
	}

	public void calculateTotal() {

		double totalPrice = 0.0;
		for (Product product : products) {
			totalPrice += product.getPrice();
		}
		this.setTotal(totalPrice);
	}
}
