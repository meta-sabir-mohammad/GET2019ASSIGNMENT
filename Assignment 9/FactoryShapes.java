package Assignment9;

import java.util.ArrayList;

/**
 * This is factory class which use to create object of all shapes
 * @author Sabir
 *
 */
public class FactoryShapes extends Screen{
	
	/**
	 * This method is use to create object of different shapes
	 * @param shape String containing name of shape that object need to be created
	 * @param start object of Point Class containing details about start point of shape
	 * @param list ArrayList containing values for shape
	 * @return Object of Shape
	 * @throws Exception throws Exception if required shape is not available
	 */
	public Shapes getShape(String shape,Point start,ArrayList<Double> list) throws Exception{
		if(shape.equalsIgnoreCase("Rectangle")){
			return new Rectangle(start,list);
		}
		else if(shape.equalsIgnoreCase("Square")){
				return new Square(start,list);	
			}
		else if(shape.equalsIgnoreCase("Triangle")){
			return new Triangle(start,list);	
		}
		else if(shape.equalsIgnoreCase("Circle")){
			return new Circle(start,list);	
		}
		else
			throw new Exception("Shape Not Found");
	}
}
