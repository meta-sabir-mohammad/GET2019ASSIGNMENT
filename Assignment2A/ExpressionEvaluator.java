package Assignment2A;

import java.util.HashMap;

/**
 * This Class contain method to evaluate expressions
 */
public class ExpressionEvaluator {

	private static HashMap<String,Integer> operatorPrecedence=new HashMap<String,Integer>();

	/**
	 * Default Constructor
	 */
	public ExpressionEvaluator() {
		//setting priority of operators
		ExpressionEvaluator.prioritySetter();
	}

	/**
	 * This method evaluate infix expression
	 * @param infixExpression String containing infix expression
	 * @return value after evaluation
	 */
	public int infixExpressionEvaluator(String infixExpression){

		String postfixExpression = infixToPostfixConverter(infixExpression);
		int result = postfixExpressionEvaluator(postfixExpression);
		return result;
	}

	/**
	 * This method evaluate postfix expression
	 * @param postfixExpression String containing postfix expression
	 * @return value after evaluation
	 */
	public int postfixExpressionEvaluator(String postfixExpression) {

		String extractedCharacters[]=postfixExpression.split(" ");
		CustomStack operandStack = new CustomStack();

		for(int indexFirst=0;indexFirst < extractedCharacters.length; indexFirst++){

			String extractedCharacter = extractedCharacters[indexFirst];
			try{
				if(extractedCharacter.charAt(0)>='0' && extractedCharacter.charAt(0)<='9'){ operandStack.push(extractedCharacter); }
				else{
					if(extractedCharacter.equals("!")){
						//String operandFirst=operandStack.stack.get(operandStack.topOfStack);
						String operandFirst=operandStack.pop();
						operandStack.push(Integer.toString(evaluateExpression(Integer.parseInt(operandFirst),0,extractedCharacter)));
					}
					else{
						//String operandSecond=operandStack.stack.get(operandStack.topOfStack);
						String operandSecond=operandStack.pop();
						//String operandFirst=operandStack.stack.get(operandStack.topOfStack);
						String operandFirst=operandStack.pop();
						operandStack.push(Integer.toString(evaluateExpression(Integer.parseInt(operandFirst), Integer.parseInt(operandSecond), extractedCharacter)));
					}
				}
			}catch(Exception e){
				System.out.println(e);
			}
		}
		return Integer.parseInt(operandStack.stack.get(operandStack.topOfStack));
	}

	/**
	 * This method convert infix expression to postfix expression
	 * @return String postfix expression after conversion 
	 */
	public String infixToPostfixConverter(String infixExpression){

		//adding  parentheses to both side
		infixExpression = "( "+infixExpression+" )";
		//CustomStack object 
		CustomStack operatorStack=new CustomStack();
		//StrigBuilder which will contain postfix expression
		StringBuilder postfixExpression =new StringBuilder();
		//getting array of individual tokens
		String[] expressionArray = infixExpression.split(" ");
		try{

			for(int indexFirst=0; indexFirst < expressionArray.length; indexFirst++) {

				//if number arrived add to postfix expression
				if(expressionArray[indexFirst].charAt(0) >= '0' && expressionArray[indexFirst].charAt(0) <= '9') {
					//postfixExpression = postfixExpression + expressionArray[indexFirst]+" ";
					postfixExpression.append(expressionArray[indexFirst]+" ");
				}
				else {
					//first operator comes in stack
					if(operatorStack.topOfStack==-1){
						operatorStack.push(expressionArray[indexFirst]);
					}
					//if operator comes and top of stack has '('
					else if( operatorStack.peek().equals("(") && (!expressionArray[indexFirst].equals(")"))){
						operatorStack.push(expressionArray[indexFirst]);
					}
					//if greater priority operator comes 
					else if((!expressionArray[indexFirst].equals(")"))  && (!expressionArray[indexFirst].equals("(")) && isFristOperatorPriorityGreater(expressionArray[indexFirst],operatorStack.peek())) {
						operatorStack.push(expressionArray[indexFirst]);
					}
					//if same priority operator comes
					else if((!expressionArray[indexFirst].equals(")"))  && (!expressionArray[indexFirst].equals("(")) && (isPriorityEqual(expressionArray[indexFirst],operatorStack.peek()))) {
						//postfixExpression = postfixExpression + operatorStack.stack.get(operatorStack.topOfStack)+" ";
						postfixExpression.append(operatorStack.stack.get(operatorStack.topOfStack)+" ");
						operatorStack.pop();
						--indexFirst;
					}
					//if ')' comes
					else if(expressionArray[indexFirst].equals(")")) {
						while(!operatorStack.peek().equals("(")) {
							//postfixExpression = postfixExpression + operatorStack.stack.get(operatorStack.topOfStack)+" ";
							postfixExpression.append(operatorStack.peek()+" ");
							operatorStack.pop();
						}
						operatorStack.pop();
						if(operatorStack.topOfStack==-1){ break; }
					}
					//if '(' comes
					else if(expressionArray[indexFirst].equals("(")) {
						operatorStack.push(expressionArray[indexFirst]);
					}
					//if lesser priority operator comes
					else {
						//postfixExpression = postfixExpression +operatorStack.stack.get(operatorStack.topOfStack)+" ";
						postfixExpression.append(operatorStack.peek()+" ");
						operatorStack.pop();
						indexFirst--;
					}
				}
			} 		
			return postfixExpression.toString();

		}catch(Exception e){
			System.out.println(e);
		}
		return "";
	}

