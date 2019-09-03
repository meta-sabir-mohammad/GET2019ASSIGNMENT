package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.User;
import facade.UserFacade;

/**
 * This servlet is used for login
 * @author Sabir
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * This method used to authenticate user and redirect to welcome page
	 * @param request object of HttpServletRequest
	 * @param request object of HttpServletResponse
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User user = new User();
		user.setUserName(request.getParameter("userName"));
		user.setPassword(Integer.parseInt(request.getParameter("password")));
		
		UserFacade userFacade = new UserFacade();
		boolean result = userFacade.login(user);
		
		HttpSession session = request.getSession();
		if(result){
			session.setAttribute("userName", user.getUserName());
			response.sendRedirect("jsp/private/welcome.jsp");
		}else{
			session.setAttribute("error","Login Failed!!!");
			response.sendRedirect("jsp/index.jsp");
		}
	}

}
