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
 * This test class test positive test cases for fixXYInArray method of ArrOperation Class
 * @author Sabir
 *
 */
@RunWith(Parameterized.class)
public class FixXYMethodPositiveCasesTest {
	private int x;
	private int y;
	private int expected[];
	private int inputArray[];
	static ArrOperation arrOperation = new ArrOperation();
	
	public FixXYMethodPositiveCasesTest(int expected[], int inputArray[], int x,int y){
		this.expected = expected;
		this.inputArray = inputArray;
		this.x = x;
		this.y = y;
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		arrOperation = new ArrOperation();
	}

	@Parameters
	public static Collection<Object[]> testData(){
		Object[][] data=new Object[][] { { new int[]{1,2,3},new int[] {1,2,3},4,5 } , { new int[]{1,2,4,5,6,7,7,9,3,4,5},new int[]{1,2,4,7,6,5,7,5,3,4,9},4,5 } };
		return Arrays.asList(data);
	}

	/**
	 * This test method test fixXYInArray method output
	 * Method take an positive integer array with two integer value x and y
	 * and return array in which all y are placed at right place
	 */
	@Test
	public void testFixXYInArray() {
		int actual[] = arrOperation.fixXYInArray(inputArray, x, y);
		assertArrayEquals(expected, actual);
	}

}
