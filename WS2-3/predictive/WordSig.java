package predictive;

/**
 * WordSig is a class that defines the pairing of a dictionary String word to it's T9 numerical String signature.
 * We establish two field variables:
 * 
 * word - is a String of the dictionary word 
 * signature - is a String of the T9 numerical signature to be paired with the word
 * 
 * @author Chirag Bhatti
 * @version 2019-02-18
 *
 */
public class WordSig implements Comparable<WordSig> {

	private String word;
	private String signature;
	
	/**
	 * WordSig is a constructor for the creation of a word signature pairing
	 * @param word - is a String of the dictionary word to be paired
	 * @param signature - is a String of the T9 numeric signature to be paired with the word
	 */
	public WordSig (String word, String signature) {
		this.word = word;
		this.signature = signature;
	}

	/**
	 * 
	 * @return the dictionary word
	 */
	public String getWord() {
		return word;
	}
	
	/**
	 * 
	 * @return the T9 numeric signature
	 */
	public String getSignature() {
		return signature;
	}
	
	/**
	 * Set the dictionary word for the pairing
	 * @param word as a String
	 */
	public void setWord(String word) {
		this.word = word;
	}
	
	/**
	 * Set the T9 numeric signature to be paired with the dictionary word
	 * @param signature as a String of numerics
	 */
	public void setSignature(String signature) {
		this.signature = signature;
	}
	
	/**
	 * CompareTo is a method required to be implemented as per the Comparable Interface from the Java API
	 * The method provides a means to compare WordSig objects based on their numerical signatures
	 */
	@Override
	public int compareTo(WordSig ws) {
				
		return this.getSignature().compareTo(ws.getSignature()); // Compare using the numerical String Signatures
		
	}

	/**
	 * toString is a method stating how the pairing of a dictionary word and numeric signature should be printed
	 */
	@Override
	public String toString() {
		return word + " " + ":" + " " + signature;
	}
	
	
}
