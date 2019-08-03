package Assignment3C;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This is test class which test positive and negative cases on methods of PriorityQueue Class
 * @author Sabir
 *
 */
public class PriorityQueueTest {

	/**
	 * This test method test positive cases on enQueue method of PriorityQueue Class
	 * @throws Exception when queue is full
	 */
	@Test
	public void enQueueMethodPositiveCasesTest() throws Exception{
		
		IPriorityQueue queue = new PriorityQueue();
		assertTrue(queue.enQueue(1,"a"));
		assertTrue(queue.enQueue(2,"b"));
		assertTrue(queue.enQueue(3,"c"));
		assertTrue(queue.enQueue(4,"d"));
		assertTrue(queue.enQueue(5,"e"));
		assertTrue(queue.enQueue(6,"f"));
		assertTrue(queue.enQueue(7,"g"));
		assertTrue(queue.enQueue(8,"h"));
		assertTrue(queue.enQueue(9,"i"));
	}

	/**
	 * This test method test positive cases on deQueue method of PriorityQueue Class
	 * @throws Exception when queue is empty
	 */
	@Test
	public void deQueueMethodPositiveCasesTest() throws Exception {
		
		IPriorityQueue queue = new PriorityQueue();
		
		queue.enQueue(1,"a");
		queue.enQueue(2,"b");
		queue.enQueue(3,"c");
		queue.enQueue(4,"d");
		queue.enQueue(5,"e");
		queue.enQueue(6,"f");
		queue.enQueue(7,"g");
		queue.enQueue(8,"h");
		queue.enQueue(9,"i");
		
		assertEquals("i",queue.deQueue().getValue());
		assertEquals("h",queue.deQueue().getValue());
		assertEquals("g",queue.deQueue().getValue());
		assertEquals("f",queue.deQueue().getValue());
		assertEquals("e",queue.deQueue().getValue());
		assertEquals("d",queue.deQueue().getValue());
		assertEquals("c",queue.deQueue().getValue());
		assertEquals("b",queue.deQueue().getValue());
		assertEquals("a",queue.deQueue().getValue());	
	}

	/**
	 * This test method test positive cases on isEmpty method of PriorityQueue Class
	 */
	@Test
	public void isEmptyMethodPositiveCasesTest() {
		IPriorityQueue queue = new PriorityQueue();
		assertTrue(queue.isEmpty());
	}

	/**
	 * This test method test Positive cases on isFull method of PriorityQueue Class
	 */
	@Test
	public void isFullMethodPositiveCasesTest(){
		
		IPriorityQueue queue = new PriorityQueue();
		try{
			queue.enQueue(1,"a");
			queue.enQueue(2,"b");
			queue.enQueue(3,"c");
			queue.enQueue(4,"d");
			queue.enQueue(5,"e");
			queue.enQueue(6,"f");
			queue.enQueue(7,"g");
			queue.enQueue(8,"h");
			queue.enQueue(9,"i");
		
		}catch(Exception e){
			System.out.println(e);
		}
		
		assertTrue(queue.isFull());
		
	}
	
	/**
	 * This test method test negative cases on enQueue method of PriorityQueue Class
	 * @throws Exception when queue is full
	 */
	@Test(expected = Exception.class)
	public void enQueueMethodNegativeCasesTest() throws Exception{
		
		IPriorityQueue queue = new PriorityQueue();
		queue.enQueue(1,"a");
		queue.enQueue(2,"b");
		queue.enQueue(3,"c");
		queue.enQueue(4,"d");
		queue.enQueue(5,"e");
		queue.enQueue(6,"f");
		queue.enQueue(7,"g");
		queue.enQueue(8,"h");
		queue.enQueue(9,"i");
		queue.enQueue(9,"i");
	}

	/**
	 * This test method test negative cases on deQueue method of PriorityQueue Class
	 * @throws Exception when queue is empty
	 */
	@Test(expected = Exception.class)
	public void deQueueMethodNegativeCasesTest() throws Exception {
		
		IPriorityQueue queue = new PriorityQueue();
		assertEquals(11,queue.deQueue());
		
	}

	/**
	 * This test method test negative cases on isEmpty method of PriorityQueue Class
	 */
	@Test
	public void isEmptyMethodNegativeCasesTest() throws Exception {
		
		IPriorityQueue queue = new PriorityQueue();
		queue.enQueue(9,"i");
		assertFalse(queue.isEmpty());
	}

	/**
	 * This test method test negative cases on isFull method of PriorityQueue Class
	 */
	@Test
	public void isFullMethodNegativeCasesTest() throws Exception{
		
		IPriorityQueue queue = new PriorityQueue();
		assertFalse(queue.isFull());
	}

}
