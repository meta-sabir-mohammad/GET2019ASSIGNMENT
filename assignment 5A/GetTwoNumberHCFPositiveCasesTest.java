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
 * This test class test positive test cases for getTwoNumbersHCF method of MathOperation Class
 * @author Sabir
 *
 */
@RunWith(Parameterized.class)
public class GetTwoNumberHCFPositiveCasesTest {
	static MathOperation mathOperation;
	private int firstNumber;
	private int secondNumber;
	private int expected;
	
	public GetTwoNumberHCFPositiveCasesTest(int expected,int firstNumber,int secondNumber){
		this.expected = expected;
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}
	
	@Parameters
	public static Collection<Object[]> testData(){
		Object[][] data=new Object[][] { { 1 , 25 , 4 },{ 1 , 5 , 1 },{ 5 , 10 , 5 }};
		return Arrays.asList(data);
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		mathOperation = new MathOperation();
	}
	
	/**
	 * This test method test getTwoNumbersHCF method output
	 * method take two positive numbers greater than zero
	 * return their HCF
	 * for invalid input throws IOException
	 */
	@Test
	public void testGetTwoNumbersHCF() {
		try {
			int actual = mathOperation.getTwoNumbersHCF(firstNumber,secondNumber);
			assertEquals(expected,actual);;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
