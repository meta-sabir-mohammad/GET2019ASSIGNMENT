package com.sms.controller;

import java.io.IOException;
import java.util.ArrayList;
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
 */
@WebServlet("/GetAllStudentDetailServlet")
public class GetAllStudentDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetAllStudentDetailServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
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
