package Assignment4A;
import java.util.ArrayList;
import java.util.Collections;

/**
 *  This class is for natural Order Sorting
 * @author Sabir
 *
 */
public class EmployeeSortNaturalOrder {
	
	private ArrayList<Employee> employeeList;
	
	public EmployeeSortNaturalOrder(ArrayList<Employee> employeeList){
		this.employeeList=employeeList;
	}
	
	/**
	 * This method sort the employee collection
	 * @return ArrayList containing sorted employee list
	 */
	public ArrayList<Employee> sort(){
		Collections.sort(this.employeeList);
		return this.employeeList;
	}
}