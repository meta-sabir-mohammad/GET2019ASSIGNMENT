package Assignment4C;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * This test class test methods of MassCalculator class
 * @author Sabir
 *
 */
public class MassCalculatorTest {

	/**
	 * This test method test positive test cases on calculateMass method of MassCalulator class
	 */
	@Test
	public void calculateMassMethodPositiveCasesTest() {
		
		MassCalculator massCalculator = new MassCalculator();
		
		String formula1 = "C2H4";
		String formula2 = "H2O";
		String formula3 = "CO2";
		String formula4 = "C(OH)3";
		String formula5 = "OH";
		try {
			assertEquals(28,massCalculator.calculateMass(formula1));
			assertEquals(18,massCalculator.calculateMass(formula2));
			assertEquals(44,massCalculator.calculateMass(formula3));
			assertEquals(63,massCalculator.calculateMass(formula4));
			assertEquals(17,massCalculator.calculateMass(formula5));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * This test method test negative test cases on calculateMass method of MassCalulator class
	 */
	@Test(expected = Exception.class)
	public void calculateMassMethodNegativeCasesTest() throws Exception {
		
		MassCalculator massCalculator = new MassCalculator();
	
		String formula = "C(OH3";
		assertEquals(63,massCalculator.calculateMass(formula));
	}

}
