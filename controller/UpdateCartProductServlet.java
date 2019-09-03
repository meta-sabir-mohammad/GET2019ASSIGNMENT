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
 * This servlet update product in cart
 * @author Sabir
 */
@WebServlet("/UpdateCartProductServlet")
public class UpdateCartProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateCartProductServlet() {
		super();
	}

	/**
	 * This method update product in cart
	 * @param request object of HttpServletRequest
	 * @param request object of HttpServletResponse 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Product product = new Product();
		product.setProductCode(Integer.parseInt(request.getParameter("id")));
		product.setQuantity(Integer.parseInt(request.getParameter("quantity")));

		HttpSession session = request.getSession();
		User user = new User();
		user.setUserName((String) session.getAttribute("userName"));

		ShoppingCartFacade shoppingCartFacade = ShoppingCartFacade.getInstance();
		boolean result = shoppingCartFacade.updateProductQuantity(user, product);

		if (result) {
			session.setAttribute("message", "Product successfully updated");
			RequestDispatcher rd = request.getRequestDispatcher("ShowCartServlet");
			rd.forward(request, response);
		} else {
			session.setAttribute("message", "Product update failed");
			RequestDispatcher rd = request.getRequestDispatcher("ShowCartServlet");
			rd.forward(request, response);
		}
	}

}
