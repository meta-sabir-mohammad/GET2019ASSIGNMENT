package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Vehicle;
import facade.VehicleFacade;
import util.Validation;

/**
 * This servlet add vehicle details
 * @author Sabir
 *
 */
@WebServlet("/AddVehicleServlet")
public class AddVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddVehicleServlet() {
		super();
	}
	
	/**
	 * This method add vehicle details
	 * @param request object of HttpServletRequest
	 * @param response object of HttpServletResponse
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		try {
			Vehicle vehicle = new Vehicle();
			vehicle.setName(request.getParameter("vehiclename"));
			vehicle.setType(request.getParameter("vehicletype"));
			vehicle.setNumber(request.getParameter("vehiclenumber"));
			vehicle.setIdentification(request.getParameter("identification"));
			int empId = Integer.parseInt(request.getParameter("empid"));

			Validation validate = new Validation();
			String error = validate.validateVehicleDetail(vehicle, empId);

			if (!error.equals("")) {
				session.setAttribute("error", error);
				response.sendRedirect("jsp/private/vehicleregister.jsp");
			}

			VehicleFacade vehicleFacade = VehicleFacade.getInstance();

			boolean result = vehicleFacade.addVehicle(vehicle, empId);
			if (result) {
				request.setAttribute("vehicleType", vehicle.getType());
				RequestDispatcher rd = request.getRequestDispatcher("RedirectToPlanRegistrationPage");
				rd.forward(request, response);
			} else {
				session.setAttribute("error", "Vehicle not added");
				response.sendRedirect("jsp/login.jsp");
			}
		} catch (Exception e) {
			session.setAttribute("error", "Vehicle not added");
			response.sendRedirect("jsp/login.jsp");
		}

	}

}
