package Assignment3C;

/**
 * This class represent priority queue
 * @author Sabir
 */
public class PriorityQueue implements IPriorityQueue {

	private Element[] priorityQueue;
	private int backIndex = 0;

	/**
	 * Default constructor
	 */
	public PriorityQueue() {
		this.priorityQueue = new Element[10];
	}
	
	/**
	 * Parameterized constructor 
	 * @param totalSize total size of priority queue
	 */
	public PriorityQueue(int totalSize){
		this.priorityQueue = new Element[totalSize+1];
	}
	/**
	 * This method add element to the priority queue if its not full
	 * @param priority integer value represent priority of element higher number mean higher priority
	 * @param value integer value to be added to priority queue
	 * @return true if value is added else false
	 * @throws Exception when priority queue is full
	 */
	@Override
	public boolean enQueue(int priority, String value) throws Exception {

		try {
			// Checking if queue is full
			if (this.priorityQueue[this.priorityQueue.length - 1] != null) {
				throw new Exception("Queue full");
			}

			Element element = new Element(priority, value);
			// if queue is empty
			if (this.priorityQueue[1] == null) {
				this.backIndex++;
				this.priorityQueue[this.backIndex] = element;
				return true;
			}
			// if queue is not empty than add element at the left most leaf of heap
			int elementIndex = backIndex + 1;
			this.priorityQueue[elementIndex] = element;
			this.backIndex++;
			// after adding the element reorder the max heap so that highest priority
			// element stay on top
			this.setOrderAfterEnQueue(elementIndex);

			return true;

		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * This method remove highest priority element from the priority queue
	 * @return element which is removed
	 * @throws Exception when priority queue is empty
	 */
	@Override
	public Element deQueue() throws Exception {

		try {
			// Checking if queue is empty
			if (this.priorityQueue[1] == null) {
				throw new Exception("Queue is empty");
			}
			// if not empty than replace the top element with the left most element and
			// remove top element
			int elementIndex = backIndex + 1;
			elementIndex--;
			Element element = this.priorityQueue[1];
			Element lastElement = this.priorityQueue[elementIndex];
			this.priorityQueue[elementIndex] = null;
			this.priorityQueue[1] = new Element(lastElement.getPriority(), lastElement.getValue());
			this.backIndex--;
			// reorder the max heap such that highest priority element stay on top
			this.setOrderAfterDequeue(1);
			return element;

		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * This method reorder the priority queue after insertion of any element
	 * @param elementIndex index of element which is added
	 */
	private void setOrderAfterEnQueue(int elementIndex) {

		int indexOfNewElement = elementIndex;
		Element newElement = this.priorityQueue[indexOfNewElement];
		while (indexOfNewElement != 1) {
			int indexOfParentElement = indexOfNewElement / 2;
			Element parentElement = this.priorityQueue[indexOfParentElement];

			if (parentElement.getPriority() < newElement.getPriority()) {
				this.swap(indexOfParentElement, indexOfNewElement);
				this.setOrderAfterEnQueue(indexOfParentElement);
			}
			break;
		}
	}

	/**
	 * This method reorder the priority queue after deletion of any element
	 * @param elementIndex index of top element in queue
	 */
	private void setOrderAfterDequeue(int elementIndex) {

		int parentElementIndex = elementIndex;
		int leftChildIndex = parentElementIndex * 2;
		int rightChildIndex = (parentElementIndex * 2) + 1;

		while (this.priorityQueue[leftChildIndex] != null || this.priorityQueue[rightChildIndex] != null) {

			Element parentElement = this.priorityQueue[parentElementIndex];
			boolean isSwap = false;
			//leftChildIndex = parentElementIndex * 2;
			//rightChildIndex = (parentElementIndex * 2) + 1;
			Element leftChild = this.priorityQueue[leftChildIndex];
			Element rightChild = this.priorityQueue[rightChildIndex];
			if (rightChild != null) {

				if (leftChild.getPriority() >= rightChild.getPriority()
						&& leftChild.getPriority() > parentElement.getPriority()) {
					this.swap(parentElementIndex, leftChildIndex);
					parentElementIndex = leftChildIndex;
					isSwap = true;
				} else if (rightChild.getPriority() > parentElement.getPriority()) {
					this.swap(parentElementIndex, rightChildIndex);
					parentElementIndex = rightChildIndex;
					isSwap = true;
				}

			} else if (leftChild != null && (leftChild.getPriority() > parentElement.getPriority())) {
				this.swap(parentElementIndex, leftChildIndex);
				parentElementIndex = leftChildIndex;
				isSwap = true;
			}
			if(!isSwap){
				break;
			}
			if(parentElementIndex == this.backIndex-1 || parentElementIndex == this.backIndex){
				break;
			}
			leftChildIndex = parentElementIndex * 2;
			rightChildIndex = (parentElementIndex * 2) + 1;
		}
	}

	/**
	 * This method swap to element in priority queue
	 * @param firstElementIndex index of first element
	 * @param secondElementIndex index of second element
	 */
	private void swap(int firstElementIndex, int secondElementIndex) {

		Element element = new Element(this.priorityQueue[firstElementIndex].getPriority(),
				this.priorityQueue[firstElementIndex].getValue());
		this.priorityQueue[firstElementIndex] = new Element(this.priorityQueue[secondElementIndex].getPriority(),
				this.priorityQueue[secondElementIndex].getValue());
		this.priorityQueue[secondElementIndex] = element;
	}

	/**
	 * This method check if the priority queue is empty
	 * @return true if priority queue is empty else false
	 */
	@Override
	public boolean isEmpty() {

		if (this.backIndex == 0) {
			return true;
		}
		return false;
	}

	/**
	 * This method check if the priority queue is full
	 * @return true if priority queue is full else false
	 */
	@Override
	public boolean isFull() {
		if (this.backIndex == this.priorityQueue.length - 1) {
			return true;
		}
		return false;
	}

}
