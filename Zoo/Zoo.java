package Assignment8.Zoo;

import java.util.HashMap;
import java.util.Map;

import Assignment8.Animal.Animal;

/**
 * This Class represent zoo and contain method related to zoo management system
 * @author Sabir
 *
 */
public class Zoo {

	/*
	 * This HashMap contain details about all the animal added in the zoo
	 * here key is the unique name of the animal and value is the animal object 
	 */
	public static Map<String,Animal> animalInZoo = new HashMap<String,Animal>();
	//contains the number of the zones added to the zoo
	public static int numberOfZones = 0;
	/*
	 * This HashMap contain details about all zones that added to the zoo
	 * here key is the integer key numberOfZones which start with 0 and increases as more zones are added
	 * and value is the zone object
	 * zone can't be removed once created
	 */
	public static Map<Integer,Zone> zonesInZoo = new HashMap<Integer,Zone>();
	//This represent the max cage limit any zone can have
	private static int MAX_CAGE_LIMIT_IN_ZONE =15;
	
	/**
	 *In this static block we area creating some initial zones for the zoo
	 *here every zone has a category and the sub category of animal it contain
	 */
	static{
		//creating a new zone object and passing as a parameter to static addZone method
		Zoo.addZone(new Zone(numberOfZones,MAX_CAGE_LIMIT_IN_ZONE,"Mammal","Carnivorous",true,true));
		Zoo.addZone(new Zone(numberOfZones,MAX_CAGE_LIMIT_IN_ZONE,"Mammal","Herbivorous",true,true));
		Zoo.addZone(new Zone(numberOfZones,MAX_CAGE_LIMIT_IN_ZONE,"Mammal","Omnivorous",true,true));
		Zoo.addZone(new Zone(numberOfZones,MAX_CAGE_LIMIT_IN_ZONE,"Reptile","Carnivorous",true,true));
		Zoo.addZone(new Zone(numberOfZones,MAX_CAGE_LIMIT_IN_ZONE,"Bird","Carnivorous",true,true));
		Zoo.addZone(new Zone(numberOfZones,MAX_CAGE_LIMIT_IN_ZONE,"Bird","Herbivorous",true,true));
		Zoo.addZone(new Zone(numberOfZones,MAX_CAGE_LIMIT_IN_ZONE,"Bird","Omnivorous",true,true));
		Zoo.addZone(new Zone(numberOfZones,MAX_CAGE_LIMIT_IN_ZONE,"Aqua","Carnivorous",true,true));
		Zoo.addZone(new Zone(numberOfZones,MAX_CAGE_LIMIT_IN_ZONE,"Aqua","Herbivorous",true,true));
		Zoo.addZone(new Zone(numberOfZones,MAX_CAGE_LIMIT_IN_ZONE,"Aqua","Omnivorous",true,true));
	}
	
	/**
	 * This static addZone method add new zone in the zoo
	 * @param zone object of the Zone Class containing details about the zone that will be created
	 * @return true if zone created successfully else return false
	 */
	public static boolean addZone(Zone zone){
		Zoo.zonesInZoo.put(zone.zoneId, zone);
		Zoo.numberOfZones++;
		return true;
	}
	
	/**
	 * This method find suitable zone for the animal according to animal category and sub category
	 * @param animal object of animal containing details about animal
	 * @return object of Zone Class containing suitable zone for the given animal 
	 * @throws Exception if no suitable zone found for the type of the animal
	 */
	private static Zone findSupportedZoneForAnimal(Animal animal) throws Exception{
	
		//checking every zone that is available in the zoo 
		for(Zone zone : Zoo.zonesInZoo.values()){
			if(zone.categoryOfAnimalSupported.equalsIgnoreCase(animal.category) && zone.subcatagoryOfAnimalSupported.equalsIgnoreCase(animal.subCatagory)){
				return zone;
			}
		}
		//if no suitable zone found
		throw new Exception("Supported zone not found for given animal!!!");
	}
	
	/**
	 * This method find the suitable zone where given cage can be placed according to the type of animal cage support
	 * @param cage object of the Cage class containing details about the cage and type of the animal it support
	 * @return object of the Zone Class containing suitable zone where given cage can be placed
	 * @throws Exception if not suitable zone found for the given cage
	 */
	private static Zone findSupportedZoneForCage(Cage cage) throws Exception{
		
		for(Zone zone : Zoo.zonesInZoo.values()){
			if(zone.categoryOfAnimalSupported.equalsIgnoreCase(cage.categoryOfAnimalSupported) && zone.subcatagoryOfAnimalSupported.equalsIgnoreCase(cage.subCategoryOfAnimalSupported)){
				return zone;
			}
		}
		throw new Exception("Supported zone not found for given cage!!!");
	}
	
	/**
	 * This method is adding new animal to the zoo
	 * @param animal object of animal representing any animal and contain its details
	 * @return true if the animal added successfully else false
	 * @throws Exception if animal is not added
	 */
	public static boolean addAnimal(Animal animal) throws Exception{
		
		//checking if same name animal already present in zoo
		if(Zoo.animalInZoo.containsKey(animal.uniqueName)){
			throw new Exception("Same name animal already present in zoo!!!");
		}
		//searching for the suitable zone for the given animal
		Zone supportedZone = Zoo.findSupportedZoneForAnimal(animal);
		boolean animalPlaced = supportedZone.addAnimal(animal);
		if(animalPlaced){ return true; }
		
		return false;
	}
	
	/**
	 * This method is used to add new cage in the zoo
	 * @param cage object of the Cage Class containing details about the cage that need to be added
	 * @return true if cage added successfully else false
	 * @throws Exception if cage is not added
	 */
	public static boolean addCage(Cage cage) throws Exception{
		
		//searching for the suitable zone for the given cage
		Zone zone = Zoo.findSupportedZoneForCage(cage);
		boolean cagePlaced = zone.addCage(cage);
		if(cagePlaced){ return true; }
		
		return false;
	}
	
	/**
	 * This method is used to remove any animal from the zoo
	 * @param animal object of the animal class containing details about the animal that needed to be removed
	 * @return true if the animal removed successfully else false
	 * @throws Exception if the animal can't be removed
	 */
	public static boolean removeAnimal(Animal animal) throws Exception{
		//checking if animal present in the zoo
		boolean isAnimalPresentInZoo = false;
		for(Animal animalInZoo : Zoo.animalInZoo.values()){
			if(animalInZoo.uniqueName.equalsIgnoreCase(animal.uniqueName)){
				isAnimalPresentInZoo = true;
			}
			if(isAnimalPresentInZoo){
				//finding zone of the animal
				Zone zone = Zoo.findSupportedZoneForAnimal(animal);
				Cage cage = zone.findCageOfAnimal(animal);
				boolean animalRemoved = cage.removeAnimalFromCage(animal) ;
				Zoo.animalInZoo.remove(animal.uniqueName);
				return animalRemoved;
			}
		}
		return false;
	}
}

