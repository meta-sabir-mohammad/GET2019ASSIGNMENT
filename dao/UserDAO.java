package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.User;
import factory.ConnectionFactory;
import factory.DatabaseQuery;

public class UserDAO {

	private static UserDAO userDAO = null;
	
	public static UserDAO getInstance(){
		if(userDAO == null){
			userDAO =  new UserDAO();
		}
		return userDAO;
	}
	
	public boolean addUser(User user){
		
		return true;
	}
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
