package Assignment2B;

import java.io.IOException;

/**
 * 
 * JobScheduler class used for First Come First Serve job scheduling it contain
 * methods to calculate waiting time,completion time, turn around time,average
 * waiting time, etc
 *
 */
public class JobScheduler {

	/**
	 * @param process take two dimension array which contain arrival time and burst time of n process
	 * @param numberOfProcess take number of process in Integer
	 * @return an one dimension array which contain waiting time for all process
	 */
	public int[] getWaitingTime(int process[][], int numberOfProcess) throws IOException {
		
		//input validation
		boolean validInput = inputValidation(process,numberOfProcess);
		if(validInput == false){
			throw new IOException("Invalid Inputs!!!");
		}
		
		
		int waitingTime[] = new int[numberOfProcess];

		// calling sortProcess method to sort according to arrival time
		int sortedProcess[][] = sortProcess(process, numberOfProcess);
		int turnAroundTime[] = getTurnAroundTime(sortedProcess, numberOfProcess);

		// calculating waiting time for process
		for (int firstIndex = 0; firstIndex < numberOfProcess; firstIndex++) {

			// if its the first Process than waiting time == arrival time
			if (firstIndex == 0) {
				waitingTime[firstIndex] = 0;
			} else {
				
				int turnAroundtimeOfProcess = turnAroundTime[firstIndex];
				int burstTimeOfProcess = sortedProcess[firstIndex][1];

				waitingTime[firstIndex] = turnAroundtimeOfProcess - burstTimeOfProcess;

			}

		}
		return waitingTime;
	}

	/**
	 * @param process take two dimension array which contain arrival time and burst time of n process
	 * @param numberOfProcess take number of process in Integer
	 * @return an one dimension array which contain completion time for all process
	 */
	public int[] getCompletionTime(int process[][], int numberOfProcess) throws IOException{
		
		//input validation
		boolean validInput = inputValidation(process,numberOfProcess);
		if(validInput == false){
			throw new IOException("Invalid Inputs!!!");
		}
				
		int completionTime[] = new int[numberOfProcess];

		// calling sortProcess method that will return two dimension sorted array
		// according to arrival time
		int sortedProcess[][] = sortProcess(process, numberOfProcess);


		for (int firstIndex = 0; firstIndex < numberOfProcess; firstIndex++) {

			int processBurstTime = sortedProcess[firstIndex][1];
			int processArrivalTime = sortedProcess[firstIndex][0];

			if (firstIndex == 0) {
				completionTime[firstIndex] = processBurstTime + processArrivalTime;
				continue;
			}
			int completionTimeOfPreviousProcess = completionTime[firstIndex - 1];
			
			if(processArrivalTime - completionTime[firstIndex] > 0){
				completionTime[firstIndex] = completionTimeOfPreviousProcess + processBurstTime + (processArrivalTime - completionTime[firstIndex]);
			}else{
				completionTime[firstIndex] = completionTimeOfPreviousProcess + processBurstTime;
			}
			
		}
		return completionTime;
	}

	/**
	 * @param process take two dimension array which contain arrival time and burst time of n process
	 * @param numberOfProcess take number of process in Integer
	 * @return an one dimension array which contain turn around time for all process
	 */
	public int[] getTurnAroundTime(int process[][], int numberOfProcess) throws IOException{
		
		//input validation
		boolean validInput = inputValidation(process,numberOfProcess);
		if(validInput == false){
			throw new IOException("Invalid Inputs!!!");
		}
		
		int turnAroundTime[] = new int[numberOfProcess];

		// calling sortProcess method that will return two dimension sorted array
		// according to arrival time
		int sortedProcess[][] = sortProcess(process, numberOfProcess);

		// calling getComplitionTime method that will return one dimension array
		// containing
		// Completion time of each process according to their order
		int completionTime[] = getCompletionTime(sortedProcess, numberOfProcess);

		for (int firstIndex = 0; firstIndex < numberOfProcess; firstIndex++) {

			int completionTimeOfProcess = completionTime[firstIndex];
			int arrivalTimeOfProcess = sortedProcess[firstIndex][0];

			turnAroundTime[firstIndex] = completionTimeOfProcess - arrivalTimeOfProcess;
		}

		return turnAroundTime;
	}

