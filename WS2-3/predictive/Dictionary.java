package predictive;

import java.util.Set;

/**
 * The interface Dictionary is an interface to any dictionary classes.
 * It will be utilised for converting T9 numeric signatures to predicted words.
 *  
 * @author Chirag Bhatti
 * @version 2020-02-18
 */
public interface Dictionary {
	
	/** 
	 * SignatureToWords is a method to be implemented with instructions of how to convert numeric T9 String signatures to their predicted
	 * String words.
	 * 
	 * @param signature, is the numeric T9 String signature to be converted
	 * @return a set of Strings containing the individual words matching the T9 numeric signature as Strings
	 */
	public Set<String> signatureToWords(String signature);
	
}
