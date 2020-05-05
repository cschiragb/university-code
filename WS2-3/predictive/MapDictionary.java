package predictive;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * MapDictionary is a class that implements the interface Dictionary. 
 * The class provides the storage of a dictionary in a hash map using signatures as the key and the words as values, stored in a hash set. 
 * The class also contains a method for converting given words to their T9 numeric signatures.
 * 
 * We establish two field variables:
 * path - is a String of the file path where a text file of the Dictionary to be stored is kept (words are split line by line)
 * mapDictionary - is a HashMap containing String signatures as the key, and a hashSet of Strings stored as the matching words to the signature.
 * 
 * @author Chirag Bhatti
 * @version 2020-02-18
 */
public class MapDictionary implements Dictionary{

	private String path;
	private HashMap<String, HashSet<String>> mapDictionary ;

	/**
	 * mapDictionary is a constructor for creating the map of the T9 numeric signatures with their accompanying set of matching words.
	 * @param path, is a String of the file path where a text file of the Dictionary is kept that will be used to populate the map
	 */
	public MapDictionary(String path) {

		this.path 			= path;
		this.mapDictionary 	= new HashMap<String, HashSet<String>>();
		/*
		 * The map works by linking keys (in this case numerical String signatures) to values (in this case a HashSet with Strings of Words).
		 * When putting an item in the map, the hashing function of the key is called (in this case a String) to find the bucket location 
		 * where the corresponding value will be stored. The location is an index of the internal array known as the hash table. When getting
		 * an object, the key to be looked up is again "hashed" and this generates the same hash code as any same key stored in the table, 
		 * allowing retrieval from the correct bucket location.
		 * A Hashmap is chosen as it offers typically O(1) performance for insertion and retrieval operations. These operations are used frequently 
		 * during the population of our dictionary within the Hashmap data structure as below. 
		 */

		try {
			Scanner s = new Scanner(new File(path));

			while(s.hasNext()) {

				String word = s.next();

				if (isValidWord(word)) {

					String signature = wordToSignature(word);

					if (mapDictionary.containsKey(signature)) { 			// it the key is already in the map

						HashSet<String> set = mapDictionary.get(signature); // get the corresponding value to the key
						set.add(word.toLowerCase()); 						// add the word to the value set
						mapDictionary.put(signature, set); 					// put the updated set back in the map against the key

					} else { 												// if the key isn't already in the map

						HashSet<String> newSet = new HashSet<String>(); 	// make an empty hash set
						newSet.add(word.toLowerCase()); 					// add the word to the hash set
						mapDictionary.put(signature, newSet); 				// put the set with the word added against the key into the map
					}
				}
			}

			s.close(); // To prevent resource leaks

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
	 * Sets the path of the dictionary text file
	 * @param path
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * 
	 * @return the mapDictionary as a hash map of the signatures as keys and hashset of words as the values
	 */
	public HashMap<String, HashSet<String>> getMapDictionary() {
		return mapDictionary;
	}

	/**
	 * Sets the map dictionary to the hash map provided in the arguments
	 * @param mapDictionary
	 */
	public void setMapDictionary(HashMap<String, HashSet<String>> mapDictionary) {
		this.mapDictionary = mapDictionary;
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
	 * The method takes a T9 numeric String signature and locates the set of words stored against the signature key
	 * in the hash map
	 * 
	 * @param signature, is the numerical String signature to be searched in the ArrayList Dictionary
	 * @return a String set of words corresponding to the signature from the Dictionary.
	 */
	@Override
	public Set<String> signatureToWords(String signature) {

		if (mapDictionary.containsKey(signature)) {
			return mapDictionary.get(signature);
		}

		else
			return new HashSet<String>();
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
