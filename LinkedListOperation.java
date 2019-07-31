package Assignment1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * This class contain method to related to LinkedList
 * @author Sabir
 *
 */
public class LinkedListOperation {

	/**
	 * This method rotate elements of sub LinkedList clock wise
	 * @param list LinkedList containing integer values
	 * @param leftIndex start index of sub list (Assuming index start from 1)
	 * @param rightIndex end index of sub list  (Assuming index start from 1)
	 * @param numberOfRotation integer represent number of time rotation happen
	 * @return LinkedList which sub list element rotated clockwise
	 * @throws when indexes are less than 1 or greater than list size
	 */
	public LinkedList<Integer> rotateSubListClockWise(LinkedList<Integer> list,int leftIndex,int rightIndex, int numberOfRotation) throws Exception{
		
		//input validation
		if(numberOfRotation <0 || leftIndex < 1 || rightIndex < 1 || leftIndex > list.size() || rightIndex > list.size()){
			throw new Exception("Invalid input");
		}
		
		LinkedList<Integer> cloneList = new LinkedList<Integer>();
		cloneList =  (LinkedList<Integer>) list.clone();
		//decreasing both index because index start from 0 
		leftIndex--;
		rightIndex--;
		while(numberOfRotation >0){
			int valueAtLeftIndex = cloneList.get(leftIndex);
			cloneList.remove(leftIndex);
			cloneList.add(rightIndex, valueAtLeftIndex);
			numberOfRotation--;
		}
		return cloneList;
	}
	
	/**
	 * This method check if loop is present in given linkedList
	 * @param list custom linked list 
	 * @return true if loop is present else false;
	 * @throws when list is empty
	 */
	public boolean isLoopPresent(CustomLinkedList list) throws Exception{

		//input validation
		if(list.headNode == null){
			throw new Exception("Empty List");
		}
		
		Node LinkedListFirstNode = list.headNode;
		while(LinkedListFirstNode.nextNode != null ){
			Node LinkedListSecondNode = LinkedListFirstNode.nextNode;
			int listSize = list.size;

			while(LinkedListSecondNode.nextNode != null && listSize > 0){
				if(LinkedListFirstNode.value == LinkedListSecondNode.value){
					return true;
				}
				LinkedListSecondNode = LinkedListSecondNode.nextNode;
				listSize--;
			}
			
			LinkedListFirstNode = LinkedListFirstNode.nextNode;
		}
		return false;
	}
	
	/**
	 * This method create loop in given linked list
	 * it set the last node next pointer to given index node
	 * @param list custom linked list
	 * @param NodeIndex index of node to which loop is to be created
	 * @return true if loop is created else false
	 * @throws exception when list is empty or index is greater than list size or less than 0
	 */
	public boolean createLoopInLinkedList(CustomLinkedList list,int NodeIndex) throws Exception{

		//size validation
		if(list.size <= NodeIndex || NodeIndex < 0 || list.headNode == null){
			throw new Exception("Index out of bound");
		}

		Node lastNode = list.getLast();
		Node secondNode = list.getNode(NodeIndex);
		lastNode.nextNode = secondNode;
		list.size++;
		return true;
	}
	
	/**
	 * This method find the degree of polynomial expression
	 * @param polynomialExpressionString String representation of polynomial expression
	 * @return value of degree
	 * @throws Exception when polynomial string is empty
	 */
	public int getDegreeOfPolynomial(String polynomialExpressionString) throws Exception{
		
		//input validation
		if(polynomialExpressionString.length() == 0){
			throw new Exception("Illegal expression");
		}
		
		LinkedList<LinkedList> polynomialList = getNestedListRepresentationOfPolynomial(polynomialExpressionString);
		
		int maxDegree=0;
		for(int indexFirst=0;indexFirst<polynomialList.size();indexFirst++){
		int degree=0;
		for(int indexSecond=1;indexSecond<polynomialList.get(indexFirst).size();indexSecond++){
		degree+=Integer.parseInt((String)(((LinkedList)(polynomialList.get(indexFirst).get(indexSecond)))).get(1));
		}
		maxDegree=Math.max(maxDegree, degree);
		}
		return maxDegree;
	}
	
