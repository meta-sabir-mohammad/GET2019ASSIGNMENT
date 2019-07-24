package Assignment8.Animal;

/**
 * This abstract class represent animal
 * @author Sabir
 *
 */
abstract public class Animal {
	
	//This represent category of animal ex. Mammal,Reptile,Bird,Aqua
	public String category;
	//This represent sub category of animal ex. Carnivorous,Herbivorous,Omnivorous
	public String subCatagory;
	//this represent the species of the animal ex. Lion,Tiger,Deer,Elephant
	public String species;
	//this represent the unique name that every animal have in the zoo 
	public String uniqueName;
	//this represent the age of the animal in years
	protected double age;
	//this represent the weight of the animal in kg
	protected double weight;
	
	/**
	 * This method return the sound of the animal as a String ex for Lion "Roars"
	 * @return
	 */
	abstract public  String getSound();
}
