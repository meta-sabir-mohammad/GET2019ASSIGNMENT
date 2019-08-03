package Assignment3C;

/**
 * This class contain method to generate bowler's order
 * @author Sabir
 */
public class BowlerOrder {
	
	private int totalNumberOfBowlers;
	private PriorityQueue priorityQueue;

	/**
	 * parameterized Constructor
	 * @param int type total number of Bowlers
	 */
	public BowlerOrder(int totalNumberOfBowlers) {
		this.totalNumberOfBowlers =totalNumberOfBowlers;
		this.priorityQueue = new PriorityQueue(this.totalNumberOfBowlers);
	}

	/**
	 * This method adds bowler to list
	 * @param Bowler type bowler
	 * @return true after adding bowler
	 * @throws exception if bowler list is full
	 */
	public boolean addBowler(Bowler bowler) throws Exception {
		if (this.totalNumberOfBowlers > 0) {
			if(bowler.getNumberOfBallsLeft() != 0){
				priorityQueue.enQueue(bowler.getNumberOfBallsLeft(), bowler.getNameOfBowler());
			}
			this.totalNumberOfBowlers--;
			return true;
		} else {
			throw new Exception("Bowlers List is already Full");
		}
	}

	/**
	 * This method returns the next Bowler
	 * @return String type Bowlers Name
	 * @throws exception if no bowler is left to bowl
	 */
	public String getNextBowler() throws Exception {
		if (this.totalNumberOfBowlers == 0) {
			if (priorityQueue.isEmpty()) {
				throw new Exception("No Bowler has balls left to bowl");
			}
			Element element = priorityQueue.deQueue();
			Bowler bowler = new Bowler((String) element.getValue(), element.getPriority());
			totalNumberOfBowlers++;
			bowler.setNumberOfBallsLeft(bowler.getNumberOfBallsLeft() - 1);
			addBowler(bowler);
			return bowler.getNameOfBowler();
		} else {
			throw new Exception("Complete Addition Of Bowlers First");
		}
	}
}