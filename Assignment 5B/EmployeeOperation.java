package Assignment5B;

import java.util.LinkedList;

/**
 * This class contain method to perform operation on employees
 * @author Sabir
 */
public class EmployeeOperation {

	// LinkedList which contain employee list
	LinkedList<Employee> employeeList = new LinkedList<Employee>();

	/**
	 * This method is use to add employee to employee list
	 * @param employee object of Employee class containing details of employee to be added
	 * @return true if added successfully else false
	 */
	public boolean addEmployee(Employee employee) {

		try {
			this.employeeList.add(employee);
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * This method is use to sort employee according to their salary in descending order
	 * @return LinkedList<Employee> containing all employee details
	 * @throws Exception when employee list is empty
	 */
	public LinkedList<Employee> getSortedEmployeeList() throws Exception {

		try {
			if (this.employeeList.size() == 0) {
				throw new Exception("Employee list is empty");
			}
			for (int currentEmployeeIndex = 1; currentEmployeeIndex < this.employeeList
					.size(); currentEmployeeIndex++) {
				int employeeIndex = 0;
				while (employeeIndex <= currentEmployeeIndex) {
					if (this.employeeList.get(employeeIndex).getEmpSalary() < this.employeeList
							.get(currentEmployeeIndex).getEmpSalary()) {
						arrangeEmployee(employeeIndex, currentEmployeeIndex);
					} else if (this.employeeList.get(employeeIndex).getEmpSalary() == this.employeeList
							.get(currentEmployeeIndex).getEmpSalary()) {
						if (this.employeeList.get(employeeIndex).getEmpAge() > this.employeeList
								.get(currentEmployeeIndex).getEmpAge()) {
							arrangeEmployee(employeeIndex, currentEmployeeIndex);
						}
					}
					employeeIndex++;
				}
			}
			return this.employeeList;
		} catch (Exception e) {
			System.out.println(e);
			throw e;
		}
	}

	/**
	 * This method is used to rearrange two employee position in list
	 * @param employeeNewIndex new index where employee need to be added
	 * @param employeeOldIndex old index where employee currently is
	 */
	private void arrangeEmployee(int employeeNewIndex, int employeeOldIndex) {

		try {
			Employee employee = this.employeeList.get(employeeOldIndex);
			this.employeeList.remove(employeeOldIndex);
			this.employeeList.add(employeeNewIndex, employee);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
