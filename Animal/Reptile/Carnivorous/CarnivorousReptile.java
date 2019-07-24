package Assignment8.Animal.Reptile.Carnivorous;

import Assignment8.Animal.Reptile.Reptile;

/**
 * This class represent Carnivorous Reptiles
 * @author Sabir
 *
 */
public abstract class CarnivorousReptile extends Reptile {

	/**
	 * default constructor set the sub category of the animal to "Carnivorous"
	 */
	protected CarnivorousReptile(){
		super.subCatagory = "Carnivorous";
	}

}
