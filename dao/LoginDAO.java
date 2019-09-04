package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DatabaseQuery;
import dto.Employee;
import factory.ConnectionFactory;

/**
 * This is dao class for login management
 * @author Sabir
 *
 */
public class LoginDAO {

	//Singleton object of LoginDAO
	private static LoginDAO loginDAO = null;

	/**
	 * This method return object of LoginDAO
	 * @return object of LoginDAO
	 */
	public static LoginDAO getInstance(){

		if(loginDAO == null){
			loginDAO = new LoginDAO();
		}
		return loginDAO;
	}

	/**
	 * This method authenticate user details 
	 * @param user object of User class
	 * @return true if user details are correct else false
	 * @throws SQLExcepion exception related to database
	 * @throws Excepiton other general exception
	 */
	public boolean login(Employee employee) throws SQLException, Exception{

		Connection conn = null;
		CallableStatement callStmt = null;

		try {
			conn = ConnectionFactory.getConnection();
			callStmt = conn.prepareCall(DatabaseQuery.CHECK_LOGIN);
			callStmt.setString(1, employee.getEmail());
			callStmt.setString(2, String.valueOf(employee.getPassword()));
			ResultSet result = callStmt.executeQuery();
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
				callStmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
