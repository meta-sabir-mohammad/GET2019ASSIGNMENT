package Assignment5A;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * This test class test positive test cases for getTwoNumbersLCM method of MathOperation Class
 * @author Sabir
 *
 */
@RunWith(Parameterized.class)
public class GetTwoNumberLCMPositiveCasesTest {
	static MathOperation mathOperation;
	private int firstNumber;
	private int secondNumber;
	private int expected;
	
	public GetTwoNumberLCMPositiveCasesTest(int expected,int firstNumber,int secondNumber){
		this.expected = expected;
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}
	
	@Parameters
	public static Collection<Object[]> testData(){
		Object[][] data=new Object[][] { { 161 , 23 , 7 },{ 20 , 20 , 4 },{ 10 , 10 , 5 }};
		return Arrays.asList(data);
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		mathOperation = new MathOperation();
	}
	
	/**
	 * This test method test getTwoNumbersLCM method output
	 * method take two positive numbers greater than zero
	 * return their LCM
	 * for invalid input throws IOException
	 */
	@Test
	public void testGetTwoNumbersLCM() {
		try {
			int actual = mathOperation.getTwoNumbersLCM(firstNumber,secondNumber);
			assertEquals(expected,actual);;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
