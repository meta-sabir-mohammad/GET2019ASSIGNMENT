package Assignment4;

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
public class FixXYMethodNegativeCasesTest {

	private int x;
	private int y;
	private int inputArray[];
	static ArrOperation arrOperation = new ArrOperation();
	
	public FixXYMethodNegativeCasesTest(int inputArray[],int x, int y){
		this.inputArray = inputArray;
		this.x = x;
		this.y = y;
	}
	
	//defining negative test cases
	@Parameters
	public static Collection<Object[]> testData(){
		Object[][] data=new Object[][] { {new int[] {},4,5 },{new int[] {1,2,3,4},4,5 } , {new int[]{1,2,4,7,6,5,7,5,4,4,9},4,5 },{new int[]{1,2,4,7,6,4,7,5,4,9},4,5 } };
		return Arrays.asList(data);
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		arrOperation = new ArrOperation();
	}
	
	/**
	 * Testing for test case where array is null in fixXYInArray method
	 * Testing for test case where array contain negative integer
	 * Testing for test case where x occur in the end in positive integer array in fixXYInArray method
	 * Testing for test case where unequal number of x and y is present in positive integer array in fixXYInArray method
	 * Testing for test case where two x occur continuously in positive integer array in fixXYInArray method
	 */
	@Test(expected = AssertionError.class)
	public void testFixXYInArray() {
		arrOperation.fixXYInArray(inputArray, x, y);
	}

}
