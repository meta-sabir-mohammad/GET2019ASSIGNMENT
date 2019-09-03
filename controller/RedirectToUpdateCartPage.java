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
 * Servlet implementation class RedirectToUpdateCartPage
 */
@WebServlet("/RedirectToUpdateCartPage")
public class RedirectToUpdateCartPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RedirectToUpdateCartPage() {
		super();
	}

	/**
	 * This method redirec to update cart page
	 * 
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
			response.sendRedirect("jsp/private/updatecart.jsp");
		} else {
			session.setAttribute("message", "Show cart operation failed!!!");
			response.sendRedirect("jsp/private/welcome.jsp");
		}
	}

}
