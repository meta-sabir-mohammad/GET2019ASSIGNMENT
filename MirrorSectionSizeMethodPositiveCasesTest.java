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
 * This is the test Class to test positive test cases of getSizeOfLargestMirrorSectionInArray method in ArrOperation Class
 * @author Sabir
 *
 */
@RunWith(Parameterized.class)
public class MirrorSectionSizeMethodPositiveCasesTest {

	private int expected;
	private int inputArray[];
	static ArrOperation arrOperation;

	public MirrorSectionSizeMethodPositiveCasesTest(int expected, int inputArray[]) {
		
		this.expected = expected;
		this.inputArray = inputArray;
	}
	
	//defining positive test cases
	@Parameters
	public static Collection<Object[]> testData(){
		
		Object[][]  data = new Object[][] {{6,new int[] {1,1,1,1,1,1}},{3,new int[] {1,2,3,4,5,3,2,1}},{3,new int[] {4,4,4}},{2,new int[] {1,2,4,5,2,1,4}},{3,new int[] {1,2,3,5,4,3,2,1,4,5}}};
		return Arrays.asList(data);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		arrOperation = new ArrOperation();
	}

	/**
	 *This test method check getSizeOfLargestMirrorSectionInArray output
	 *Method take a positive integer array as an input and return size of largest mirror section if present 
	 */
	@Test
	public void testGetSizeOfLargestMirrorSectionInArray() {
		
		int actual = arrOperation.getSizeOfLargestMirrorSectionInArray(inputArray);
		assertEquals(expected,actual);
	}

}
