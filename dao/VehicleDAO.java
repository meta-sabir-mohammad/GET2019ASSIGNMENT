package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DatabaseQuery;
import dto.Vehicle;
import factory.ConnectionFactory;

/**
 * This is dao class for vehicle
 * @author Sabir
 *
 */
public class VehicleDAO {

	//Singleton object of VehicleDAO
	private static VehicleDAO vehicleDAO = null;

	/**
	 * This method return the object of VehicleDAO
	 * @return object of VehicleDAO
	 */
	public static VehicleDAO getInstance(){

		if(vehicleDAO == null){
			vehicleDAO = new VehicleDAO();
		}
		return vehicleDAO;
	}

	/**
	 * This method add vehicle details to database
	 * @param vehicle object of Vehicle containing details of vehicle
	 * @param empId employee id
	 * @return true if added else false
	 * @throws SQLException exception related to database
	 * @throws Exception other general exception
	 */
	public boolean addVehicle(Vehicle vehicle, int empId) throws SQLException,Exception{

		Connection conn = null;
		CallableStatement callStmt = null;
		try{
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			callStmt = conn.prepareCall(DatabaseQuery.ADD_VEHICLE);
			callStmt.setString(1, vehicle.getName());
			callStmt.setString(2, vehicle.getType());
			callStmt.setString(3, vehicle.getNumber());
			callStmt.setString(4, vehicle.getIdentification());
			callStmt.setInt(5, empId);
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
	 * This method return the vehicle id from database
	 * @param empId employee id
	 * @return integer vehicle id
	 * @throws SQLException exception related to database
	 * @throws Exception other general exception
	 */
	public int getVehicleId(int empId) throws SQLException, Exception{
		
		Connection conn = null;
		CallableStatement callStmt = null;
		try{
			conn = ConnectionFactory.getConnection();
			callStmt = conn.prepareCall(DatabaseQuery.GET_VEHICLE_ID);
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
	
	/**
	 * This method return the type of vehicle
	 * @param empId employee id
	 * @return String containing type of vehicle of employee
	 * @throws SQLException exception related to database
	 * @throws Exception other general exception
	 */
	public String getVehicleType(int empId) throws SQLException,Exception{

		Connection conn = null;
		CallableStatement callStmt = null;
		try{
			conn = ConnectionFactory.getConnection();
			callStmt = conn.prepareCall(DatabaseQuery.GET_VEHICLE_TYPE);
			callStmt.setInt(1, empId);
			ResultSet result = callStmt.executeQuery();
			result.next();
			return result.getString(1);
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
