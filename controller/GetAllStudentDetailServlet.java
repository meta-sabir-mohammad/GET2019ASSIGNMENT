package com.sms.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sms.dto.Student;
import com.sms.model.StudentManagementSystemModel;

/**
 * Servlet implementation class GetAllStudentDetailServlet
 * This servlet get all student details and return
 * @author Sabir
 */
@WebServlet("/GetAllStudentDetailServlet")
public class GetAllStudentDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor 
	 */
	public GetAllStudentDetailServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * This method get all student detail and return as a session using service get type request 
	 * @param request object of HttpServletRequest 
	 * @param response object of HttpServletResponse
	 * @throws ServletExcetion,IOException
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		StudentManagementSystemModel studentManagementSystemModel = StudentManagementSystemModel.getInstance();
		try{
			List<Student> studentList = studentManagementSystemModel.getAllStudentDetails();
			session.setAttribute("studentList", studentList);
		}catch(Exception e){
			session.setAttribute("operation","retrival");
			session.setAttribute("message", false);
		}
		response.sendRedirect("jsp/showAllStudent.jsp");
	}
}
