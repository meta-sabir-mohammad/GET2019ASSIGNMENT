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
 * Servlet implementation class RedirectToUpdatePageServlet
 * This servlet redirect to update page
 * @author Sabir
 */
@WebServlet("/RedirectToUpdatePageServlet")
public class RedirectToUpdatePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * Default Constructor
     */
    public RedirectToUpdatePageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * This method redirect to update page and send the detail of student using service post type request 
	 * @param request object of HttpServletRequest 
	 * @param response object of HttpServletResponse
	 * @throws ServletExcetion,IOException
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentManagementSystemModel studentManagementSystemModel = StudentManagementSystemModel.getInstance();
		HttpSession session = request.getSession();
		try {
			Student student = studentManagementSystemModel.getStudentDetailById(Integer.parseInt(request.getParameter("id")));
			session.setAttribute("studentDetail", student);
		} catch (Exception e) {
			System.out.println(e);
			session.setAttribute("operation","update");
			session.setAttribute("message", false);
		}
		response.sendRedirect("jsp/updateStudent.jsp");
	}

}
