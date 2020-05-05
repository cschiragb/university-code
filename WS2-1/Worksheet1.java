/**
 * This class contains the implementations for the Worksheet1 exercises.
 * 
 * @author <Chirag Bhatti> (CXB937)
 * @version 26/01/2020
 */

public class Worksheet1 {

	// Exercise 1

	/**
	 * power is a Method to compute the calculation m to the power of n
	 * @param m, an integer which is the root number
	 * @param n, an integer which is the power number / exponent
	 * @return an integer which is the result of m^n
	 */
	static int power(int m, int n) {

		// Base case 
		if (n == 0) {
			return 1;
		}

		// Base case 
		else if (m == 0) {
			return 0;
		}

		// Base case
		else if (n == 1) {
			return m;
		}

		// Recursive step
		else {
			return m * power(m, n-1);
		}
	}

	/**
	 * fastPower is a Method to compute the calculation m to the power of n
	 * with less steps
	 * @param m, an integer which is the root number
	 * @param n, an integer which is the power number / exponent
	 * @return an integer which is the result of m^n
	 */
	static int fastPower(int m, int n) {
		
		// Base case 
		if (n == 0) {
			return 1;
		}

		// Base case 
		else if (m == 0) {
			return 0;
		}

		// Base case 
		else if (n == 1) {
			return m;
		}

		// Recursive step using half powers when powers are even 
		else if (n % 2 == 0) {
			return fastPower(m, n/2) * fastPower(m, n/2);
		}

		// Alternative recursive step when powers are odd
		else {
			return m * fastPower(m, n-1);
		}

	}

	// Exercise 2

	/**
	 * negateAll is a Method to negate all the signs of the elements in an integer list
	 * @param a, is the integer list to be negated
	 * @return a List with the negated elements
	 */
	static List<Integer> negateAll(List<Integer> a) {

		// Base case
		if (a.isEmpty()) {
			return new List<Integer>();
		}

		// Recursive step
		else {
			return new List<Integer>(-(a.getHead()), negateAll(a.getTail()));
		}

	}

	// Exercise 3

	/**
	 * find is a Method to find the position/index of the first occurrence of an element in a list
	 * @param x, is an integer element to be found in the list
	 * @param a, is the integer list to be searched
	 * @return the position as an integer if the element is found within the list
	 */
	static int find(int x, List<Integer> a) {

		// Base case 
		if (a.isEmpty()) {
			throw new IllegalArgumentException("Integer x could not be found in Integer List a"
					+ "because it is empty");
		}

		// Base case
		else if (x == a.getHead()) { 
			return 0;
		}

		// Recursive step
		else {
			return 1 + find(x, a.getTail());
		}

	}

	// Exercise 4

	/**
	 * allEven is a Method to check if all the integer elements of a list are even numbers
	 * @param a, is the integer list to be checked
	 * @return the boolean true if all the elements are even otherwise false
	 */
	static boolean allEven(List<Integer> a) {

		// Base case
		if (a.isEmpty()) {
			return true;
		}

		// Base case // should use Math instead??
		else if (a.getHead() % 2 != 0) {
			return false;
		}

		// Recursive step
		else {
			return allEven(a.getTail());
		}

	}

	// Exercise 5

	/**
	 * evenNumbers is a Method to extract only the even numbers in an integer list
	 * @param a, the list to be extracted from
	 * @return a list with the even numbers from the original list only
	 */
	static List<Integer> evenNumbers(List<Integer> a) {

		// Base case
		if (a.isEmpty()) {
			return new List<Integer>();
		}

		// Recursive step
		else if (a.getHead() % 2 == 0) { // should use Math instead??
			return new List<Integer>(a.getHead(),evenNumbers(a.getTail()));
		}

		// Alternative Recursive step
		else {
			return evenNumbers(a.getTail());
		}

	}

	// Exercise 6

	/**
	 * sorted is a Method to confirm whether a list of integers is sorted in descending order
	 * @param a, the list to be checked
	 * @return a boolean true if the list is sorted otherwise false
	 */
	static boolean sorted(List<Integer> a) {

		// Base case
		if (a.isEmpty()) {
			return true;
		}

		// Base case
		else if (a.getTail().isEmpty()) {
			return true;
		}
		
		// Recursive step
		else if (a.getHead() >= a.getTail().getHead()) {
			return sorted(a.getTail());
		}

		// When an unsorted list is detected
		else {
			return false;
		}

	}

	// Exercise 7

	/**
	 * merge is a Method to completely combine two lists sorted lists that are in descending order
	 * @param a, is the first list in descending order to be considered
	 * @param b, is the second list in descending order to be considered
	 * @return a list also in descending order with all the elements of a and b 
	 */
	static List<Integer> merge(List<Integer> a, List<Integer> b) {

		// Base case
		if (a.isEmpty()) {
			return b;
		}

		// Base case
		else if (b.isEmpty()) {
			return a;
		}

		// Recursive step
		else if (a.getHead() >= b.getHead()) {
			return new List<Integer>(a.getHead() , merge(a.getTail(), b));
		}

		// Alternative Recursive step
		else {
			return new List<Integer>(b.getHead() , merge(a, b.getTail()));
		}

	}

	// Exercise 8

	/**
	 * removeDuplicates is a Method to remove repeated elements from an integer list sorted in 
	 * descending order, so that only unique elements are left
	 * @param a, an integer list that may contain duplicate elements
	 * @return a list with removed duplicates leaving unique elements
	 */
	static List<Integer> removeDuplicates(List<Integer> a) {

		// Base case
		if (a.isEmpty()) {
			return new List<Integer>();
		}

		// Base case
		else if (a.getTail().isEmpty()) {
			return a;
		}

		// Recursive step making use of helper Method 
		else {
			return new List<Integer>(a.getHead(), 
				removeDuplicates(clearMultiple(a.getHead(), a.getTail())));
		}

	}

	/**
	 * clearMultiple is a helper Method for removeDuplicates above to remove zero, one or more 
	 * duplicates from an integer list sorted in descending order, especially at the first sign 
	 * of detection of a duplicate
	 * @param headValue, is the value to be checked for duplicates
	 * @param b, is the list containing the potential duplicates
	 * @return a list with all duplicates of the headValue removed
	 */
	static List<Integer> clearMultiple(int headValue, List<Integer> b) {

		// Base case
		if (b.isEmpty()) {
			return new List<Integer>();
		}

		// Base case
		else if (headValue > b.getHead()) {
			return b;
		}

		// Recursive step
		else {
			return clearMultiple(headValue, b.getTail());
		}
	}

}