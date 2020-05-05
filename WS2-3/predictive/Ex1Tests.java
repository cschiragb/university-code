package predictive;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class Ex1Tests {

	/**
	 * Ex1 TestA - Checks the conversion of the String word "test" to its String signature
	 */
	@Test
	public void Ex1TestA() {
		
		String result 	= PredictivePrototype.wordToSignature("test");
		String correct 	= "8378";
		
		assertEquals(correct, result);
	}
	
	/**
	 * Ex1 TestB - Checks the conversion of a String word with only non-alphabetic characters returns 
	 * a signature with four blank spaces;
	 */
	@Test
	public void Ex1TestB() {
		
		String result 	= PredictivePrototype.wordToSignature("^%9/");
		String correct 	= "    ";
		
		assertEquals(correct, result);
	}
	
	/**
	 * Ex1 TestC - Checks the conversion of a blank String word returns a blank String signature
	 */
	@Test
	public void Ex1TestC() {
		

		String result 	= PredictivePrototype.wordToSignature("");
		String correct 	= "";
		
		assertEquals(correct, result);
	}
	
	/**
	 * Ex1 TestD - Checks the conversion of a valid signature to possible words using the supplied words dictionary
	 */
	@Test
	public void Ex1TestD() {

		Set<String> result 	= PredictivePrototype.signatureToWords("329");

		Set<String> correct = new HashSet<>();
		correct.add("dbw");
		correct.add("dax");
		correct.add("daw");
		correct.add("fax");
		correct.add("day");
		correct.add("fcy");
		correct.add("fay");

		assertEquals(correct, result);  // This also establishes the returned results are in lower case, and no duplicates are provided due to Hash Set.
	}
	
	/**
	 * Ex1 TestE - Checks the conversion of an invalid signature returns an empty set
	 */
	@Test
	public void Ex1TestE() {

		Set<String> result 	= PredictivePrototype.signatureToWords("329*");

		Set<String> correct = new HashSet<>();

		assertEquals(correct, result);
	}
	
	/**
	 * Ex1 TestF - Checks the conversion of an invalid signature returns an empty set
	 */
	@Test
	public void Ex1TestF() {

		Set<String> result 	= PredictivePrototype.signatureToWords("hello");

		Set<String> correct = new HashSet<>();

		assertEquals(correct, result);
	}
	
	/**
	 * Ex1 TestG - Checks the conversion of an invalid signature returns an empty set
	 */
	@Test
	public void Ex1TestG() {

		Set<String> result 	= PredictivePrototype.signatureToWords("");

		Set<String> correct = new HashSet<>();

		assertEquals(correct, result);
	}
	
	/**
	 * Ex1 TestH - Checks the isValid method correctly detects a valid word
	 */
	@Test
	public void Ex1TestH() {

		boolean result 	= PredictivePrototype.isValidWord("hello");

		boolean correct = true;

		assertEquals(correct, result);
	}
	
	/**
	 * Ex1 TestI - Checks the isValid method correctly detects an invalid word
	 */
	@Test
	public void Ex1TestI() {

		boolean result 	= PredictivePrototype.isValidWord("10-point");

		boolean correct = false;

		assertEquals(correct, result);
	}
	
	/**
	 * Ex1 TestJ - Checks the isValid method correctly detects an invalid word which is just a blank string
	 */
	@Test
	public void Ex1TestJ() {

		boolean result 	= PredictivePrototype.isValidWord("");

		boolean correct = false;

		assertEquals(correct, result);
	}
}

/* 
 * --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 * THE FOLLOWING TEST used 94 signatures passed as main method arguments to the Sigs2WordsProto method. 
 * The command was as below:
 * 
 * time predictive/Sigs2WordsProto 8378 42837 43556 2424678 26 465879 2 256737 387648873 47238283722683 738325464 27326 7374337 6887433 43556 2354383 4684837 269 427336 2 2327464 243 76537 2354383 843 387 844657469 226 843 73669 288363268 26567 6253 843 3424726 532837 843 5878423 22683843 7827378368 26868377278 469 226 2354383 784685283 6253 7866464732566 3278 763557 23569 2 47266284225 26843683 2 3327 272957 67767483 3278 7866464 437482837 7866464 292487 84346243368426637 26678837 36267 467433 843 73325 7226637 6398 86 843 3484333 39767873 224337 2 8636756933 836753 94369455 2 26623786 7946 8633763284 26678837 26678837 78773287 2 2677377663368 72346 68373569 7288537 26 864325849 569
 * 
 * The results of this were 54.84s user / 0.45s system / 103% cpu / 53.600 total
 * --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 */

