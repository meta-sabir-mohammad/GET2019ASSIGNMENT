package Assignment3B;

import java.io.IOException;

/**
 * 
 * Marksheet Class implement methods to perform on all student grades
 * This include finding maximum,minimum grades or average grades,percentage of pass student
 *
 */
public class Marksheet {
	
	public static final int MINIMUM_PASSING_GRADE = 40;
	
	/**
	 * Find average grade from all student grades
	 * @param grades array containing grades of all student
	 * @param numberOfStudent number of student who's grades is in array
	 * @return average grade from all student grades
	 */
	public double getAverageOfAllGrades(double grades[],int numberOfStudent) throws IOException{
		
		
		//grades and student validation
		if(numberOfStudent <= 0){
			throw new IOException("Invalid Number Of Student!!!");
		}
		if(!gradesValidation(grades, numberOfStudent)){
			throw new IOException("Invalid Grades!!!");
		}
		
		
		double averageGrades = 0.0;
		
		for(int gradeIndex = 0; gradeIndex < numberOfStudent; gradeIndex++){
			averageGrades += grades[gradeIndex];
		}
		averageGrades = averageGrades / numberOfStudent;
		return averageGrades;
	}
	
	/**
	 * Find maximum grade of all student grades
	 * @param grades array containing grades of all student
	 * @param numberOfStudent number of student who's grades is in array
	 * @return
	 */
	public double getMaximumOfAllGrades(double grades[],int numberOfStudent) throws IOException{
		
		//grades and student validation
		if(numberOfStudent <= 0){
			throw new IOException("Invalid Number Of Student!!!");
		}
		if(!gradesValidation(grades, numberOfStudent)){
			throw new IOException("Invalid Grades!!!");
		}
				
				
		double maximumGrade = 0.0;
		maximumGrade = grades[0];
		
		for(int gradeIndex = 0; gradeIndex < numberOfStudent; gradeIndex++){
			if(maximumGrade < grades[gradeIndex]){
				maximumGrade = grades[gradeIndex];
			}
		}
		return maximumGrade;
	}
	
	/**
	 * Find minimum grade in all student grades
	 * @param grades array containing grades of all student
	 * @param numberOfStudent number of student who's grades is in array
	 * @return minimum grade in all student grades
	 */
	public double getMinimumOfAllGrades(double grades[],int numberOfStudent) throws IOException{
		
		//grades and student validation
		if(numberOfStudent <= 0){
			throw new IOException("Invalid Number Of Student!!!");
		}
		if(!gradesValidation(grades, numberOfStudent)){
			throw new IOException("Invalid Grades!!!");
		}
				
				
		double minimumGrade = 0.0;
		minimumGrade = grades[0];
		
		for(int gradeIndex = 0; gradeIndex < numberOfStudent; gradeIndex++){
			if(minimumGrade > grades[gradeIndex]){
				minimumGrade = grades[gradeIndex];
			}
		}
		return minimumGrade;
	}
	
	/**
	 * Find percentage of student passed
	 * @param grades array containing grades of all student
	 * @param numberOfStudent number of student who's grades is in array
	 * @return percentage of student passed
	 */
	public double getPercentageOfPassStudent(double grades[],int numberOfStudent) throws IOException{
		
		//grades and student validation
		if(numberOfStudent <= 0){
			throw new IOException("Invalid Number Of Student!!!");
		}
		if(!gradesValidation(grades, numberOfStudent)){
			throw new IOException("Invalid Grades!!!");
		}
				
				
		double passStudentPrecentage = 0.0;
		double numberOfPassStudent = 0;
		for(int gradeIndex =0; gradeIndex < numberOfStudent; gradeIndex++){
			if(grades[gradeIndex] >= 40){
				numberOfPassStudent++;
			}
		}
		passStudentPrecentage = (numberOfStudent / 100) * numberOfPassStudent;
		return passStudentPrecentage;
	}
	
	/**
	 * Validate grades of all student
	 * @param grades array containing grades of all student
	 * @param numberOfStudent number of student who's grades is in array
	 * @return true if grades is in between 0 to 100 inclusive
	 */
	private boolean gradesValidation(double grades[], int numberOfStudent){
		for(int studentGradeIndex =0; studentGradeIndex < numberOfStudent; studentGradeIndex++){
			if(grades[studentGradeIndex] < 0 || grades[studentGradeIndex] > 100){
				return false;
			}
		}
		return true;
	}
	
}
