package Assignment9;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * This is test Class for Screen Class it test all methods positive and negative
 * test cases
 * 
 * @author Sabir
 *
 */
class ScreenTest {

	/**
	 * This test method test addShape method positive test cases
	 */
	@Test
	void addShapeMethodPositiveCasesTest() throws Exception {
		Screen screen = new Screen();
		Point point = new Point(1, 1);
		ArrayList<Double> list = new ArrayList<Double>();
		list.add(1.0);
		assertTrue(screen.addShape("Square", point, list));
		assertTrue(screen.addShape("Circle", point, list));
		list.add(2.3);
		assertTrue(screen.addShape("Rectangle", point, list));
		assertTrue(screen.addShape("Triangle", point, list));
	}

	/**
	 * This test method test displayScreen method positive test cases
	 */
	@Test
	void displayScreenMethodPositiveCasesTest() throws Exception {
		Screen screen = new Screen();
		Point point = new Point(1, 1);
		ArrayList<Double> list = new ArrayList<Double>();
		list.add(1.0);
		screen.addShape("Square", point, list);
		screen.addShape("Circle", point, list);
		list.add(2.3);
		screen.addShape("Rectangle", point, list);
		screen.addShape("Triangle", point, list);
		screen.addShape("Rectangle", point, list);
		screen.addShape("Rectangle", point, list);
		screen.addShape("Rectangle", point, list);
		screen.addShape("Triangle", point, list);
		String actual[] = screen.displayScreen();
		String expected[] = new String[] { "Square", "Circle", "Rectangle", "Triangle", "Rectangle", "Rectangle",
				"Rectangle", "Triangle" };
		assertArrayEquals(expected, actual);
	}

	/**
	 * This test method test deleteShape method positive test cases
	 */
	@Test
	void deleteShapeMethodPositiveCasesTest() throws Exception {
		Screen screen = new Screen();
		Point point = new Point(1, 1);
		ArrayList<Double> list = new ArrayList<Double>();
		list.add(1.0);
		screen.addShape("Square", point, list);
		screen.addShape("Circle", point, list);
		list.add(2.3);
		screen.addShape("Rectangle", point, list);
		screen.addShape("Triangle", point, list);
		screen.addShape("Rectangle", point, list);
		screen.addShape("Rectangle", point, list);
		screen.addShape("Rectangle", point, list);
		screen.addShape("Triangle", point, list);
		assertTrue(screen.deleteShape("Rectangle"));
		assertTrue(screen.deleteShape("Circle"));
	}

	/**
	 * This test method test deleteAllShapes method positive test cases
	 */
	@Test
	void deleteAllShapesMethodPositiveCasesTest() throws Exception {
		Screen screen = new Screen();
		Point point = new Point(1, 1);
		ArrayList<Double> list = new ArrayList<Double>();
		list.add(1.0);
		screen.addShape("Square", point, list);
		screen.addShape("Circle", point, list);
		list.add(2.3);
		screen.addShape("Rectangle", point, list);
		screen.addShape("Triangle", point, list);
		screen.addShape("Rectangle", point, list);
		screen.addShape("Rectangle", point, list);
		screen.addShape("Rectangle", point, list);
		screen.addShape("Triangle", point, list);
		assertTrue(screen.deleteAllShapes());
	}

	/**
	 * This test method test deleteAllShapesOfParticularType method positive test
	 * cases
	 */
	@Test
	void deleteAllShapesOfParticularTypeMethodPositiveCasesTest() throws Exception {
		Screen screen = new Screen();
		Point point = new Point(1, 1);
		ArrayList<Double> list = new ArrayList<Double>();
		list.add(1.0);
		screen.addShape("Square", point, list);
		screen.addShape("Circle", point, list);
		list.add(2.3);
		screen.addShape("Rectangle", point, list);
		screen.addShape("Triangle", point, list);
		screen.addShape("Rectangle", point, list);
		screen.addShape("Rectangle", point, list);
		screen.addShape("Rectangle", point, list);
		screen.addShape("Triangle", point, list);
		assertTrue(screen.deleteAllShapesOfParticularType("Rectangle"));
		assertTrue(screen.deleteAllShapesOfParticularType("Circle"));
	}

