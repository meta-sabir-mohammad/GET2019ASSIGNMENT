package Assignment8.Animal.Mammal.Omnivorous;

import Assignment8.Animal.Mammal.Mammal;

/**
* This class represent Omnivorous Mammals
* @author Sabir
*
*/
public abstract class OmnivorousMammal extends Mammal {

	/**
	 * default constructor set the sub category of the animal to "Omnivorous"
	 */
	protected OmnivorousMammal(){
		super.subCatagory = "Omnivorous";
	}

}