package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Product;
import dto.User;
import facade.ShoppingCartFacade;

/**
 * This servlet remove product form cart
 * @author Sabir
 */
@WebServlet("/RemoveProductFromCartServlet")
public class RemoveProductFromCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveProductFromCartServlet() {
		super();
		
	}

	/**
	 * This method remove product form cart
	 * @param request object of HttpServletRequest
	 * @param request object of HttpServletResponse
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Product product = new Product();
		product.setProductCode(Integer.parseInt(request.getParameter("id")));
		product.setQuantity(0);

		HttpSession session = request.getSession();
		User user = new User();
		user.setUserName((String) session.getAttribute("userName"));

		ShoppingCartFacade shoppingCartFacade = ShoppingCartFacade.getInstance();
		boolean result = shoppingCartFacade.removeProductFromCart(user, product);

		if (result) {
			session.setAttribute("message", "Product successfully removed");
			RequestDispatcher rd = request.getRequestDispatcher("ShowCartServlet");
			rd.forward(request, response);
		} else {
			session.setAttribute("message", "Product remove failed");
			RequestDispatcher rd = request.getRequestDispatcher("ShowCartServlet");
			rd.forward(request, response);
		}
	}
	
	/**
	 * This method remove product form cart
	 * @param request object of HttpServletRequest
	 * @param request object of HttpServletResponse
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Product product = new Product();
		product.setProductCode(Integer.parseInt(request.getParameter("id")));
		product.setQuantity(0);

		HttpSession session = request.getSession();
		User user = new User();
		user.setUserName((String) session.getAttribute("userName"));

		ShoppingCartFacade shoppingCartFacade = ShoppingCartFacade.getInstance();
		boolean result = shoppingCartFacade.removeProductFromCart(user, product);

		if (result) {
			session.setAttribute("message", "Product successfully removed");
			RequestDispatcher rd = request.getRequestDispatcher("ShowCartServlet");
			rd.forward(request, response);
		} else {
			session.setAttribute("message", "Product remove failed");
			RequestDispatcher rd = request.getRequestDispatcher("ShowCartServlet");
			rd.forward(request, response);
		}
	}

}
