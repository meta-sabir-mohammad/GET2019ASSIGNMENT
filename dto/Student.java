package com.sms.dto;

/**
 * This class represent student
 * @author Sabir
 *
 */
public class Student {

	//Represent id of student
	private int id;
	//Represent first name of student
	private String firstName;
	//Represent last name of student
	private String lastName;
	//Represent father's name of student
	private String fatherName;
	//Represent email of student
	private String email;
	//Represent student class
	private int studentClass;
	//Represent student age
	private double age;
	
	/**
	 * Default constructor
	 */
	public Student(){
		
	}
	
	/**
	 * This method return the id of student
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * This method set the id of student
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * This method return first name of student
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * This method set the first name of student
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * This method return the last name of student
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * This method set the last name of student
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * This method return the father name 
	 * @return the fatherName
	 */
	public String getFatherName() {
		return fatherName;
	}
	
	/**
	 * This method set the father name of student
	 * @param fatherName the fatherName to set
	 */
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	
	/**
	 * This method return the email of student
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * This method set the email of student
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * This method return the class of student
	 * @return the studentClass
	 */
	public int getStudentClass() {
		return studentClass;
	}
	
	/**
	 * This method set the class of student
	 * @param studentClass the studentClass to set
	 */
	public void setStudentClass(int studentClass) {
		this.studentClass = studentClass;
	}
	
	/**
	 * This method return the age of student
	 * @return the age
	 */
	public double getAge() {
		return age;
	}
	
	/**
	 * This method set the age of student
	 * @param age the age to set
	 */
	public void setAge(double age) {
		this.age = age;
	}
}
