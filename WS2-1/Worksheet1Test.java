import static org.junit.Assert.assertEquals;
import org.junit.Test;


/** 
 * This class contains the test cases for Worksheet1 solutions.
 * 
 * @author <CHIRAG BHATTI> (CXB937)
 * @version 26/01/2020
 */

public class Worksheet1Test {
	
	// Ex1 Tests ----------------------------------------------------------------------------------------------------

	/**
	 * Ex1 TestA - Checks when the root and power are both zero
	 */
	@Test
	public void Ex1TestA() {

		int powerResult 	= Worksheet1.power(0, 0);
		int fastPowerResult = Worksheet1.fastPower(0, 0);

		assertEquals(powerResult, 1);
		assertEquals(fastPowerResult, 1);
		assertEquals(powerResult,fastPowerResult);
	}

	/**
	 * Ex1 TestB - Checks when the root is zero and the power is non-zero
	 */
	@Test
	public void Ex1TestB() {

		int powerResult 	= Worksheet1.power(0, 3);
		int fastPowerResult = Worksheet1.fastPower(0, 3);

		assertEquals(powerResult, 0);
		assertEquals(fastPowerResult, 0);
		assertEquals(powerResult,fastPowerResult);
	}

	/**
	 * Ex1 TestC - Checks when the root is non-zero and the power is zero
	 */
	@Test
	public void Ex1TestC() {

		int powerResult 	= Worksheet1.power(3, 0);
		int fastPowerResult = Worksheet1.fastPower(3, 0);

		assertEquals(powerResult, 1);
		assertEquals(fastPowerResult, 1);
		assertEquals(powerResult,fastPowerResult);
	}

	/**
	 * Ex1 TestD - Checks when the root is non-zero and the power is one
	 */
	@Test
	public void Ex1TestD() {

		int powerResult 	= Worksheet1.power(3, 1);
		int fastPowerResult = Worksheet1.fastPower(3, 1);

		assertEquals(powerResult, 3);
		assertEquals(fastPowerResult, 3);
		assertEquals(powerResult,fastPowerResult);
	}

	/**
	 * Ex1 TestE - Checks numbers greater than 1 for both root and power
	 */
	@Test
	public void Ex1TestE() {

		int powerResult 	= Worksheet1.power(4, 6);
		int fastPowerResult = Worksheet1.fastPower(4, 6);

		assertEquals(powerResult, 4096);
		assertEquals(fastPowerResult, 4096);
		assertEquals(powerResult,fastPowerResult);
	}

	// Ex2 Tests ----------------------------------------------------------------------------------------------------

	/**
	 * Ex2 Test A - Checks negating an empty List gives an empty List
	 */
	@Test
	public void Ex2TestA() {

		List<Integer> testListA = new List<Integer>();
		List<Integer> resultA = Worksheet1.negateAll(testListA);
		
		List<Integer> correctA 	= new List<>();


		assertEquals(resultA, correctA);
	}

	/**
	 * Ex2 Test B - Checks negating a List with all negative integers
	 */
	@Test
	public void Ex2TestB() {

		List<Integer> testListB = new List<>(-1, new List<>(-2, new List<>(-3, new List<>())));
		List<Integer> resultB 	= Worksheet1.negateAll(testListB);
		
		List<Integer> correctB 	= new List<>(1, new List<>(2, new List<>(3, new List<>())));

		assertEquals(resultB, correctB);
	}

	/**
	 * Ex2 Test C - Checks negating a List with all positive integers
	 */
	@Test
	public void Ex2TestC() {

		List<Integer> testListC = new List<>(1, new List<>(2, new List<>(3, new List<>())));
		List<Integer> resultC 	= Worksheet1.negateAll(testListC);
		
		List<Integer> correctC 	= new List<>(-1, new List<>(-2, new List<>(-3, new List<>())));

		assertEquals(resultC, correctC);
	}
	
	/**
	 * Ex2 Test D - Checks negating a List with a mixture of negative and positive integers
	 */
	@Test
	public void Ex2TestD() {

		List<Integer> testListD = new List<>(1, new List<>(-2, new List<>(3, new List<>(-4, new List<>()))));
		List<Integer> resultD 	= Worksheet1.negateAll(testListD);
		
		List<Integer> correctD 	= new List<>(-1, new List<>(2, new List<>(-3, new List<>(4, new List<>()))));

		assertEquals(resultD, correctD);
	}
	
