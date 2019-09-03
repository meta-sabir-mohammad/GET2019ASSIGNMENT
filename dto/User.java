package dto;

/**
 * This class represent user
 * @author Sabir
 *
 */
public class User {

	//This represent id of user
	private int id;
	//This represent user name
	private String userName;
	//This represent password of user
	private int password;
	//This represent the email of user
	private String email;
	//This represent the phone number of user
	private int phone;
	//This represent the name of user
	private String name;
	
	/**
	 * This method return the name of user
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This method set the name of user
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * This method return the id of user
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * This method set the id of user
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * This method return the username of user
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * This method set the username
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * This method return the password of user
	 * @return the password
	 */
	public int getPassword() {
		return password;
	}
	
	/**
	 * This method set the password of user
	 * @param password the password to set
	 */
	public void setPassword(int password) {
		this.password = password;
	}
	
	/**
	 * This method return the email of user
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * This method set the email of user
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * This method return the phone number of user
	 * @return the phone
	 */
	public int getPhone() {
		return phone;
	}
	
	/**
	 * This method set the phone number of user
	 * @param phone the phone to set
	 */
	public void setPhone(int phone) {
		this.phone = phone;
	}
}
