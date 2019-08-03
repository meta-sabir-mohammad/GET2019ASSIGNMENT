package Assignment3C;

/**
 * This class represent individual element in priority queue
 * @author Sabir
 */
public class Element {

	//priority of element bigger number mean higher priority
	private int priority;
	//String value
	private String value;

	/**
	 * Parameterized constructor
	 * @param priority integer type priority of element
	 * @param String value of element
	 */
	public Element(int priority, String value) {
		this.priority = priority;
		this.value = value;
	}

	/**
	 * This method return the priority of element
	 * @return priority of element
	 */
	public int getPriority() {
		return this.priority;
	}

	/**
	 * This method return the value of element
	 * @return String value of element
	 */
	public String getValue() {
		return this.value;
	}
}