	/**
	 * Ex2 Test E - Checks negating a List with just one integer
	 */
	@Test
	public void Ex2TestE() {

		List<Integer> testListE = new List<>(-1, new List<>());
		List<Integer> resultE 	= Worksheet1.negateAll(testListE);
		
		List<Integer> correctE 	= new List<>(1, new List<>());

		assertEquals(resultE, correctE);
	}
	
	/**
	 * Ex2 Test F - Checks negating a List with a mixture of negative and positive integers as well as zero
	 */
	@Test
	public void Ex2TestF() {

		List<Integer> testListF = new List<>(1, new List<>(0, new List<>(-2, new List <>())));
		List<Integer> resultF 	= Worksheet1.negateAll(testListF);
		
		List<Integer> correctF 	= new List<>(-1, new List<>(0, new List<>(2, new List <>())));

		assertEquals(resultF, correctF);
	}
	
	// Ex3 Tests ----------------------------------------------------------------------------------------------------
	
	/**
	 * Ex3 Test A - Checks finding an integer in empty List throws an Illegal Argument Exception
	 */
	@Test (expected = IllegalArgumentException.class)
	public void Ex3TestA() {

		int testIntA 			=  1;
		List<Integer> testListA = new List<>();
		
		Worksheet1.find(testIntA, testListA);
	}
	
	/**
	 * Ex3 Test B - Checks the integer to be found is the first and only element in the list
	 */
	@Test 
	public void Ex3TestB() {

		int testIntB 			=  1;
		List<Integer> testListB = new List<>(1, new List<>());
		int resultB 			= Worksheet1.find(testIntB, testListB);
		
		int correctB			= 0;
		
		assertEquals(resultB, correctB);
	}
	
	/**
	 * Ex3 Test C - Checks integer is found in a populated list at the correct index / position
	 */
	@Test 
	public void Ex3TestC() {

		int testIntC			=  1;
		List<Integer> testListC = new List<>(4, new List<>(3, new List<>(-1, new List<>(1, new List <>(2, new List <>())))));
		int resultC				= Worksheet1.find(testIntC, testListC);
		
		int correctC			= 3;
		
		assertEquals(resultC, correctC);
	}
	
	/**
	 * Ex3 Test D - Checks illegal argument exception is thrown when integer is not found in a populated list
	 */
	@Test (expected = IllegalArgumentException.class)
	public void Ex3TestD() {

		int testIntD			=  5;
		List<Integer> testListD = new List<>(4, new List<>(3, new List<>(-5, new List<>(2, new List <>()))));
		
		Worksheet1.find(testIntD, testListD);
		
	}
	
	// Ex4 Tests ----------------------------------------------------------------------------------------------------
	
	/**
	 * Ex4 Test A - Checks an empty list is confirmed as having all even numbers
	 */
	@Test 
	public void Ex4TestA() {

		List<Integer> testListA = new List<>();
		boolean resultA			= Worksheet1.allEven(testListA);
		
		boolean correctA		= true;
		
		assertEquals(resultA, correctA);
	}
	
	/**
	 * Ex4 Test B - Checks a list with a single zero element has all even numbers
	 */
	@Test 
	public void Ex4TestB() {

		List<Integer> testListB = new List<>(0, new List <>());
		boolean resultB			= Worksheet1.allEven(testListB);
		
		boolean correctB		= true;
		
		assertEquals(resultB, correctB);
	}
	
	/**
	 * Ex4 Test C - Checks a list with a mixture of positive and negative even numbers, and zero, is all even
	 */
	@Test 
	public void Ex4TestC() {

		List<Integer> testListC = new List<>(4, new List <>(-2, new List<>(0, new List<>(6, new List<>()))));
		boolean resultC			= Worksheet1.allEven(testListC);
		
		boolean correctC		= true;
		
		assertEquals(resultC, correctC);
	}
	
	/**
	 * Ex4 Test D - Checks a list with a mixture of positive, negative, odd, even and zero numbers isn't all even
	 */
	@Test 
	public void Ex4TestD() {

		List<Integer> testListD = new List<>(4, new List <>(-2, new List<>(3, new List<>(-5, new List<>(6, new List <>())))));
		boolean resultD  		= Worksheet1.allEven(testListD);
		
		boolean correctD		= false;
		
		assertEquals(resultD, correctD);
	}
	
