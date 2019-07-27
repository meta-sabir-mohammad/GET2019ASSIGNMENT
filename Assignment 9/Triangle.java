package Assignment9;

import java.util.ArrayList;

import Assignment9.Point;
import Assignment9.Shapes;

/**
 * This class represent shape Triangle
 * @author Sabir
 *
 */
public class Triangle implements Shapes{
	
	//This represent base length of triangle
	public double base;
	//This represent length of perpendicular of triangle
	public double perpendicular;	
	//This represent length of hypotnuse of triangle
	public double hypotnuse;
	//This represent first point of triangle
	public Point point1;
	//This represent second point of triangle
	public Point point2;
	//This represent thired point of triangle
	public Point point3;
	
	/**
	 * Parameterized constructor 
	 * @param start object of Point Class containing details about point
	 * @param list 
	 */
	public Triangle(Point start,ArrayList<Double> list){
		this.point1=start;
		this.base=(double)list.get(0);
		this.perpendicular=(double)list.get(1);
		this.hypotnuse=Math.sqrt(perpendicular*perpendicular+base*base);
		initialisePoints();
	}
	
	private void initialisePoints() {
		Point pointSecond = new Point(this.point1.getxCoordinate(),this.point1.getyCoordinate()+perpendicular);
		point2=pointSecond;
		Point pointThird = new Point(this.point1.getxCoordinate()+base,this.point1.getyCoordinate());
		point2=pointThird;
	}
	
	private double calculateArea(Point p1,Point p2,Point p3){
		double area=p1.getxCoordinate()*(p2.getyCoordinate()-p3.getyCoordinate())+p2.getxCoordinate()*(p1.getyCoordinate()-p3.getyCoordinate())+p3.getxCoordinate()*(p2.getyCoordinate()-p1.getyCoordinate());
		area=area/2;
		if(area<0){
			area*=-1;
		}
		return area;
	}

	/**
	 * This method find the area of square
	 * @return area of square as double
	 */
	@Override
	public double getArea() {
		return base*perpendicular/2;
	}

	/**
	 * This method find the perimeter of Triangle
	 * @return perimeter of Triangle as double
	 */
	@Override
	public double getPerimeter() {
		return (base+hypotnuse+perpendicular);
	}
	
	/**
	 * This method find if given point is enclosed by Triangle
	 * @return true if point is enclosed else false
	 */
	@Override
	public boolean isPointEnclosed(Point point) {
		if((calculateArea(point, this.point1 , this.point2)+calculateArea(point, this.point1 , this.point3)+calculateArea(point, this.point3 , this.point2))==calculateArea(this.point1, this.point2,this.point3)){
			return true;
		}
		return false;
	}

	/**
	 * This method return the origin point of Triangle
	 * @return object of Point Class containing details of point
	 */
	@Override
	public Point getOrigin() {
		return this.point1;
	}
}