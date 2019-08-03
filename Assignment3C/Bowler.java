package Assignment3C;

/**
 * This class represent Bowler
 * @author Sabir
 */
public class Bowler {
	
	private final String nameOfBowler;
	private int numberOfBallsLeft;

	/**
	 * Parameterized constructor
	 * @param String name of Bowler
	 * @param int type number of balls left
	 */
	public Bowler(String nameOfBowler, int numberOfBallsLeft) {
		this.nameOfBowler = nameOfBowler;
		this.numberOfBallsLeft = numberOfBallsLeft;
	}

	/**
	 * This method return the number of ball bowler has left
	 * @return int type number of balls left
	 */
	public int getNumberOfBallsLeft() {
		return this.numberOfBallsLeft;
	}

	/**
	 * This method set the number of balls left of bowler
	 * @param int type number of balls
	 */
	public void setNumberOfBallsLeft(int numberOfBallsLeft) {
		this.numberOfBallsLeft = numberOfBallsLeft;
	}

	/**
	 * This method return the name of bowler
	 * @return String type name of bowler
	 */
	public String getNameOfBowler() {
		return this.nameOfBowler;
	}
}