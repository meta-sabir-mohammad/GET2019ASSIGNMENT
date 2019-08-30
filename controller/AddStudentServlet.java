package com.sms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.sms.dto.Student;
import com.sms.model.StudentManagementSystemModel;

/**
 * Servlet implementation class AddStudentServlet
 * This servlet add student details to database
 * @author Sabir
 */
@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor 
	 */
	public AddStudentServlet() {
		super();
	}

	/**
	 * This method add student using service post type request 
	 * @param request object of HttpServletRequest 
	 * @param response object of HttpServletResponse
	 * @throws ServletExcetion,IOException
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
