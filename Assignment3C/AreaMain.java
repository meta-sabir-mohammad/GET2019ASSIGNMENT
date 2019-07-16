package Assignment3C;

import java.util.Scanner;

/**
 * 
 * AreaMain Class used to perform test on Area Class
 * It interact with user and take input and get the result 
 * from Area Class and print to console
 *
 */
public class AreaMain {

	public static void main(String[] args) {
		
		Area area = new Area();
		Scanner userInput = new Scanner(System.in);
		
		while(true){
			
			System.out.println("1. Get Area Of Right Angle Triangle");
			System.out.println("2. Get Area Of Rectangle");
			System.out.println("3. Get Area Of Square");
			System.out.println("4. Get Area Of Circle");
			System.out.println("5. Exit");
			System.out.print("Please Select Opion : ");
			int option = userInput.nextInt();
			
			//loop termination logic
			if(option == 5){
				System.out.println("Thank You");
				break;
			}
			
			//switch case for option selection
			switch(option){
			
			//for getting area of Right Angle Triangle
			case(1):{
				try{
					System.out.print("Enter Height Of Right Angle Triangle : ");
					double heightOfRightAngleTriangle = userInput.nextDouble();
					System.out.print("Enter Width Of Right Angle Triangle : ");
					double widthOfRightAngleTriangle = userInput.nextDouble();
					
					double areaOfRightAngleTriangle = area.getAreaOfTriangle(heightOfRightAngleTriangle, widthOfRightAngleTriangle);
					System.out.println("Area Of Right Angle Triangle is : "+areaOfRightAngleTriangle);
					
				}catch(Exception e){
					System.out.println(e);
				}
				
				break;
			}
			
			//for getting area of Rectangle
			case(2):{
				try{
					System.out.print("Enter Height Of Rectangle : ");
					double heightOfRectangle = userInput.nextDouble();
					System.out.print("Enter Width Of Rectangle : ");
					double widthOfRectangle = userInput.nextDouble();
					
					double areaOfRectangle = area.getAreaOfRectangle(heightOfRectangle, widthOfRectangle);
					System.out.println("Area Of Rectangle is : "+areaOfRectangle);
					
				}catch(Exception e){
					System.out.println(e);
				}
				
				break;
			}
			
			//for getting area of Square
			case(3):{
				try{
					
					System.out.print("Enter Width Of Square : ");
					double widthOfSquare = userInput.nextDouble();
					
					double areaOfSquare = area.getAreaOfSquare(widthOfSquare);
					System.out.println("Area Of Square is : "+areaOfSquare);
					
				}catch(Exception e){
					System.out.println(e);
				}
				
				break;
			}
			
			//fir getting area of Circle
			case(4):{
				try{
					System.out.print("Enter Radius Of Circle : ");
					double radiusOfCircle = userInput.nextDouble();
					
					double areaOfCircle = area.getAreaOfCircle(radiusOfCircle);
					System.out.println("Area Of Circle is : "+areaOfCircle);
					
				}catch(Exception e){
					System.out.println(e);
				}
				
				break;
			}
			default:{
				System.out.println("Invalid Option!!!");
			}
			}
		}

	}

}
