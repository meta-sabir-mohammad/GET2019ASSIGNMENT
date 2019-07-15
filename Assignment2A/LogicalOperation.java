
package Assignment2A;

import java.io.IOException;

/**
 * This Interface provide generic method for logical operation  
 *
 */
public interface LogicalOperation {

	/**
	 * 
	 * @param firstOperand operand for equal operation
	 * @param secondOperand operand for equal operation
	 * @return boolean containing true if equal or false
	 * @throws IOException if parameter not contain legal value 
	 */
	public boolean equalsOperation(String firstOperand, String secondOperand) throws IOException;
	
	/**
	 * assuming first operand is greater 
	 * @param firstOperand operand for greater than operation
	 * @param secondOperand operand for greater than operation
	 * @return true if firstOperand is greater
	 * @throws IOException if parameter not contain legal value
	 */
	public boolean greaterThanOperation(String firstOperand, String secondOperand) throws IOException;
	
	/**
	 * assuming first operand is lesser
	 * @param firstOperand operand for less than operation
	 * @param secondOperand operand for less than operation
	 * @return true if firstOperand is lesser
	 * @throws IOException if parameter not contain legal value
	 */
	public boolean lessThanOperation(String firstOperand, String secondOperand) throws IOException;
	
}
