package predictive;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;


class Ex3Tests {

	String pathToWordsDictionary 	= "/Users/chirag/eclipse-workspace/WS2-3/src/words";
	MapDictionary wordsDictionary 	= new MapDictionary(pathToWordsDictionary);

	/**
	 * Ex3 TestA - Checks the conversion of the String word "test" to its String signature
	 */
	@Test
	public void Ex3TestA() {
		
		String result 	= MapDictionary.wordToSignature("test");
		String correct 	= "8378";
		
		assertEquals(correct, result);
	}
	
	/**
	 * Ex3 TestB - Checks the conversion of a String word with only non-alphabetic characters returns 
	 * a signature with four blank spaces;
	 */
	@Test
	public void Ex3TestB() {
		
		String result 	= MapDictionary.wordToSignature("^%9/");
		String correct 	= "    ";
		
		assertEquals(correct, result);
	}
	
	/**
	 * Ex3 TestC - Checks the conversion of a blank String word returns a blank String signature
	 */
	@Test
	public void Ex3TestC() {
		

		String result 	= MapDictionary.wordToSignature("");
		String correct 	= "";
		
		assertEquals(correct, result);
	}
	
	/**
	 * Ex3 TestD - Checks the conversion of a valid signature to possible words using the supplied words dictionary
	 */
	@Test
	public void Ex3TestD() {

		Set<String> result 	= wordsDictionary.signatureToWords("329");

		Set<String> correct = new HashSet<>();
		correct.add("dbw");
		correct.add("dax");
		correct.add("daw");
		correct.add("fax");
		correct.add("day");
		correct.add("fcy");
		correct.add("fay");

		assertEquals(correct, result); // This also establishes the returned results are in lower case, and no duplicates are provided due to Hash Set.

	}
	
	/**
	 * Ex3 TestE - Checks the conversion of an invalid signature returns an empty set
	 */
	@Test
	public void Ex3TestE() {

		Set<String> result 	= wordsDictionary.signatureToWords("329*");

		Set<String> correct = new HashSet<>();

		assertEquals(correct, result);

	}
	/**
	 * Ex3 TestF - Checks the conversion of an invalid signature returns an empty set
	 */
	@Test
	public void Ex3TestF() {

		Set<String> result 	= wordsDictionary.signatureToWords("hello");

		Set<String> correct = new HashSet<>();

		assertEquals(correct, result);

	}
	
	/**
	 * Ex3 TestG - Checks the conversion of an invalid signature returns an empty set
	 */
	@Test
	public void Ex3TestG() {

		Set<String> result 	= wordsDictionary.signatureToWords("");

		Set<String> correct = new HashSet<>();

		assertEquals(correct, result);

	}
	
	/**
	 * Ex3 TestH - Checks the isValid method correctly detects a valid word
	 */
	@Test
	public void Ex3TestH() {

		boolean result 	= MapDictionary.isValidWord("hello");

		boolean correct = true;

		assertEquals(correct, result);

	}
	
	/**
	 * Ex3 TestI - Checks the isValid method correctly detects an invalid word
	 */
	@Test
	public void Ex3TestI() {

		boolean result 	= MapDictionary.isValidWord("10-point");

		boolean correct = false;

		assertEquals(correct, result);

	}
	
	/**
	 * Ex3 TestJ - Checks the isValid method correctly detects an invalid word which is just a blank string
	 */
	@Test
	public void Ex3TestJ() {

		boolean result 	= MapDictionary.isValidWord("");

		boolean correct = false;

		assertEquals(correct, result);

	}
	
	/* 
	 * --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 * THE FOLLOWING TEST USE A SHORTENED CUSTOM DICTIONARY AS BELOW
	 * --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 */

	String pathToMyTestDictionary 	= "/Users/chirag/eclipse-workspace/WS2-3/src/myTestDictionary";
	MapDictionary myTestDictionary = new MapDictionary(pathToMyTestDictionary);
	 
	/* 
	 * The dictionary contains the following 6 words:
	 * 
	 * Wisping
	 * Wissing
	 * Yipping
	 * Yirring
	 * Zipping
	 * Wisping
	 * 
	 * All the words have the corresponding T9 numerical String signature --> "9477464"
	 * All the words have one capital letter
	 * The word "Wisping" is duplicated twice in the Dictionary file (at the beginning and the end)
	 * --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 */
	
	/**
	 * Ex3 TestK - Searches the custom dictionary by a signature that all the words within it match, and checks all the matching words are in lower case and without duplicates.
	 */
	@Test
	public void Ex3TestK() {

		Set<String> result 	= myTestDictionary.signatureToWords("9477464");

		Set<String> correct = new HashSet<>();
		correct.add("wisping");
		correct.add("wissing");
		correct.add("yipping");
		correct.add("yirring");
		correct.add("zipping");
		
		assertEquals(correct, result); // This also establishes the returned results are in lower case, and no duplicates are provided due to Hash Set.

	}
	
	/**
	 * Ex3 TestL - Searches the custom dictionary by a signature that none of the words within match, and confirms that an empty String set of matching words is returned.
	 */
	@Test
	public void Ex3TestL() {

		Set<String> result 	= myTestDictionary.signatureToWords("9477469");

		Set<String> correct = new HashSet<>();
		
		assertEquals(correct, result); 

	}
	
	/* 
	 * --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 * THE FOLLOWING TEST USE A CUSTOM DICTIONARY AS BELOW
	 * --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 */

	String pathToMyEmptyDictionary 	 = "/Users/chirag/eclipse-workspace/WS2-3/src/myEmptyDictionary";
	MapDictionary myEmptyDictionary = new MapDictionary(pathToMyEmptyDictionary);
	
	/* 
	 * The dictionary is an empty text file thereby containing no words
	 *
	 * --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 */
	
	/**
	 * Ex3 TestM - Searches the empty custom dictionary with a valid signature and ensures an empty String set is returned
	 */
	@Test
	public void Ex3TestM() {

		Set<String> result 	= myEmptyDictionary.signatureToWords("9477464");

		Set<String> correct = new HashSet<>();

		assertEquals(correct, result);

	}
	
}

/* 
 * --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 * THE FOLLOWING TEST used 94 signatures passed as main method arguments to the Sigs2WordsMap method. 
 * The command was as below:
 * 
 * time predictive/Sigs2WordsMap 8378 42837 43556 2424678 26 465879 2 256737 387648873 47238283722683 738325464 27326 7374337 6887433 43556 2354383 4684837 269 427336 2 2327464 243 76537 2354383 843 387 844657469 226 843 73669 288363268 26567 6253 843 3424726 532837 843 5878423 22683843 7827378368 26868377278 469 226 2354383 784685283 6253 7866464732566 3278 763557 23569 2 47266284225 26843683 2 3327 272957 67767483 3278 7866464 437482837 7866464 292487 84346243368426637 26678837 36267 467433 843 73325 7226637 6398 86 843 3484333 39767873 224337 2 8636756933 836753 94369455 2 26623786 7946 8633763284 26678837 26678837 78773287 2 2677377663368 72346 68373569 7288537 26 864325849 569
 * 
 * The results of this were 3.50s user / 0.27s system / 227% cpu / 1.656 total
 * --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 */
