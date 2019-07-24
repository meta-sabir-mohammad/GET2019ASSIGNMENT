package Assignment8.Zoo;

import java.util.HashMap;
import java.util.Map;

import Assignment8.Animal.Animal;

/**
 * This Class represent zone in the zoo
 * @author Sabir
 *
 */
public class Zone {
	
	//unique integer value for zone
	public int zoneId;
	//total cages that the zone can have
	public int totalCagesCapacity;
	//total cages added to zone currently 
	public int numberOfCagesPlaced;
	//category of the animal supported by zone
	public String categoryOfAnimalSupported;
	//sub category of the animal supported by zone
	public String subcatagoryOfAnimalSupported;
	/*
	 * HashMap contains all the cages that added to zone
	 * here key the integer numberOfCagesPlaced that at start is 0 and increases after each cage placed
	 * value is the object of Cage Class containing all details of the cage
	 */
	private Map<Integer,Cage> cageList = new HashMap<Integer,Cage>();
	//true if zone has a Canteen
	public boolean hasCanteen;
	//true if zone has a Park
	public boolean hasPark;
	
	/**
	 * parameterized constructor creating object of the Zone with given parameters
	 * @param zoneId integer value must be unique for all zones
	 * @param totalCagesCapacity integer value total number of cages zone can have
	 * @param catagoryOfAnimalSupported String value category of animal supported by zone
	 * @param subcatagoryOfAnimalSupported String value sub category  of animal supported by the zone
	 * @param hasCanteen boolean value true if zone has a canteen
	 * @param hasPark boolean value true if zone has a park
	 */
	public Zone(int zoneId,int totalCagesCapacity,String catagoryOfAnimalSupported,String subcatagoryOfAnimalSupported,boolean hasCanteen,boolean hasPark){
		this.zoneId = zoneId;
		this.totalCagesCapacity = totalCagesCapacity;
		this.categoryOfAnimalSupported = catagoryOfAnimalSupported;
		this.subcatagoryOfAnimalSupported = subcatagoryOfAnimalSupported;
		this.hasCanteen = hasCanteen;
		this.hasPark = hasPark;
	}
	
	/**
	 * This method add new cage to the zone
	 * @param cage object of the Cage Class contain details about the cage
	 * @return true if cage is added successfully else false
	 * @throws Exception if cage is not added because zone cage capacity is full
	 */
	public boolean addCage(Cage cage) throws Exception{
		//checking if zone cages capacity is full
		if(this.totalCagesCapacity == this.numberOfCagesPlaced){
			throw new Exception("Can't place new cage zone capacity is full");
		}
		this.cageList.put(cage.cageId, cage);
		this.numberOfCagesPlaced++;
		return true;
	}
	
	/**
	 * This method add animal to zone
	 * @param animal object of the Animal Class contain details about the animal 
	 * @return true if the animal added successfully else false
	 * @throws Exception if animal is not supported in this zone or cage is not available in zone
	 */
	public boolean addAnimal(Animal animal) throws Exception{
		//checking if animal is supported in the zone
		if(!animal.category.equalsIgnoreCase(this.categoryOfAnimalSupported)){
			throw new Exception("Animal is not Supported in this zone!!!");
		}
		//checking if supported cage has space
		boolean cageIsSupported = false;
		boolean animalIsPlaced = false;
		for(Cage cage :this.cageList.values()){
			
			boolean animalCanBePlaced = true;
			if(cage.subCategoryOfAnimalSupported.equalsIgnoreCase(animal.subCatagory)){
				cageIsSupported = true;
			}
			if(cageIsSupported && cage.capacityOfCage != cage.TotalAnimalInCage){
				for(Animal animalInCage : cage.animalList.values()){
					if(!animalInCage.species.equalsIgnoreCase(animal.species)){
						animalCanBePlaced = false;
						cageIsSupported = false;
						break;
					}else{
						animalCanBePlaced = true;
					}
				}
				if(animalCanBePlaced){
					cage.addAnimalInCage(animal);
					animalIsPlaced = true;
					return true;
				}
			}
		}
		if(!cageIsSupported){
			throw new Exception("Supported cage is not available in this zone!!!");
		}
		if(!animalIsPlaced){
			throw new Exception("Can't add animal no space available add new cage!!!");
		}
		return false;
	}
	
	/**
	 * This method cage of animal already present in the zoo
	 * @param animal object of the Animal Class contain details about the animal
	 * @return object of the Cage Class contain details of the cage of the animal
	 * @throws Exception if cage is not found
	 */
	public Cage findCageOfAnimal(Animal animal) throws Exception{
		
		for(Cage cage : this.cageList.values()){
			for(Animal animalInCage : cage.animalList.values()){
				if(animalInCage.uniqueName.equalsIgnoreCase(animal.uniqueName)){
					return cage;
				}
			}
		}
		throw new Exception("Cage not found!!!");
	}
	
}
