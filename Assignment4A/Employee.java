package Assignment4A;

/**
 * This class represent employee
 * @author Sabir
 *
 */
public class Employee implements Comparable<Employee>{
	
	//employee id
	private final String EmpId;
	private final String name;
	private final String address;
	
	/**
	 * Parameterized constructor
	 * @param EMPID String type employee id
	 * @param name String type employee name
	 * @param address String type employee address
	 */
	public Employee(String EmpId,String name,String address){
		this.EmpId=EmpId;
		this.name=name;
		this.address=address;
	}
	
	/**
	 * This method return employee id
	 * @return String type Employee Id
	 */
	public String getEmpId() {
		return EmpId;
	}
	
	/**
	 * This method return employee name
	 * @return String type employee name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This method return employee address
	 * @return String type employee address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * This method compare employee
	 * @param employee object of Employee class
	 * @return 1 if both are same else 0
	 */
	@Override
	public int compareTo(Employee employee) {
		return this.getEmpId().compareTo(employee.getEmpId());
	}
}