	/**
	 * This test method test isPointEnclosedByShapes method positive test cases
	 */
	@Test
	void isPointEnclosedByShapesMethodPositiveCasesTest() throws Exception {
		Screen screen = new Screen();
		Point point = new Point(1, 1);
		ArrayList<Double> list = new ArrayList<Double>();
		list.add(1.0);
		screen.addShape("Square", point, list);
		screen.addShape("Circle", point, list);
		List<String> actual = new LinkedList<String>();
		actual = screen.isPointEnclosedByShapes(point);
		List<String> expected = new LinkedList<String>();
		expected.add("Square");
		expected.add("Circle");
		assertEquals(expected, actual);
	}

	/**
	 * This test method test sortShapesByAtrributes method positive test cases
	 */
	@Test
	void sortShapesByAtrributesMethodPositiveCasesTest() throws Exception {
		Screen screen = new Screen();
		Point point = new Point(1, 1);
		ArrayList<Double> list = new ArrayList<Double>();
		list.add(1.0);
		screen.addShape("Square", point, list);
		screen.addShape("Circle", point, list);
		List<String> actual = new LinkedList<String>();
		actual = screen.sortShapesByAttributes("Area");
		List<String> expected = new LinkedList<String>();
		expected.add("Square");
		expected.add("Circle");
		assertEquals(expected, actual);
		expected.removeAll(expected);
		actual = screen.sortShapesByAttributes("Perimeter");
		expected.add("Square");
		expected.add("Circle");
		assertEquals(expected, actual);
		expected.removeAll(expected);
		actual = screen.sortShapesByAttributes("Origin");
		expected.add("Square");
		expected.add("Circle");
		assertEquals(expected, actual);
		expected.removeAll(expected);
		actual = screen.sortShapesByAttributes("TimeStamp");
		expected.add("Square");
		expected.add("Circle");
		assertEquals(expected, actual);
	}

	/**
	 * This test method test addShape method negative test cases
	 */
	@Test(expected = Exception.class)
	void addShapeMethodNegativeCasesTest() throws Exception {
		Point point1 = new Point(1, 1);
		Screen screen1 = new Screen();
		ArrayList<Double> attributeList = new ArrayList<Double>();
		screen1.addShape("Hexagon", point1, attributeList);
	}

	/**
	 * This test method test deleteAllShapes method negative test cases
	 */
	@Test(expected = Exception.class)
	void deleteAllShapesMethodNegativeCasesTest() throws Exception {
		Screen screen2 = new Screen();
		screen2.deleteShape("Hexagon");
	}

	/**
	 * This test method test deleteAllShapesOfParticularType method negative test
	 * cases
	 */
	@Test(expected = Exception.class)
	void deleteAllShapesOfParticularTypeMethodNegativeCasesTest() throws Exception {
		Screen screen3 = new Screen();
		screen3.deleteAllShapesOfParticularType("Circle");
	}

	/**
	 * This test method test sortShapesByAtrributes method negative test cases
	 */
	@Test(expected = Exception.class)
	void sortShapesByAtrributesMethodNegativeCasesTest() throws Exception {
		Point point1 = new Point(1, 1);
		ArrayList<Double> attributeList1 = new ArrayList<Double>();
		attributeList1.add(0, 1.0);
		attributeList1.add(1, 1.0);
		Screen screen3 = new Screen();
		screen3.addShape("Rectangle", point1, attributeList1);
		screen3.sortShapesByAttributes("Hexagon");
	}

	/**
	 * This test method test isPointEnclosedByShapes method negative test cases
	 */
	@Test(expected = Exception.class)
	void isPointEnclosedByShapesMethodNegativeCasesTest() throws Exception {
		Point point1 = new Point(1, 1);
		Screen screen4 = new Screen();
		screen4.isPointEnclosedByShapes(point1);
	}

}
