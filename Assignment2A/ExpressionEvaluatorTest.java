package Assignment2A;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * This is test class which test method of ExpressionEvaluator Class
 * @author Sabir
 *
 */
public class ExpressionEvaluatorTest {

	//object of ExpressionEvaluator class
	static ExpressionEvaluator expressionEvaluator;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		expressionEvaluator = new ExpressionEvaluator();
	}

	/**
	 * This method is testing  infixExprssionEvaluatot method of ExpressionEvaluator class
	 */
	@Test
	public void infixExpressionEvaluatorMethodTest() {
	String infixExpression1 = "1 + 2";
	String infixExpression2 = "( 5 * 6 ) / 5";
	String infixExpression3 = "3 && 4";
	String infixExpression4 = "7 || 9";
	String infixExpression5 = "( 5 - 2 ) * 3";
	String infixExpression6 = "( 3 < 6 ) * 6";
	String infixExpression7 = "( 7 > 9 )";
	String infixExpression8 = "7 >= 9";
	String infixExpression9 = "7 <= 9";
	String infixExpression10 = "! 6";
	String infixExpression11 = "5 == 5";
	
	assertEquals(3,expressionEvaluator.infixExpressionEvaluator(infixExpression1));
	assertEquals(6,expressionEvaluator.infixExpressionEvaluator(infixExpression2));
	assertEquals(1,expressionEvaluator.infixExpressionEvaluator(infixExpression3));
	assertEquals(1,expressionEvaluator.infixExpressionEvaluator(infixExpression4));
	assertEquals(9,expressionEvaluator.infixExpressionEvaluator(infixExpression5));
	assertEquals(6,expressionEvaluator.infixExpressionEvaluator(infixExpression6));
	assertEquals(0,expressionEvaluator.infixExpressionEvaluator(infixExpression7));
	assertEquals(0,expressionEvaluator.infixExpressionEvaluator(infixExpression8));
	assertEquals(1,expressionEvaluator.infixExpressionEvaluator(infixExpression9));
	assertEquals(0,expressionEvaluator.infixExpressionEvaluator(infixExpression10));
	assertEquals(1,expressionEvaluator.infixExpressionEvaluator(infixExpression11));
	
	
	}

}
