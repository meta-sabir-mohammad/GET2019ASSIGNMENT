package Assignment4A;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class contain method to perform on employee data
 * @author Sabir
 *
 */
public class EmployeeOperations {
	
	private ArrayList<Employee> employeeList;
	
	/**
	 * Default constructor
	 */
	public EmployeeOperations(){
		
		this.employeeList=new ArrayList<Employee>();
	}
	
	/**
	 * This method add employee to list
	 * @param Employee type employee
	 * @return boolean true after addition
	 */
	public boolean addEmployee(Employee employee){
		
		employeeList.add(employee);
		return true;
	}
	
	/**
	 * This method sort employee list by natural order
	 * @return sorted ArrayList of Employees
	 */
	public ArrayList<Employee> employeeSortNaturalOrder(){
		
		EmployeeSortNaturalOrder sort=new EmployeeSortNaturalOrder(employeeList);
		return sort.sort();
	}
	
	/**
	 * This method sort employee list by name
	 * @return ArrayList of Employees
	 */
	public ArrayList<Employee> employeeSortByName(){
		
		EmployeeSortByName sort=new EmployeeSortByName();
		Collections.sort(this.employeeList,sort);
		return this.employeeList;
	}
}