package com.sms.controller;

import java.io.IOException;
import java.sql.SQLException;
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
 * Servlet implementation class SearchStudentDetailServlet
 */
@WebServlet("/SearchStudentDetailServlet")
public class SearchStudentDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchStudentDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Student student = new Student();
		student.setFirstName(request.getParameter("firstName"));
		student.setLastName(request.getParameter("lastName"));
		boolean filterByClass;
		if(request.getParameter("filterByClass").equals("no")){
			filterByClass = false;
		}else{
			filterByClass = true;
		}
		
		StudentManagementSystemModel studentManagementSystemModel = StudentManagementSystemModel.getInstance();
		HttpSession session = request.getSession();
		try {
			List<Student> studentSearchList = studentManagementSystemModel.getStudentDetailsByName(student, filterByClass);
			session.setAttribute("studentSearchList", studentSearchList);
		} catch (SQLException e) {
			e.printStackTrace();
			session.setAttribute("operation", "search");
			session.setAttribute("operation", false);
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("operation", "search");
			session.setAttribute("operation", false);
		}
		response.sendRedirect("jsp/searchStudent.jsp");
	}

}
