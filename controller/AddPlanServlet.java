package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Plan;
import facade.EmployeeFacade;
import facade.PlanFacade;
import util.Validation;

/**
 * This servlet add vehicle plan
 * @author Sabir
 *
 */
@WebServlet("/AddPlanServlet")
public class AddPlanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPlanServlet() {
		super();
	}

	/**
	 * This method add vehicle plan
	 * @param request object of HttpServletRequest
	 * @param response object of HttpServletResponse
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Plan plan = new Plan();
		HttpSession session = request.getSession();
		try {
			plan.setCurrency(request.getParameter("CurrencySelect"));
			plan.setType(request.getParameter("VehiclePlan"));
			plan.setPrice(Double.parseDouble(request.getParameter("TotalCost")));

			Validation validate = new Validation();
			String error = validate.validatePlanDetail(plan);
			if (!error.equals("")) {
				session.setAttribute("error", error);
				response.sendRedirect("jsp/private/register/planregister.jsp");
			}

			PlanFacade planFacade = PlanFacade.getInstance();
			EmployeeFacade employeeFacade = EmployeeFacade.getInstance();

			String email = (String) session.getAttribute("email");
			int empId = employeeFacade.getEmployeeId(email);
			boolean result = planFacade.addPlan(plan, empId);

			if (result) {
				RequestDispatcher rd = request.getRequestDispatcher("ShowEmployeeDetailServlet");
				rd.forward(request, response);
			} else {
				session.setAttribute("error", "Plan registration failed");
				RequestDispatcher rd = request.getRequestDispatcher("LogoutServlet");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			session.setAttribute("error", "Plan registration failed");
			RequestDispatcher rd = request.getRequestDispatcher("LogoutServlet");
			rd.forward(request, response);
		}
	}

}
