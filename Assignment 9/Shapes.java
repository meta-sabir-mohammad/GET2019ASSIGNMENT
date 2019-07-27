package Assignment9;

import Assignment9.Point;

/**
 * This interface represent shape and contain method related to it
 * @author Sabir
 *
 */
public interface Shapes  {
	/**
	 * This method find the area of the shape
	 * @return area of the shape as double
	 */
	public double getArea();
	
	/**
	 * This method find the perimeter of the shape
	 * @return return the perimeter of the shape as double
	 */
	public double getPerimeter();
	
	/**
	 * This method find the origin point of the shape
	 * @return object of Point Class containing the details about origin point
	 */
	public Point getOrigin();
	
	/**
	 * This method find if given point is enclosed by the shape
	 * @param point object of Point Class containing details of point
	 * @return true if point is enclosed by the shape else false
	 */
	public boolean isPointEnclosed(Point point);
}
