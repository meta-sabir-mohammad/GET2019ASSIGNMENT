package com.sms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sms.connectionfactory.ConnectionFactory;
import com.sms.dto.Student;
import com.sms.model.StudentManagementSystemModel;

/**
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddStudentServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Student student = new Student();
		HttpSession session = request.getSession();
		try{
			student.setFirstName(request.getParameter("firstName"));
			student.setLastName(request.getParameter("lastName"));
			student.setFatherName(request.getParameter("fatherName"));
			student.setEmail(request.getParameter("email"));
			student.setStudentClass(Integer.parseInt(request.getParameter("class")));
			student.setAge(Double.parseDouble(request.getParameter("age")));

			StudentManagementSystemModel studentManagementSystemModel = StudentManagementSystemModel.getInstance();
			boolean result = studentManagementSystemModel.addStudent(student);
			System.out.println(result);
			if(result){
				session.setAttribute("operation", "add");
				session.setAttribute("message", true);
			}else{
				session.setAttribute("operation", "add");
				session.setAttribute("message", false);
			}
		}catch(Exception e){
			System.out.println(e);
			session.setAttribute("operation", "add");
			session.setAttribute("message", false);
		}
		response.sendRedirect("jsp/index.jsp");
	}

}
