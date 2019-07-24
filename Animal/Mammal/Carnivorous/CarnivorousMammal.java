package Assignment8.Animal.Mammal.Carnivorous;

import Assignment8.Animal.Mammal.Mammal;

/**
 * This class represent Carnivorous Mammals
 * @author Sabir
 *
 */
abstract class CarnivorousMammal extends Mammal {

	/**
	 * default constructor set the sub category of the animal to "Carnivorous"
	 */
	protected CarnivorousMammal(){
		super.subCatagory = "Carnivorous";
	}
}
