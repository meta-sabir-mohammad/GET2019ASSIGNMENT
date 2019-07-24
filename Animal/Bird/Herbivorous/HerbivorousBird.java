package Assignment8.Animal.Bird.Herbivorous;

import Assignment8.Animal.Bird.Bird;

/**
 * This class represent Herbivorous Birds
 * @author Sabir
 *
 */
public abstract class HerbivorousBird extends Bird {

	/**
	 * default constructor set the sub category of the animal to "Herbivorous"
	 */
	protected HerbivorousBird(){
		super.subCatagory = "Herbivorous";
	}

}
