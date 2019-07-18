package Assignment4;

import java.util.Arrays;
import java.util.Collection;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * This is test class for testing negative test cases of getSplitIndexInArray method of ArrOperation Class
 * @author Sabir
 *
 */
@RunWith(Parameterized.class)
public class SplitIndexMethodNegativeCasesTest {

	private int inputArray[];
	static ArrOperation arrOperation;
	
	public SplitIndexMethodNegativeCasesTest(int inputArray[]) {
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
	 * Testing for empty array AssertionError in getSizeOfLargestMirrorSectionInArray
	 * Testing for AssertionError test case where array contain negative number in getSizeOfLargestMirrorSectionInArray
	 */
	@Test(expected = AssertionError.class)
	public void testGetSplitIndexInArray() {
		arrOperation.getSplitIndexInArray(inputArray);
	}
}
