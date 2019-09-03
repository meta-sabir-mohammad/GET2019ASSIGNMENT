package dto;

/**
 * This class represent product
 * @author Sabir
 *
 */
public class Product {

	//This represent the product code
	private int productCode;
	//This represent the category code
	private int categoryCode;
	//This represent the product name
	private String name;
	//This represent the product price
	private double price;
	//This represent the product quantity
	private int quantity;
	
	/**
	 * This method return the product code
	 * @return the productCode
	 */
	public int getProductCode() {
		return productCode;
	}
	
	/**
	 * This method set the product code
	 * @param productCode the productCode to set
	 */
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	
	/**
	 * This method return the category code
	 * @return the categoryCode
	 */
	public int getCategoryCode() {
		return categoryCode;
	}
	
	/**
	 * This method set the category code
	 * @param categoryCode the categoryCode to set
	 */
	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}
	
	/**
	 * This method return the name of product
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This method set the name of product
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * This method return the price of product
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * This method set the price of product
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * This method return the quantity of product
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * This method set the quantity of product
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
