package Assignment4C;

import java.util.ArrayList;

/**
 * This class calculate mass of organic compounds containing C , H and O
 * @author Sabir
 */
public class MassCalculator {
	private String[] formulaArray;
	private ArrayList<String> formulaList;
	private int MASS_OF_CARBON=12;
	private int MASS_OF_HYDROGEN=1;
	private int MASS_OF_OXYGEN=16;
	
	/**
	 * This method calculate and returns the mass of Compound given
	 * @param formula String containing formula
	 * @return total mass of compound
	 * @throws Exception for unclosed Parenthesis
	 */
	public int calculateMass(String formula) throws Exception {
		
		this.formulaArray=formula.split("");
		this.formulaList=new ArrayList<String>();
		elementCombiner();
		int massOfFormula=0;
		for(int indexFirst=0;indexFirst<this.formulaList.size();indexFirst++){
			String element=this.formulaList.get(indexFirst);
			if(element.charAt(0)=='C'){
				 massOfFormula+=Integer.parseInt(element.substring(1))*MASS_OF_CARBON;
			}
			if(element.charAt(0)=='H'){
				 massOfFormula+=Integer.parseInt(element.substring(1))*MASS_OF_HYDROGEN;
			}
			if(element.charAt(0)=='O'){
				 massOfFormula+=Integer.parseInt(element.substring(1))*MASS_OF_OXYGEN;
			}			
		}
		return massOfFormula;
	}
	/**
	 * This method adds individual organic element to List with there coefficients from given formula
	 * @throws Exception for unclosed Parenthesis in the formula
	 */
	private void elementCombiner() throws Exception{
		
		for(int indexFirst=0;indexFirst<this.formulaArray.length;indexFirst++) {
			if(this.formulaArray[indexFirst].equals("C") || this.formulaArray[indexFirst].equals("H") || this.formulaArray[indexFirst].equals("O")) {
				this.formulaList.add(getElementWithItsCoefficient(indexFirst));
			}
			else{
				if(this.formulaArray[indexFirst].equals("(")){
					try{
						int indexOfClosingBracket=getIndexOfClosingBracket(indexFirst);
					}catch(Exception e){
						throw e;
					}
					
					String coefficient=getNumericCoefficient(indexOfClosingBracket+1);
					indexFirst++;
					while(indexFirst!=indexOfClosingBracket){
						if(this.formulaArray[indexFirst].equals("C") || this.formulaArray[indexFirst].equals("H") || this.formulaArray[indexFirst].equals("O")) {
							String element=getElementWithItsCoefficient(indexFirst);
							this.formulaList.add(element.substring(0,1)+(Integer.toString((Integer.parseInt(element.substring(1)))*(Integer.parseInt(coefficient)))));
						}
						indexFirst++;
					}
				}	
			}
		}
	}
	/**
	 * This element find the organic element with its Coefficient
	 * @param int type starting Index
	 * @return String type element followed by its coefficient 
	 */
	private String getElementWithItsCoefficient(int indexFirst){
		
		String returnValue="";
		if(indexFirst+1 == this.formulaArray.length || (!(this.formulaArray[indexFirst+1].charAt(0)>='0' && this.formulaArray[indexFirst+1].charAt(0)<='9'))) {
			returnValue= (this.formulaArray[indexFirst]+"1");
		}
		else if((this.formulaArray[indexFirst+1].charAt(0)>='0' && this.formulaArray[indexFirst+1].charAt(0)<='9')){
			String element=this.formulaArray[indexFirst];
			indexFirst++;
			element+=getNumericCoefficient(indexFirst);
			returnValue=(element);
		}
		return returnValue;
	}
	/**
	 * This method returns numeric coefficient of element
	 * @param int type starting index
	 * @return String type numeric coefficient
	 */
	private String getNumericCoefficient(int index){
		
		String coefficient="";
		while(index!=this.formulaArray.length){
			if(!(this.formulaArray[index].charAt(0)>='0' && this.formulaArray[index].charAt(0)<='9')){ break; }
			else{
				coefficient+=this.formulaArray[index];
				index++;
			}
		}
		return coefficient;
	}
	
	/**
	 * This method returns index of closing bracket
	 * @param indexFirst int type starting Index
	 * @return int type index of closing bracket
	 * @throws Exception if closing bracket is not found
	 */
	private int getIndexOfClosingBracket(int indexFirst) throws Exception{
		
		try{
			for(int index=indexFirst;index<this.formulaArray.length;index++){
				if(this.formulaArray[index].equals(")")){ return index; }
			}
			throw new Exception(" ')' bracket Missing");
		}catch(Exception e){
			throw e;
		}
		
	}
}
