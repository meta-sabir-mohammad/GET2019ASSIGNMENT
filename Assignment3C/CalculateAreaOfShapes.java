/**
 * 
 */
package Assignment3C;

/**
 * This Interface contain abstract method to calculate area of different shapes
 *
 */
public interface CalculateAreaOfShapes {

	/**
	 * Find area of right angle triangle
	 * Assuming triangle is right angle triangle
	 * Assuming height and width value will greater than zero
	 * @param height represent height of a right angle triangle
	 * @param width represent width of a right angle triangle
	 * @return area of triangle
	 */
	public double getAreaOfTriangle(double height, double width);
	
	/**
	 * Find area of rectangle
	 * Assuming height and width value will greater than zero
	 * @param height represent height of a rectangle
	 * @param width represent width of a rectangle
	 * @return area of triangle
	 */
	public double getAreaOfRectangle(double height, double width);
	
	/**
	 * Find area of circle
	 * Assuming radius value will greater than zero
	 * @param radius represent radius of a circle
	 * @return area of a circle
	 */
	public double getAreaOfCircle(double radius);
	
	/**
	 * Find area of square
	 * Assuming height and width value will greater than zero
	 * @param height represent height of a square
	 * @param width represent width of a square
	 * @return area of a square
	 */
	public double getAreaOfSquare(double width);
}
