package dto;

/**
 * This class represent company
 * @author Sabir
 *
 */
public class Company {

	//This represent id of company
	private int id;
	//This represent name of company
	private String name;
	
	/**
	 * This method return the id of company
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * This method set the id of company
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * This method return the name of company
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This method set the name of company
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
