package Assignment5;

import java.sql.Date;

/**
 * This class represent order
 * @author Sabir
 *
 */
public class Order {

	//This represent order id
	private int orderId;
	//This represent shopper id
	private int shopperId;
	//This represent order total
	private double orderTotal;
	//This represent order date
	private Date OrderDate;
	
	/**
	 * This method return the order id
	 * @return the orderId
	 */
	public int getOrderId() {
		return orderId;
	}
	
	/**
	 * This method return the shopper id
	 * @return the shopperId
	 */
	public int getShopperId() {
		return shopperId;
	}
	
	/**
	 * This method return the order total
	 * @return the orderTotal
	 */
	public double getOrderTotal() {
		return orderTotal;
	}
	
	/**
	 * This method return the order date
	 * @return the orderDate
	 */
	public Date getOrderDate() {
		return OrderDate;
	}
	
	/**
	 * This method set the order id
	 * @param orderId the orderId to set
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	/**
	 * This method set the shopper id
	 * @param shopperId the shopperId to set
	 */
	public void setShopperId(int shopperId) {
		this.shopperId = shopperId;
	}
	
	/**
	 * This method set the order total
	 * @param orderTotal the orderTotal to set
	 */
	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}
	
	/**
	 * This method set the order date
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	}
}
