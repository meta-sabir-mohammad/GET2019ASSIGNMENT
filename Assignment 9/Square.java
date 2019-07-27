package Assignment9;

import java.util.ArrayList;

import Assignment9.Point;

/**
 * This class represent shape Square
 * @author Sabir
 *
 */
public class Square implements Shapes{
	
	//This represent the start point of the Square
	public Point start;
	//This represent the side of the Square
	public double side;
	

	/**
	 * Parameterized constructor
	 * @param point object of Point Class containing details of point
	 * @param list ArrayList containing start and side values
	 */
	public Square(Point point,ArrayList<Double> list){
		this.start=point;
		this.side=(double)list.get(0);
	}
	
	/**
	 * This method find the area of square
	 * @return area of square as double
	 */
	@Override
	public double getArea() {
		return side*side;
	}

	/**
	 * This method find the perimeter of square
	 * @return perimeter of square as double
	 */
	@Override
	public double getPerimeter() {
		return 4*side;
	}

	/**
	 * This method return the origin point of square
	 * @return object of Point Class containing details of point
	 */
	@Override
	public Point getOrigin() {
		Point point=new Point(this.start.getxCoordinate(),this.start.getyCoordinate());
		return point;
	}

	/**
	 * This method find if given point is enclosed by square
	 * @return true if point is enclosed else false
	 */
	@Override
	public boolean isPointEnclosed(Point point) {
		if(point.getxCoordinate()>=this.start.getxCoordinate() && ((this.start.getxCoordinate()+side)>=point.getxCoordinate()) && point.getyCoordinate()>=this.start.getyCoordinate() && ((this.start.getyCoordinate()+side)>=point.getyCoordinate()) ){
			return true;
		}
		return false;
	}
}
