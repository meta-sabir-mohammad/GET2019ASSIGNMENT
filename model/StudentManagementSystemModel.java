package com.sms.model;

import java.sql.SQLException;
import java.util.List;

import com.sms.dao.StudentManagementSystemDAO;
import com.sms.dto.Student;

public class StudentManagementSystemModel {
	
	private static StudentManagementSystemModel studentManagementSystemModel = new StudentManagementSystemModel();
	
	public static StudentManagementSystemModel getInstance(){
		return studentManagementSystemModel;
	}

	public boolean addStudent(Student student) throws SQLException,Exception{

		StudentManagementSystemDAO studentManagementSystemDAO = StudentManagementSystemDAO.getInstance();
		try{
			return studentManagementSystemDAO.addStudent(student);
		}catch(SQLException e){
			throw e;
		}catch(Exception e){
			throw e;
		}
	}

	public List<Student> getAllStudentDetails() throws SQLException,Exception{
		
		StudentManagementSystemDAO studentManagementSystemDAO = StudentManagementSystemDAO.getInstance();
		try{
			return studentManagementSystemDAO.getAllStudentDetails();
		}catch(SQLException e){
			throw e;
		}catch(Exception e){
			throw e;
		}
	}

	public List<Student> getStudentDetailsByName(Student student,boolean filterByClass) throws SQLException,Exception{

		StudentManagementSystemDAO studentManagementSystemDAO = StudentManagementSystemDAO.getInstance();
		try{
			return studentManagementSystemDAO.getStudentDetailsByName(student,filterByClass);
		}catch(SQLException e){
			throw e;
		}catch(Exception e){
			throw e;
		}
	}
	
	public boolean updateStudentDetail(Student student) throws SQLException,Exception{
		
		StudentManagementSystemDAO studentManagementSystemDAO = StudentManagementSystemDAO.getInstance();
		try{
			return studentManagementSystemDAO.updateStudentDetail(student);
		}catch(SQLException e){
			throw e;
		}catch(Exception e){
			throw e;
		}
	}
	
	public Student getStudentDetailById(int id) throws SQLException,Exception{
		
		StudentManagementSystemDAO studentManagementSystemDAO = StudentManagementSystemDAO.getInstance();
		try{
			return studentManagementSystemDAO.getStudentDetailById(id);
		}catch(SQLException e){
			throw e;
		}catch(Exception e){
			throw e;
		}
	}
}
