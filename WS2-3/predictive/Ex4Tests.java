package predictive;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;


class Ex4Tests {

	String pathToWordsDictionary 	= "/Users/chirag/eclipse-workspace/WS2-3/src/words";
	TreeDictionary wordsDictionary 	= new TreeDictionary(pathToWordsDictionary);

	/**
	 * Ex4 TestA - Checks the conversion of the String word "test" to its String signature
	 */
	@Test
	public void Ex4TestA() {
		
		String result 	= TreeDictionary.wordToSignature("test");
		String correct 	= "8378";
		
		assertEquals(correct, result);
	}
	
	/**
	 * Ex4 TestB - Checks the conversion of a String word with only non-alphabetic characters returns 
	 * a signature with four blank spaces;
	 */
	@Test
	public void Ex4TestB() {
		
		String result 	= TreeDictionary.wordToSignature("^%9/");
		String correct 	= "    ";
		
		assertEquals(correct, result);
	}
	
	/**
	 * Ex4 TestC - Checks the conversion of a blank String word returns a blank String signature
	 */
	@Test
	public void Ex4TestC() {
		

		String result 	= TreeDictionary.wordToSignature("");
		String correct 	= "";
		
		assertEquals(correct, result);
	}
	
	/**
	 * Ex4 TestD - Checks the conversion of an invalid signature returns an empty set
	 */
	@Test
	public void Ex4TestD() {

		Set<String> result 	= wordsDictionary.signatureToWords("329*");

		Set<String> correct = new HashSet<>();

		assertEquals(correct, result);

	}
	/**
	 * Ex4 TestE - Checks the conversion of an invalid signature returns an empty set
	 */
	@Test
	public void Ex4TestE() {

		Set<String> result 	= wordsDictionary.signatureToWords("hello");

		Set<String> correct = new HashSet<>();

		assertEquals(correct, result);

	}
	
	/**
	 * Ex4 TestF - Checks the conversion of an invalid signature returns an empty set
	 */
	@Test
	public void Ex4TestF() {

		Set<String> result 	= wordsDictionary.signatureToWords("");

		Set<String> correct = new HashSet<>();

		assertEquals(correct, result);

	}
	
	/**
	 * Ex4 TestG - Checks the isValid method correctly detects a valid word
	 */
	@Test
	public void Ex4TestG() {

		boolean result 	= TreeDictionary.isValidWord("hello");

		boolean correct = true;

		assertEquals(correct, result);

	}
	
	/**
	 * Ex4 TestH - Checks the isValid method correctly detects an invalid word
	 */
	@Test
	public void Ex4TestH() {

		boolean result 	= TreeDictionary.isValidWord("10-point");

		boolean correct = false;

		assertEquals(correct, result);

	}
	
	/**
	 * Ex4 TestI - Checks the isValid method correctly detects an invalid word which is just a blank string
	 */
	@Test
	public void Ex4TestI() {

		boolean result 	= TreeDictionary.isValidWord("");

		boolean correct = false;

		assertEquals(correct, result);

	}
	
	/* 
	 * --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 * THE FOLLOWING TEST USE A SHORTENED CUSTOM DICTIONARY AS BELOW
	 * --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 */

