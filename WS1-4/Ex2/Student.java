/** Student is a class for a student created from their registration number
 * and their marks across 8 assessed work sheets, 4 in-class tests, a team project
 * and an examination result (i.e. 14 assessments overall).
 * 
 * We establish two field variables:
 * registrationNumber - a String of the student's unique registration number
 * marks - an array of the students mark with respect to the above assessments
 * 
 * @author Chirag Bhatti
 * @version 08/11/2018
 */

public class Student {
	private	String 	registrationNumber;
	private	int[] 	marks;
	
	/** Student is a Constructor to create the profile of a student
	 * 
	 * @param registrationNumber is the registration number ID of a student as a String
	 * @param marks is the marks achieved by the student as an Array of Integers
	 */
	public Student (String registrationNumber, int[] marks) {
		this.registrationNumber = registrationNumber;
		this.marks 				= marks;
	}

	/**
	 * @return the registration number of a Student as a String
	 */
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	/**
	 * Sets the registration number of a Student
	 * @param registrationNumber
	 */
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	/**
	 * @return the marks achieved by the student across the assessments an an Array of Integers
	 */
	public int[] getMarks() {
		return marks;
	}

	/**
	 * Sets the marks achieved by the student to the field variable marks
	 * @param marks
	 */
	public void setMarks(int[] marks) {
		this.marks = marks;
	}
	
	/**
	 * A separate setter that allows the user to set the marks for a single assessment
	 * @param assignmentNumber is the assessment number from 1-14 for which the mark needs to be updated
	 * @param mark is a mark score from 0 - 100 that needs updating
	 */
	public void setAssignmentMark(int assignmentNumber, int mark) {
		marks[assignmentNumber-1] = mark; 
		/* [assignmentNumber-1 is] required to ensure the correct index 
		is updated in relation to assignments 1 to 14. */
	}
	
	/**
	 * A separate method for calculating the total  mark (overall percentage score) achieved by the student 
	 * @return the total mark / course percentage achieved by the student rounded to 1 decimal place
	 */
	public double totalMark() {
		
		double totalMarks = 0.0; /* initialise the totalMarks to be zero */
		
		int correctionFactor = 100; /* initialise the correction factor to be applied to the total mark to 100
		in case no correction is required in the end */
		
		int [] weighting = {2, 2, 2, 2, 1, 1, 1, 1, 2, 2, 1, 3, 10, 70}; /* initialisation of an integer array 
		signifying the weighting for each assessment */
		
		/**
		 * This loop calculates the correctionFactor to be applied to the total marks, in case there are any 
		 * assessments with a mark score of -1 and a weighting less than or equal to 50%.
		 * It loops through the marks array, and if it finds any marks with score -1 that have a corresponding 
		 * weighting in the weighting array of less than or equal to 50, deducts the weighting from its current value.
		 * LOOP INVARIANT: 0 >= CorrectionFactor <= 100
		 */
		for (int i = 0; i < marks.length; i++) {
			if (marks[i] == -1 && weighting[i] <= 50) {
				correctionFactor -= weighting[i];
			}
		}
		
		/**
		 * This loop calculates the total mark achieved by looping through the marks array and adding the marks together
		 * in accumulation.
		 * The mark for the assessment is added to the totalMark as long as it is greater than or equal to 0.
		 * If the mark is equal to -1 but the weighting is less than 50, it is not added to the totalMark.
		 * If the mark is equal to -1 but the weighting is higher than 50, the student's overall totalMark must be 
		 * made to equal -1, and the loop is broken.
		 * LOOP INVARIANT: totalMarks == -1 OR 0 <= totalMarks <= 100.
		 */
		for (int i = 0; i < marks.length; i++) {
			
			if (marks[i] >= 0) 
			{
				totalMarks += (marks[i] * weighting[i]);
			}
			else if (marks[i] == -1 && weighting[i] > 50)
			{
				totalMarks = -1;
				break;
			}
		}
		
		/**
		 * A conditional return statement is used to decide the correct TotalMarks to be returned.
		 * If the totalMarks is -1 due to a mark being -1 for an assessment with a weighting > 50, 
		 * then the totalMarks returned must also be -1.
		 * Otherwise, the totalMarks returned must be that with any necessary correctionFactor applied
		 * followed by the rounding of the totalMarks by 1 decimal place.
		 */
		if (totalMarks == -1)
		{
			return totalMarks;
		}
			totalMarks = Math.round((totalMarks / correctionFactor) * 10) / 10.0;
		return totalMarks;
	}
		
		/**
		 * A separate method to return a boolean depndinng on the totalMark calculated.
		 * If the student has a totalMark greater than or equal to 50, then it is true they have passed.
		 * If the totalMark is less than 50 but not equal to -1, then it is false they have passed.
		 * If the totalMark is equal to -1, than an illegal argument exception is thrown as they have
		 * not scored a mark on assessment with weighting greater than 50.
		 * @return
		 */
	public boolean passed() {
		
			if (totalMark() != -1 && totalMark() >=50)
			{
				return true;
			}
			else if (totalMark() == -1)
			{
				throw new IllegalArgumentException();
		}
			return false;
	}
	
	/** toString defines how the details of a student will be printed
	 * @return the print type of Student
	 */
	public String toString() {
		return "Student with registration number: " + registrationNumber + " \u007C" +
				" Has totalmarks of: " + totalMark() + "\u0025";
	}
}





