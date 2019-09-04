package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DatabaseQuery;
import dto.Plan;
import factory.ConnectionFactory;

/**
 * This is dao class for Plan
 * @author Sabir
 *
 */
public class PlanDAO {

	//Singleton object of PlanDAO
	private static PlanDAO planDAO = null;

	/**
	 * This method return object of PlanDAO class
	 * @return object of PlanDAO class
	 */
	public static PlanDAO getInstance(){

		if(planDAO == null){
			planDAO = new PlanDAO();
		}
		return planDAO;
	}
	
	/**
	 * This method add plan details to database
	 * @param plan object of Plan containing details of plan
	 * @param empId employee id
	 * @return true if plan is added else false
	 * @throws SQLException exception related to database
	 * @throws Exception other general exception
	 */
	public boolean addPlan(Plan plan, int empId) throws SQLException,Exception{
		
		Connection conn = null;
		CallableStatement callStmt = null;
		try{
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			callStmt = conn.prepareCall(DatabaseQuery.ADD_PLAN);
			callStmt.setString(1, plan.getCurrency());
			callStmt.setString(2, plan.getType());
			callStmt.setDouble(3, plan.getPrice());
			callStmt.setInt(4, empId);
			int result = callStmt.executeUpdate();
			if(result > 0){
				conn.commit();
				conn.setAutoCommit(true);
				return true;
			}else{
				return false;
			}
		}catch(SQLException e){
			conn.rollback();
			conn.setAutoCommit(true);
			e.printStackTrace();
			throw e;
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		finally{
			try{
				conn.close();
				callStmt.close();
			}catch(SQLException e){
				e.printStackTrace();
				throw e;
			}
		}
	}
	
	/**
	 * This method find and return id of plan from database
	 * @param empId employee id
	 * @return integer plan id
	 * @throws SQLException exception related to database
	 * @throws Exception other general exception
	 */
	public int getPlanId(int empId) throws SQLException,Exception {
		
		Connection conn = null;
		CallableStatement callStmt = null;
		try{
			conn = ConnectionFactory.getConnection();
			callStmt = conn.prepareCall(DatabaseQuery.GET_PLAN_ID);
			callStmt.setInt(1, empId);
			ResultSet result = callStmt.executeQuery();
			result.next();
			return result.getInt(1);
		}catch(SQLException e){
			e.printStackTrace();
			throw e;
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		finally{
			try{
				conn.close();
				callStmt.close();
			}catch(SQLException e){
				e.printStackTrace();
				throw e;
			}
		}
	}
}
