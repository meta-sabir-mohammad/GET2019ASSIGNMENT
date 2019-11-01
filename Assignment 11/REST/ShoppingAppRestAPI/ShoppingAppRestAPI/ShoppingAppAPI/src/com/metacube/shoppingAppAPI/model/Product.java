package com.metacube.shoppingAppAPI.model;



public class Product{
	private int productId;
	private String productName;
	private double price;
	private String imageURL;
	
	public Product() {
	}
	
	public Product(int productId , String productName , double price , String imageURL) {
		this.imageURL = imageURL;
		this.price = price;
		this.productId = productId;
		this.productName = productName;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	@Override
	public String toString() {
		return "product [productId=" + productId + ", productName=" + productName + ", price=" + price + ", imageURL="
				+ imageURL + "]";
	}	
}