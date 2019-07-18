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
 * This is test class for testing positive test cases of getSplitIndexInArray method of ArrOperation Class
 * @author Sabir
 *
 */
@RunWith(Parameterized.class)
public class SplitIndexMethodPositiveCasesTest {

	private int expected;
	private int inputArray[];
	static ArrOperation arrOperation;
	
	public SplitIndexMethodPositiveCasesTest(int expected, int inputArray[]) {
		this.expected = expected;
		this.inputArray = inputArray;
	}
	
	//defining positive test cases
	@Parameters
	public static Collection<Object[]> testData(){
		Object[][]  data = new Object[][] {{3,new int[] {1,1,1,1,1,1}},{-1,new int[] {1,2,3,4,5,3,2,1}},{-1,new int[] {4,4,4}},{3,new int[] {1, 1, 1, 2, 1}},{1,new int[] {10, 10}}};
		return Arrays.asList(data);
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		arrOperation = new ArrOperation();
	}
	
	/**
	 * This test method check getSplitIndexInArray method output
	 * getSplitIndexInArray method take an array as input and return an index of element 
	 * if the sum of both side is equal from that index else -1
	 */
	@Test
	public void testGetSplitIndexInArray() {
		int actual = arrOperation.getSplitIndexInArray(inputArray);
		assertEquals(expected,actual);
	}
}
