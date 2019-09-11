package com.sms.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import com.sms.dto.Student;
import com.sms.service.SMSService;

/**
 * This is test class for student management system
 * @author Sabir
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentManagementSystemTest {

	//Static object of SMSService class
	public static SMSService smsService = SMSService.getInstance();
	
	/**
	 * This method test positive cases on addStudent method of SMSService class
	 */
	@Test
	public void addStudentMethodPositiveTest() {
		
		Student student = new Student("Sabir","Mohammad","Abdul Hakeem Mansuri","sabirmansuri900@gmail.com","12","22");
		assertTrue(smsService.addStudent(student));
	}
	
	/**
	 * This test method test positive test case on getAllStudent method of SMSService
	 */
	@Test
	public void getAllStudentPositiveTest() {
		
		Student expected = new Student("Sabir","Mohammad","Abdul Hakeem Mansuri","sabirmansuri900@gmail.com","12","22");
		Student actual = smsService.getAllStudent().get(0);
		assertEquals(expected.getFirstName(),actual.getFirstName());
		assertEquals(expected.getLastName(), actual.getLastName());
		assertEquals(expected.getFatherName(),actual.getFatherName());
		assertEquals(expected.getEmail(), actual.getEmail());
		assertEquals(expected.getStudentClass(),actual.getStudentClass());
		assertEquals(expected.getAge(), actual.getAge());
	}
}