	/**
	 * @param process take two dimension array which contain arrival time and burst time of n process
	 * @param numberOfProcess take number of process in Integer
	 * @return an double which contain average waiting time for process
	 */
	public double getAverageWaitingTime(int process[][], int numberOfProcess) throws IOException{
		
		//input validation
		boolean validInput = inputValidation(process,numberOfProcess);
		if(validInput == false){
			throw new IOException("Invalid Inputs!!!");
		}
				
		int avrageWaitingTime = 0;

		// calling sortProcess method that will return two dimension sorted array
		// according to arrival time
		int sortedProcess[][] = sortProcess(process, numberOfProcess);

		// calling getWaitingTime method that will return one dimension array containing
		// waiting time of each process according to their order
		int waitingTime[] = getWaitingTime(sortedProcess, numberOfProcess);

		int totalWaitTime = 0;

		// calculating total waiting time of all process
		for (int firstIndex = 0; firstIndex < numberOfProcess; firstIndex++) {
			totalWaitTime += waitingTime[firstIndex];
		}

		avrageWaitingTime = totalWaitTime / numberOfProcess;
		return avrageWaitingTime;
	}

	/**
	 * @param process take two dimension array which contain arrival time and burst time of n process
	 * @param numberOfProcess take number of process in Integer
	 * @return an integer which contain maximum waiting time for process
	 */
	public int getMaximumWaitingTime(int process[][], int numberOfProcess) throws IOException {
		
		//input validation
		boolean validInput = inputValidation(process,numberOfProcess);
		if(validInput == false){
			throw new IOException("Invalid Inputs!!!");
		}
				
		int maximumWaitingTime = 0;

		// calling sortProcess mehtod that will return two dimension sorted array
		// according to arrival time
		int sortedProcess[][] = sortProcess(process, numberOfProcess);

		// calling getWaitingTime method that will return one dimension array containing
		// waiting time of each process according to their order
		int waitingTime[] = getWaitingTime(sortedProcess, numberOfProcess);

		maximumWaitingTime = waitingTime[0];

		// calculating maximum waiting time of process
		for (int firstIndex = 0; firstIndex < numberOfProcess; firstIndex++) {
			if (maximumWaitingTime < waitingTime[firstIndex]) {
				maximumWaitingTime = waitingTime[firstIndex];
			}
		}

		return maximumWaitingTime;
	}

	/**
	 * 
	 * @param process take a two dimension array containing arrival time and burst time of process
	 * @param numberOfProcess take number of process in Integer
	 * @return a sorted two dimension array according to arrival time
	 */
	public int[][] sortProcess(int process[][], int numberOfProcess) throws IOException{
		
		//input validation
		boolean validInput = inputValidation(process,numberOfProcess);
		if(validInput == false){
			throw new IOException("Invalid Inputs!!!");
		}
				
		int tempProcessArrivalTime;
		int tempProcessBurstTime;
		int sortedProcess[][] = process;

		// for sorting process according to arrival time
		for (int firstIndex = 0; firstIndex < numberOfProcess; firstIndex++) {

			int firstProcessArrivalTime = sortedProcess[firstIndex][0];
			int firstProcessBurstTime = sortedProcess[firstIndex][1];

			for (int secondIndex = firstIndex + 1; secondIndex < numberOfProcess; secondIndex++) {

				int secondProcessArrivalTime = sortedProcess[secondIndex][0];
				int secondProcessBurstTime = sortedProcess[secondIndex][1];

				if (firstProcessArrivalTime > secondProcessArrivalTime) {

					// storing second process arrival and burst time in temporary variable
					tempProcessArrivalTime = secondProcessArrivalTime;
					tempProcessBurstTime = secondProcessBurstTime;

					// storing first process arrival and burst time at second location
					sortedProcess[secondIndex][0] = firstProcessArrivalTime;
					sortedProcess[secondIndex][1] = firstProcessBurstTime;

					// storing second process arrival and burst time at first location from
					// temporary variables
					sortedProcess[firstIndex][0] = tempProcessArrivalTime;
					sortedProcess[firstIndex][1] = tempProcessBurstTime;
				}
			}
		}
		return sortedProcess;
	}
	
	/**
	 * 
	 * @param process take a two dimension integer array containing arrival time and burst time of n process
	 * @param numberOfProcess take a integer value containing number of Process
	 * @return true if number of process is greater than 0 and arrival time and burst time of each process is not less than 0 and 1 else return false
	 */
	public boolean inputValidation(int process[][], int numberOfProcess){
		
		if(numberOfProcess <= 0){
			return false;
		}else{
			for(int processIndex = 0; processIndex <numberOfProcess; processIndex++){
				int processArrivalTime = process[processIndex][0];
				int processBurstTime = process[processIndex][1];
				
				if(processArrivalTime <=0 || processBurstTime < 1){
					return false;
				}
			}
		}
		return true;
	}
}