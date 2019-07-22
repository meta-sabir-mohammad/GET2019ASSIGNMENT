package Assignment6B;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * This Class will run both positive and negative test cases of Poly Class
 * @author Sabir
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	PolyNegativeTest.class,
	PolyPositiveTest.class
})
public class PolyTest {


}
