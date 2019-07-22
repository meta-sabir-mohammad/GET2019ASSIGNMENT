package Assignment7;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * This test class test methods of SparseMatrice Class
 * @author Sabir
 *
 */
public class SparseMatriceTest {

	/**
	 * This test method test getMatrice method of SparseMatrice Class
	 * this method return 2 dimensional array containing sparse matrix
	 */
	@Test
	public void testGetMatrice() {
		int[][] array1 = new int[][] {{0,0,1},{0,2,0},{1,0,3}};
		SparseMatrice matrix1 = new SparseMatrice(array1);		
		int[][] actualArray = matrix1.getMatrice();
		assertArrayEquals(array1,actualArray);
	}

	/**
	 * This test method test getMultiplicationOfTwoSparseMatrice method of SparseMatrice Class
	 * this do the multiplication of two sparse matrix and return object of SparseMatrice immutable Class
	 */
	@Test
	public void testGetMultiplicationOfTwoSparseMatrice() {
		int[][] array1 = new int[][] {{0,0,1},{0,2,0},{1,0,3}};
		SparseMatrice matrix1 = new SparseMatrice(array1);		
		int[][] array2 = new int[][] {{1,0,0},{2,0,0},{3,0,0}};
		SparseMatrice matrix2 = new SparseMatrice(array2);
		int[][] expectedMultiplication1 = new int[][] {{3,0,0},{4,0,0},{10,0,0}};
		try {
			int[][] actualMultiplication1 = matrix1.getMultiplicationOfTwoSparseMatrice(matrix2).getMatrice();
			assertArrayEquals(expectedMultiplication1,actualMultiplication1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This test method test the getTransposeOfSparseMatrice method of SparseMatrice Class
	 * this method return the transpose of given matrix in the form of SparseMatrice object
	 */
	@Test
	public void testGetTransposeOfSparseMatrice() {
		int[][] array1 = new int[][] {{0,0,1},{0,0,2},{0,0,3}};
		SparseMatrice matrix1 = new SparseMatrice(array1);
		int[][] expectedTranspose1 = new int[][] {{0,0,0},{0,0,0},{1,2,3}};
		int[][] actualTranspose1 = matrix1.getTransposeOfSparseMatrice().getMatrice();
		assertArrayEquals(expectedTranspose1,actualTranspose1);

		int[][] array2 = new int[][] {{1,0,0},{2,0,0},{3,0,0}};
		SparseMatrice matrix2 = new SparseMatrice(array2);
		int[][] expectedTranspose2 = new int[][] {{1,2,3},{0,0,0},{0,0,0}};
		int[][] actualTranspose2 = matrix2.getTransposeOfSparseMatrice().getMatrice();
		assertArrayEquals(expectedTranspose2,actualTranspose2);
	}

	/**
	 * This test method test the isSparseMatriceSymmetrical method of SparseMatrice Class
	 * this method return true if matrix is symmetrical else false
	 */
	@Test
	public void testIsSparseMatriceSymmetrical() {
		int[][] array1 = new int[][] {{0,0,1},{0,2,0},{1,0,3}};
		SparseMatrice matrix1 = new SparseMatrice(array1);
		assertTrue(matrix1.isSparseMatriceSymmetrical());
		
		int[][] array2 = new int[][] {{1,0,0},{2,0,0},{3,0,0}};
		SparseMatrice matrix2 = new SparseMatrice(array2);
		assertFalse(matrix2.isSparseMatriceSymmetrical());
	}

	/**
	 * This test method test getAdditionOfTwoSparseMatrice method of SparseMatrice Class
	 * this do the addition of two sparse matrix and return object of SparseMatrice immutable Class
	 */
	@Test
	public void testGetAdditionOfTwoSparseMatrice() {
		int[][] array1 = new int[][] {{0,0,1},{0,2,0},{1,0,3}};
		SparseMatrice matrix1 = new SparseMatrice(array1);		
		int[][] array2 = new int[][] {{1,0,0},{2,0,0},{3,0,0}};
		SparseMatrice matrix2 = new SparseMatrice(array2);
		int[][] expectedAddition1 = new int[][] {{1,0,1},{2,2,0},{4,0,3}};
		try {
			int[][] actualAddition1 = matrix1.getAdditionOfTwoSparseMatrice(matrix2).getMatrice();
			assertArrayEquals(expectedAddition1,actualAddition1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
