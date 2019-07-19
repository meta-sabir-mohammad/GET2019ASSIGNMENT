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
 * This is test class to test getElementIndexByLinearSearch method of Search Class
 * @author Sabir
 *
 */
@RunWith(Parameterized.class)
public class GetElementIndexByLinearSearchMethodPositiveCasesTest {
	
	static Search search;
	private int expected;
	private int elementToSearch;
	private int inputArray[];
	
	public GetElementIndexByLinearSearchMethodPositiveCasesTest(int expected,int elementToSearch,int inputArray[]){
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
		Object[][] data = new Object[][] {{ 4,5 , new int[]{1,2,3,4,5} },{ 4,7 , new int[]{5,2,4,6,7,8} },{ 1, 8 , new int[]{7,8,5,41,3,6} }};
		return Arrays.asList(data);
	}

	/**
	 * This test method test getElementIndexByLinearSearch method of Search Class
	 * method take an array of integer 
	 * return index of element if found else -1
	 */
	@Test
	public void testGetElementIndexByLinearSearch() {
		assertEquals(expected,search.getElementIndexByLinearSearch(inputArray, elementToSearch));
	}

}
