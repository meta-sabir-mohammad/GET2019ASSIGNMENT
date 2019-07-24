package Assignment8.Zoo.Test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import Assignment8.Animal.Animal;
import Assignment8.Animal.Mammal.Carnivorous.Lion;
import Assignment8.Zoo.Cage;
import Assignment8.Zoo.Zoo;

/**
 * This test class test negative test cases on addAnimal method of Zoo Class
 * @author Sabir
 *
 */
public class AddAnimalMethodNegativeCasesTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Cage cage1 = new Cage(1,3,"Mammal","Carnivorous");
		Zoo.addCage(cage1);
	}

	@Test(expected = Exception.class)
	public void testAddAnimal() throws Exception{
		
		Animal animal1 =new Lion("alphaLion",10,150);
		assertTrue(Zoo.addAnimal(animal1));
		
		Animal animal2 =new Lion("alphaLion",10,150);
		assertFalse(Zoo.addAnimal(animal2));
		
	}

}
