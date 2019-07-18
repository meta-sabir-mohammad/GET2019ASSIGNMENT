package Assignment4;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * This test class test positive test cases for getNumberOfClumpsInArray method in ArrOperation Class 
 * @author Sabir
 *
 */
@RunWith(Parameterized.class)
public class NumberOfClumpsMethodPositiveCasesTest {

	private int expected;
	private int inputArray[];
	static ArrOperation arrOperation;
	
	public NumberOfClumpsMethodPositiveCasesTest(int expected, int inputArray[]){
		this.expected = expected;
		this.inputArray = inputArray;
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		arrOperation = new ArrOperation();
	}
	
	//defining positive test cases
	@Parameters
	public static Collection<Object[]> testData(){
		Object[][] data = new Object[][]{{ 0 , new int[]{1} },{ 0, new int[]{1,2,3,4,5,3,2,1} },{ 1 , new int[]{4,4,4}},{ 2 , new int[]{9,1,1,1,2,1,4,4} }};
		return Arrays.asList(data);
	}

	/**
	 * This test method test getNumberOfClumpsInArray method output
	 * Method take a positive integer array and return number of clumps in it
	 */
	@Test
	public void testGetNumberOfClumpsInArray() {
		int actual = arrOperation.getNumberOfClumpsInArray(inputArray);
		assertEquals(expected,actual);
	}

}
