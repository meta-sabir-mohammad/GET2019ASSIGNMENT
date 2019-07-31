package Assignment1;

/**
 * This class represent node in linked list
 * @author Sabir
 *
 */
public class Node {

	//integer value stored in node
	public int value;
	//next node in linked list
	public Node nextNode;
	//previous node in linked list
	public Node previousNode;
	
	/**
	 *Parameterized constructor  
	 * @param value integer value to be added to node
	 */
	public Node(int value){
		this.value = value;
	}
}
