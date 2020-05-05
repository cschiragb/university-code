/**
 * Class Statistics is a class to determine standard statistics of interest (maximum,
 * average and standard deviation) from an array list of items of type Measurable.
 * See Measurable interface for implementation of items of type Measurable.
 * 
 * No field variables are established in this class.
 * 
 * @author Chirag Bhatti
 * @version 18/11/2018
 */

import java.util.ArrayList;

public class Statistics {
	
	/** maximum is a method for determining the maximum value in an array list of elements of type Measurable
	 * 
	 * @param elements of the ArrayList of type Measurable
	 * @return max as double
	 */
	public static double maximum(ArrayList<Measurable> elements) {
		
		/* Initialise the maximum to be the value of the first element as is best practice */
		double max = elements.get(0).getValue(); 
		
		/* Use of enhanced for loop through array list as we are only looking to determine the maximum value */
		for (Measurable a : elements) {
			if (a.getValue() < 0) {
				throw new IllegalArgumentException();
				/* assuming an invoice amount, patient age or patient weight must be 0 or higher, through an exception if we find a
				 * nevative number as the statistic maybe invalid
				 */
		}
			else if (a.getValue() > max) {
				max = a.getValue();
			}
		}
		return max;
	}
	
	/** average is a method for determining the average of all the elements in an array list of type Measurable
	 * 
	 * @param elements of the ArrayList of type Measurable
	 * @return average as double
	 */
	public static double average(ArrayList<Measurable> elements) {
		
		/* Initialise the sum of all the array list elements to zero */
		double total = 0.0;
		
		/* Use of enhanced for loop through array list as we are only looking to sum up all elements of the array list */
		for (Measurable b : elements) {
			if (b.getValue() < 0) {
				throw new IllegalArgumentException();
				/* assuming an invoice amount, patient age or patient weight must be 0 or higher, through an exception if we find a
				 * nevative number as the statistic maybe invalid
				 */
			}
			else total += b.getValue();
		}
		
		double average = total / elements.size();
		
		return average;
	}
	
	/** standardDeviation is a method for determining the standard deviation of all elements of type Measurable in an array list.
	 * 
	 * @param elements of the ArrayList of type Measurable
	 * @return standarddeviation as double
	 */
	public static double standardDeviation(ArrayList<Measurable> elements) {
		
		/* Initialise the sum of all the array list elements to zero */
		double total = 0.0;
		
		/* Use of enhanced for loop through array list as we are only looking to sum up all elements of the array list */
		for (Measurable c : elements) {
			if (c.getValue() < 0) {
				throw new IllegalArgumentException();
				/* assuming an invoice amount, patient age or patient weight must be 0 or higher, through an exception if we find a
				 * nevative number as the statistic maybe invalid
				 */
			}
			else total += c.getValue();
		}
		
		/* Calculation of the average of the values in the array list */
		double average = total / elements.size();
		
		/* Intialising the sum of the differences from the average squared to zero */
		double differenceSumAverageSquared = 0.0;
		
		/* Use of enhanced for loop through the array list, to calculate the sum of the square of the differences between the array list 
		 * individual values from the array list average.
		 */
		for (Measurable d : elements) {
			differenceSumAverageSquared += (d.getValue() - average) * (d.getValue() - average);
		}
		
		/* Calculation of the standard deviation of the array list by dividing the sum of the square of differences from the average
		 * above by the number of elements in the array list minus 1.
		 */
		double standarddeviation = Math.sqrt(differenceSumAverageSquared / (elements.size() - 1));
		
		return standarddeviation;
		
	}
}
