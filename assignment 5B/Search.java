package Assignment5B;

/**
 * This class contain method to perform linear and binary search on integer array
 * @author Sabir
 *
 */
public class Search {

	/**
	 * Search element in an array using linear search
	 * @param inputArray array of elements
	 * @param elementToSearch element to be searched
	 * @return index of element if found otherwise -1
	 */
	public int getElementIndexByLinearSearch(int inputArray[],int elementToSearch){
		int elementIndex = linearSearch(inputArray,elementToSearch,0);
		return elementIndex;
	}
	
	/**
	 * Search element in an array using binary search
	 * Assuming array is in ascending order
	 * @param inputArray array of elements
	 * @param elementToSearch element to be searched
	 * @return index of element if found otherwise -1
	 */
	public int getElementIndexByBinarySearch(int inputArray[],int elementToSearch){
		int elementIndex = binarySearch(inputArray,elementToSearch,0,(inputArray.length-1));
		return elementIndex;
	}
	
	/**
	 * This is recursive method for used in getElementByLinearSearch method
	 * @param inputArray array of element
	 * @param elementToSearch element to be searched
	 * @param startIndex index on which element need to check
	 * @return index of element otherwise -1
	 */
	private int linearSearch(int inputArray[], int elementToSearch, int startIndex){
		
		if(startIndex >= inputArray.length){ return -1; }
		if(elementToSearch == inputArray[startIndex]){ return startIndex; }
		return linearSearch(inputArray,elementToSearch,startIndex+1);
	}
	
	/**
	 * This is recursive method for used in getElementByBinarySearch method
	 * @param inputArray array of element
	 * @param elementToSearch element to be searched
	 * @param startIndex start index of sub array
	 * @param endIndex end index of sub array
	 * @return index of element otherwise -1
	 */
	private int binarySearch(int inputArray[], int elementToSearch, int startIndex , int endIndex){
		if(startIndex > endIndex){ return -1; }
		int middleIndex = (startIndex + endIndex) / 2;
		if(inputArray[middleIndex] == elementToSearch){ return middleIndex; }
		if(elementToSearch > inputArray[middleIndex]){
			return binarySearch(inputArray,elementToSearch,middleIndex+1,endIndex);
		}
	
		return binarySearch(inputArray,elementToSearch,startIndex,middleIndex-1);
	}
}
