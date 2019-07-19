package Assignment5C;

/**
 * This class implement method to solve N Queen problem
 * @author Sabir
 *
 */
public class PlaceQueen {
	
	public static int queenPosition[][];
	
	/**
	 * 
	 * @param chessBoard two dimension NxN integer array containing zeros
	 * @param startRow positive integer value indicating starting row
	 * @param dimensionOfMatrix dimension of two dimension NxN matrix
	 * @return true if their is solution to place all queen safely else false
	 */
	public boolean placeNQueen(int chessBoard[][],int startRow, int dimensionOfMatrix){
		queenPosition = chessBoard;
		boolean success = nQueen(chessBoard,startRow,dimensionOfMatrix);
		chessBoard = queenPosition;
		return success;
	}
	
	/**
	 * 
	 * @param chessBoard chessBoard two dimension NxN integer array containing zeros
	 * @param startRow startRow positive integer value indicating starting row
	 * @param numberOfQueen number of queen to be placed
	 * @return true if their is solution to place all queen safely else false
	 */
	private boolean nQueen (int chessBoard[][], int startRow,int numberOfQueen){
		boolean queenPlaced = false;
		boolean innerQueenPlace = false;
		if(numberOfQueen == 0){
			return true;
		}
		for(int rowIndex = startRow;rowIndex <chessBoard.length;rowIndex++){
			for(int colIndex = 0; colIndex < chessBoard[0].length;colIndex++){
				if(chessBoard[rowIndex][colIndex]==0){
					queenPosition[rowIndex][colIndex] = 1;
					int value =1;
					blockLeftPositionInBoard(chessBoard, rowIndex, colIndex, value);
					blockRightPositionInBoard(chessBoard, rowIndex, colIndex, value);
					blockUpPositionInBoard(chessBoard, rowIndex, colIndex, value);
					blockDownPositionInBoard(chessBoard, rowIndex, colIndex, value);
					blockLeftUpDiagonalPositionInBoard(chessBoard, rowIndex, colIndex, value);
					blockRightUpDiagonalPositionInBoard(chessBoard, rowIndex, colIndex, value);
					blockLeftDownDiagonalPositionInBoard(chessBoard, rowIndex, colIndex, value);
					blockRightDownDiagonalPositionInBoard(chessBoard, rowIndex, colIndex, value);
					innerQueenPlace = nQueen(chessBoard,rowIndex+1,numberOfQueen-1);
				}else{
					continue;
				}
				
				if(innerQueenPlace == true){ return true; }
				else{
					queenPosition[rowIndex][colIndex] += -1;
					int value =-1;
					blockLeftPositionInBoard(chessBoard, rowIndex, colIndex, value);
					blockRightPositionInBoard(chessBoard, rowIndex, colIndex, value);
					blockUpPositionInBoard(chessBoard, rowIndex, colIndex, value);
					blockDownPositionInBoard(chessBoard, rowIndex, colIndex, value);
					blockLeftUpDiagonalPositionInBoard(chessBoard, rowIndex, colIndex, value);
					blockRightUpDiagonalPositionInBoard(chessBoard, rowIndex, colIndex, value);
					blockLeftDownDiagonalPositionInBoard(chessBoard, rowIndex, colIndex, value);
					blockRightDownDiagonalPositionInBoard(chessBoard, rowIndex, colIndex, value);
					chessBoard[rowIndex][colIndex] += -1;
				}
			}
		}
		return false;
	}
	
	/**
	 * This method is use to block left side position from the queen 
	 * @param chessBoard chessBoard chessBoard two dimension NxN integer array containing zeros
	 * @param startRow row index of queen
	 * @param startCol column index of queen
	 * @param value integer value that will be added to chessBoard
	 */
	private void blockLeftPositionInBoard(int chessBoard[][],int startRow, int startCol, int value){
		
			for(int colIndex = startCol; colIndex >= 0; colIndex--){
				if(colIndex == startCol && chessBoard[startRow][colIndex] == 0){
					chessBoard[startRow][colIndex] += value; 
					continue;
				}
				if(colIndex !=startCol){ chessBoard[startRow][colIndex] += value; }
			}
	}
	
	/**
	 * This method is use to block right side position from the queen 
	 * @param chessBoard chessBoard chessBoard two dimension NxN integer array containing zeros
	 * @param startRow row index of queen
	 * @param startCol column index of queen
	 * @param value integer value that will be added to chessBoard
	 */
	private void blockRightPositionInBoard(int chessBoard[][],int startRow, int startCol, int value){
		
		for(int colIndex = startCol; colIndex < chessBoard[0].length; colIndex++){
			if(colIndex == startCol && chessBoard[startRow][colIndex] == 0){
				chessBoard[startRow][colIndex] += value; 
				continue;
			}
			if(colIndex != startCol){ chessBoard[startRow][colIndex] +=value; }
		}
	}
	
