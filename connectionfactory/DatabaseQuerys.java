package com.sms.connectionfactory;

/**
 * This class contain database query's
 * @author Sabir
 *
 */
public class DatabaseQuerys {

	//Database query for adding student
	public static final String ADD_STUDENT = "{CALL AddStudent(?,?,?,?,?,?)}";
	//Database query for getting details of all students
	public static final String GET_ALL_STUDENT_DETAIL = "{CALL GetAllStudentDetail()}";
	//Database query for updating student detail
	public static final String UPDATE_STUDENT_DETAIL = "{CALL UpdateStudentDetail(?,?,?,?,?,?,?)}";
	//Database query for getting details of student using id
	public static final String GET_STUDENT_DETAIL_BY_ID = "{CALL GetStudentDetailById(?)}";
	//Database query for getting details of students by name and filter by class
	public static final String GET_STDUDENT_DETAIL_BY_NAME_FILTER_BY_CLASS = "{CALL GetStudentDetailByNameFilterByClass(?,?,?)}";
}
