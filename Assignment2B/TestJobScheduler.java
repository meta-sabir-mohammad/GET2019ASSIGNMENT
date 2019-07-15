package Assignment2B;

import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * TestJobScheduler class is used as a test class to check JobScheduler class methods  output
 *
 */
public class TestJobScheduler {

	public static void main(String[] args) {

		JobScheduler jobScheduler = new JobScheduler();
		
		//Scanner object for taking user input from console
		Scanner userInput = new Scanner(System.in);

		/**
		 * taking number of process as input
		 */
		System.out.print("Enter Number Of Process :-");
		int numberOfProcess = userInput.nextInt();
		
		//creating process 2 dimension array which store arrival time and burst time of process
		int process[][] = new int[numberOfProcess][2];
		
		
		//taking arrival time and burst time of all process and storing into process array
		for (int loop = 0; loop < numberOfProcess; loop++) {
			System.out.print("Enter Arrival Time Of Process " + (loop + 1) + " :- ");
			process[loop][0] = userInput.nextInt();
			System.out.print("Ener Burst Time Of Process " + (loop + 1) + " :- ");
			process[loop][1] = userInput.nextInt();
		}

		
		//while loop for options
		while (true) {
			System.out.println("1.Calculate Waiting Time Of All Process");
			System.out.println("2.Calculate Completion Time Of All Process");
			System.out.println("3.Calculate Turn Around Time Of All Process");
			System.out.println("4.Calculate Avrage Waiting Time");
			System.out.println("5.Calculate Maximum Waiting Time");
			System.out.println("6.Get Sorted Process According to Arrival Time");
			System.out.println("7.Exit");

			//taking input for selecting option
			int option = userInput.nextInt();
			
			//while loop closing condition
			if (option == 7) {
				System.out.println("Thank You");
				break;
			}
			
			switch (option) {
			
			//for calculating waiting time of all process
			case (1): {
				try{
					int waitingTime[] = jobScheduler.getWaitingTime(process, numberOfProcess);
					for (int loop = 0; loop < numberOfProcess; loop++) {

						System.out.println("Waiting Time Of Process " + (loop + 1) + " :-\t" + waitingTime[loop]);

					}
				}catch(IOException io){
					System.out.println(io);
				}
				
				break;
			}
			
			//for calculating completion time of all process
			case (2): {
				try{
					int completionTime[] = jobScheduler.getCompletionTime(process, numberOfProcess);
					for (int loop = 0; loop < numberOfProcess; loop++) {

						System.out.println("Completion Time Of Process " + (loop + 1) + " :-\t" + completionTime[loop]);

					}
				}catch(IOException io){
					System.out.println(io);
				}
				
				break;
			}
			
			//for calculating turn around time of all process
			case (3): {
				try{
					int turnAroundTime[] = jobScheduler.getTurnAroundTime(process, numberOfProcess);
					for (int loop = 0; loop < numberOfProcess; loop++) {

						System.out.println("Turn Around Time Of Process " + (loop + 1) + " :-\t" + turnAroundTime[loop]);

					}
				}catch(IOException io){
					System.out.println(io);
				}
				
				break;
			}
			
			//for calculating average waiting time of all process
			case (4): {
				try{
					double averageWaitingTime = jobScheduler.getAverageWaitingTime(process, numberOfProcess);
					System.out.println("Average Waiting Time Of Process is :-\t" + averageWaitingTime);
				}catch(IOException io){
					System.out.println(io);
				}
				
				break;
			}
			
			//for getting maximum waiting time
			case (5): {
				try{
					int maximumWaitingTime = jobScheduler.getMaximumWaitingTime(process, numberOfProcess);
					System.out.println("Maximum Waiting Time Of Process is :-\t" + maximumWaitingTime);
				}catch(IOException io){
					System.out.println(io);
				}
				
				break;
			}
			
			//for sorting process array 
			case (6): {
				try{
					int sortedProcess[][] = jobScheduler.sortProcess(process, numberOfProcess);
					for (int loop = 0; loop < numberOfProcess; loop++) {

						System.out.println("Arrival Time Of Process " + (loop + 1) + " :-\t" + sortedProcess[loop][0]);
						System.out.println("Burst Time Of Process " + (loop + 1) + " :-\t" + sortedProcess[loop][1]);

					}
				}catch(IOException io){
					System.out.println(io);
				}
				
				break;
			}
			default: {
				System.out.println("Invalid Choice!!!");
			}
			}
		}

	}

}