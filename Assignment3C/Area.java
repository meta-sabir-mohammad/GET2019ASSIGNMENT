package Assignment3C;

import java.io.IOException;

/**
 * 
 * Area class implement methods to calculate area of different shapes
 *
 */
public class Area implements CalculateAreaOfShapes{
	
	/**
	 * Find area of right angle triangle
	 * Assuming triangle is right angle triangle
	 * Assuming height and width value will greater than zero
	 * @param height represent height of a right angle triangle
	 * @param width represent width of a right angle triangle
	 * @return area of triangle
	 */
	public double getAreaOfTriangle(double height, double width) throws ArithmeticException{
		double areaOfTriangle = (width*height)/2;
		return areaOfTriangle;
	}
	
	/**
	 * Find area of rectangle
	 * Assuming height and width value will greater than zero
	 * @param height represent height of a rectangle
	 * @param width represent width of a rectangle
	 * @return area of triangle
	 */
	public double getAreaOfRectangle(double height, double width) throws ArithmeticException{
		double areaOfRectangle = height * width;
		return areaOfRectangle;
	}
	
	/**
	 * Find area of circle
	 * Assuming radius value will greater than zero
	 * @param radius represent radius of a circle
	 * @return area of a circle
	 */
	public double getAreaOfCircle(double radius) throws ArithmeticException{
		double areaOfCircle = java.lang.Math.PI * java.lang.Math.pow(radius, 2);
		return areaOfCircle;
	}
	
	/**
	 * Find area of square
	 * Assuming height and width value will greater than zero
	 * @param height represent height of a square
	 * @param width represent width of a square
	 * @return area of a square
	 */
	public double getAreaOfSquare(double width) throws ArithmeticException{
		double areaOfSquare = java.lang.Math.pow(width, 2);
		return areaOfSquare;
	}
	
	
}
