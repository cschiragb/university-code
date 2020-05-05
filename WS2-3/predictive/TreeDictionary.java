package predictive;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * TreeDictionary is a class that implements the interface Dictionary.
 * The class provides the storage of a Dictionary in a recursive tree data structure. Each node in the data structure holds a 
 * set of words predictably possible, as well an array of TreeDictionaries, each branch of which corresponds to 1 of 8 possible 
 * numerals that may exist in the signature string. No words are stored at the root node of the tree.
 * 
 * We establish four field variables.
 * path - is a String of the file path where a text file of the Dictionary to be stored is kept (words are split line by line)
 * words - is a HashSet of Strings where predicted words are saved in their full length
 * children - is an Array of TreeDictionary objects (thereby making it recursive) which correspond to one of 8 subtrees where
 * again words and children can be stored i.e. further TreeDictionary objects.
 * depth - is initialised to zero for the very first time a tree is constructed. The depth is updated recursively for deeper nodes.
 * 
 * @author Chirag Bhatti
 * @version 2020-02-18
 *
 */
public class TreeDictionary implements Dictionary {

	private String path;
	private HashSet<String> words;
	private TreeDictionary[] children;
	private int depth = 0;

	/**
	 * TreeDictionary is a constructor for creating a recursive tree data structure storing a dictionary. Here nodes will store 
	 * predicted words according to the current signature that would have led to the node.
	 * @param path, is a String of the file path where a text file of the Dictionary is kept that will be used to populate the tree
	 */
	public TreeDictionary(String path) {

		this.path 		= path;
		this.words 		= new HashSet<String>(); // initialise an empty set
		this.children 	= new TreeDictionary[8]; // initialise array of size 8 to correspond to numbers 2 to 9 of a T9 keypad

		try {
			Scanner s = new Scanner(new File(path));

			while(s.hasNext()) {

				String word = s.next();

				if (PredictivePrototype.isValidWord(word)) {

					String signature = PredictivePrototype.wordToSignature(word);

					insert(this, word.toLowerCase(), signature); // call the recursive insert method on this object

				}
			}

			s.close(); // To prevent resource leaks

		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	/**
	 * TreeDictionary is an overloaded constructor that creates an empty node at any depth in the recursive tree data structure.
	 * The object can be stored in the TreeDictionary array.
	 */
	public TreeDictionary () {
		this.words 		= new HashSet<String>(); 	// initialise an empty set
		this.children 	= new TreeDictionary[8]; 	// initialise array of size 8 to correspond to numbers 2 to 9 of a T9 keypad
		this.path 		= null; 					// no path necessary for additional nodes, only for initiating population of a tree
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
	 * @return a Set of words as Strings
	 */
	public Set<String> getWords() {
		return words;
	}

	/**
	 * Sets the Set of String words at a given node in the tree
	 * @param words
	 */
	public void setWords(HashSet<String> words) {
		this.words = words;
	}

	/**
	 * 
	 * @return the array of TreeDictionary objects, i.e. subtrees / children corresponding to keypad numbers 2 to 9.
	 */
	public TreeDictionary[] getChildren() {
		return children;
	}

	/**
	 * Sets the subtrees of a node to the array of TreeDictionary objects provided
	 * @param children
	 */
	public void setChildren(TreeDictionary[] children) {
		this.children = children;
	}

	/**
	 * 
	 * @return the depth of a node in the tree as an integer
	 */
	public int getDepth() {
		return depth;
	}

	/**
	 * Sets the depth of a node in the tree as an integer
	 * @param depth
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}

	/**
	 * insert is an instance method that decides and can add words to the tree dependent on the depth of the node
	 * the recursive call is on.
	 * @param treeDictionary, is the treeDictionary object to be inserted into given by keyword this. It is also
	 * used for subtrees on recursive calls on the "this" tree.
	 * @param word, is the word String to be inserted into the tree at various depths
	 * @param signature, is the signature String used to determine which subtrees / nodes the words will be added
	 * to and to determine the depth of the nodes the word should be added to.
	 */
	public void insert(TreeDictionary treeDictionary, String word, String signature) {

		if (treeDictionary.getDepth() == 0) { 

			boolean addWord = false; 									// Don't add words to the set at the root node
			insertHelper(treeDictionary, word, signature, addWord); 	// call the insert helper method

		} else if (treeDictionary.getDepth() == signature.length()) { 	// Once on the last node recursion stops
			
			treeDictionary.getWords().add(word); 						// Add word to the set only once we're upto the desired depth

		} else { 

			boolean addWord = true; 									// We need to add words to the set at the node
			insertHelper(treeDictionary, word, signature, addWord); 	// call the insert helper method

		}

	}

	/**
	 * insert is an instance method that recursively inserts a word and/or treeDictionary objects into a tree, such
	 * that the word could be predicted by entering the partial to full signature that tallies with the word, by
	 * traversing the tree according to the word's signature.
	 * @param treeDictionary, is the treeDictionary object to be inserted into given by keyword this. It is also
	 * used for subtrees recursively.
	 * @param word, is the word String to be inserted into the tree at various depths
	 * @param signature, is the signature String used to determine which subtrees / nodes the words will be added
	 * to and to determine the depth the word should be added to.
	 * @param addWord
	 */
	public void insertHelper(TreeDictionary treeDictionary, String word, String signature, boolean addWord) {

		/*
		 * This code attains the character of the signature, based on the depth of the node in the tree we are
		 * working with, and converts it into an an integer
		 */
		String signatureChar 	= String.valueOf(signature.charAt(treeDictionary.getDepth()));
		int signatureCharInt 	= Integer.parseInt(signatureChar);

		if (addWord)
			treeDictionary.getWords().add(word); 							// add word to the set if the boolean is true

		
		if (treeDictionary.getChildren()[signatureCharInt - 2] == null) {   // check subtree corresponding to signature numat a given node depth is null

			TreeDictionary newTree = new TreeDictionary(); 					// because it's null make a new subtree
			newTree.setDepth(treeDictionary.getDepth() + 1); 				// make the depth of the subtree plus 1 of the current

			treeDictionary.getChildren()[signatureCharInt - 2] = newTree; 	// add the new tree to the array

			insert(newTree, word, signature); 								// call insert recursively on the subtree

		} else {

			/* if the subtree we need already exists we call insert on it recursively */
			insert(treeDictionary.getChildren()[signatureCharInt - 2], word, signature); 
		}
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
	 * The method takes a T9 numeric String signature and returns a set of matching word prefixes
	 * 
	 * @param signature, is the numerical String signature to be searched in the TreeDictionary
	 * @return a is String set of prefixes corresponding to the signature length
	 */
	@Override
	public Set<String> signatureToWords(String signature) {

		Set<String> prefixes 	= new HashSet<String>(); 				// initialise a set to store our prefixes to

		if (signature.matches("[0-9]+")) { 								// ensuring the signature only contains numerals

			Set<String> words = searchTreeDictionary(this, signature); 	// call the helper to search the tree

			if (words.isEmpty()) 										// if nothing is found in the tree
				return words; 											// return the empty set
			
			else
				/* create prefixes of each word contained in the set in the tree with the same length as the signature */
				words.forEach((x) -> { prefixes.add(x.substring(0, signature.length())); } ); 
				return prefixes;

		} else {
			return prefixes; 											// return an empty set if the signature is invalid
		}
	}

	/**
	 * searchTreeDictionary is recursive helper method to find the set of words stored at the relevant
	 * node dependent on the signature provided. The set will be returned at a node whose depth is equal
	 * to the length of the signature so that predicted words can be provided.
	 * 
	 * @param treeDictionary is the TreeDictionary object to be searched in recurisvely
	 * @param signature, is the String signature to be used to traverse the tree and subtrees accordingly
	 * @return a Set String of words that would be predicted as a result of the signature being pressed in
	 * a T9 keypad
	 */
	public Set<String> searchTreeDictionary(TreeDictionary treeDictionary, String signature) {

		String signatureChar; 	
		int signatureCharInt; 	

		if (treeDictionary.getDepth() == signature.length()) {
			return treeDictionary.getWords(); // once at the depth required, returned the set

		} else {

			/* determine the integer of the signature we are interested in based on current depth in the tree */
			signatureChar 		= String.valueOf(signature.charAt(treeDictionary.getDepth()));
			signatureCharInt 	= Integer.parseInt(signatureChar);
			
			/* 
			 * if there is no subtree to traverse where we might have expected to, it means no words in the tree
			 * correspond to the signature given so an empty set is returned
			 */
			if (treeDictionary.getChildren()[signatureCharInt - 2] == null) 
				return new HashSet<String>();

			else
				/* recursively traverse the subtree based on the signature integer of interest */
				return searchTreeDictionary(treeDictionary.getChildren()[signatureCharInt - 2], signature);

		}
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
