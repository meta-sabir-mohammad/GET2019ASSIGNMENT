package Assignment8.Animal.Aqua.Carnivorous;

import Assignment8.Animal.Aqua.Aqua;

/**
 * This class represent animal which are Carnivorous and lives in water
 * @author Sabir
 *
 */
public abstract class CarnivorousAqua extends Aqua {

	/**
	 * This default constructor set the sub category of the animal to "Carnivorous"
	 */
	protected CarnivorousAqua(){
		super.subCatagory = "Carnivorous";
	}
}
