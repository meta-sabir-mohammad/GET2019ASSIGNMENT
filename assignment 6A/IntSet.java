package Assignment6A;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represent immutable abstract IntSet data type
 * @author Sabir
 *
 */
public class IntSet {

	private final int MAX_SET_SIZE = 1000;
	private final int integerArray[];

	/**
	 * Parameterized constructor used to initialize instance variable integer array
	 * @param integerArray  integer single dimension array containing integer between 1 to 1000
	 */
	public IntSet(int integerArray[]) {
		this.integerArray = integerArray;
	}

	/**
	 * This method check if given integer value is member of the set
	 * @param value integer value between 1 to 1000
	 * @return true if integer value is part of set else false
	 */
	public boolean isMember(int value) {
		for (int index = 0; index < this.integerArray.length; index++) {
			if (this.integerArray[index] == value) { return true; }
		}
		return false;
	}

	/**
	 * This method find size of the integer set
	 * @return integer representing size of the set
	 */
	public int size() {
		return this.integerArray.length;
	}

	/**
	 * This method check if given parameter set is subset or not
	 * @param set integer set containing integer between 1 to 1000
	 * @return true if given set is subset else false
	 */
	public boolean isSubSet(IntSet set) {

		boolean isSet;
		for (int firstIndex = 0; firstIndex < set.integerArray.length; firstIndex++) {
			isSet = false;
			for (int secondIndex = 0; secondIndex < this.integerArray.length; secondIndex++) {
				if (set.integerArray[firstIndex] == this.integerArray[secondIndex]) {
					isSet = true;
				}
			}
			if (!isSet) { return false; }
		}
		return true;
	}

	/**
	 * This method find the complement of set assumming 1 to 1000 as universal set
	 * @return complement set
	 */
	public IntSet getComplement() {

		List<Integer> complementSetList = new ArrayList<Integer>();
		int complementSetIndex = 0;
		boolean elementPresent;
		for (int firstIndex = 0; firstIndex < MAX_SET_SIZE; firstIndex++) {
			elementPresent = false;
			for (int secondIndex = 0; secondIndex < this.integerArray.length; secondIndex++) {
				if ((firstIndex + 1) == this.integerArray[secondIndex]) {
					elementPresent = true;
					break;
				}
			}
			if (!elementPresent) {
				complementSetList.add(firstIndex+1);
				complementSetIndex++;
			}
		}
		int[] complementSet = new int[complementSetList.size()];
		for(int listIndex =0; listIndex < complementSetList.size(); listIndex++){
			complementSet[listIndex] = complementSetList.get(listIndex);
		}
		return new IntSet(complementSet);
	}

	/**
	 * This method find the union of to sets
	 * @param firstSet  integer set containing integer between 1 to 1000
	 * @param secondSet integer set containing integer between 1 to 1000
	 * @return union of two sets
	 */
	public static IntSet union(IntSet firstSet, IntSet secondSet) {
		int totalElementInSet = 0;
		for (int firstIndex = 0; firstIndex < firstSet.integerArray.length; firstIndex++) {
			for (int secondIndex = 0; secondIndex < secondSet.integerArray.length; secondIndex++) {
				if (firstSet.integerArray[firstIndex] == secondSet.integerArray[secondIndex]) {
					totalElementInSet++;
				}
			}
		}
		totalElementInSet = (firstSet.integerArray.length + secondSet.integerArray.length) - totalElementInSet;

		int[] unionOfSet = new int[totalElementInSet];
		int unionSetIndex = 0;
		for (int firstIndex = 0; firstIndex < firstSet.integerArray.length; firstIndex++) {
			unionOfSet[unionSetIndex] = firstSet.integerArray[firstIndex];
			unionSetIndex++;
		}
		for (int firstIndex = 0; firstIndex < secondSet.integerArray.length; firstIndex++) {
			boolean elementPresent = false;
			
			for (int secondIndex = 0; secondIndex < unionSetIndex; secondIndex++) {
				if (unionOfSet[secondIndex] == secondSet.integerArray[firstIndex]) { elementPresent = true; }
			}
			
			if (!elementPresent) {
				unionOfSet[unionSetIndex] = secondSet.integerArray[firstIndex];
				unionSetIndex++;
			}
		}
		return new IntSet(unionOfSet);
	}

	/**
	 * This method return the set as single dimension array
	 * @return single dimension integer array containing the set
	 */
	public int[] getSetAsArray() {
		IntSet set = new IntSet(this.integerArray);
		return set.integerArray;
	}

}