	// Ex5 Tests ----------------------------------------------------------------------------------------------------
	
	/**
	 * Ex5 Test A - Checks for even numbers in an empty list gives an empty list
	 */
	@Test
	public void Ex5TestA() {

		List<Integer> testListA = new List<>();
		List<Integer> resultA 	= Worksheet1.evenNumbers(testListA);
		
		List<Integer> correctA 	= new List<>();

		assertEquals(resultA, correctA);
	}
	
	/**
	 * Ex5 Test B - Checks for even numbers in a list with all positive, negative and zero even numbers gives the same list
	 */
	@Test
	public void Ex5TestB() {

		List<Integer> testListB = new List<>(2, new List<>(-4, new List<>(-6, new List <>(0, new List <>()))));
		List<Integer> resultB 	= Worksheet1.evenNumbers(testListB);
		
		List<Integer> correctB 	= new List<>(2, new List<>(-4, new List<>(-6, new List <>(0, new List <>()))));

		assertEquals(resultB, correctB);
	}
	
	/**
	 * Ex5 Test C - Checks for even numbers in a list with all positive, negative odd numbers gives an empty list
	 */
	@Test
	public void Ex5TestC() {

		List<Integer> testListC = new List<>(1, new List<>(-3, new List<>(5, new List <>())));
		List<Integer> resultC	= Worksheet1.evenNumbers(testListC);
		
		List<Integer> correctC	= new List<>();

		assertEquals(resultC, correctC);
	}
	
	/**
	 * Ex5 Test D - Checks for even numbers in a list with zero, odd, even, positive and negative numbers gives a list
	 * with the even numbers only
	 */
	
	@Test
	public void Ex5TestD() {

		List<Integer> testListD = new List<>(2, new List<>(1, new List<>(-4, new List <>(-3, new List<>(0, new List<>())))));
		List<Integer> resultD	= Worksheet1.evenNumbers(testListD);
		
		List<Integer> correctD	= new List<>(2, new List<>(-4, new List<>(0, new List<>())));

		assertEquals(resultD, correctD);
	}
	
	// Ex6 Tests ----------------------------------------------------------------------------------------------------
	
	/**
	 * Ex6 Test A - Checks an empty List for being sorted in desc. order is true
	 */
	@Test
	public void Ex6TestA() {

		List<Integer> testListA = new List<>();
		boolean resultA			= Worksheet1.sorted(testListA);
		
		boolean correctA 		= true;

		assertEquals(resultA, correctA);
	}
	
	/**
	 * Ex6 Test B - Checks a List with a single number for being sorted in desc. order is true
	 */
	@Test
	public void Ex6TestB() {

		List<Integer> testListB = new List<>();
		boolean resultB			= Worksheet1.sorted(testListB);
		
		boolean correctB 		= true;

		assertEquals(resultB, correctB);
	}
	
	/**
	 * Ex6 Test C - Checks a List containing positive, negative and zero integer elements with duplicates in desc. order 
	 * is true
	 */
	@Test
	public void Ex6TestC() {

		List<Integer> testListC = new List<>(2, new List<>(2, new List<>(1, new List<>(0, new List<>(-1, new List<>(-2,
				new List<>(-2, new List<>())))))));
		boolean resultC 		= Worksheet1.sorted(testListC);
		
		boolean correctC 		= true;

		assertEquals(resultC, correctC);
	}
	
	/**
	 * Ex6 Test D - Checks an unsorted List containing positive, negative and zero integer elements with duplicates 
	 * is NOT in desc. order
	 */
	@Test
	public void Ex6TestD() {

		List<Integer> testListD = new List<>(2, new List<>(3, new List<>(3, new List<>(2, new List<>(0, new List<>(-1,
				new List<>()))))));
		boolean resultD 		= Worksheet1.sorted(testListD);
		
		boolean correctD 		= false;

		assertEquals(resultD, correctD);
	}
	
	// Ex7 Tests ----------------------------------------------------------------------------------------------------
	
	/**
	 * Ex7 Test A - Checks merging two empty lists gives an empty list
	 */
	@Test
	public void Ex7TestA() {

		List<Integer> testListA 	= new List<>();
		List<Integer> testListB 	= new List<>();
		List<Integer> result 		= Worksheet1.merge(testListA, testListB);
		
		List<Integer> correctResult = new List<>();

		assertEquals(result, correctResult);
	}
	
