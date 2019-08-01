package Assignment2A;

/**
 * This interface represent Stack and contain method related to it
 * @author Sabir
 *
 */
public interface Stack {

	/**
	 * This method pushes an element into stack
	 * @param element to be added in the queue
	 * @return true if element is added to stack
	 */
	public boolean push(String element)throws Exception;
	
	/**
	 * This method deletes an element from stack
	 * @return true if element is deleted from stack
	 */
	public String pop()throws Exception;
	
	/**
	 * This method checks for is stack is empty
	 * @return true if stack is empty else false
	 */
	public boolean isEmpty();
	
	/**
	 * This method returns the value of top Of stack
	 * @return integer value of top of stack
	 */
	public String peek()throws Exception;
}
