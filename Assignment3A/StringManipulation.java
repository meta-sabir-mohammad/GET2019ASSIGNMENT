package Assignment3A;

/**
 * 
 * this class contain methods to manipulate strings we can perform
 * comparison,reverse of string, upper case to lower case etc
 *
 */
public class StringManipulation {

	/**
	 * To compare two strings
	 * @param firstString contain a not null case sensitive String
	 * @param secondString contain a not null case sensitive String
	 * @return Integer value 1 if strings are equal and 0 if not
	 */
	public int compareStrings(String firstString, String secondString) {

		char firstStringCharArray[] = firstString.toCharArray();
		int firstStringLength = firstString.length();

		char secondStringCharArray[] = secondString.toCharArray();
		int secondStringLength = secondString.length();

		if (firstStringLength != secondStringLength) {
			return 0;
		} else {
			int charIndex = 0;
			while (charIndex != firstStringLength - 1) {
				if (firstStringCharArray[charIndex] != secondStringCharArray[charIndex]) {
					return 0;
				}
				charIndex++;
			}
		}
		return 1;
	}

	/**
	 * To get reverse of a string
	 * @param firstString contain a not null case sensitive String
	 * @return reverse of string
	 */
	public String reverseOfString(String firstString) {
		char firstStringCharArray[] = firstString.toCharArray();
		int firstStringLength = firstString.length();

		char reverseOfString[] = new char[firstStringLength];

		int reverseCharIndex = firstStringLength - 1;
		int frontCharIndex = 0;
		while (reverseCharIndex >= 0) {
			reverseOfString[frontCharIndex] = firstStringCharArray[reverseCharIndex];
			reverseCharIndex--;
			frontCharIndex++;
		}
		String reverseString = new String(reverseOfString);
		return reverseString;
	}

	/**
	 * To convert upper case character to lower case and vice-versa
	 * @param firstString contain a not null case sensitive String
	 * @return String thats character converted from lower case to upper case and vice-versa
	 */
	public String chracterConversionOfString(String firstString) {
		char firstStringCharArray[] = firstString.toCharArray();
		int firstStringLength = firstString.length();

		char convertedString[] = new char[firstStringLength];

		int charIndex = 0;

		while (charIndex < firstStringLength) {

			if (firstStringCharArray[charIndex] >= 'A' && firstStringCharArray[charIndex] <= 'Z') {
				convertedString[charIndex] = (char) (firstStringCharArray[charIndex] + 32);
			}else if (firstStringCharArray[charIndex] >= 'a' && firstStringCharArray[charIndex] <= 'z') {
				convertedString[charIndex] = (char) (firstStringCharArray[charIndex] - 32);
			}else{
				convertedString[charIndex] = firstStringCharArray[charIndex];
			}
			charIndex++;
		}

		return new String(convertedString);
	}

	/**
	 * Find largest word in string
	 * @param firstString contain a not null case sensitive String
	 * @return longest word in string
	 */
	public String getLongestWordOfString(String firstString) {
		//remove extra starting blank spaces and ending blank spaces from both strings
		firstString=removeBlankSpaces(firstString);
		
		//here blank found variable is used as a flag variable
		int characterIndexFirst,characterIndexSecond,blankFound=0,maxLength;
		String maxLengthWord;
		
		for(characterIndexFirst=0;characterIndexFirst<firstString.length();characterIndexFirst++){
			//find the first occurrence of blank space in your word
			if(firstString.charAt(characterIndexFirst)==' '){
				break;
			}
		}
		
		//do substring of the string from starting till the occurrence of first blank space
		//store the length of this word and suppose it is the longest word and compare its length with all other words length
		maxLength=firstString.substring(0,characterIndexFirst).length();
		maxLengthWord=firstString.substring(0,characterIndexFirst);
		
		//add single blank spaces in starting and ending of the string
		firstString=" "+firstString+" ";
		
		for(characterIndexFirst=0;characterIndexFirst<firstString.length()-1;characterIndexFirst++){
			//find for an occurrence of blank space
			if(firstString.charAt(characterIndexFirst)==' '){
				for(characterIndexSecond=characterIndexFirst+1;characterIndexSecond<firstString.length();characterIndexSecond++){
					//find for next occurrence of a blank space
					if(firstString.charAt(characterIndexSecond)==' '){
						//if found then raise the flag that blank space found and break i.e. make it to 1
						blankFound=1;
						break;
					}
				}
				//if flag is raised
				if(blankFound==1){
					//do substring from the first index of blank till next index of blank excluding blanks
					//calculate its length and check for if its length is greater or equal to previous longest word
					if(maxLength<=(firstString.substring(characterIndexFirst+1,characterIndexSecond).length())){
						//if so then change max length word to this word and do same for the length
						maxLength=firstString.substring(characterIndexFirst+1,characterIndexSecond).length();
						maxLengthWord=firstString.substring(characterIndexFirst+1,characterIndexSecond);
					}
					//ultimately drop off the flag back down i.e. change it to 0
					blankFound=0;
				}
			}
		}		
		//return maximum length word
		return maxLengthWord;
	}
	
	/**
	 * remove blank spaces from front and back of strings
	 * Assumption String is not null
	 * Assumption String is case Sensitive
	 * @param firstString contain a not null case sensitive String
	 * @return string after removing extra blank spaces from starting and ending of the string
	 *  
	 */
	public static String removeBlankSpaces(String firstString) {
		int characterIndex;
		//if first character of the string is a blank space
		if(firstString.charAt(0)==' '){
			for(characterIndex=0;characterIndex<firstString.length();characterIndex++){
				char character=firstString.charAt(characterIndex);
				//checks continuously until any other character comes and as soon as any other character comes break the loop
				if(character!=' ') {
					break;
				}
			}
			//fetch out the string till last from the index of the first charcter's occurrence i.e. not a blank space
			//and store it back to original string
			firstString=firstString.substring(characterIndex);
		}
		if((firstString.charAt(firstString.length()-1))==' '){
			for(characterIndex=firstString.length()-1; characterIndex>0; characterIndex--){
				char character=firstString.charAt(characterIndex);
				//checks continuously until any other character comes and as soon as any other character comes break the loop
				if(character!=' ') {
					break;
				}
			}
			//fetch out the string from 0 till the index of the first charcter's occurrence i.e. not a blank space
			//and store it back to original string
			firstString=firstString.substring(0,characterIndex+1);
		}
		//return string back
		return firstString;
	}
}

