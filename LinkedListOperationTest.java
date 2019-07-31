package Assignment1;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * This is test class to test positive and negative cases on methods of LinkedListOperation class
 * @author Sabir
 *
 */
public class LinkedListOperationTest {

	//object of LinkedListOperation class
	static LinkedListOperation linkedListOperation;
	
	/**
	 * This method initialize the object of LinkedListOperation class 
	 */
	@BeforeClass
	public static void setUpBeforeClass(){
		linkedListOperation = new LinkedListOperation();
	}

	/**
	 * This test method test positive cases on rotateSubListClockWise method of LinkedListOperation class
	 * @throws Exception when indexes are invalid
	 */
	@Test
	public void rotateSubListClockWiseMethodPositiveCasesTest() throws Exception {
		
		LinkedList<Integer> list=new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		int left=2;
		int right=5;
		int rotations=3;
		LinkedList<Integer> expected=new LinkedList<Integer>();
		expected.add(1);
		expected.add(5);
		expected.add(2);
		expected.add(3);
		expected.add(4);
		expected.add(6);
		assertEquals(expected,linkedListOperation.rotateSubListClockWise(list, left, right, rotations));
	}
	
	/**
	 * This test method test negative cases on rotateSubListClockWise method of LinkedListOperation class
	 * @throws Exception when indexes are invalid
	 */
	@Test(expected = Exception.class)
	public void rotateSubListClockWiseMethodNegativeCasesTest() throws Exception {
		
		LinkedList<Integer> list=new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		int left=-1;
		int right=5;
		int rotations=3;
		LinkedList<Integer> expected=new LinkedList<Integer>();
		expected.add(1);
		expected.add(5);
		expected.add(2);
		expected.add(3);
		expected.add(4);
		expected.add(6);
		assertEquals(expected,linkedListOperation.rotateSubListClockWise(list, left, right, rotations));
	}

	/**
	 * This test method test positive cases on isLoopPresent method of LinkedListOperation class
	 * @throws Exception when linked list is empty
	 */
	@Test
	public void loopPresentMethodPositiveCasesTest() throws Exception {
		
		CustomLinkedList list=new CustomLinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		assertFalse(linkedListOperation.isLoopPresent(list));
		linkedListOperation.createLoopInLinkedList(list, 3);
		assertTrue(linkedListOperation.isLoopPresent(list));
	}
	
	/**
	 * This test method test negative cases on isLoopPresent method of LinkedListOperation class
	 * @throws Exception when linked list is empty
	 */
	@Test(expected = Exception.class)
	public void isLoopPresentMethodNegativeCasesTest() throws Exception {
		
		CustomLinkedList list=new CustomLinkedList();
		assertFalse(linkedListOperation.isLoopPresent(list));
	}

	/**
	 * This test method test positive cases on getDegreeOfPolynomial method of LinkedListOperation class
	 * @throws Exception if polynomial string is empty
	 */
	@Test
	public void getDegreeOfPolynomialMethodPositiveCasesTest() throws Exception {

		assertEquals(27,linkedListOperation.getDegreeOfPolynomial("-4x3y+3xy-5vgh+4yu-89y-96g25fr"));
		assertEquals(36,linkedListOperation.getDegreeOfPolynomial("4x35y+3xy-5vgh+4yu-89y-96g25fr"));
		assertEquals(5,linkedListOperation.getDegreeOfPolynomial("4x3y+3x2y3"));
	}
	
	/**
	 * This test method test negative cases on getDegreeOfPolynomial method of LinkedListOperation class
	 * @throws Exception if polynomial string is empty
	 */
	@Test(expected = Exception.class)
	public void getDegreeOfPolynomialMethodNegativeCasesTest() throws Exception {

		assertEquals(0,linkedListOperation.getDegreeOfPolynomial(""));
	}

}
