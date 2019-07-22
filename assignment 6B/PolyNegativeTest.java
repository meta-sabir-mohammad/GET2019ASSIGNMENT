package Assignment6B;

import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Test;

/*
 * This is test class to test methods of Poly Class
 */ 
public class PolyNegativeTest {	
	
	/*
	 * Testing for negative test cases of getPolynomial
	 */
	@Test(expected=IOException.class)
	public void testGetPolynomial1() throws IOException {
		//test case 1
		int array[]=new int[]{};
		Poly pol=new Poly(array);
		int expected[]=new int[]{1,2,3,4,5};
		int actual[]=pol.getPolynomial();
		assertArrayEquals(expected,actual);
	}
	/*
	 * Testing for negative test cases
	 */
	@Test(expected=IOException.class)
	public void testEvaluate2() throws IOException{
		//test case 1
		int b[]=new int[]{};
		Poly object2=new Poly(b);
		float numberSecond=5;
		float resultSecond=object2.evaluate(numberSecond);
		assertEquals(7896,resultSecond,0);
	}
	/*
	 * Testing for negative test cases
	 */
	@Test(expected=IOException.class)
	public void testDegree2() throws IOException {
		//test case 1
		int b[]=new int[]{};
		Poly object2=new Poly(b);
		assertEquals(-1456,object2.degree());
	}
	/*
	 * Testing for negative test cases
	 */
	@Test(expected=IOException.class)
	public void testAddPoly2() throws IOException {
		//test case 1
		int arrayFifth[]=new int[]{};
		int arraySixth[]=new int[]{1,2,3,4,5};
		Poly objectFifth=new Poly(arrayFifth);
		Poly objectSixth=new Poly(arraySixth);
		int actualThird[]=(objectFifth.addPoly(objectFifth, objectSixth)).getPolynomial();
		int expectedThird[]=new int[]{1,2,3,4,5};
		assertArrayEquals(expectedThird,actualThird);
	}
	/*
	 * Testing for negative test cases
	 */
	@Test(expected=IOException.class)
	public void testAddPoly3() throws IOException {
		//test case 1
		int arraySeventh[]=new int[]{};
		int arrayEight[]=new int[]{};
		Poly objectSeventh=new Poly(arraySeventh);
		Poly objectEight=new Poly(arrayEight);
		int actualFourth[]=(objectSeventh.addPoly(objectSeventh, objectEight)).getPolynomial();
		int expectedFourth[]=new int[]{};
		assertArrayEquals(expectedFourth,actualFourth);
	}
	/*
	 * Testing for negative test cases
	 */
	@Test(expected=IOException.class)
	public void testMultiplyPoly1() throws IOException {
		//test case 1
		int arrayFifth[]=new int[]{};
		int arraySixth[]=new int[]{1,2,3,4,5};
		Poly objectFifth=new Poly(arrayFifth);
		Poly objectSixth=new Poly(arraySixth);
		int actualThird[]=(objectFifth.multiplyPoly(objectFifth, objectSixth)).getPolynomial();
		int expectedThird[]=new int[]{0,0,0,0};
		assertArrayEquals(expectedThird,actualThird);
	}
	/*
	 * Testing for negative test cases
	 */
	@Test(expected=IOException.class)
	public void testMultiplyPoly2() throws IOException {
		//test case 1
		int arraySeventh[]=new int[]{};
		int arrayEight[]=new int[]{};
		Poly objectSeventh=new Poly(arraySeventh);
		Poly objectEight=new Poly(arrayEight);
		int actualFourth[]=(objectSeventh.multiplyPoly(objectSeventh, objectEight)).getPolynomial();
		int expectedFourth[]=new int[]{};
		assertArrayEquals(expectedFourth,actualFourth);
	}
}