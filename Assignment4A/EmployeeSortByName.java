package Assignment4A;
import java.util.Comparator;

/**
 * This class implements comparator to create custom compare employee by name
 * @author Sabir
 */
public class EmployeeSortByName implements Comparator<Employee>{
	
	/**
	 * This method compare two employee objects
	 * @param employeeFirst first employee object
	 * @param employeeSecond second employee object
	 * @return 1 if both are equal else 0
	 */
	@Override
	public int compare(Employee employeeFirst, Employee employeeSecond) {
		return employeeFirst.getName().compareTo(employeeSecond.getName());
	}
}