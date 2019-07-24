package Assignment8.Zoo.Test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import Assignment8.Animal.Animal;
import Assignment8.Animal.Mammal.Carnivorous.Tiger;
import Assignment8.Zoo.Cage;
import Assignment8.Zoo.Zoo;

/**
 * This test class test negative test cases on removeAnimal method of Zoo Class
 * @author Sabir
 *
 */
public class RemoveAnimalMethodNegativeCasesTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Cage cage1 = new Cage(1,3,"Mammal","Carnivorous");
		Zoo.addCage(cage1);
	}

	@Test
	public void testRemoveAnimal()throws Exception{
		
		Animal animal2 =new Tiger("alphaTiger",10,150);
		assertFalse(Zoo.removeAnimal(animal2));
	}
}
