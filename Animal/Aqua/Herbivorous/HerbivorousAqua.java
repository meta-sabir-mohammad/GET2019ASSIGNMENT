package Assignment8.Animal.Aqua.Herbivorous;

import Assignment8.Animal.Aqua.Aqua;

/**
* This class represent animal which are Herbivorous and lives in water
* @author Sabir
*
*/
public abstract class HerbivorousAqua extends Aqua {

	/**
	 * This default constructor set the sub category of the animal to "Herbivorous"
	 */
	protected HerbivorousAqua(){
		super.subCatagory = "Herbivorous";
	}

}
