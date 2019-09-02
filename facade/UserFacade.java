package facade;

import dao.UserDAO;
import dto.User;

public class UserFacade {

	public boolean addUser(User user){
		
		return true;
	}
	
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