	/**
	 * This method perform specified operation on operands and return value
	 * @param Operand First
	 * @param Operand Second
	 * @param Operator 
	 * @return final Result
	 */
	private int evaluateExpression(int operandFirst, int operandSecond, String operator) {

		switch(operator){

		case "+":{
			return ( operandFirst + operandSecond );
		}
		case "-":{
			return ( operandFirst - operandSecond );
		}
		case "*":{
			return ( operandFirst * operandSecond );
		}
		case "/":{
			return ( operandFirst / operandSecond );
		}
		case "==":{
			if( operandFirst == operandSecond ){
				return 1;
			}
			return 0;	
		}	
		case "!=":{
			if( operandFirst == operandSecond ){
				return 0;
			}
			return 1;
		}
		case "<":{
			if( operandFirst < operandSecond ){
				return 1;
			}
			return 0;	
		}
		case ">":{
			if( operandFirst > operandSecond ){
				return 1;
			}
			return 0;	
		}
		case "<=":{
			if( operandFirst <= operandSecond ){
				return 1;
			}
			return 0;	
		}
		case ">=":{
			if( operandFirst >= operandSecond ){
				return 1;
			}
			return 0;
		}
		case "&&":{
			if( ( operandFirst > 0 ) && ( operandSecond > 0 ) ){
				return 1;
			}
			return 0;
		}
		case "||":{
			if( ( operandFirst > 0 ) || ( operandSecond > 0 ) ){
				return 1;
			}
			return 0;
		}
		case "!":{
			if( operandFirst > 0 ){
				return 0;
			}
			return 1;
		}
		}		
		return 0;
	}

	/**
	 * Sets Priority of different Operators
	 */
	private static void prioritySetter() {

		ExpressionEvaluator.operatorPrecedence.put("||",1);
		ExpressionEvaluator.operatorPrecedence.put("&&",2);
		ExpressionEvaluator.operatorPrecedence.put("==",3);
		ExpressionEvaluator.operatorPrecedence.put("!=",3);
		ExpressionEvaluator.operatorPrecedence.put("<",4);
		ExpressionEvaluator.operatorPrecedence.put(">",4);
		ExpressionEvaluator.operatorPrecedence.put("<=",4);
		ExpressionEvaluator.operatorPrecedence.put(">=",4);
		ExpressionEvaluator.operatorPrecedence.put("+",5);
		ExpressionEvaluator.operatorPrecedence.put("-",5);
		ExpressionEvaluator.operatorPrecedence.put("*",6);
		ExpressionEvaluator.operatorPrecedence.put("/",6);
		ExpressionEvaluator.operatorPrecedence.put("!",7);
	}

	/**
	 * Checks for if First Operator Priority Greater
	 * @param String type operator First
	 * @param String type operator Second
	 * @return boolean true if First Operator Priority is Greater else false
	 */
	private boolean isFristOperatorPriorityGreater(String firstOperstor,String secondOperator) {

		if( ExpressionEvaluator.operatorPrecedence.get(firstOperstor) > ExpressionEvaluator.operatorPrecedence.get(secondOperator) ){ return true; }
		else { return false; }
	}

	/**
	 * Checks for if Priorities are Equal
	 * @param String type operator First
	 * @param String type operator Second
	 * @return boolean true if First Operator Priority is Equal to Second Operators Priority else false
	 */
	private boolean isPriorityEqual(String firstOperstor,String secondOperator) {

		if( ExpressionEvaluator.operatorPrecedence.get(firstOperstor) == ExpressionEvaluator.operatorPrecedence.get(secondOperator) ){ return true;}
		else { return false; }
	}
}