	/**
	 * This method create nested list representation of given polynomial expression
	 * @param polynomialExpressionString String representation of polynomial expression
	 * @return LinkedList containing nested representation of polynomial expression
	 * @throws Exception when polynomial string is empty
	 */
	private LinkedList<LinkedList> getNestedListRepresentationOfPolynomial(String polynomialExpressionString) throws Exception{
		
		//input validation
		if(polynomialExpressionString.length() == 0){
			throw new Exception("Illegal expression");
		}
		//dividing expressions in strings
		String expressions[] = polynomialExpressionString.split("[+-]");
		LinkedList<LinkedList> list = new LinkedList<LinkedList>();
		int polynomialStringIndex = 0;
		for(int arrayIndex =0; arrayIndex < expressions.length; arrayIndex++){
			if(expressions[arrayIndex].equals("")){
				continue;
			}
			if(polynomialExpressionString.charAt(0) =='-' || arrayIndex > 0){
				//extracting and adding operator to list
				while( polynomialStringIndex < polynomialExpressionString.length()){
					if(polynomialExpressionString.charAt(polynomialStringIndex) == '-' || polynomialExpressionString.charAt(polynomialStringIndex) == '+'){
						LinkedList<Character> operator = new LinkedList<Character>();
						operator.add(polynomialExpressionString.charAt(polynomialStringIndex));
						list.add(operator);
						polynomialStringIndex++;
						break;
					}
					polynomialStringIndex++;
				}
			}	
			//getting expression as nested list and adding to main list
			list.add(getNestedListRepresentaionOfExpression(expressions[arrayIndex]));
		}
		return list;
	}
	
	/**
	 * This method create nested list representation of given expression
	 * @param expression String representation of polynomial expression
	 * @return LinkedList containing nested representation of expression
	 */
	private LinkedList<LinkedList> getNestedListRepresentaionOfExpression(String expression){
		
		//extracting and storing variables in string array
		ArrayList<String> variable = new ArrayList<String>();
		for(int strIndex =0; strIndex <expression.length(); strIndex++){
			if(expression.charAt(strIndex) >='a' && expression.charAt(strIndex) <='z'){
				variable.add(Character.toString(expression.charAt(strIndex)));
			}
		}

		Object[] obj = variable.toArray();
		String variables[] = Arrays.copyOf(obj,obj.length,String[].class);
		//extracting and storing constant integers in array
		String constant[] = expression.split("[a-z]");

		
		LinkedList<LinkedList> mainList = new LinkedList<LinkedList>();
		{
			//creating constant linked list which store constant 
			LinkedList<Integer> constantList = new LinkedList<Integer>();
			if(constant[0].equals("")){
				constantList.add(1);
			}else{
				constantList.add(Integer.parseInt(constant[0]));
			}
			//adding constant list to main list
			mainList.add(constantList);
		}

		int constantArrayIndex =1;
		int variablesArrayIndex = 0;
		//creating variable list which contain variable and their power
		while(variablesArrayIndex < variables.length){
			LinkedList<String> variableList = new LinkedList<String>();
			if(!variables[variablesArrayIndex].equals("")){
				variableList.add(variables[variablesArrayIndex]);
				if(constantArrayIndex >= constant.length || constant[constantArrayIndex].equals("")){
					variableList.add("1");
					constantArrayIndex++;
				}else{
					variableList.add(constant[constantArrayIndex]);
					constantArrayIndex++;
				}	
				//adding variable list to main list
				mainList.add(variableList);
			}	
			variablesArrayIndex++;
		}
		//returning main list which contain nested representation of given single expression
		return mainList;
	}
}

