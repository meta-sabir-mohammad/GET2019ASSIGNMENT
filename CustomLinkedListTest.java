package Assignment1;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * This is test class which test positive and negative test case on methods of CustomLinkedList Class
 * @author Sabir
 *
 */
public class CustomLinkedListTest {

	/**
	 * This test method test positive cases on add method of CustomLinkedList class
	 */
	@Test
	public void addMethodPositiveCasesTest() {
	
		CustomLinkedList  customLinkedList = new CustomLinkedList();
		assertTrue(customLinkedList.add(1));
		assertTrue(customLinkedList.add(2));
		assertTrue(customLinkedList.add(3));
	}

	/**
	 * This test method test positive cases on add at index method of CustomLinkedList class
	 * @throws Exception when index is invalid
	 */
	@Test
	public void addAtIndexMethodPositiveCasesTest() throws Exception{
		CustomLinkedList  customLinkedList = new CustomLinkedList();
		customLinkedList.add(1);
		customLinkedList.add(2);
		customLinkedList.add(3);
		assertTrue(customLinkedList.add(1, 4));
	}

	/**
	 * This test method test positive cases on get method of CustomLinkedList class
	 * @throws Exception when index is invalid or linked list is empty
	 */
	@Test
	public void getMethodPositiveCasesTest() throws Exception{
		CustomLinkedList  customLinkedList = new CustomLinkedList();
		customLinkedList.add(1);
		customLinkedList.add(2);
		customLinkedList.add(3);
		assertEquals(2,customLinkedList.get(1));
	}

	/**
	 * This test method test positive cases on remove method of CustomLinkedList class
	 * @throws Exception when index is invalid or linked list is empty
	 */
	@Test
	public void removeMethodPositiveCasesTest() throws Exception{
		CustomLinkedList  customLinkedList = new CustomLinkedList();
		customLinkedList.add(1);
		customLinkedList.add(2);
		customLinkedList.add(3);
		assertTrue(customLinkedList.remove(1));
	}

	/**
	 * This test method test negative cases on add method of CustomLinkedList class
	 * @throws Exception when index is invalid
	 */
	@Test(expected = Exception.class)
	public void addAtIndexMethodNegativeCasesTest() throws Exception{
		CustomLinkedList  customLinkedList = new CustomLinkedList();
		customLinkedList.add(1);
		customLinkedList.add(2);
		customLinkedList.add(3);
		assertTrue(customLinkedList.add(-1, 4));
	}

	/**
	 * This test method test negative cases on get method of CustomLinkedList class
	 * @throws Exception when index is invalid or linked list is empty
	 */
	@Test(expected = Exception.class)
	public void getMethodNegativeCasesTest() throws Exception{
		CustomLinkedList  customLinkedList = new CustomLinkedList();
		customLinkedList.add(1);
		customLinkedList.add(2);
		customLinkedList.add(3);
		assertEquals(2,customLinkedList.get(-1));
	}

	/**
	 * This test method test negative cases on remove method of CustomLinkedList class
	 * @throws Exception when index is invalid or linked list is empty
	 */
	@Test(expected = Exception.class)
	public void removeMethodNegativeCasesTest() throws Exception{
		CustomLinkedList  customLinkedList = new CustomLinkedList();
		customLinkedList.add(1);
		customLinkedList.add(2);
		customLinkedList.add(3);
		assertTrue(customLinkedList.remove(-1));
	}

}