	/**
	 * Ex7 Test B - Checks  merging of a: an empty List, with b: a non-empty list sorted in desc order
	 * gives a list the same as b
	 */
	@Test
	public void Ex7TestB() {

		List<Integer> testListA 	= new List<>();
		List<Integer> testListB 	= new List<>(3, new List<>(2, new List<>(1, new List<>())));
		List<Integer> result 		= Worksheet1.merge(testListA, testListB);
		
		List<Integer> correctResult = new List<>(3, new List<>(2, new List<>(1, new List<>())));

		assertEquals(result, correctResult);
	}
	
	/**
	 * Ex7 Test B - Checks merging of a: a non-empty list sorted in desc order, with b: an empty List, gives a 
	 * list the same as a
	 */
	@Test
	public void Ex7TestC() {

		List<Integer> testListA 	= new List<>(3, new List<>(2, new List<>(1, new List<>())));
		List<Integer> testListB 	= new List<>();
		List<Integer> result 		= Worksheet1.merge(testListA, testListB);
		
		List<Integer> correctResult = new List<>(3, new List<>(2, new List<>(1, new List<>())));

		assertEquals(result, correctResult);
	}
	
	/**
	 * Ex7 Test D - Checks the merging of a and b, both non-empty integer lists sorted in desc order with
	 * positive, negative and zero number elements gives a list with all elements in desc. order incl.
	 * any elements common between the a and b.
	 */
	@Test
	public void Ex7TestD() {

		List<Integer> testListA 	= new List<>(2, new List<>(1, new List<>(0, new List<>(-1, new List<>(-2, new List<>())))));
		List<Integer> testListB 	= new List<>(2, new List<>(0, new List<>(-2, new List<>(-4, new List<>()))));
		List<Integer> result 		= Worksheet1.merge(testListA, testListB);
		
		List<Integer> correctResult = new List<>(2, new List<>(2, new List<>(1, new List<>(0, new List<>(0, new List<>(-1,
				new List<>(-2, new List<>(-2, new List<>(-4, new List<>())))))))));

		assertEquals(result, correctResult);
	}
	
	// Ex8 Tests ----------------------------------------------------------------------------------------------------
	
	/**
	 * Ex8 Test A - Checks the removing duplicates from an empty List gives an empty List
	 */
	@Test
	public void Ex8TestA() {

		List<Integer> testListA 	= new List<>();
		List<Integer> resultA 		= Worksheet1.removeDuplicates(testListA);
		
		List<Integer> correctA 		= new List<>();

		assertEquals(resultA, correctA);
	}
	
	/**
	 * Ex8 Test B - Checks the removing duplicates from a single element List gives the same List
	 */
	@Test
	public void Ex8TestB() {

		List<Integer> testListB 	= new List<>(1, new List <>());
		List<Integer> resultB		= Worksheet1.removeDuplicates(testListB);
		
		List<Integer> correctB 		= new List<>(1, new List <>());

		assertEquals(resultB, correctB);
	}
	
	/**
	 * Ex8 Test C - Checks removing duplicate elements from a list with two duplicate number elements gives a List 
	 * with a single Integer element
	 */
	@Test
	public void Ex8TestC() {

		List<Integer> testListC		= new List<>(1, new List <>(1, new List <>()));
		List<Integer> resultC		= Worksheet1.removeDuplicates(testListC);
		
		List<Integer> correctC		= new List<>(1, new List <>());

		assertEquals(resultC, correctC);
	}
	
	/**
	 * Ex8 Test D - Checks removing duplicate elements from an extensive list with duplicate positive, negative and zero
	 * integers from a List gives a uniquely elemented list also in desc. order
	 */
	@Test
	public void Ex8TestD() {

		List<Integer> testListD 	= new List<>(3, new List <>(2, new List <>(2, new List <>(1, new List <>(0, new List <>(-1, 
				new List <>(-1, new List <>(-2, new List <>()))))))));
		List<Integer> resultD		= Worksheet1.removeDuplicates(testListD);
		
		List<Integer> correctD 		= new List<>(3, new List <>(2, new List <>(1, new List <>(0, new List <>(-1, new List <>(-2, 
				new List <>()))))));

		assertEquals(resultD, correctD);
	}
	

}

