package Assignment5;

/**
 * This class represent image
 * @author Sabir
 *
 */
public class Image {

	//This represent image id
	private int imageId;
	//This represent product id
	private int productId;
	//This represent image Url
	private String imageUrl;
	
	/**
	 * This method return the image id
	 * @return the imageId
	 */
	public int getImageId() {
		return imageId;
	}
	
	/**
	 * This method set the image id
	 * @param imageId the imageId to set
	 */
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	
	/**
	 * This method return the product id
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}
	
	/**
	 * This method set the product id
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	/**
	 * This method return the image url
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}
	
	/**
	 * This method set the image url
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