	/**
	 * This method is use to block up side position from the queen 
	 * @param chessBoard chessBoard chessBoard two dimension NxN integer array containing zeros
	 * @param startRow row index of queen
	 * @param startCol column index of queen
	 * @param value integer value that will be added to chessBoard
	 */
	private void blockUpPositionInBoard(int chessBoard[][],int startRow, int startCol, int value){
		
		for(int rowIndex = startRow; rowIndex >= 0; rowIndex--){
			if(rowIndex == startRow && chessBoard[rowIndex][startCol] == 0){
				chessBoard[rowIndex][startCol] += value; 
				continue;
			}
			if(rowIndex != startRow){ chessBoard[rowIndex][startCol] += value; }
		}
	}
	
	/**
	 * This method is use to block down side position from the queen 
	 * @param chessBoard chessBoard chessBoard two dimension NxN integer array containing zeros
	 * @param startRow row index of queen
	 * @param startCol column index of queen
	 * @param value integer value that will be added to chessBoard
	 */
	private void blockDownPositionInBoard(int chessBoard[][],int startRow, int startCol, int value){
		
		for(int rowIndex = startRow; rowIndex < chessBoard.length; rowIndex++){
			if(rowIndex == startRow && chessBoard[rowIndex][startCol] == 0){
				chessBoard[startRow][startCol] += value; 
				continue;
			}
			if(rowIndex != startRow){ chessBoard[rowIndex][startCol] += value; }
		}
	}
	
	/**
	 * This method is use to block left side upper diagonal position from the queen 
	 * @param chessBoard chessBoard chessBoard two dimension NxN integer array containing zeros
	 * @param startRow row index of queen
	 * @param startCol column index of queen
	 * @param value integer value that will be added to chessBoard
	 */
	private void blockLeftUpDiagonalPositionInBoard(int chessBoard[][],int startRow, int startCol, int value){
		
		int rowIndex = startRow;
		int colIndex = startCol;
		while(rowIndex >=0 && colIndex >= 0){
			if(rowIndex == startRow && colIndex == startCol && chessBoard[rowIndex][colIndex] == 0){
				chessBoard[rowIndex][colIndex] += value; 
				continue;
			}
			if(rowIndex != startRow && colIndex != startCol){ chessBoard[rowIndex][colIndex] += value; }
			rowIndex--;
			colIndex--;
		}
	}
	
	/**
	 * This method is use to block right side upper diagonal position from the queen 
	 * @param chessBoard chessBoard chessBoard two dimension NxN integer array containing zeros
	 * @param startRow row index of queen
	 * @param startCol column index of queen
	 * @param value integer value that will be added to chessBoard
	 */
	private void blockRightUpDiagonalPositionInBoard(int chessBoard[][],int startRow, int startCol, int value){
		
		int rowIndex = startRow;
		int colIndex = startCol;
		while(rowIndex >=0  && colIndex < chessBoard[0].length ){
			if(rowIndex == startRow && colIndex == startCol && chessBoard[rowIndex][colIndex] == 0){
				chessBoard[rowIndex][colIndex] += value; 
				continue;
			}
			if(rowIndex != startRow && colIndex != startCol){ chessBoard[rowIndex][colIndex] += value; }
			rowIndex--;
			colIndex++;
		}
	}
	
	/**
	 * This method is use to block left side down diagonal position from the queen 
	 * @param chessBoard chessBoard chessBoard two dimension NxN integer array containing zeros
	 * @param startRow row index of queen
	 * @param startCol column index of queen
	 * @param value integer value that will be added to chessBoard
	 */
	private void blockLeftDownDiagonalPositionInBoard(int chessBoard[][],int startRow, int startCol, int value){
		
		int rowIndex = startRow;
		int colIndex = startCol;
		while(rowIndex < chessBoard.length  && colIndex >= 0 ){
			if(rowIndex == startRow && colIndex == startCol && chessBoard[rowIndex][colIndex] == 0){
				chessBoard[rowIndex][colIndex] += value; 
				continue;
			}
			if(rowIndex != startRow && colIndex != startCol){ chessBoard[rowIndex][colIndex] += value; }
			rowIndex++;
			colIndex--;
		}
	}
	
	/**
	 * This method is use to block right side down diagonal position from the queen 
	 * @param chessBoard chessBoard chessBoard two dimension NxN integer array containing zeros
	 * @param startRow row index of queen
	 * @param startCol column index of queen
	 * @param value integer value that will be added to chessBoard
	 */
	private void blockRightDownDiagonalPositionInBoard(int chessBoard[][],int startRow, int startCol, int value){
		
		int rowIndex = startRow;
		int colIndex = startCol;
		while(rowIndex < chessBoard.length  && colIndex < chessBoard[0].length){
			if(rowIndex == startRow && colIndex == startCol  && chessBoard[rowIndex][colIndex] == 0){
				chessBoard[rowIndex][colIndex] += value; 
				continue;
			}
			if(rowIndex != startRow && colIndex != startCol){ chessBoard[rowIndex][colIndex] += value; }
			rowIndex++;
			colIndex++;
		}
	}
}
