package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.User;
import factory.ConnectionFactory;
import factory.DatabaseQuery;

/**
 * This class represent user dao
 * @author Sabir
 *
 */
public class UserDAO {

	//Singleton object of UserDAO class
	private static UserDAO userDAO = null;
	
	/**
	 * This method return object of UserDAO
	 * @return object of UserDAO
	 */
	public static UserDAO getInstance(){
		if(userDAO == null){
			userDAO =  new UserDAO();
		}
		return userDAO;
	}
	
	/**
	 * This method authenticate user details 
	 * @param user object of User class
	 * @return true if user details are correct else false
	 * @throws SQLException exception related to database
	 * @throws Exception other general exception
	 */
	public boolean login(User user) throws SQLException,Exception{
		
		Connection conn = null;
		PreparedStatement preStmt = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			preStmt = conn.prepareStatement(DatabaseQuery.CHECK_LOGIN);
			preStmt.setString(1, user.getUserName());
			preStmt.setInt(2, user.getPassword());
			ResultSet result = preStmt.executeQuery();
			while(result.next()){
				if(result.getInt(1) == 1){
					return true;
				}else{
					return false;
				}
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
		finally{
			try {
				conn.close();
				preStmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
