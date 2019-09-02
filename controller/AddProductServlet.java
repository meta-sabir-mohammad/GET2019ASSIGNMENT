package controller;

import java.io.IOException;

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
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddProductServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
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
		boolean result = shoppingCartFacade.addProductToCart(product, user);

		if (result) {
			session.setAttribute("message", "Product added successful");
			response.sendRedirect("jsp/private/showallproduct.jsp");
		} else {
			session.setAttribute("message", "Product adding unsuccessful");
			response.sendRedirect("jsp/private/showallproduct.jsp");
		}
	}

}
