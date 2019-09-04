package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Employee;
import facade.EmployeeFacade;
import util.Validation;

/**
 * This servlet is use to update employee detail
 * 
 * @author Sabir
 *
 */
@WebServlet("/UpdateEmployeeDetailServlet")
public class UpdateEmployeeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateEmployeeDetailServlet() {
		super();
	}

	/**
	 * This method is use to update employee details
	 * @param request object of HttpServletRequest
	 * @param response object of HttpServletResponse
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Employee employee = new Employee();
		HttpSession session = request.getSession();
		try {
			String email = (String) session.getAttribute("email");
			employee.setEmail(request.getParameter("email"));
			employee.setPassword(request.getParameter("password"));
			String confirmPassword = request.getParameter("confirmPassword");
			employee.setPhoneNumber(request.getParameter("contactnumber"));

			Validation validate = new Validation();
			String error = validate.validateEmployeeDetailOnUpdate(employee, confirmPassword);
			if (!error.equals("")) {
				session.setAttribute("error", error);
				RequestDispatcher rd = request.getRequestDispatcher("RedirectToEditPlage");
				rd.forward(request, response);
			}

			EmployeeFacade employeeFacade = EmployeeFacade.getInstance();

			boolean result = employeeFacade.updateEmployeeDetail(employee, email);
			if (result) {
				session.setAttribute("message", "Update successful");
				session.setAttribute("email", employee.getEmail());
				RequestDispatcher rd = request.getRequestDispatcher("ShowEmployeeDetailServlet");
				rd.forward(request, response);
			} else {
				session.setAttribute("error", "Update unsuccessful");
				RequestDispatcher rd = request.getRequestDispatcher("ShowEmployeeDetailServlet");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			session.setAttribute("error", "Update unsuccessful");
			RequestDispatcher rd = request.getRequestDispatcher("ShowEmployeeDetailServlet");
			rd.forward(request, response);
		}
	}

}
