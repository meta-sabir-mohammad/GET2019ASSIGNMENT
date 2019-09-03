package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Product;

/**
 * This servlet is used to redirect to add product page
 * @author Sabir
 */
@WebServlet("/RedirectToAddProductPage")
public class RedirectToAddProductPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RedirectToAddProductPage() {
		super();
	}

	/**
	 * This method is used to redirect to add product page
	 * @param request object of HttpServletRequest
	 * @param request object of HttpServletResponse
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product product = new Product();
		product.setProductCode(Integer.parseInt(request.getParameter("id")));
		product.setName(request.getParameter("name"));
		product.setPrice(Double.parseDouble(request.getParameter("price")));
		HttpSession session = request.getSession();
		session.setAttribute("product", product);
		response.sendRedirect("jsp/private/addproduct.jsp");
	}

}
