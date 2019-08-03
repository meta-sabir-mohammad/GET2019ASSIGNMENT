package Assignment3A;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

/**
 * This class represent directory in file system
 * @author Sabir
 */
public class Directory {

	// creation date and time
	final private String dateTime;
	// parent directory
	final private Directory parent;
	// name of directory
	final private String name;
	/*
	 * HashMap<String,Directory> which store details about sub directories key is
	 * the name of sub directory and value is their object
	 */
	private HashMap<String, Directory> subDirectories = new HashMap<String, Directory>();

	/**
	 * Default constructor
	 *//*
	public Directory() {
	}*/

	/**
	 * Parameterized Constructor
	 * @param name name of directory
	 * @param parent object of Directory representing parent directory
	 */
	public Directory(String name, Directory parent) {
		this.name = name;
		this.parent = parent;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		this.dateTime = formatter.format(new Date());
	}

	/**
	 * This method return the date and time when directory is created
	 * @return the dateTime
	 */
	public String getDateTime() {
		return dateTime;
	}

	/**
	 * This method return the object of Directory which contain reference to the parent directory
	 * @return the parent directory reference object
	 */
	public Directory getParent() {
		return parent;
	}

	/**
	 * This method return the name of directory
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method return the Collection containing all sub directories of current directory
	 * @return Collection containing all sub directory of current directory
	 */
	public Collection<Directory> getSubDirectories() {
		return this.subDirectories.values();
	}

	/**
	 * This method add new sub directory to current directory
	 * @param name name of sub directory
	 * @return true if directory is added else false
	 */
	public boolean addSubDirectory(String name) {
		Directory subDirectory = new Directory(name, this);
		this.subDirectories.put(name, subDirectory);
		return true;
	}

	/**
	 * This method change the current directory to given sub directory
	 * @param nameOfSubDirectory name of sub directory
	 * @return object of sub directory
	 * @throws Exception if given sub directory is not available
	 */
	public Directory changeCurrentDirectory(String nameOfSubDirectory) throws Exception {

		for (Directory subDirectory : this.subDirectories.values()) {
			if (subDirectory.getName().equalsIgnoreCase(nameOfSubDirectory)) {
				return subDirectory;
			}
		}
		try {
			throw new Exception("Directory not available");
		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * This method change the current directory to its parent directory
	 * @return object of parent directory
	 * @throws Exception
	 */
	public Directory goBackToParentDirectory() throws Exception {

		try {
			if (this.parent == null) {
				throw new Exception("Directory not available");
			}
			return this.parent;
		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * This method find and return all the sub directory of current directory
	 * @return array of String contain name date and time of creation of all sub directory of current directory
	 */
	public String[] getDetailListOfSubDirectory() {

		int totalDirectories = this.subDirectories.size();
		String[] listOfSubDirectory = new String[totalDirectories + 1];
		int directoryIndex = 0;
		for (Directory directory : this.subDirectories.values()) {
			listOfSubDirectory[directoryIndex] = directory.getDateTime() + " " + directory.getName();
			directoryIndex++;
		}
		listOfSubDirectory[directoryIndex] = totalDirectories + " Folders";
		return listOfSubDirectory;
	}

	/**
	 * This method find and return the path from root to current directory
	 * @return String containing the path form root to current directory
	 */
	public String getDirectoryPath() {

		String directoryPath = "";
		if (this.parent == null) {
			directoryPath = this.getName() + ":>";
			return directoryPath;
		}
		directoryPath = "\\" + this.getName() + ">";
		Directory parentDirectory = this.getParent();
		while (parentDirectory.parent != null) {
			directoryPath = "\\" + parentDirectory.getName() + directoryPath;
			parentDirectory = parentDirectory.parent;
		}
		directoryPath = parentDirectory.getName() + ":" + directoryPath;

		return directoryPath;
	}

	/**
	 * This method find path from current directory to given start directory
	 * @param startDirectory object of directory till path need to find
	 * @return String containing path from current directory to given start directory
	 */
	private String getDirectoryPath(Directory startDirectory) {

		String directoryPath = "";
		if (this.getName().equalsIgnoreCase(startDirectory.getName())) {
			directoryPath = ".\\" + this.getName();
			return directoryPath;
		}
		directoryPath = "\\" + this.getName();
		Directory parentDirectory = this.getParent();
		while (!parentDirectory.getName().equalsIgnoreCase(startDirectory.getName())) {
			directoryPath = "\\" + parentDirectory.getName() + directoryPath;
			parentDirectory = parentDirectory.parent;
		}
		directoryPath = "." + directoryPath;

		return directoryPath;
	}

	/**
	 * This method find given directory in current directory and its sub directories Recursively
	 * @param directoryName name of directory need to be find
	 * @return path of all matched directories form current directory
	 */
	public String[] findDirectory(String directoryName) {

		ArrayList<String> foundDirectoriesPath = new ArrayList<String>();
		foundDirectoriesPath = findDirectoryInSubDirectories(foundDirectoriesPath, this, this, directoryName);
		Object[] objArr = foundDirectoriesPath.toArray();

		// convert Object array to String array
		String[] directoriesPath = Arrays.copyOf(objArr, objArr.length, String[].class);
		return directoriesPath;
	}

	/**
	 * This method find given directory in all sub directory of given current directory
	 * @param foundDirectoriesPath ArrayList containing path of found directories till now
	 * @param startDirectory object of directory till the path need to find
	 * @param currentDirectory object of current directory which sub directories need to be check
	 * @param directoryName name of directory which need to be find
	 * @return path of all found directories from start directory
	 */
	private ArrayList<String> findDirectoryInSubDirectories(ArrayList<String> foundDirectoriesPath,
			Directory startDirectory, Directory currentDirectory, String directoryName) {

		for (Directory directory : currentDirectory.subDirectories.values()) {

			if (directory.getName().equalsIgnoreCase(directoryName)) {
				foundDirectoriesPath.add(directory.getDirectoryPath(startDirectory));
			}
			findDirectoryInSubDirectories(foundDirectoriesPath, startDirectory, directory, directoryName);
		}

		return foundDirectoriesPath;

	}

}
