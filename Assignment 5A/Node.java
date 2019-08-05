package Assignment5A;

/**
 * This class represent node in binary search tree
 * @author Sabir
 *
 */
public class Node {

	//left child
	public Node leftChildNode;
	//right child
	public Node rightChildNode;
	//key for the node
	private final String key;
	//value for the node
	private final String value;

	/**
	 * Parameterized constructor used to initializing key and value
	 */
	public Node(String key, String value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * This method return left child node
	 * @return the leftChildNode
	 */
	public Node getLeftChildNode() {
		return leftChildNode;
	}

	/**
	 * This method set the right child node
	 * @param leftChildNode the leftChildNode to set
	 */
	public void setLeftChildNode(Node leftChildNode) {
		this.leftChildNode = leftChildNode;
	}

	/**
	 * This method return the right child node
	 * @return the rightChildNode
	 */
	public Node getRightChildNode() {
		return rightChildNode;
	}

	/**
	 * This method set the right child node
	 * @param rightChildNode the rightChildNode to set
	 */
	public void setRightChildNode(Node rightChildNode) {
		this.rightChildNode = rightChildNode;
	}

	/**
	 * This method return the key 
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * This method return the value
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
}
