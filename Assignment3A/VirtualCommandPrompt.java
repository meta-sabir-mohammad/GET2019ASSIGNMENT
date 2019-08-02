package Assignment3A;

import java.util.Scanner;

/**
 * This class is creating virtual command prompt user interface
 * 
 * @author Sabir
 *
 */
public class VirtualCommandPrompt {

	public static void main(String[] args) {

		// creating root directory at start
		Directory currentDirectory = new Directory("Root", null);
		// creating scanner object to take user input from console
		Scanner userInput = new Scanner(System.in);
		// creating a boolean to exit from program on user demand
		boolean exit = false;
		System.out.println("::::::::: Welcome to Metacube Virtual Command Prompt :::::::::");
		// starting the loop
		while (!exit) {
			// printing current directory path
			System.out.print(currentDirectory.getDirectoryPath());
			// System.out.print("\u2514 \u251c \u2500 \u2502");
			String dirName = "";
			// taking command from console
			String command = userInput.nextLine();

			// extracting commands
			String commands[] = command.split(" ");
			if (commands.length > 2) {

			} else if (commands.length == 1) {
				// if command does not have additional details
				command = commands[0];
			} else {
				// if command has directory name
				dirName = commands[1];
				command = commands[0];
			}

			// switch case for performing right action according to command
			switch (command) {
			// case for "ls" command which give details about all single level sub directory
			// of current directory
			case ("ls"): {
				for (String dir : currentDirectory.getListOfSubDirectory()) {
					System.out.println(dir);
				}
				break;
			}
			// case for "exit" command which close the program
			case ("exit"): {
				exit = true;
				System.out.println("Thank You");
				break;
			}
			// case for "tree" command which prints tree structure of all directories
			case ("tree"): {
				break;
			}
			// case for "bk" command which goes back to parent directory of current
			// directory
			case ("bk"): {
				try {
					currentDirectory = currentDirectory.goBackToParentDirectory();
				} catch (Exception e) {
					System.out.println("You are on root directory!!!");
				}
				break;
			}
			// case for "mkdir" command which create new directory in current directory
			case ("mkdir"): {
				currentDirectory.addSubDirectory(dirName);
				break;
			}
			// case for "cd" command which change to current directory to given sub
			// directory
			case ("cd"): {
				try {
					currentDirectory = currentDirectory.changeCurrentDirectory(dirName);
				} catch (Exception e) {
					System.out.println("Directory not available!!!");
				}
				break;
			}
			// case for "find" command which find all same name directories in sub
			// directories of current directory recursively
			case ("find"): {
				String foundDirectories[] = currentDirectory.findDirectory(dirName);
				for (String path : foundDirectories) {
					System.out.println(path);
				}
				break;
			}
			// if wrong command is enter
			default: {
				System.out.println("Invalid Command!!!");
			}
			}
		}

	}

}
