package com.sms.connectionfactory;

public class DatabaseQuerys {

	public static final String ADD_STUDENT = "{CALL AddStudent(?,?,?,?,?,?)}";
	public static final String GET_ALL_STUDENT_DETAIL = "{CALL GetAllStudentDetail()}";
	public static final String UPDATE_STUDENT_DETAIL = "{CALL UpdateStudentDetail(?,?,?,?,?,?,?)}";
	public static final String GET_STUDENT_DETAIL_BY_ID = "{CALL GetStudentDetailById(?)}";
	public static final String GET_STDUDENT_DETAIL_BY_NAME_FILTER_BY_CLASS = "{CALL GetStudentDetailByNameFilterByClass(?,?,?)}";
}
