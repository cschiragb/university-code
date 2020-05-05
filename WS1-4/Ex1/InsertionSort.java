/** InsertionSort is a class for sorting the number elements of an array from lowest to highest,
 * using the Insertion Sort algorithm implemented below.
 * 
 * Rather than creating a new sorted array, the algorithm below sorts the original array.
 * 
 * We use a variable insertHolder to hold the number in the array that is to be inserted back in
 * once it's appropriate position is found in the portion of array in question.
 * 
 * @author Chirag Bhatti
 * @version 08/11/2018
 */

public class InsertionSort {
	
	public static int[] insertionSort (int[] numbers) {
		
		/**
		 * create a variable insertHolder to hold elements that need to be compared against temporarily.
		 */
		int insertHolder;
		
		/**
		 * Loop through the elements of array 'numbers' starting from index 1 up to the last element.
		 */
		for (int i = 1; i < numbers.length; i++)
		{
			
			/**
			 * Hold the number at index [i] in the insertHolder
			 */
			insertHolder = numbers [i];
			
			/**
			 * 	Whilst the index is higher than 0 and the element at the index to the left of the
			 * current index is greater than the inserHolder, copy the number on the left into the index to the right.
			 * This means that both indexes will have the same number temporarily. Reduce the index number in question by one.
			 * Keep doing this until we either get to the beginning of the array (element 0) or the element at index i
			 * in question is no longer greater than the insertHolder.
			 */
			while(i > 0 && numbers [i -1] > insertHolder)
			{
				numbers[i] = numbers[i -1];
				i--;
			}
			
			/**
			 * Once the while loop is exited, set the number at index i of the array numbers to the insertHolder
			 * to sort that portion of the array, and loop back to the next i in the for statement above to
			 * continue sorting the rest of the array as necessary.
			 */
			numbers[i] = insertHolder;

		}
			/** 
			 * Finally, return the sorted array which has the same array name 'numbers'
			 */
		return numbers;
		
	}
}
