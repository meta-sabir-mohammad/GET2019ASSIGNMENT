package Assignment2A;

import java.io.IOException;

/**
 * This Interface provide generic method for arithmetic operation  
 *
 */
public interface ArithmeticOperation {
	
	/**
	 * 
	 * @param firstOperand operand for addition
	 * @param secondOperand operand for addition
	 * @return result of addition of two operand 
	 * @throws IOException if parameter not contain legal value
	 */
	public String addOperation(String firstOperand , String secondOperand) throws IOException;
	
	/**
	 * 
	 * @param firstOperand operand for subtraction
	 * @param secondOperand operand for subtraction
	 * @return result of subtraction of two operand
	 * @throws IOException if parameter not contain legal value
	 */
	public String subtractOperation(String firstOperand , String secondOperand)throws IOException;
	
	/**
	 * 
	 * @param firstOperand operand for division
	 * @param secondOperand operand for division
	 * @return result of division of two operand
	 * @throws IOException if parameter not contain legal value
	 */
	public String divisonOperation(String firstOperand , String secondOperand)throws IOException,ArithmeticException;
	
	/**
	 * 
	 * @param firstOperand operand for multiplication
	 * @param secondOperand operand for multiplication
	 * @return result of multiplication of two operand
	 * @throws IOException if parameter not contain legal value
	 */
	public String multiplicationOperation(String firstOperand , String secondOperand)throws IOException;

}
