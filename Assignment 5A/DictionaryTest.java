package Assignment5A;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * This test class test the methods of Dictionary class
 * @author Sabir
 *
 */
public class DictionaryTest {

	static String keyValuePairsJsonString = "";
	
	/**
	 * initializing the json key value pair string
	 */
	@BeforeClass
	public static void setUpBeforeClass(){
		
		keyValuePairsJsonString = " {"
											+ "\"keys\" : [\"1\"] ,"
											+ "\"values\" : [\"apple\"]"
											+ "}";
	}

	/**
	 * This test method test positive case on add method of Dictionary class
	 */
	@Test
	public void addMethodPositiveCasesTest() {
		
		String key1 = "2";
		String key2 = "3";
		String key3 = "4";
		String value1 = "banana";
		String value2 = "orange";
		String value3 = "water melon";
		try{
			Dictionary dictionary = new Dictionary(keyValuePairsJsonString);
			assertTrue(dictionary.add(key1, value1));
			assertTrue(dictionary.add(key2, value2));
			assertTrue(dictionary.add(key3, value3));
		}catch(Exception e){
			
		}
		
	}

	/**
	 * This test method test positive case on delete method of Dictionary class
	 */
	@Test
	public void deleteMethodPositiveCasesTest() {
		try{
			Dictionary dictionary = new Dictionary(keyValuePairsJsonString);
			assertTrue(dictionary.delete("1"));
		}catch(Exception e){
			
		}
	}

	/**
	 * This test method test positive case on get method of Dictionary class
	 */
	@Test
	public void getMethodPositiveCasesTest() {
		try{
			Dictionary dictionary = new Dictionary(keyValuePairsJsonString);
			assertEquals("apple",dictionary.get("1"));
		}catch(Exception e){
			
		}
		
	}

	/**
	 * This test method test positive case on getSortedKeyValuePairs method of Dictionary class
	 */
	@Test
	public void getSortedKeyValuePairsMethodPositiveCasesTest() {
		
		String key1 = "2";
		String key2 = "3";
		String key3 = "4";
		String value1 = "banana";
		String value2 = "orange";
		String value3 = "water melon";
		try{
			Dictionary dictionary = new Dictionary(keyValuePairsJsonString);
			assertTrue(dictionary.add(key1, value1));
			assertTrue(dictionary.add(key2, value2));
			assertTrue(dictionary.add(key3, value3));
			String expectedKeyValuePairs[][] = new String[][]{{"1","apple"},{"2","banana"},{"3","orange"},{"4","water melon"}};
			assertArrayEquals(expectedKeyValuePairs,dictionary.getSortedKeyValuePairs());
		}catch(Exception e){
		
		}
	}

	/**
	 * This test method test positive case on getSortedKeyValuePairs method of Dictionary classwhich return pairs between two given keys 
	 */
	@Test
	public void getSortedKeyValuePairsStringStringMethodPositiveCasesTest() {
		
		String key1 = "2";
		String key2 = "3";
		String key3 = "4";
		String value1 = "banana";
		String value2 = "orange";
		String value3 = "water melon";
		try{
			Dictionary dictionary = new Dictionary(keyValuePairsJsonString);
			assertTrue(dictionary.add(key1, value1));
			assertTrue(dictionary.add(key2, value2));
			assertTrue(dictionary.add(key3, value3));
			String expectedKeyValuePairs[][] = new String[][]{{"2","banana"},{"3","orange"}};
			assertArrayEquals(expectedKeyValuePairs,dictionary.getSortedKeyValuePairs("2","3"));
		}catch(Exception e){
			
		}
	}
	
	/**
	 * This test method test negative case on add method of Dictionary class
	 */
	@Test(expected = Exception.class)
	public void addMethodNegativetiveCasesTest() throws Exception{
		
		String key1 = "1";
		String value1 = "banana";
		Dictionary dictionary = new Dictionary(keyValuePairsJsonString);
		assertTrue(dictionary.add(key1, value1));
	}

	/**
	 * This test method test negative case on delete method of Dictionary class
	 */
	@Test(expected = Exception.class)
	public void deleteMethodNegativeCasesTest() throws Exception{
		
		Dictionary dictionary = new Dictionary(keyValuePairsJsonString);
		assertTrue(dictionary.delete("2"));
	}

	/**
	 * This test method test negative case on get method of Dictionary class
	 */
	@Test(expected = Exception.class)
	public void getMethodNegativeCasesTest()  throws Exception{
		
		Dictionary dictionary = new Dictionary(keyValuePairsJsonString);
		assertEquals("apple",dictionary.get("2"));
		
	}

	/**
	 * This test method test negative case on getSortedKeyValuePairs method of Dictionary class
	 */
	@Test(expected = Exception.class)
	public void getSortedKeyValuePairsMethodNegativeCasesTest() throws Exception{
		
		String key1 = "1";
		Dictionary dictionary = new Dictionary(keyValuePairsJsonString);
		assertTrue(dictionary.delete(key1));
		dictionary.getSortedKeyValuePairs();
	}

	/**
	 * This test method test negative case on getSortedKeyValuePairs method of Dictionary class which return pairs between two given keys 
	 */
	@Test(expected = Exception.class)
	public void getSortedKeyValuePairsStringStringMethodNegativeCasesTest() throws Exception {
		
		String key1 = "1";
		String key2 = "2";
		String key3 = "3";
		Dictionary dictionary = new Dictionary(keyValuePairsJsonString);
		assertTrue(dictionary.delete(key1));
		dictionary.getSortedKeyValuePairs(key2, key3);
		
	}

}
