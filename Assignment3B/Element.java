package Assignment3B;

/**
 * This class represent indivisual element in priority queue
 * 
 * @author Sabir
 * @param <T>
 *            this is generic type
 */
public class Element<T> {

	// priority of element bigger number mean higher priority
	private int priority;
	// generic type value
	private T value;

	/**
	 * Parameterized constructor
	 * 
	 * @param priority
	 *            integer type priority of element
	 * @param value
	 *            generic type value of element
	 */
	public Element(int priority, T value) {
		this.priority = priority;
		this.value = value;
	}

	/**
	 * This method return the priority of element
	 * 
	 * @return priority of element
	 */
	public int getPriority() {
		return this.priority;
	}

	/**
	 * This method return the value of element
	 * 
	 * @return generic type value of element
	 */
	public T getValue() {
		return this.value;
	}
}
