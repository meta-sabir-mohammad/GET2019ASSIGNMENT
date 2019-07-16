package Assignment3A;

import java.util.Scanner;

/**
 *This Class used as a input class for String Manipulation Class
 *It provide user option and get the result from StringManipulation Class
 *respective methods and print them on console
 *
 */
public class StringManipulationMain {

	public static void main(String[] args) {
		
		StringManipulation stringManipulation = new StringManipulation();
		Scanner userNumInput = new Scanner(System.in);
		Scanner userStringInput = new Scanner(System.in);
		

		//while loop for options
		while (true) {
			System.out.println("1.Compare Two Strings");
			System.out.println("2.Reverse Of A String");
			System.out.println("3.Convert Upper Case To Lower And Vice-Versa");
			System.out.println("4.Get The Largest Word");
			System.out.println("5.Exit");

			//taking input for selecting option
			int option = userNumInput.nextInt();
			
			//while loop closing condition
			if (option == 5) {
				System.out.println("Thank You");
				break;
			}
			
			switch (option) {
			
			//for comparing two strings
			case (1): {
				
				System.out.print("Enter First String :- ");
				String firstString = userStringInput.nextLine();
				System.out.print("Enter Second String :- ");
				String secondString = userStringInput.nextLine();
				
				int compareResult = stringManipulation.compareStrings(firstString, secondString);
				
				if(compareResult == 1){
					System.out.println(firstString+" and "+secondString+" are equal");
				}else{
					System.out.println(firstString+" and "+secondString+" are not equal");
				}
				
				break;
			}
			
			//for getting reverse of a string
			case (2): {
				System.out.print("Enter String :- ");
				String firstString = userStringInput.nextLine();
				String reverseString = stringManipulation.reverseOfString(firstString);
				System.out.println("Reverse of "+firstString+" is "+reverseString);
				
				break;
			}
			
			//converting upper case character to lower case and vice-versa
			case (3): {
				
				System.out.print("Enter String :- ");
				String firstString = userStringInput.nextLine();
				String convertedString = stringManipulation.chracterConversionOfString(firstString);
				System.out.println(firstString+" after conversion "+ convertedString);
				
				break;
			}
			
			//getting longest word in a string
			case (4): {
				System.out.print("Enter String :- ");
				String firstString = userStringInput.nextLine();
				String longestWord = stringManipulation.getLongestWordOfString(firstString);
				System.out.println("Longest word is "+longestWord);
				
				break;
			}
			
			default: {
				System.out.println("Invalid Choice!!!");
			}
			}
		}

	}

}