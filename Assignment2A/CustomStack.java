package Assignment2A;

import java.util.LinkedList;
import java.util.List;

/**
 * This class implements Stack interface and create a custom Stack
 */
public class CustomStack implements Stack {
	
	public List<String> stack=new LinkedList<String>();
	public int topOfStack=-1;
	public final int MAX_SIZE_OF_STACK=1000;
	
	/**
	 * This method pushes an element into stack
	 * @param element to be added in the stack
	 * @return true if element is added to stack
	 */
	public boolean push(String element)throws Exception {
		
		boolean flag=false;
		if((this.topOfStack+1)==MAX_SIZE_OF_STACK) { throw new Exception("Stack Overflow"); }
		else {
			this.topOfStack++;
			this.stack.add(element);
			flag=true;
		}
		return flag;
	}
	
	/**
	 * This method deletes an element from stack
	 * @return true if element is deleted from stack
	 */
	public String pop()throws Exception {
		
		String value = "";
		if(this.topOfStack==-1) { throw new Exception("Stack Underflow"); }
		else {
			value = this.stack.get(topOfStack);
			this.stack.remove(topOfStack);
			this.topOfStack--;
		}
		return value;
	}
	
	/**
	 * This method checks for is stack is empty
	 * @return true if stack is empty else false
	 */
	public boolean isEmpty() {
		
		boolean flag=false;
		if(this.topOfStack==-1) { flag=true; }
		return flag;
	}
	
	/**
	 * This method returns the value of top Of stack
	 * @return integer value of top of stack
	 */
	public String peek()throws Exception {
		
		if(topOfStack==-1) { throw new Exception("Stack Underflow"); }
		return this.stack.get(topOfStack);
	}
}
