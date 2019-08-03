package Assignment4B;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * This class find unique character in strings
 * @author Sabir
 *
 */
public class UniqueCharacterFinder {
	
	//HashMap contain string for checking for duplicate string if comes
	private HashMap<String,Set<Character>> stringCache;
	
	/**
	 * Parameterized constructor 
	 */
	public UniqueCharacterFinder(){
		stringCache = new HashMap<String,Set<Character>>();
	}
	
	/**
	 * This method find total unique character in given string
	 * @param inputString string containing different characters
	 * @return number of unique character 
	 */
	public int getNumberOfUniqueCharacters(String inputString){
		
		if(stringCache.containsKey(inputString)){
			return stringCache.get(inputString).size();
		}
		else{
			Set<Character> uniqueCharacterSet=new HashSet<Character>();
			for(int charIndex=0;charIndex<inputString.length();charIndex++){
				uniqueCharacterSet.add(inputString.charAt(charIndex));
			}
			stringCache.put(inputString, set);
		}
		return uniqueCharacterSet.size();
	}
}