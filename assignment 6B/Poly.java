package Assignment6B;

import java.io.IOException;

/*
 * Immutable class for Polynomial Operations
 */	
final class Poly {
	private final int[] polynomial;
	
	/* Parameterised Constructor of class
	 * @param int array of Polynomial
	 * @throws IOException if the poly array is null
	 */
	Poly(int[] poly)throws IOException	{
		
		//inputValidation
		if(poly.length==0){
			throw new IOException("Null Polynomial Not Allowed");
		}
		this.polynomial=poly;
	}
	
	/*
	 * getter method for getting int array from polynomial
	 * @return int array of polynomials
	 * @throws IOException if the polynomial is null
	 */
	public int[] getPolynomial() throws IOException {
		
		Poly poly=new Poly(polynomial);
		return poly.polynomial;
	}
	
	/*
	 * This method evaluate polynomial equation
	 * @param float value of which evaluation is to be done
	 * @return float type solution
	 */
	public float evaluate(float value) {
		
		float solution=0.0f;
		for(int indexValue=polynomial.length-1;indexValue>=0;indexValue--) {
			solution+=(polynomial[indexValue]*Math.pow(value,indexValue));
		}
		return solution;
	}
	
	/*
	 * This method return degree of polynomial
	 * @return int value of degree
	 */
	public int degree() {
		return (polynomial.length-1);
	}
	
	/*
	 * This method add two polynomial
	 * @param Object of Poly Class of First Value
	 * @param Object of Poly Class of Second Value
	 * @return Poly of sum of polynomials
	 * throws IOException if array of polynomial is null
	 */
	public Poly addPoly(Poly p1, Poly p2) throws IOException {
		
		if(p2.polynomial.length>p1.polynomial.length){
			Poly p3=p1;
			p1=p2;
			p2=p3;
		}
		int result[]=new int[Math.max(p1.polynomial.length,p2.polynomial.length)];
		int counter=0;
		for(int indexFirst=0;indexFirst<p1.polynomial.length;indexFirst++){
			if(p2.polynomial.length>indexFirst){
				result[counter]=p1.polynomial[indexFirst]+p2.polynomial[indexFirst];
			}
			else{
				result[counter]=p1.polynomial[indexFirst];
			}
			counter++;
		}
		return new Poly(result);
	}
	
	/*
	 * This method multiply two polinomial
	 * @param Object of Poly Class of First Value
	 * @param Object of Poly Class of Second Value
	 * @return Poly of product of polynomials
	 * throws IOException if array of polynomial is null
	 */
	public Poly multiplyPoly(Poly p1, Poly p2)throws IOException {
		
		if(p2.polynomial.length>p1.polynomial.length){
			Poly p3=p1;
			p1=p2;
			p2=p3;
		}
		int result[]=new int[p1.polynomial.length+p2.polynomial.length-1];
		for(int indexFirst=0;indexFirst<result.length;indexFirst++) {
			result[indexFirst]=0;
		}
		for(int indexFirst=p1.polynomial.length-1;indexFirst>=0;indexFirst--) {
			for(int indexSecond=p2.polynomial.length-1;indexSecond>=0;indexSecond--) {
				result[indexFirst+indexSecond]+=p1.polynomial[indexFirst]*p2.polynomial[indexSecond];		
			}
		}
		return new Poly(result);
	}
}