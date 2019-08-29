package com.sms.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sms.connectionfactory.ConnectionFactory;
import com.sms.connectionfactory.DatabaseQuerys;
import com.sms.dto.Student;

public class StudentManagementSystemDAO {

	private static StudentManagementSystemDAO studentManagementSystemDAO = new StudentManagementSystemDAO(); 

	public static StudentManagementSystemDAO getInstance(){
		return studentManagementSystemDAO;
	}

	public boolean addStudent(Student student) throws SQLException,Exception{

		Connection conn  = null;
		CallableStatement callStmt = null;

		try {
			conn = ConnectionFactory.getConnection();
			callStmt = conn.prepareCall(DatabaseQuerys.ADD_STUDENT);
			callStmt.setString(1, student.getFirstName());
			callStmt.setString(2, student.getLastName());
			callStmt.setString(3, student.getFatherName());
			callStmt.setString(4, student.getEmail());
			callStmt.setInt(5, student.getStudentClass());
			callStmt.setDouble(6, student.getAge());

			int result = callStmt.executeUpdate();
			System.out.println(result);
			if(result == 1){
				return true;
			}else{
				return false;
			}
		}catch (SQLException e) {
			System.out.println(e);
			throw e;
		}
		catch (Exception e) {
			System.out.println(e);
			throw e;
		}
		finally{
			try {
				conn.close();
				callStmt.close();
			} catch (SQLException e) {

			}
		}
	}

	public List<Student> getAllStudentDetails() throws SQLException,Exception{

		Connection conn  = null;
		CallableStatement callStmt = null;

		try {
			conn = ConnectionFactory.getConnection();
			callStmt = conn.prepareCall(DatabaseQuerys.GET_ALL_STUDENT_DETAIL);

			ResultSet result = callStmt.executeQuery();
			List<Student> studentList = new ArrayList<Student>();
			while(result.next()){
				Student student = new Student();
				student.setId(result.getInt(1));
				student.setFirstName(result.getString(2));
				student.setLastName(result.getString(3));
				student.setFatherName(result.getString(4));
				student.setEmail(result.getString(5));
				student.setStudentClass(result.getInt(6));
				student.setAge(result.getDouble(7));
				studentList.add(student);
			}
			return studentList;
		}catch (SQLException e) {
			System.out.println(e);
			throw e;
		}
		catch (Exception e) {
			System.out.println(e);
			throw e;
		}
		finally{
			try {
				conn.close();
				callStmt.close();
			} catch (SQLException e) {

			}
		}

	}

	public List<Student> getStudentDetailsByName(Student student,boolean filterByClass) throws SQLException,Exception{
		
		Connection conn  = null;
		CallableStatement callStmt = null;

		try {
			conn = ConnectionFactory.getConnection();
			callStmt = conn.prepareCall(DatabaseQuerys.GET_STDUDENT_DETAIL_BY_NAME_FILTER_BY_CLASS);
			callStmt.setString(1, student.getFirstName());
			callStmt.setString(2, student.getLastName());
			callStmt.setBoolean(3, filterByClass);
			
			ResultSet result = callStmt.executeQuery();
			List<Student> studentSearchList = new ArrayList<Student>();
			while(result.next()){
				Student studentDetail = new Student();
				studentDetail.setFirstName(result.getString(1));
				studentDetail.setLastName(result.getString(2));
				studentDetail.setFatherName(result.getString(3));
				studentDetail.setEmail(result.getString(4));
				studentDetail.setStudentClass(result.getInt(5));
				studentDetail.setAge(result.getDouble(6));
				studentSearchList.add(studentDetail);
			}
			return studentSearchList;
		}catch (SQLException e) {
			System.out.println(e);
			throw e;
		}
		catch (Exception e) {
			System.out.println(e);
			throw e;
		}
		finally{
			try {
				conn.close();
				callStmt.close();
			} catch (SQLException e) {

			}
		}
	}

	public boolean updateStudentDetail(Student student) throws SQLException,Exception{
		Connection conn  = null;
		CallableStatement callStmt = null;

		try {
			conn = ConnectionFactory.getConnection();
			callStmt = conn.prepareCall(DatabaseQuerys.UPDATE_STUDENT_DETAIL);
			callStmt.setInt(1, student.getId());
			callStmt.setString(2, student.getFirstName());
			callStmt.setString(3, student.getLastName());
			callStmt.setString(4, student.getFatherName());
			callStmt.setString(5, student.getEmail());
			callStmt.setInt(6, student.getStudentClass());
			callStmt.setDouble(7, student.getAge());
			int result = callStmt.executeUpdate();
			if(result == 1){
				return true;
			}else{
				return false;
			}
		}catch (SQLException e) {
			System.out.println(e);
			throw e;
		}
		catch (Exception e) {
			System.out.println(e);
			throw e;
		}
		finally{
			try {
				conn.close();
				callStmt.close();
			} catch (SQLException e) {

			}
		}
	}

	public Student getStudentDetailById(int id) throws SQLException,Exception{

		Connection conn  = null;
		CallableStatement callStmt = null;

		try {
			conn = ConnectionFactory.getConnection();
			callStmt = conn.prepareCall(DatabaseQuerys.GET_STUDENT_DETAIL_BY_ID);
			callStmt.setInt(1, id);
			ResultSet result = callStmt.executeQuery();
			result.next();
			Student student = new Student();
			student.setId(result.getInt(1));
			student.setFirstName(result.getString(2));
			student.setLastName(result.getString(3));
			student.setFatherName(result.getString(4));
			student.setEmail(result.getString(5));
			student.setStudentClass(result.getInt(6));
			student.setAge(result.getDouble(7));

			return student;
		}catch (SQLException e) {
			System.out.println(e);
			throw e;
		}
		catch (Exception e) {
			System.out.println(e);
			throw e;
		}
		finally{
			try {
				conn.close();
				callStmt.close();
			} catch (SQLException e) {

			}
		}
	}
}
