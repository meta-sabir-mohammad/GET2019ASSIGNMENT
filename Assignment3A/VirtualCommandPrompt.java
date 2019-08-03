package Assignment3A;

import java.util.Scanner;

/**
 * This class is creating virtual command prompt user interface
 * @author Sabir
 */
public class VirtualCommandPrompt {

	/**
	 * This method create user interface and take user input and show output
	 */
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
				for (String dir : currentDirectory.getDetailListOfSubDirectory()) {
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
				Directory directory = currentDirectory;
				while(directory.getParent() != null){
					directory = directory.getParent();
				}
				VirtualCommandPrompt.printDirectoryTree(directory,0,true);
				System.out.println();
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
				if(dirName.equalsIgnoreCase("")){
					System.out.println("Invalid directory name!!!");
					break;
				}
				currentDirectory.addSubDirectory(dirName);
				break;
			}
			// case for "cd" command which change to current directory to given sub
			// directory
			case ("cd"): {
				if(dirName.equals("")){
					System.out.println("Invalid directory name!!!");
					break;
				}
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
				if(foundDirectories.length == 0){
					System.out.println("No directory found!!!");
				}
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
	
	/**
	 * This method print the tree structure of directories
	 * @param startDIrectory current object of root directory
	 * @param dirLevel level of current directory
	 * @param isParentLast boolean is true if parent of current directory is last directory in its parent
	 */
	private static void printDirectoryTree(Directory startDirectory,int dirLevel,boolean isParentLast){

		int totalSubDir = startDirectory.getSubDirectories().size();
		for(Directory directory : startDirectory.getSubDirectories()){
			int directoryLevel = dirLevel;
			if(totalSubDir > 0){
				if(directoryLevel == 0){
					//System.out.print("\n");
					if(totalSubDir >1){
						System.out.print("\u251c\u2500\u2500\u2500\u2500\u2500\u2500\u2500"+directory.getName());
						totalSubDir--;
						VirtualCommandPrompt.printDirectoryTree(directory,dirLevel+1,false);
						System.out.print("\n");
					}else{
						System.out.print("\u2514\u2500\u2500\u2500\u2500\u2500\u2500\u2500"+ directory.getName());
						VirtualCommandPrompt.printDirectoryTree(directory,dirLevel+1,true);
					}
				}else{
					System.out.print("\n");
					if(directoryLevel-1 == 0 ||!isParentLast ){
						System.out.print("\u2502");
					}
					while(directoryLevel != 0){

						if(!isParentLast &&  directoryLevel >0 && directoryLevel <= dirLevel-1){
							System.out.print("\u2502");
						}
						System.out.print("\t");
						directoryLevel--;
					}

					if(totalSubDir >1){
						System.out.print("\u251c\u2500\u2500\u2500\u2500\u2500\u2500\u2500"+directory.getName());
						totalSubDir--;
						VirtualCommandPrompt.printDirectoryTree(directory,dirLevel+1,false);
					}else{
						System.out.print("\u2514\u2500\u2500\u2500\u2500\u2500\u2500\u2500"+ directory.getName());
						VirtualCommandPrompt.printDirectoryTree(directory,dirLevel+1,true);
					}
				}
			}
		}
	}
}
