package Assignment3B;

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
		assertTrue(queue.enQueue(1,11));
		assertTrue(queue.enQueue(2,12));
		assertTrue(queue.enQueue(3,13));
		assertTrue(queue.enQueue(4,14));
		assertTrue(queue.enQueue(5,15));
		assertTrue(queue.enQueue(6,16));
		assertTrue(queue.enQueue(7,17));
		assertTrue(queue.enQueue(8,18));
		assertTrue(queue.enQueue(9,19));
	}

	/**
	 * This test method test positive cases on deQueue method of PriorityQueue Class
	 * @param <T>
	 * @throws Exception when queue is empty
	 */
	@Test
	public void deQueueMethodPositiveCasesTest() throws Exception {
		
		IPriorityQueue queue = new PriorityQueue();
		
		queue.enQueue(1,11);
		queue.enQueue(2,12);
		queue.enQueue(3,"hello");
		queue.enQueue(4,14);
		queue.enQueue(5,15);
		queue.enQueue(6,16);
		queue.enQueue(7,'M');
		queue.enQueue(8,18);
		queue.enQueue(9,19);
		
		assertEquals(19,queue.deQueue());
		assertEquals(18,queue.deQueue());
		assertEquals('M',queue.deQueue());
		assertEquals(16,queue.deQueue());
		assertEquals(15,queue.deQueue());
		assertEquals(14,queue.deQueue());
		assertEquals("hello",queue.deQueue());
		assertEquals(12,queue.deQueue());
		assertEquals(11,queue.deQueue());
	}

	/**
	 * This test method test positive cases on isEmpty method of PriorityQueue Class
	 * @param <T>
	 */
	@Test
	public void isEmptyMethodPositiveCasesTest() {
		IPriorityQueue queue = new PriorityQueue();
		assertTrue(queue.isEmpty());
	}

	/**
	 * This test method test Positive cases on isFull method of PriorityQueue Class
	 * @param <T>
	 */
	@Test
	public void isFullMethodPositiveCasesTest(){
		
		IPriorityQueue queue = new PriorityQueue();
		try{
			queue.enQueue(1,11);
			queue.enQueue(2,12);
			queue.enQueue(3,13);
			queue.enQueue(4,14);
			queue.enQueue(5,15);
			queue.enQueue(6,16);
			queue.enQueue(7,17);
			queue.enQueue(8,18);
			queue.enQueue(9,19);
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
		queue.enQueue(1,11);
		queue.enQueue(2,12);
		queue.enQueue(3,13);
		queue.enQueue(4,14);
		queue.enQueue(5,15);
		queue.enQueue(6,16);
		queue.enQueue(7,17);
		queue.enQueue(8,18);
		queue.enQueue(9,19);
		queue.enQueue(9,19);
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
		queue.enQueue(1,11);
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
