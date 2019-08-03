package Assignment4B;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * This is test class which test methods of UniqueCharacterFinder class
 * @author Sabir
 */
public class UniqueCharacterFinderTest {

	/**
	 * This test method test positive test case on getNumberOfUniqueCharacters method in UniqueCharacterFinder class
	 */
	@Test
	public void getNumberOfUniqueCharactersMethodPositiveCasesTest() {
		
		UniqueCharacterFinder uniqueChracterFinder = new UniqueCharacterFinder();
		String input1 = "abcd";
		String input2 = "aaaa";
		String input3 = "rty567%^&";
		assertEquals(4,uniqueChracterFinder.getNumberOfUniqueCharacters(input1));
		assertEquals(1,uniqueChracterFinder.getNumberOfUniqueCharacters(input2));
		assertEquals(9,uniqueChracterFinder.getNumberOfUniqueCharacters(input3));
	}

}
