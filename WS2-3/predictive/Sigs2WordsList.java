package predictive;

/**
 * Sigs2WordsList is a class to enable a user to provide T9 numerical String signatures to the command line and return back the predicted 
 * words by looking up a stored Dictionary.
 * 
 * No field variables are established in this class
 * 
 * @author Chirag Bhatti
 * @version 2020-02-09
 */
public class Sigs2WordsList {

	/**
	 * The main method is used to pass numerical String arguments into a String array via the command line. 
	 * The method then calls the signatureToWords method of the DictionaryList class to carry out the conversion.
	 * @param args is an array of Strings passed via the command line, containing the words to be converted
	 */
	public static void main(String[] args) {

		String path 		= "/Users/chirag/eclipse-workspace/WS2-3/words"; // Provide a path to a dictionary text file
		ListDictionary test = new ListDictionary(path); // Create a new ListDictionary object based on the file

		for (int i = 0; i < args.length; i++) {
			
			/*
			 * For each numerical signature, print out the predicted words on the same line
			 */
			System.out.println(args[i] + " " + ":" + " " + test.signatureToWords(args[i]));
		}

	}
}
