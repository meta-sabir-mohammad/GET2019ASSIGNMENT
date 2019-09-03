package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import facade.ShoppingCartFacade;

/**
 * This servlet show all product
 * @author Sabir
 */
@WebServlet("/ShowAllProductsServlet")
public class ShowAllProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAllProductsServlet() {
        super();
        
    }

	/**
	 * This method show all product available 
	 * @param request object of HttpServletRequest
	 * @param request object of HttpServletResponse 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ShoppingCartFacade shoppingCartFacade = ShoppingCartFacade.getInstance();
		HttpSession session = request.getSession();
		session.setAttribute("productsList", shoppingCartFacade.getAllProducts());
		response.sendRedirect("jsp/private/showallproduct.jsp");
	}
}
