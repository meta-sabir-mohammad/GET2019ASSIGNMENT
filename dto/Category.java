package dto;

/**
 * This class represent category
 * @author Sabir
 *
 */
public class Category {

	//This represent the category code
	private int categoryCode;
	//This represent category name
	private String categoryName;
	
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
	 * This method return the category name
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}
	
	/**
	 * This method set the category name
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
