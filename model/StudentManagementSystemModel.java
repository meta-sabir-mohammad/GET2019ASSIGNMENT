package com.sms.model;

import java.sql.SQLException;
import java.util.List;

import com.sms.dao.StudentManagementSystemDAO;
import com.sms.dto.Student;

/**
 * This is Model class of student management system
 * @author Sabir
 *
 */
public class StudentManagementSystemModel {
	
	//Object of StudentManagementSystemModel class
	private static StudentManagementSystemModel studentManagementSystemModel = new StudentManagementSystemModel();
	
	/**
	 * This method return singleton object of StudentManagementSystemModel class
	 * @return object of StudentManagementSystemModel
	 */
	public static StudentManagementSystemModel getInstance(){
		return studentManagementSystemModel;
	}

	/**
	 * This method add student details 
	 * @param student object of Student class containing details of student
	 * @return true if added successful else false
	 * @throws SQLException if exception occur because of database
	 * @throws Exception other general exception
	 */
	public boolean addStudent(Student student) throws SQLException,Exception{

		StudentManagementSystemDAO studentManagementSystemDAO = StudentManagementSystemDAO.getInstance();
		try{
			return studentManagementSystemDAO.addStudent(student);
		}catch(SQLException e){
			System.out.println(e);
			throw e;
		}catch(Exception e){
			System.out.println(e);
			throw e;
		}
	}

	/**
	 * This method get details of all students
	 * @return List of student
	 * @throws SQLException if exception occur because of database
	 * @throws Exception other general exception
	 */
	public List<Student> getAllStudentDetails() throws SQLException,Exception{
		
		StudentManagementSystemDAO studentManagementSystemDAO = StudentManagementSystemDAO.getInstance();
		try{
			return studentManagementSystemDAO.getAllStudentDetails();
		}catch(SQLException e){
			System.out.println(e);
			throw e;
		}catch(Exception e){
			System.out.println(e);
			throw e;
		}
	}

	/**
	 * This method get the details of students by name 
	 * @param student object of Student class containing first and last name
	 * @param filterByClass boolean contain true if filter is require else false
	 * @return List of Student
	 * @throws SQLException if exception occur because of database
	 * @throws Exception other general exception
	 */
	public List<Student> getStudentDetailsByName(Student student,boolean filterByClass) throws SQLException,Exception{

		StudentManagementSystemDAO studentManagementSystemDAO = StudentManagementSystemDAO.getInstance();
		try{
			return studentManagementSystemDAO.getStudentDetailsByName(student,filterByClass);
		}catch(SQLException e){
			System.out.println(e);
			throw e;
		}catch(Exception e){
			System.out.println(e);
			throw e;
		}
	}
	
	/**
	 * This method update student detail
	 * @param student object of Student class containing details of student
	 * @return true if update successful else false
	 * @throws SQLException if exception occur because of database
	 * @throws Exception other general exception
	 */
	public boolean updateStudentDetail(Student student) throws SQLException,Exception{
		
		StudentManagementSystemDAO studentManagementSystemDAO = StudentManagementSystemDAO.getInstance();
		try{
			return studentManagementSystemDAO.updateStudentDetail(student);
		}catch(SQLException e){
			System.out.println(e);
			throw e;
		}catch(Exception e){
			System.out.println(e);
			throw e;
		}
	}
	
	/**
	 * This method get student detail using id
	 * @param id represent student id
	 * @return object of Student class contain detail of student
	 * @throws SQLException if exception occur because of database
	 * @throws Exception other general exception
	 */
	public Student getStudentDetailById(int id) throws SQLException,Exception{
		
		StudentManagementSystemDAO studentManagementSystemDAO = StudentManagementSystemDAO.getInstance();
		try{
			return studentManagementSystemDAO.getStudentDetailById(id);
		}catch(SQLException e){
			System.out.println(e);
			throw e;
		}catch(Exception e){
			System.out.println(e);
			throw e;
		}
	}
}
