package Assignment5;

/**
 * This class represent category
 * @author Sabir
 *
 */
public class Category {

	//This represent id of category
	private int categoryId;
	//This represent name of category
	private String categoryName;
	//This represent the id of parent category
	private int parentCategoryId;
	//This represent total child category of category
	private int totalChlidCategory;
	
	/**
	 * This method return category id
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}
	
	/**
	 * This method set the category id 
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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
	
	/**
	 * This method return the parent Category id
	 * @return the parentCategoryId
	 */
	public int getParentCategoryId() {
		return parentCategoryId;
	}
	
	/**
	 * This method set the parent category id
	 * @param parentCategoryId the parentCategoryId to set
	 */
	public void setParentCategoryId(int parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}
	
	/**
	 * This method return total child category 
	 * @return the totalChlidCategory
	 */
	public int getTotalChlidCategory() {
		return totalChlidCategory;
	}
	
	/**
	 * This method set the total child category
	 * @param totalChlidCategory the totalChlidCategory to set
	 */
	public void setTotalChlidCategory(int totalChlidCategory) {
		this.totalChlidCategory = totalChlidCategory;
	}
}
