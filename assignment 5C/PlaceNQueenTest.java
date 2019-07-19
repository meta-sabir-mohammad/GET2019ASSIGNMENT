package Assignment5C;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * This is test class to test placeNQueen method of PlaceQueen Class
 * @author Sabir
 *
 */
@RunWith(Parameterized.class)
public class PlaceNQueenTest {

	static PlaceQueen placeQueen;
	private int dimensionOfMatrix;
	private int chessBoard[][];
	private int startRow;
	private boolean expected;
	
	public PlaceNQueenTest(int chessBoard[][],int startRow,int dimensionOfMatrix){
	
		this.chessBoard = chessBoard;
		this.startRow = startRow;
		this.dimensionOfMatrix = dimensionOfMatrix;
	}
	
	@Parameters
	public static Collection<Object[]> testData(){
		Object[][] data = new Object[][] { { new int[][]{{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}}, 0 , 4 },
				                           {new int[][]{{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},
				                                         {0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},
				                                         {0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}}, 0 , 8}};
		return Arrays.asList(data);
	}
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		placeQueen = new PlaceQueen();
	}
	
	/**
	 * This test method test placeNQueen method of PlaceQueen Class
	 * this method take a two dimension nxn array containing zero
	 * return true if n number of queen can be place safely else false
	 */
	@Test
	public void testPlaceNQueen() {
	 assertTrue(placeQueen.placeNQueen(chessBoard,startRow,dimensionOfMatrix));
	}

}
