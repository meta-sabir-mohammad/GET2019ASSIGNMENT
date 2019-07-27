package Assignment9;

import java.util.ArrayList;

import Assignment9.Point;
import Assignment9.Shapes;

/**
 * This class represent shape Rectangle
 * @author Sabir
 *
 */
public class Rectangle implements Shapes{
	
	//this represent length of rectangle
	public double length;
	//this represent breadth of rectangle
	public double breadth;
	//this represent start point of rectangle
	public Point start;
	
	/**
	 * Parameterized constructor 
	 * @param point object of the Point Class containing details about the starting point of rectangle
	 * @param list contain values of length and breadth of rectangle in ArrayList
	 */
	public Rectangle (Point point,ArrayList<Double> list){
		this.start=point;
		this.length=(double)list.get(0);
		this.breadth=(double)list.get(1);
	}
	
	/**
	 * This method return the area of rectangle
	 * @return area of rectangle as double
	 */
	@Override
	public double getArea() {
		return length*breadth;
	}

	/**
	 * This method return the perimeter of rectangle
	 * @return perimeter of rectangle as double
	 */
	@Override
	public double getPerimeter() {
		return 2*(length+breadth);
	}
	
	/**
	 * This method find if any given point is enclosed by rectangle
	 * @param point object of the Point Class representing the point
	 * @return true if point is enclosed else false
	 */
	@Override
	public boolean isPointEnclosed(Point point) {
		if(point.getxCoordinate()>=this.start.getxCoordinate() && (this.start.getxCoordinate()+length)>=point.getyCoordinate() && point.getyCoordinate()>=this.start.getyCoordinate() && (this.start.getyCoordinate()+breadth)>=point.getyCoordinate()){
			return true;
		}
		return false;
	}

	/**
	 * This method find the origin of rectangle]
	 * @return object of Point class containing details of the origin point
	 */
	@Override
	public Point getOrigin() {
		Point point=new Point(this.start.getxCoordinate(),this.start.getyCoordinate());
		return point;
	}
}