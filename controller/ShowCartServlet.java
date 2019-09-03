package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Cart;
import dto.User;
import facade.ShoppingCartFacade;

/**
 * This servlet show cart of user
 */
@WebServlet("/ShowCartServlet")
public class ShowCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowCartServlet() {
		super();

	}

	/**
	 * This method show cart of user
	 * @param request object of HttpServletRequest
	 * @param request object of HttpServletResponse 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ShoppingCartFacade shoppingCartFacade = ShoppingCartFacade.getInstance();
		HttpSession session = request.getSession();
		User user = new User();
		user.setUserName((String) session.getAttribute("userName"));
		Cart cart = shoppingCartFacade.getCart(user);

		if (cart != null) {
			session.setAttribute("cart", cart);
			response.sendRedirect("jsp/private/showcart.jsp");
		} else {
			session.setAttribute("message", "Show cart operation failed!!!");
			response.sendRedirect("jsp/private/welcome.jsp");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
