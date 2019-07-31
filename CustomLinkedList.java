package Assignment1;

/**
 * This class represent custom linked list
 * @author Sabir
 *
 */
public class CustomLinkedList {

	//object of Node class representing the head of linked list
	public Node headNode;
	//size of the linked list
	public int size;
	
	/**
	 * default constructor
	 */
	public CustomLinkedList(){
		
	}
	
	/**
	 * This method the given value to the end of the linked list
	 * @param value integer value to be added in linked list
	 * @return true if added successfully else false;
	 */
	public boolean add(int value){
		
		Node node = new Node(value);
		if(this.isHeadNodeEmpty()){
			headNode= node;
			node.previousNode = headNode;
		}else{
			node.previousNode = this.getLast();
			this.getLast().nextNode = node;
			
		}
		this.size++;
		return true;
	}
	
	/**
	 * This method add given value at given index
	 * @param index index on which value to be added
	 * @param value integer value to be added into linked list 
	 * @return true if value added successfully else false
	 * @throws Exception when index is invalid
	 */
	public boolean add(int index, int value)throws Exception{
		
		//size validation
		if(this.size <= index || index < 0){
			throw new Exception("Index out of bound");
		}
		Node node = new Node(value);
		if(index == 0){
			node.nextNode = this.headNode;
			node.previousNode = this.headNode;
			this.headNode.previousNode = node;
			this.headNode = node;
			
			this.size++;
			return true;
		}
		int listIndex =0;
		Node tempNode = this.headNode;
		while(listIndex < (index-1)){
			tempNode = tempNode.nextNode;
			listIndex--;
		}
		node.nextNode = tempNode;
		tempNode.previousNode.nextNode = node;
		this.size++;
		return true;
	}
	
	/**
	 * This method get the value from linked list present at given index
	 * @param index integer value representing index of value
	 * @return value at given index
	 * @throws Exception when index is invalid
	 */
	public int get(int index) throws Exception{
		
		//size validation
		if(this.size <= index || index < 0){
			throw new Exception("Linked list is empty or Index out of bound");
		}
		
		Node tempNode = this.headNode;
		while( index >0){
			tempNode = tempNode.nextNode;
			index--;
		}
		return tempNode.value;
	}
	
	/**
	 * This method find the Node from given index
	 * @param index integer value representing index
	 * @return object of Node Class representing linked list node
	 */
	public Node getNode(int index){

		try{
			//size validation
			if(this.size <= index || index < 0){
				throw new Exception("Linked list is empty or Index out of bound");
			}
		}catch(Exception e){
			System.out.println(e);
		}
		
		Node tempNode = this.headNode;
		while( index >0){
			tempNode = tempNode.nextNode;
			index--;
		}
		return tempNode;
	}
	
	/**
	 * This method find the last node of linked list
	 * @return object of Node Class representing last node of linked list
	 */
	public Node getLast(){
		Node node = this.headNode;
		while(node.nextNode != null){
			node = node.nextNode;
		}
		return node;
	}
	
	/**
	 * This method remove the value from linked list form given index
	 * @param index integer value representing index of value 
	 * @return true if value is removed else false
	 * @throws Exception if index is invalid
	 */
	public boolean remove(int index) throws Exception{
		//size validation
		if(this.size <= index || index < 0){
			throw new Exception("Linked list is empty or Index out of bound");
		}
		
		if(index == 0){
			this.headNode = this.headNode.nextNode;
			this.headNode.nextNode.previousNode = this.headNode;
			this.size--;
			return true;
		}
		
		int linkedListIndex = index;
		Node node = this.headNode;
		while( linkedListIndex >0){
			node = node.nextNode;
			linkedListIndex--;
		}
		
		if(index == this.size-1){
			node.previousNode.nextNode = null;
			this.size--;
			return true;
		}
		
		node.previousNode.nextNode = node.nextNode;
		node.nextNode.previousNode = node.previousNode;
		this.size--;
		return true;
	}
	
	/**
	 * This method check if linked list is empty
	 * @return true if linked list is empty else false
	 */
	private boolean isHeadNodeEmpty(){
		
		if(this.headNode == null){
			return true;
		}
		return false;
	}
	
}
