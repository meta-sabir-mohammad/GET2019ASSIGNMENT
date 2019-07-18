package Assignment4;

import java.util.Arrays;
import java.util.Collection;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * This test class test negative test cases for getNumberOfClumpsInArray method in ArrOperation Class 
 * @author Sabir
 *
 */
@RunWith(Parameterized.class)
public class NumberOfClumpsMethodNegativeCasesTest {

	private int inputArray[];
	static ArrOperation arrOperation;

	public NumberOfClumpsMethodNegativeCasesTest(int inputArray[]){
		
		this.inputArray = inputArray;
	}
	
	//defining negative test cases
	@Parameters
	public static Collection<Object[]> testData(){
		
		Object[][]  data = new Object[][] {{new int[] {}},{new int[] {1,2,3,4,-1,3,2,1}}};
		return Arrays.asList(data);
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		arrOperation = new ArrOperation();
	}
	
	/**
	 * Testing for empty array AssertionError in getNumberOfClumpsInArray method
	 * Testing for AssertionError test case where array contain negative integer
	 */
	@Test(expected = AssertionError.class)
	public void testGetNumberOfClumpsInArray() {
		arrOperation.getNumberOfClumpsInArray(inputArray);
	}

}
