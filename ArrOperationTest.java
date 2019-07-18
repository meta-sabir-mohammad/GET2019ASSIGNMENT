package Assignment4;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	FixXYMethodNegativeCasesTest.class,
	FixXYMethodPositiveCasesTest.class,
	MirrorSectionSizeMethodNegativeCasesTest.class,
	MirrorSectionSizeMethodPositiveCasesTest.class,
	NumberOfClumpsMethodNegativeCasesTest.class,
	NumberOfClumpsMethodPositiveCasesTest.class,
	SplitIndexMethodNegativeCasesTest.class,
	SplitIndexMethodPositiveCasesTest.class
})

/**
 * This is suite test class for ArrOperation Class
 * this class will run all the test classes for all the methods of ArrOperation Class
 * @author Sabir
 *
 */
public class ArrOperationTest {
	
}
