package Assignment8.Animal.Bird.Carnivorous;

import Assignment8.Animal.Bird.Bird;

/**
 * This class represent Carnivorous Birds
 * @author Sabir
 *
 */
public abstract class CarnivorousBird extends Bird {

	/**
	 * default constructor set the sub category of the animal to "Carnivorous"
	 */
	protected CarnivorousBird(){
		super.subCatagory = "Carnivorous";
	}

}
