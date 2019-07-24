package Assignment8.Zoo;

import java.util.HashMap;
import java.util.Map;

import Assignment8.Animal.Animal;

/**
 * This class represent cage in the zoo
 * @author Sabir
 *
 */
public class Cage {

	//integer value unique to every cage in a zone
	public int cageId;
	//total animal capacity of the cage
	public int capacityOfCage;
	//category of the animal supported by cage ex Mammal
	public String categoryOfAnimalSupported;
	//sub category of the animal supported by cage ex Carnivorous
	public String subCategoryOfAnimalSupported;
	//total animal in the cage currently 
	public int TotalAnimalInCage;
	/*
	 * This HashMap store details about the animals stored in the cage
	 * key is the unique name of the animal and value is the animal object
	 */
	public Map<String,Animal> animalList = new HashMap<String,Animal>();
	
	/**
	 * parameterized constructor used to create object of Cage
	 * @param cageId unique integer id for cage in zone
	 * @param capacityOfCage capacity of the cage to contain animal
	 * @param catagoryOfAnimalSupported category of the animal supported by cage
	 * @param subCatagoryOfAnimalSupported sub category of the animal supported by cage
	 */
	public Cage(int cageId,int capacityOfCage,String catagoryOfAnimalSupported,String subCatagoryOfAnimalSupported){
		this.cageId = cageId;
		this.capacityOfCage = capacityOfCage;
		this.categoryOfAnimalSupported = catagoryOfAnimalSupported;
		this.subCategoryOfAnimalSupported = subCatagoryOfAnimalSupported;
	}
	
	/**
	 * This method is use to add animal to the cage
	 * @param animal object of the animal class contain details about the animal
	 * @return true if the animal is added else false
	 * @throws Exception if different species animal already present in the cage 
	 */
	public boolean addAnimalInCage(Animal animal) throws Exception{
		
		for(Animal animalInCage : this.animalList.values()){
			if(!animalInCage.species.equalsIgnoreCase(animal.species)){
				throw new Exception("Can't add different species animal in one cage!!!");
			}
		}
		this.animalList.put(animal.uniqueName, animal);
		Zoo.animalInZoo.put(animal.uniqueName, animal);
		this.TotalAnimalInCage++;
		return true;
	}
	
	/**
	 * This method is used to remove given animal from cage
	 * @param animal object of animal class contain details of the animal to be removed
	 * @return true if animal is removed else false
	 */
	public boolean removeAnimalFromCage(Animal animal){
		this.animalList.remove(animal.uniqueName);
		this.TotalAnimalInCage--;
		return true;
	}
}
