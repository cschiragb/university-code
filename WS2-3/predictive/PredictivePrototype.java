package predictive;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * PredictivePrototype is a class that provides prototype methods to convert words to their number signatures
 * and vice versa based on the T9 prediction method. Words and signatures are handled as Strings.
 * 
 * No field variables are established in this class.
 * 
 * @author Chirag Bhatti
 * @version 2020-02-18
 */
public class PredictivePrototype {

	/**
	 * wordToSignature is a method to convert a word to a numerical signature. The method only considers 
	 * alphabetical characters in the word, non-alphabetics are given a blank space in the signature.
	 * @param word, is the String that is to be converted to a numerical signature
	 * @return a String of the numerical signature
	 */
	public static String wordToSignature(String word) {

		/*
		 * Because Strings are immutable / can't be edited in Java, unless overwritten, we utilise
		 * StringBuffer in order to accumulate the String signature character by character.
		 * This is more efficient because we won't have to store and combine separate String variables 
		 * instead after each iteration of the for-loop below. 
		 */
		StringBuffer signature = new StringBuffer();

		String[] chars = word.split(""); //Split the signature into a String array of its individual characters

		/*
		 * Cover the case where a String which is just "" is passed in as the word.
		 * If we do not include this code, the signature will return as "2".
		 */
		if (chars.length == 1 && chars[0].equals("")) {
			
			signature.append("");
			return signature.toString();
			
		}

		for (int i = 0; i < chars.length; i++) {

			if ("abcABC".contains(chars[i]))
				signature.append("2");
			else if ("defDEF".contains(chars[i]))
				signature.append("3");
			else if ("ghiGHI".contains(chars[i]))
				signature.append("4");
			else if ("jklJKL".contains(chars[i]))
				signature.append("5");
			else if ("mnoMNO".contains(chars[i]))
				signature.append("6");
			else if ("pqrsPQRS".contains(chars[i]))
				signature.append("7");
			else if("tuvTUV".contains(chars[i]))
				signature.append("8");
			else if ("wxyzWXYZ".contains(chars[i]))
				signature.append("9");
			else 
				signature.append(" ");
		}
		
		return signature.toString();
	}

	/**
	 * signatureToWords is a method to convert a numeric signature into possible predicted words based on the T9 format, 
	 * referencing a given dictionary text file containing a list of words.
	 * @param signature, is the numeric String signature to be converted
	 * @return matchingWords, is a Set of possible words as Strings that match the given numeric signature
	 */
	public static Set<String> signatureToWords(String signature) {

		Set<String> matchingWords = new HashSet<>(); // We use HashSet as we're only interested in unique words that match

		if (signature.matches("[0-9]+")) {

			try {

				/* It would be inefficient to store the dictionary in the Java program. 
				 * This would result in a large data structure that would likely be sorted in word
				 * order rather than its matching signature order. 
				 * It would be time inefficient to search through this dictionary to find all
				 * possible words that match a given signature due to its unsorted nature and size.
				 * Hence we scan through the dictionary text file line by line instead.
				 */
				Scanner s = new Scanner(new File("words"));

				while (s.hasNext()) {

					String word = s.next();

					if (isValidWord(word) && signature.equals(wordToSignature(word))) {

						matchingWords.add(word.toLowerCase()); //all returned matching words must be lower case
					}
				}

				s.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

			return matchingWords;
		}

		else { 
			
			return matchingWords;
			
		}

	}

	/**
	 * isValidWord is a helper method to ascertain whether a String word from a dictionary can be deemed valid, as long as no special 
	 * or numerical characters are contained in the String. 
	 * @param word, is a String of the dictionary word to be assessed
	 * @return boolean true if the word is valid otherwise false
	 */
	public static boolean isValidWord(String word) {

		return word.matches("^[a-zA-Z]+"); // If the word contains anything other than alphabetic characters, it is deemed invalid.

	}
}