	String pathToMyTestDictionary 	= "/Users/chirag/eclipse-workspace/WS2-3/src/myTestDictionary";
	TreeDictionary myTestDictionary = new TreeDictionary(pathToMyTestDictionary);
	 
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
	 * Ex4 TestJ - Searches the custom dictionary by a signature that all the words within it match, and checks all the matching words are in lower case and without duplicates.
	 */
	@Test
	public void Ex4TestJ() {

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
	 * Ex4 TestK - Searches the custom dictionary by a signature that all the words within it match, and checks all the matching words are in lower case and without duplicates, 
	 * and prefixed to the right length.
	 */
	@Test
	public void Ex4TestK() {

		Set<String> result 	= myTestDictionary.signatureToWords("947746");

		Set<String> correct = new HashSet<>();
		correct.add("wispin");
		correct.add("wissin");
		correct.add("yippin");
		correct.add("yirrin");
		correct.add("zippin");
		
		assertEquals(correct, result); // This also establishes the returned results are in lower case, and no duplicates are provided due to Hash Set.

	}
	
	/**
	 * Ex4 TestL - Searches the custom dictionary by a signature that all the words within it match, and checks all the matching words are in lower case and without duplicates,
	 * and prefixed to the right length.
	 */
	@Test
	public void Ex4TestL() {

		Set<String> result 	= myTestDictionary.signatureToWords("94774");

		Set<String> correct = new HashSet<>();
		correct.add("wispi");
		correct.add("wissi");
		correct.add("yippi");
		correct.add("yirri");
		correct.add("zippi");
		
		assertEquals(correct, result); // This also establishes the returned results are in lower case, and no duplicates are provided due to Hash Set.

	}
	
	/**
	 * Ex4 TestM - Searches the custom dictionary by a signature that all the words within it match, and checks all the matching words are in lower case and without duplicates,
	 * and prefixed to the right length.
	 */
	@Test
	public void Ex4TestM() {

		Set<String> result 	= myTestDictionary.signatureToWords("9477");

		Set<String> correct = new HashSet<>();
		correct.add("wisp");
		correct.add("wiss");
		correct.add("yipp");
		correct.add("yirr");
		correct.add("zipp");
		
		assertEquals(correct, result); // This also establishes the returned results are in lower case, and no duplicates are provided due to Hash Set.

	}
	
	/**
	 * Ex4 TestN - Searches the custom dictionary by a signature that all the words within it match, and checks all the matching words are in lower case and without duplicates,
	 * and prefixed to the right length.
	 */
	@Test
	public void Ex4TestN() {

		Set<String> result 	= myTestDictionary.signatureToWords("947");

		Set<String> correct = new HashSet<>();
		correct.add("wis");
		correct.add("yip");
		correct.add("yir");
		correct.add("zip");
		
		assertEquals(correct, result); // This also establishes the returned results are in lower case, and no duplicates are provided due to Hash Set.

	}
	
	/**
	 * Ex4 TestO - Searches the custom dictionary by a signature that all the words within it match, and checks all the matching words are in lower case and without duplicates,
	 * and prefixed to the right length.
	 */
	@Test
	public void Ex4TestO() {

		Set<String> result 	= myTestDictionary.signatureToWords("94");

		Set<String> correct = new HashSet<>();
		correct.add("wi");
		correct.add("yi");
		correct.add("zi");
		
		assertEquals(correct, result); // This also establishes the returned results are in lower case, and no duplicates are provided due to Hash Set.

	}
	
	/**
	 * Ex4 TestP - Searches the custom dictionary by a signature that all the words within it match, and checks all the matching words are in lower case and without duplicates,
	 * and prefixed to the right length.
	 */
	@Test
	public void Ex4TestP() {

		Set<String> result 	= myTestDictionary.signatureToWords("9");

		Set<String> correct = new HashSet<>();
		correct.add("w");
		correct.add("y");
		correct.add("z");
		
		assertEquals(correct, result); // This also establishes the returned results are in lower case, and no duplicates are provided due to Hash Set.

	}
	
	/**
	 * Ex4 TestQ - Searches the custom dictionary with an empty signature ensuring that no words are stored at the rood node of the tree.
	 */
	@Test
	public void Ex4TestQ() {

		Set<String> result 	= myTestDictionary.signatureToWords("");

		Set<String> correct = new HashSet<>();
		
		assertEquals(correct, result); // 

	}
	
	/**
	 * Ex4 TestR - Searches the custom dictionary by a signature that none of the words within match, and confirms that an empty String set of matching words is returned.
	 */
	@Test
	public void Ex4TestR() {

		Set<String> result 	= myTestDictionary.signatureToWords("9477469");

		Set<String> correct = new HashSet<>();
		
		assertEquals(correct, result); 

	}
	
	/* 
	 * --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 * THE FOLLOWING TEST USE A CUSTOM DICTIONARY AS BELOW
	 * --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 */

	String pathToMyEmptyDictionary 	= "/Users/chirag/eclipse-workspace/WS2-3/src/myEmptyDictionary";
	TreeDictionary myEmptyDictionary = new TreeDictionary(pathToMyEmptyDictionary);
	
	/* 
	 * The dictionary is an empty text file thereby containing no words
	 *
	 * --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 */
	
	/**
	 * Ex4 TestS - Searches the empty custom dictionary with a valid signature and ensures an empty String set is returned
	 */
	@Test
	public void Ex4TestS() {

		Set<String> result 	= myEmptyDictionary.signatureToWords("9477464");

		Set<String> correct = new HashSet<>();

		assertEquals(correct, result);

	}
	
}

/* 
 * --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 * THE FOLLOWING TEST used 94 signatures passed as main method arguments to the Sigs2WordsTree method. 
 * The command was as below:
 * 
 * time predictive/Sigs2WordsTree 8378 42837 43556 2424678 26 465879 2 256737 387648873 47238283722683 738325464 27326 7374337 6887433 43556 2354383 4684837 269 427336 2 2327464 243 76537 2354383 843 387 844657469 226 843 73669 288363268 26567 6253 843 3424726 532837 843 5878423 22683843 7827378368 26868377278 469 226 2354383 784685283 6253 7866464732566 3278 763557 23569 2 47266284225 26843683 2 3327 272957 67767483 3278 7866464 437482837 7866464 292487 84346243368426637 26678837 36267 467433 843 73325 7226637 6398 86 843 3484333 39767873 224337 2 8636756933 836753 94369455 2 26623786 7946 8633763284 26678837 26678837 78773287 2 2677377663368 72346 68373569 7288537 26 864325849 569
 * 
 * The results of this were 4.77s user / 0.38s / system 244% / cpu 2.106 total
 * --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 */