package Assignment5B;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * This is test class to test getElementIndexByBinarySearch method of Search Class
 * @author Sabir
 *
 */
@RunWith(Parameterized.class)
public class GetElementIndexByBinarySearchMethodPositiveCasesTest {

	static Search search;
	private int expected;
	private int elementToSearch;
	private int inputArray[];
	
	public GetElementIndexByBinarySearchMethodPositiveCasesTest(int expected,int elementToSearch,int inputArray[]){
		this.elementToSearch = elementToSearch;
		this.inputArray = inputArray;
		this.expected = expected;
	}
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		search = new Search();
	}
	
	@Parameters
	public static Collection<Object[]> testData(){
		Object[][] data = new Object[][] {{ 4,5 , new int[]{1,2,3,4,5} },{ 4,7 , new int[]{2,4,5,6,7,8} },{ -1, 8 , new int[]{2,6,9,12,45} }};
		return Arrays.asList(data);
	}
	
	/**
	 * This test method test getElementIndexByBinarySearch method of Search Class
	 * this method take a sorted ascending order array
	 * return index of element if present else -1
	 */
	@Test
	public void testGetElementIndexByBinarySearch() {
		assertEquals(expected,search.getElementIndexByLinearSearch(inputArray, elementToSearch));
	}


}
