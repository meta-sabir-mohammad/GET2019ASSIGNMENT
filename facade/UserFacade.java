package facade;

import dao.UserDAO;
import dto.User;

/**
 * This class represetn UserFacade
 * @author Sabir
 *
 */
public class UserFacade {

	/**
	 * This method authenticate user details 
	 * @param user object of User class
	 * @return true if user details are correct else false
	 */
	public boolean login(User user){
		
		UserDAO userDAO = UserDAO.getInstance();
		try{
		 return userDAO.login(user);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
