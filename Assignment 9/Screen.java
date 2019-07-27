package Assignment9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * This Class represent screen and contain method related to it
 * @author Sabir
 *
 */
public class Screen {

	// this linkedList store the name of the shapes added to screen
	public List<String> shapeListString = new LinkedList<String>();
	// this linkedList store the object of shape that added to screen
	public List<Shapes> shapeList = new LinkedList<Shapes>();
	// this linkedList store the time stamp of shapes when they are added to screen
	public List<Double> timeStamp = new LinkedList<Double>();
	// this represent the current time stamp of the system
	public double currentTimeStamp = 0;
	// object of the FactoryShapes Class it is used to create different shapes
	// objects
	FactoryShapes factory;

	/**
	 * This method is used to add shapes to screen
	 * @param shape name of the shape that need to be added
	 * @param start object of Point Class represent the start point of the shape
	 * @param list ArrayList contain the values for shapes attribute
	 * @return true if shape is added successfully else false
	 * @throws Exception when shape can't be added
	 */
	public boolean addShape(String shape, Point start, ArrayList<Double> list) throws Exception {
		factory = new FactoryShapes();
		this.shapeList.add(factory.getShape(shape, start, list));
		this.shapeListString.add(shape);
		this.timeStamp.add(currentTimeStamp++);
		return true;
	}

	/**
	 * This method used to display all shapes added to screen
	 * @return array of Strings containing names of the shapes present on the screen
	 */
	public String[] displayScreen() {
		String shapesOnScreeen[] = new String[shapeListString.size()];
		for (int shapeListStringIndex = 0; shapeListStringIndex < shapeListString.size(); shapeListStringIndex++) {
			shapesOnScreeen[shapeListStringIndex] = shapeListString.get(shapeListStringIndex);
		}
		return shapesOnScreeen;
	}

	/**
	 * This method is use to delete shapes from screen
	 * @param shape name of the shape to be deleted
	 * @return true if shape is deleted else false
	 * @throws Exception if no shape is available
	 */
	public boolean deleteShape(String shape) throws Exception {
		
		//checking if any shape is present or not
		if(this.shapeListString.size() == 0) {
			throw new Exception("No shapes found on screen");
		}
		int shapeListIndex;
		boolean flag = false;
		for (shapeListIndex = shapeListString.size() - 1; shapeListIndex >= 0; shapeListIndex--) {
			if (shapeListString.get(shapeListIndex).equals(shape)) {
				flag = true;
				break;
			}
		}
		if (flag == true) {
			this.shapeList.remove(shapeListIndex);
			this.timeStamp.remove(shapeListIndex);
			this.shapeListString.remove(shapeListIndex);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method is use to delete all shapes from screen
	 * @return true if all shapes deleted
	 * @throws Exception if no shape is available
	 */
	public boolean deleteAllShapes() throws Exception{
		
		//checking if any shape is available
		if(this.shapeListString.size()== 0) {
			throw new Exception("No shape on screen");
		}
		this.shapeList.removeAll(shapeList);
		this.timeStamp.removeAll(timeStamp);
		this.shapeListString.removeAll(shapeListString);
		return true;
	}

	/**
	 * This method is use to delete all shapes of a given type from screen
	 * @param shape name of type of shape
	 * @return true if shape is deleted else false
	 */
	public boolean deleteAllShapesOfParticularType(String shape) throws Exception{
		boolean flagFirst = false;
		boolean flagSecond = false;
		int counter = 0;
		while (true) {
			flagFirst = deleteShape(shape);
			if (counter == 0) {
				flagSecond = flagFirst;
				counter++;
			}
			if (!flagFirst) {
				break;
			}
		}
		return flagSecond;
	}

	/**
	 * This method is use to sort the shapes added to screen using different parameters
	 * @param sortType contain the values of shapes ex.area to be sorted
	 * @param listOfStringShapes name of the shapes present on screen
	 * @return
	 */
	private List<String> sortByType(List<Double> sortType, List<String> listOfStringShapes) {

		for (int sortTypeListFirstIndex = 0; sortTypeListFirstIndex < sortType.size(); sortTypeListFirstIndex++) {
			for (int sortTypeSecondIndex = sortTypeListFirstIndex + 1; sortTypeSecondIndex < sortType.size(); sortTypeSecondIndex++) {

				if (sortType.get(sortTypeSecondIndex) < sortType.get(sortTypeListFirstIndex)) {

					Double temp = sortType.get(sortTypeSecondIndex);
					sortType.set(sortTypeSecondIndex, sortType.get(sortTypeListFirstIndex));
					sortType.set(sortTypeListFirstIndex, temp);

					String shapeString = listOfStringShapes.get(sortTypeSecondIndex);
					listOfStringShapes.set(sortTypeSecondIndex, listOfStringShapes.get(sortTypeListFirstIndex));
					listOfStringShapes.set(sortTypeListFirstIndex, shapeString);
				}
			}
		}
		return listOfStringShapes;
	}

	/**
	 * This method use to sort shapes present on screen using different attributes like area,perimeter
	 * @param type string contain the type of attribute form which sorting should done
	 * @return list of name of the shapes in sorted order
	 * @throws Exception if valid attribute is not given
	 */
	public List<String> sortShapesByAttributes(String type) throws Exception {
		if (type.equalsIgnoreCase("Area")) {
			List<Double> area = new ArrayList<Double>();
			for (int shapeListIndex = 0; shapeListIndex < shapeList.size(); shapeListIndex++) {
				area.add(shapeList.get(shapeListIndex).getArea());
			}
			return sortByType(area, shapeListString);
		}
		if (type.equalsIgnoreCase("Perimeter")) {
			List<Double> perimeter = new ArrayList<Double>();
			for (int shapeListIndex = 0; shapeListIndex < shapeList.size(); shapeListIndex++) {
				perimeter.add(shapeList.get(shapeListIndex).getPerimeter());
			}
			return sortByType(perimeter, shapeListString);
		}
		if (type.equalsIgnoreCase("Origin")) {
			List<Double> origin = new ArrayList<Double>();
			for (int shapeListIndex = 0; shapeListIndex < shapeList.size(); shapeListIndex++) {
				origin.add(Math.sqrt(Math.pow((shapeList.get(shapeListIndex).getOrigin()).getxCoordinate(), 2)
						+ Math.pow((shapeList.get(shapeListIndex).getOrigin()).getyCoordinate(), 2)));
			}
			return sortByType(origin, shapeListString);
		}
		if (type.equalsIgnoreCase("Timestamp")) {
			return shapeListString;
		}
		throw new Exception("Not a valid Parameter");
	}

	/**
	 * This method is use to check if any given point is enclosed by shape
	 * @param point object of Point Class containing details about the point
	 * @return List of shapes enclosing the point
	 * @throws Exception when no shape on screen
	 */
	public List<String> isPointEnclosedByShapes(Point point) throws Exception {
		
		//checking if any shape is present on screen or not
		if(this.shapeListString.size() == 0) {
			throw new Exception("No shapes present on screen");
		}
		List<String> listOfShapesThatEnclosedPoint = new LinkedList<String>();
		for (int index = 0; index < shapeList.size(); index++) {
			if (shapeList.get(index).isPointEnclosed(point)) {
				listOfShapesThatEnclosedPoint.add(this.shapeListString.get(index));
			}
		}
		return listOfShapesThatEnclosedPoint;
	}

}
