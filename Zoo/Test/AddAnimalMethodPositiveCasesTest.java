package Assignment8.Zoo.Test;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import Assignment8.Animal.Animal;
import Assignment8.Animal.Aqua.Carnivorous.Shark;
import Assignment8.Animal.Aqua.Herbivorous.SurgeonFish;
import Assignment8.Animal.Aqua.Omnivorous.AngelFish;
import Assignment8.Animal.Bird.Carnivorous.Eagle;
import Assignment8.Animal.Bird.Herbivorous.Duck;
import Assignment8.Animal.Bird.Omnivorous.Peacock;
import Assignment8.Animal.Mammal.Carnivorous.Lion;
import Assignment8.Animal.Mammal.Herbivorous.Deer;
import Assignment8.Animal.Mammal.Herbivorous.Elephant;
import Assignment8.Animal.Mammal.Omnivorous.Bear;
import Assignment8.Animal.Reptile.Carnivorous.Crocodile;
import Assignment8.Zoo.Cage;
import Assignment8.Zoo.Zoo;

/**
 * This test class test positive test cases on addAnimal method of Zoo Class
 * @author Sabir
 *
 */
public class AddAnimalMethodPositiveCasesTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Cage cage1 = new Cage(1,3,"Mammal","Carnivorous");
		Cage cage2 = new Cage(2,3,"Mammal","Herbivorous");
		Cage cage3 = new Cage(3,3,"Mammal","Omnivorous");
		Cage cage4 = new Cage(4,3,"Bird","Carnivorous");
		Cage cage5 = new Cage(5,3,"Bird","Herbivorous");
		Cage cage6 = new Cage(6,3,"Bird","Omnivorous");
		Cage cage7 = new Cage(7,3,"Reptile","Carnivorous");
		Cage cage8 = new Cage(8,3,"Aqua","Carnivorous");
		Cage cage9 = new Cage(9,3,"Aqua","Herbivorous");
		Cage cage10 = new Cage(10,3,"Aqua","Omnivorous");
		Cage cage11 = new Cage(11,3,"Mammal","Herbivorous");
		
		Zoo.addCage(cage1);
		Zoo.addCage(cage2);
		Zoo.addCage(cage3);
		Zoo.addCage(cage4);
		Zoo.addCage(cage5);
		Zoo.addCage(cage6);
		Zoo.addCage(cage7);
		Zoo.addCage(cage8);
		Zoo.addCage(cage9);
		Zoo.addCage(cage10);
		Zoo.addCage(cage11);
	}
	

	@Test
	public void testAddAnimal() {
		try{
			Animal animal1 =new Lion("alphaLion",10,150);
			assertTrue(Zoo.addAnimal(animal1));
			
			Animal animal2 =new Lion("betaLion",9,150);
			assertTrue(Zoo.addAnimal(animal2));
			
			Animal animal3 =new Deer("alphaDeer",5,70);
			assertTrue(Zoo.addAnimal(animal3));
			
			Animal animal4 =new Elephant("aplhaElephant",25,300);
			assertTrue(Zoo.addAnimal(animal4));
			
			Animal animal5 =new Bear("alphaBear",10,150);
			assertTrue(Zoo.addAnimal(animal5));
			
			Animal animal6 =new Crocodile("alphaCrocodile",15, 120);
			assertTrue(Zoo.addAnimal(animal6));
			
			Animal animal7 =new Eagle("alphaEagle",2,3);
			assertTrue(Zoo.addAnimal(animal7));
			
			Animal animal8 =new AngelFish("alphaAngelFish",.5,.5);
			assertTrue(Zoo.addAnimal(animal8));
			
			Animal animal9 =new Shark("alphaShark",5,150);
			assertTrue(Zoo.addAnimal(animal9));
			
			Animal animal10 = new Duck("alphaDuck",1,1.5);
			assertTrue(Zoo.addAnimal(animal10));
			
			Animal animal11 = new Peacock("aplhaPeacock",2,3);
			assertTrue(Zoo.addAnimal(animal11));
			
			Animal animal12 = new SurgeonFish("alphaSurgeonFish",1,.5);
			assertTrue(Zoo.addAnimal(animal12));
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
