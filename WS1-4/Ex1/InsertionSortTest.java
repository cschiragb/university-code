import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class InsertionSortTest {
	
	// testing on array with non-integer values being type cast back to integer
	@Test
	public void test1() {
		int[] numbers = {(int) 1.1, (int) 2.3};
		int[] expected = {1, 2};
		int[] actual = InsertionSort.insertionSort(numbers);
		assertTrue(Arrays.equals(expected, actual));
	}
	
	// testing on array with all the numbers exactly the same except for one of them
		@Test
		public void test2() {
			int[] numbers = {10, 10, 10, 10, 10, 10, 10, 10, 10, 1};
			int[] expected = {1, 10, 10, 10, 10, 10, 10, 10, 10, 10};
			int[] actual = InsertionSort.insertionSort(numbers);
			assertTrue(Arrays.equals(expected, actual));
		}
		
	// testing on array with mathematical operations inside of it
		@Test
		public void test3() {
			int[] numbers = {3*3, 2*2, 4*4, 6*6, 9*9, 7*7, 1*1, 5*5, 10*10, 8*8};
			int[] expected = {1, 4, 9, 16, 25, 36, 49, 64, 81, 100};
			int[] actual = InsertionSort.insertionSort(numbers);
			assertTrue(Arrays.equals(expected, actual));
		}	
	
	// testing unsorted array
	@Test
	public void test4() {
		int[] numbers = {4, 7, 12, 99, 8};
		int[] expected = {4, 7, 8, 12, 99};
		int[] actual = InsertionSort.insertionSort(numbers);
		assertTrue(Arrays.equals(expected, actual));
	}
	
	// testing larger array
	@Test
	public void test5() {
		int[] numbers = {5, 3, 9, 1, 6, 10, 56, 4, 8, 2, 14};
		int[] expected = {1, 2, 3, 4, 5, 6, 8, 9, 10, 14, 56};
		int[] actual = InsertionSort.insertionSort(numbers);
		assertTrue(Arrays.equals(expected, actual));
	}
	
	// testing on already sorted array
	@Test
	public void test6() {
		int[] numbers = {0, 2, 4, 6, 8, 10, 12, 14, 16};
		int[] expected = {0, 2, 4, 6, 8, 10, 12, 14, 16};
		int[] actual = InsertionSort.insertionSort(numbers);
		assertTrue(Arrays.equals(expected, actual));
	}
	
	
	// testing on array with duplicates
	@Test
	public void test7() {
		int[] numbers = {3, 3, 1, 1, 2, 2, 6, 6};
		int[] expected = {1, 1, 2, 2, 3, 3, 6, 6};
		int[] actual = InsertionSort.insertionSort(numbers);
		assertTrue(Arrays.equals(expected, actual));
	}
	
	// testing on empty array
	@Test
	public void test8() {
		int[] numbers = {};
		int[] expected = {};
		int[] actual = InsertionSort.insertionSort(numbers);
		assertTrue(Arrays.equals(expected, actual));
	}
	
	
	// testing on array with all negative numbers
	@Test
	public void test9() {
		int[] numbers = {-1, -15, -30, -60, -90, -120};
		int[] expected = {-120, -90, -60, -30, -15, -1};
		int[] actual = InsertionSort.insertionSort(numbers);
		assertTrue(Arrays.equals(expected, actual));
	}
	
	// testing on array with negative zero
	@Test
	public void test10() {
		int[] numbers = {0, -0};
		int[] expected = {0, 0};
		int[] actual = InsertionSort.insertionSort(numbers);
		assertTrue(Arrays.equals(expected, actual));
	}
	
	

}
