package Assignment4A;
import java.util.HashMap;

/**
 * This class represent unique employees
 * @author Sabir
 *
 */
public class UniqueEmployees {
	
	private HashMap<String,Employee> employeeMap;
	
	/**
	 * Default constructor
	 */
	public UniqueEmployees(){
		
		this.employeeMap=new HashMap<String,Employee>();
	}
	
	/**
	 * This method adds unique employee to existing collection
	 * @param Employee type employee
	 * @return true after Addition of Employee
	 */
	public boolean addEmployee(Employee employee){
	
		if(!this.employeeMap.containsKey(employee.getEMPID())){
			this.employeeMap.put(employee.getEMPID(),employee);
			return true;
		}
		return false;
	}
}