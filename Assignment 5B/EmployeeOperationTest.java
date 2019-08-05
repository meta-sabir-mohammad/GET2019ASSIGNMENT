package Assignment5B;

import static org.junit.Assert.assertTrue;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

/**
 * This is test class which test EmployeeOperation class methods
 * @author Sabir
 *
 */
class EmployeeOperationTest {

	/**
	 * This test method test positive cases on getSortedEmployeeList method of
	 * EmployeeOperation class
	 */
	@Test
	void testGetSortEmployeeList() {

		try {
			Employee emp1 = new Employee(1, "sabir", "chittorgarh", 20000, 21);
			Employee emp2 = new Employee(2, "pankaj", "UP", 20000, 22);
			Employee emp3 = new Employee(3, "abhishek", "jaipur", 25000, 22);
			Employee emp4 = new Employee(4, "manoj", "jaipur", 30000, 21);
			Employee emp5 = new Employee(5, "vinod", "jaipur", 40000, 23);

			EmployeeOperation empOperation = new EmployeeOperation();
			empOperation.addEmployee(emp1);
			empOperation.addEmployee(emp2);
			empOperation.addEmployee(emp3);
			empOperation.addEmployee(emp4);
			empOperation.addEmployee(emp5);

			LinkedList<Employee> expectedList = new LinkedList<Employee>();
			expectedList.add(emp5);
			expectedList.add(emp4);
			expectedList.add(emp3);
			expectedList.add(emp1);
			expectedList.add(emp2);

			LinkedList<Employee> actualList = empOperation.getSortedEmployeeList();
			for (int empIndex = 0; empIndex < expectedList.size(); empIndex++) {
				assertTrue(expectedList.get(0).getEmpName().equalsIgnoreCase(actualList.get(0).getEmpName()));
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
