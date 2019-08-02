package Assignment3B;

/**
 * This interface represent Priority Queue and contain related methods
 * @author Sabir
 * @param <T>
 *
 */
public interface IPriorityQueue<T> {

	/**
	 * This method add element to the priority queue if its not full
	 * @param priority integer value represent priority of element higher number  mean higher priority
	 * @param value integer value to be added to priority queue
	 * @return true if value is added else false
	 * @throws Exception when priority queue is full
	 */
	public boolean enQueue(int priority,T value)throws Exception;
	
	/**
	 * This method remove highest priority element from the priority queue
	 * @return element which is removed
	 * @throws Exception when priority queue is empty
	 */
	public T deQueue()throws Exception;
	
	/**
	 * This method check if the priority queue is empty
	 * @return true if priority queue is empty else false
	 */
	public boolean isEmpty();
	
	/**
	 * This method check if the priority queue is full
	 * @return true if priority queue is full else false
	 */
	public boolean isFull();

}
