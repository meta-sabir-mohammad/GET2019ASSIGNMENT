package Assignment9;

import java.util.ArrayList;

import Assignment9.Point;
import Assignment9.Shapes;

/**
 * This class represent shape circle
 * @author Sabir
 *
 */
public class Circle implements Shapes{
	
	//Object of Point class represent center point of the circle
	public Point start;
	//radius of the circle
	public double radius;
	
	/**
	 * This is parameterized constructor
	 * @param start object of Point Class representing center of of circle
	 * @param list ArrayList containing radius of circle
	 */
	public Circle(Point start,ArrayList<Double> list){
		this.start=start;
		this.radius=(double)list.get(0);
	}
	
	/**
	 * This method find the area of circle
	 * @return area of circle
	 */
	@Override
	public double getArea() {
		return (float) (Math.PI*radius*radius);
	}

	/**
	 * This method find the perimeter of circle
	 * @return perimeter of cirlce
	 */
	@Override
	public double getPerimeter() {
		return (float)(2*Math.PI*radius);
	}

	/**
	 * This method find the origin points of the circle
	 * @return origin point of circle as object of Point Class
	 */
	@Override
	public Point getOrigin() {
		Point point=new Point(this.start.getxCoordinate(),this.start.getyCoordinate());
		return point;
	}

	/**
	 * This method find if any given point is enclosed by circle
	 * @param point object of Point Class containing details about the point
	 * @return true if point is enclosed else false
	 */
	@Override
	public boolean isPointEnclosed(Point point) {
		if(Math.sqrt((Math.pow((point.getxCoordinate()-this.start.getxCoordinate()),2))+(Math.pow((point.getyCoordinate()-this.start.getyCoordinate()),2)))<=radius){
			return true;
		}
		return false;
	}
}
