package com.sms.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sms.dto.Student;
import com.sms.model.StudentManagementSystemModel;

/**
 * Servlet implementation class UpdateStudentDetailServlet
 */
@WebServlet("/UpdateStudentDetailServlet")
public class UpdateStudentDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Student student = new Student();
		student.setId(Integer.parseInt(request.getParameter("id")));
		student.setFirstName(request.getParameter("firstName"));
		student.setLastName(request.getParameter("lastName"));
		student.setFatherName(request.getParameter("fatherName"));
		student.setEmail(request.getParameter("email"));
		student.setStudentClass(Integer.parseInt(request.getParameter("class")));
		student.setAge(Double.parseDouble(request.getParameter("age")));
		
		StudentManagementSystemModel studentManagementSystemModel = StudentManagementSystemModel.getInstance();
		HttpSession session = request.getSession();
		try {
			boolean result = studentManagementSystemModel.updateStudentDetail(student);
			if(result){
				session.setAttribute("operation", "update");
				session.setAttribute("message", true);
			}
		} catch (SQLException e) {
			session.setAttribute("operation", "update");
			session.setAttribute("message", false);
		} catch (Exception e) {
			session.setAttribute("operation", "update");
			session.setAttribute("message", false);
		}
		
		response.sendRedirect("jsp/index.jsp");
	}

}
