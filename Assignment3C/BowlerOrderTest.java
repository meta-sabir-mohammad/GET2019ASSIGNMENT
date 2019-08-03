package Assignment3C;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * This is test class which test methods of BowlerOrder class
 * @author Sabir
 *
 */
public class BowlerOrderTest {

	/**
	 * This test method test positive test case on addBowler method of BowlerOrder class
	 * @throws Exception if queue is full
	 */
	@Test
	public void addBowlerMethodPositiveCasesTest() throws Exception {
		BowlerOrder sequence = new BowlerOrder(2);
		assertTrue(sequence.addBowler(new Bowler("Bumrah", 2)));
		assertTrue(sequence.addBowler(new Bowler("Jadeja", 1)));
	}

	/**
	 * This test method test positive test case on getBowler method of BowlerOrder class
	 * @throws Exception if queue is empty
	 */
	@Test
	public void getNextBowlerMethodPositiveCasesTest() throws Exception {
		BowlerOrder sequence = new BowlerOrder(3);
		assertTrue(sequence.addBowler(new Bowler("Bumrah", 2)));
		assertTrue(sequence.addBowler(new Bowler("Bhubhneshwar", 3)));
		assertTrue(sequence.addBowler(new Bowler("Jadeja", 1)));
		assertEquals("Bhubhneshwar", sequence.getNextBowler());
		assertEquals("Bumrah", sequence.getNextBowler());
		assertEquals("Bhubhneshwar", sequence.getNextBowler());
		assertEquals("Bumrah", sequence.getNextBowler());
		assertEquals("Bhubhneshwar", sequence.getNextBowler());
		assertEquals("Jadeja", sequence.getNextBowler());
	}

	/**
	 * This test method test negative test case on addBowler method of BowlerOrder class
	 * @throws Exception if queue is full
	 */
	@Test(expected = Exception.class)
	public void addBowlerNegativeCasesTest() throws Exception {
		BowlerOrder sequence = new BowlerOrder(2);
		assertTrue(sequence.addBowler(new Bowler("Bumrah", 2)));
		assertTrue(sequence.addBowler(new Bowler("Jadeja", 1)));
		assertTrue(sequence.addBowler(new Bowler("Jadeja", 1)));
		//assertTrue(sequence.addBowler(new Bowler("Jadeja", 1)));
	}

	/**
	 * This test method test negative test case on getBowler method of BowlerOrder class
	 * @throws Exception if queue is empty
	 */
	@Test(expected = Exception.class)
	public void getNextBowlerNegativeCasesTest() throws Exception {
		BowlerOrder sequence = new BowlerOrder(3);
		assertTrue(sequence.addBowler(new Bowler("Bumrah", 2)));
		assertTrue(sequence.addBowler(new Bowler("Bhubhneshwar", 3)));
		assertTrue(sequence.addBowler(new Bowler("Jadeja", 1)));
		assertEquals("Bhubhneshwar", sequence.getNextBowler());
		assertEquals("Bumrah", sequence.getNextBowler());
		assertEquals("Bhubhneshwar", sequence.getNextBowler());
		assertEquals("Bumrah", sequence.getNextBowler());
		assertEquals("Bhubhneshwar", sequence.getNextBowler());
		assertEquals("Jadeja", sequence.getNextBowler());
		sequence.getNextBowler();
	}

}
