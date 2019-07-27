package Assignment9;

/**
 * This class represent point on the screen
 * This store x and y coordinates
 * @author Sabir
 *
 */
public class Point {
	//x co-ordinate of point
	public double xCoordinate;
	//y co-ordinate of point
	public double yCoordinate;
	/**
	 * Parameterized constructor
	 * @param x represent value of x axis
	 * @param y represent value of y axis
	 */
	public Point(double x,double y){
		this.xCoordinate=x;
		this.yCoordinate=y;
	}
	
	/**
	 * This method return value of xCoordinate
	 * @return value of xCoordinate
	 */
	public double getxCoordinate() {
		return xCoordinate;
	}
	
	/**
	 * This method set the value of xCoordinate
	 */
	public void setxCoordinate(double xCoordinate) {
		this.xCoordinate = xCoordinate;
	}
	
	/**
	 * This method return value of yCoordinate
	 * @return value of yCoordinate
	 */
	public double getyCoordinate() {
		return yCoordinate;
	}
	
	/**
	 * This method set the value of yCoordinate
	 */
	public void setyCoordinate(double yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	
}
