package predictive;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * ListDictionary is a class that implements the interface Dictionary. The class provides the storage of a dictionary containing 
 * String words and their equivalent T9 String numeric signatures in an Array List. The class also contains a method for converting 
 * given words to T9 numeric signatures, and a method to convert numeric signatures to predicted words using the stored dictionary.
 * 
 * We establish two field variables:
 * path - is a String of the file path where a text file of the Dictionary to be stored is kept (words are split line by line)
 * dictionary - is an ArrayList of type WordSig containing all pairs of words and numeric signatures based on the dictionary
 * 
 * @author Chirag Bhatti
 * @version 2020-02-18
 */
public class ListDictionary implements Dictionary {

	private String path;
	private ArrayList <WordSig> dictionary;

	/**
	 * List dictionary is a constructor for creating the ArrayList of the Dictionary words coupled with their T9 numeric signatures
	 * @param path, is a String of the file path where a text file of the Dictionary is kept
	 */
	public ListDictionary(String path) {
		this.path = path;
		this.dictionary = new ArrayList <WordSig>();

		try {
			Scanner s = new Scanner(new File(path));

			while(s.hasNext()) {

				String word = s.next();

				if (isValidWord(word)) {

					String signature 	= wordToSignature(word);
					WordSig wordsig 	= new WordSig(word, signature);

					dictionary.add(wordsig); 

				}

			}
			
			s.close(); 						// To prevent resource leaks
			Collections.sort(dictionary); 	// Once populated, the ArrayList is sorted to allow for efficient searches in it in future=

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @return the path of the dictionary text file as a String
	 */
	public String getPath() {
		return path;
	}

	/**
	 * 
	 * @return the dictionary object which is an ArrayList of type WordSig
	 */
	public ArrayList<WordSig> getDictionary() {
		return dictionary;
	}

	/**
	 * Sets the path of the dictionary text file
	 * @param path
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * Sets the stored dictionary to be used
	 * @param dictionary
	 */
	public void setDictionary(ArrayList<WordSig> dictionary) {
		this.dictionary = dictionary;
	}

	/** 
	 * wordToSignature is a method to convert a word to a numeric signature based on the T9 predictive typing method
	 * The approach needed is identical to the same method within the class PredictivePrototype so we reuse its code.
	 * @param word is the word to be converted as type String
	 * @return signature is a String of the numeric signature determined
	 */
	public static String wordToSignature(String word) {

		return PredictivePrototype.wordToSignature(word);
	}

	/**
	 * signatureToWords is a method required to be implemented as per the Dictionary interface
	 * The method takes a T9 numeric String signature and locates the first index that matches the signature in the ArrayList dictionary, 
	 * using the binary search algorithm. 
	 * The method then checks for further matching signatures above and below the index. 
	 * All words in the dictionary that match the signature are then returned.
	 * 
	 * @param signature, is the numerical String signature to be searched in the ArrayList Dictionary
	 * @return words, which a is String set of words corresponding to the signature from the Dictionary.
	 */
	@Override
	public Set<String> signatureToWords(String signature) {

		Set<String> words = new HashSet<>();
		
		/* If the signature is valid i.e. it only contains numerical characters in its String, then we proceed to a search */
		if (signature.matches("[0-9]+")) { 

			/* Search only for matching signature Strings, find the index of the first match */
			int index = Collections.binarySearch(dictionary, new WordSig(null, signature)); 

			if (index < 0)
				
				/* If the binary search found no matching signatures in our dictionary, we return an empty set as the index given will be negative */
				return words; 

			/* Search and check indexes before and including the first matched index */
			for (int i = index; i >= 0; i--) { 

				/* If the signatures are the same */
				if (dictionary.get(i).getSignature().equals(signature))
					
					/* If the word in the dictionary is valid otherwise we aren't interested in it */
					if (isValidWord(dictionary.get(i).getWord())) 
						
						/* Add any further matches as lower case words */
						words.add(dictionary.get(i).getWord().toLowerCase()); 

					else
						
						/* If the signatures no longer match we don't need to continue looking at indexes before and incl. the first match */
						break; 
			}

			/* Search and check indexes after the first matched index */
			for (int i = (index + 1); i < dictionary.size(); i++) { 

				/* If the signatures are the same */
				if (dictionary.get(i).getSignature().equals(signature)) 
					
					/* If the word in the dictionary is valid otherwise we aren't interested in it */
					if (isValidWord(dictionary.get(i).getWord())) 
						
						/* Add any further matches as lower case words */
						words.add(dictionary.get(i).getWord().toLowerCase()); 

					else 
						
						/* If the signatures no longer match we don't need to continue looking at indexes after the first match */
						break; 
			}

			/* Return the set once we have check all indexes with matching signatures either side of the first matching index */
			return words; 
		}

		/* Return an empty set if the signature is invalid */ 
		return words; 
	}

	/**
	 * isValidWord is a helper method to ascertain whether a String word from a dictionary can be deemed valid, as long as no special 
	 * or numerical characters are contained in the String. We reuse the static method from PredictivePrototype.
	 * @param word, is a String of the dictionary word to be assessed
	 * @return boolean true if the word is valid otherwise false
	 */
	public static boolean isValidWord(String word) {

		return PredictivePrototype.isValidWord(word); // If the word contains anything other than alphabetic characters, it is deemed invalid.

	}

}

