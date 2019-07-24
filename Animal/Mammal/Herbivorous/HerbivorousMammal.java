package Assignment8.Animal.Mammal.Herbivorous;

import Assignment8.Animal.Mammal.Mammal;

/**
 * This class represent Herbivorous Mammals
 * @author Sabir
 *
 */
abstract class HerbivorousMammal extends Mammal {
	
	/**
	 * default constructor set the sub category of the animal to "Herbivorous"
	 */
	protected HerbivorousMammal(){
		super.subCatagory = "Herbivorous";
	}
}
