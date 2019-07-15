package Assignment2A;

import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * This class interact with user
 * provide option to perform operation
 * on hexa decimal number
 *
 */
public class TestHexCalc {

	public static void main(String[] args) {
		
		HexCalc hexaDecimal = new HexCalc();
		String firstOperand;
		String secondOperand;
		
		//for taking user input from keyboard
		Scanner userInput = new Scanner(System.in);
		
		/**
		 * it is used to call static method that will initialize hex table
		 */
		HexCalc.initializeHexTables();
		while(true){
		       System.out.println("Please Select Option...."+"\n1.HexaDecimal Addition"+"\n2.HexaDecimal Subtraction"+"\n3.HexaDecimal Division"+"\n4.HexaDecimal Multiplication");
		       System.out.print("\n5.HexaDecimal Equal Opration"+"\n6.HexaDecimal GreaterThan Operation"+"\n7.HexaDecimal LessThan Operation"+"\n8.HexaDecimal to Decimal"+"\n9.Decimal to HexaDecimal"+"\n10.Exit");
		       System.out.print("\nSelect Option:-");
		
		       //this variable store user choice
		       int option = userInput.nextInt();
		       
		       //this terminate program
		       if(option==10){
		    	   System.out.println("Thank You");
		    	   break;
		       }
		       
		       //for calling respective methods
		       switch(option){
		       case(1):{
		    	   System.out.print("Please Enter First HexaDecimal Number:-");
		    	   firstOperand = userInput.next();
		    	   
		    	   System.out.print("Please Enter Second HexaDecimal Number:-");
		    	   secondOperand = userInput.next();
		    	   
		    	   
		    	   
		    	   try{
		    		   
		    		   /**
			    	    * @addResult store addition of two hexaDecimal numbers
			    	    */
		    		   String addResult = hexaDecimal.addOperation(firstOperand, secondOperand);
		    		   
		    		   /**
			    	    * Printing result of addition
			    	    */
		    		   System.out.println(firstOperand+" + "+secondOperand+" = "+addResult);
		    	   }catch(IOException io){
		    		   System.out.println(io);
		    	   }
		    	   
		    	   
		    	   
		    	   
		    	   break;
		       }
		       case(2):{
		    	   System.out.print("Please Enter First HexaDecimal Number:-");
		    	   firstOperand = userInput.next();
		    	   System.out.print("Please Enter Second HexaDecimal Number:-");
		    	   secondOperand = userInput.next();
		    	   
		    	   try{
		    		   /**
			    	    * @subResult store subtraction of two hexaDecimal numbers
			    	    */
			    	   String subResult = hexaDecimal.subtractOperation(firstOperand, secondOperand);
			    	   
			    	   /**
			    	    * Printing result of subtraction
			    	    */
			    	   System.out.println(firstOperand+" - "+secondOperand+" = "+subResult);
		    	   }catch(IOException io){
		    		   System.out.println(io);
		    	   }
		    	   
		    	   break;
		       }
		       case(3):{
		    	 
		    	   System.out.print("Please Enter First HexaDecimal Number:-");
		    	   firstOperand = userInput.next();
		    	   System.out.print("Please Enter Second HexaDecimal Number:-");
		    	   secondOperand = userInput.next();
		    	   
		    	   
		    	   try{
		    		   /**
			    	    * @divResult store division of two hexaDecimal numbers
			    	    */
			    	   String divResult = hexaDecimal.divisonOperation(firstOperand, secondOperand);
			    	   
			    	   /**
			    	    * Printing result of division
			    	    */
			    	   System.out.println(firstOperand+" / "+secondOperand+" = "+divResult);
		    	   }catch(IOException io){
		    		   System.out.println(io);
		    	   }
		    	  
		    	   break;
		       }
		       case(4):{
		    	   
		    	   System.out.print("Please Enter First HexaDecimal Number:-");
		    	   firstOperand = userInput.next();
		    	   System.out.print("Please Enter Second HexaDecimal Number:-");
		    	   secondOperand = userInput.next();
		    	   
		    	   
		    	   try{
		    		   /**
			    	    * @mulResult store multiplication of two hexaDecimal numbers
			    	    */
			    	   String mulResult = hexaDecimal.multiplicationOperation(firstOperand,secondOperand);
			    	   
			    	   /**
			    	    * Printing result of multiplication
			    	    */
			    	   System.out.println(firstOperand+" * "+secondOperand+" = "+mulResult);
		    	   }catch(IOException io){
		    		   System.out.println(io);
		    	   }
		    	   
		    	   
		    	   break;
		       }
		       case(5):{
		    	   
		    	   System.out.print("Please Enter First HexaDecimal Number:-");
		    	   firstOperand = userInput.next();
		    	   System.out.print("Please Enter Second HexaDecimal Number:-");
		    	   secondOperand = userInput.next();
		    	   
		    	   try{
		    		   /**
			    	    * @eqResult store result of equal operation on two hexaDecimal numbers
			    	    */
			    	   boolean eqResult = hexaDecimal.equalsOperation(firstOperand, secondOperand);
			    	   
			    	   /**
			    	    * Printing result of equal operation
			    	    */
			    	   if(eqResult){
			    		   System.out.println(firstOperand+" == "+secondOperand);
			    	   }else{
			    		   System.out.println(firstOperand+" != "+secondOperand);
			    	   }
		    	   }catch(IOException io){
		    		   System.out.println(io);
		    	   }
		    	   
		    	   
		    	   break;
		       }
		       case(6):{
		    	   
		    	   System.out.print("Please Enter First HexaDecimal Number:-");
		    	   firstOperand = userInput.next();
		    	   System.out.print("Please Enter Second HexaDecimal Number:-");
		    	   secondOperand = userInput.next();
		    	   
		    	   try{
		    		   /**
			    	    * @geResult store result of greater than operation on two hexaDecimal numbers
			    	    */
			    	   boolean geResult = hexaDecimal.greaterThanOperation(firstOperand,secondOperand);
			    	   
			    	   /**
			    	    * Printing result of greater than operation
			    	    */
			    	   if(geResult){
			    		   System.out.println(firstOperand+" is greater than "+secondOperand);
			    	   }else{
			    		   System.out.println(firstOperand+" is not greater than "+secondOperand);
			    	   }
		    	   }catch(IOException io){
		    		   System.out.println(io);
		    	   }
		    	  
		    	   break;
		       }
		       case(7):{
		    	   
		    	   System.out.print("Please Enter First HexaDecimal Number:-");
		    	   firstOperand = userInput.next();
		    	   System.out.print("Please Enter Second HexaDecimal Number:-");
		    	   secondOperand = userInput.next();
		    	   
		    	   try{
		    		   /**
			    	    * @geResult store result of less than operation on two hexaDecimal numbers
			    	    */
			    	   boolean geResult = hexaDecimal.lessThanOperation(firstOperand,secondOperand);
			    	   
			    	   /**
			    	    * Printing result of less than operation
			    	    */
			    	   if(geResult){
			    		   System.out.println(firstOperand+" is less than "+secondOperand);
			    	   }else{
			    		   System.out.println(firstOperand+" is not less than "+secondOperand);
			    	   }
		    	   }catch(IOException io){
		    		   System.out.println(io);
		    	   }
		    	  
		    	   break;
		       }
		       
		       case(8):{
		    	   
		    	   System.out.print("Please Enter HexaDecimal Number:-");
		    	   firstOperand =userInput.next();
		    	   
		    	   try{
		    		   /**
			    	    * @geResult store decimal representation of hexadecimal 
			    	    */
			    	   long geResult = hexaDecimal.hexToDecimal(firstOperand);
			    	   
			    	   /**
			    	    * Printing result of hexadecimal to decimal
			    	    */
			    	   System.out.println(firstOperand+" Decimal Representation is :- "+ geResult);
		    	   }catch(IOException io){
		    		   System.out.println(io);
		    	   }
		    	  
		    	   break;
		       }
		       case(9):{
		    	   
		    	   System.out.print("Please Enter Decimal Number:-");
		    	   String decimal = userInput.next();
		    	   
		    	   try{
		    		   /**
			    	    * @geResult store hexadecimal of decimal representation
			    	    */
			    	   String geResult = hexaDecimal.decimalToHex(decimal);
			    	   
			    	   /**
			    	    * Printing result of decimal to hexadecimal 
			    	    */
			    	   System.out.println(decimal+" Decimal Representation is :- "+ geResult);
		    	   }catch(IOException io){
		    		   System.out.println(io);
		    	   }
		    	   
		    	   break;
		       }
		       default:{
		    	   System.out.println("Invalid Input!!!!");
		       }
		       };
	           
		}
	           

	}
	

}
