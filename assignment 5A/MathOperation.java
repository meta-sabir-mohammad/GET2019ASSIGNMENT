package Assignment5A;

import java.io.IOException;

/**
 * This class perform contain method to get HCF,LCM of two positive integer number
 * @author Sabir
 *
 */
public class MathOperation {

	/**
	 * Find HCF of two positive integer numbers
	 * @param firstNumber positive integer
	 * @param secondNumber positive integer 
	 * @return HCF of both positive integer
	 * @throws IOException when input is not greater than zero
	 */
	public int getTwoNumbersHCF(int firstNumber, int secondNumber) throws IOException{
		
		if(firstNumber <= 0 || secondNumber <= 0 ){
			throw new IOException("Invalid Input");
		}
		
		int smallerNumber;
		int largerNumber;
		
		if(firstNumber>secondNumber){
			largerNumber = firstNumber;
			smallerNumber = secondNumber;
		}else{
			largerNumber = secondNumber;
			smallerNumber = firstNumber;
		}
		if(largerNumber % smallerNumber == 0){ 
			return smallerNumber; 
		}else{
			return getTwoNumbersHCF(smallerNumber,(largerNumber % smallerNumber));
		}
	}
	
	/**
	 * Find LCM of two positive integer 
	 * @param firstNumber positive integer
	 * @param secondNumber positive integer
	 * @return LCM of both numbers
	 * @throws IOException when numbers are not greater than zero
	 */
	public int getTwoNumbersLCM(int firstNumber, int secondNumber) throws IOException{
		int hcfOfNumbers = getTwoNumbersHCF(firstNumber,secondNumber);
		if(hcfOfNumbers == 0){
			throw new IOException("Invalid LCM");
		}
		return ((firstNumber * secondNumber) / hcfOfNumbers);
	}
}
