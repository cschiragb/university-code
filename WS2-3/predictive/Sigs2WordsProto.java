package predictive;

/**
 * Sigs2WordsProto is a class to enable a user to provide numerical String signatures to the command line and return back the predicted 
 * words based on T9 prediction method.
 * 
 * No field variables are established in this class
 * 
 * @author Chirag Bhatti
 * @version 2020-02-09
 */
public class Sigs2WordsProto {

	/**
	 * The main method is used to pass numerical String arguments into a String array via the command line. 
	 * The method then calls the signatureToWords method of the PredictivePrototype class to carry out the conversion.
	 * @param args is an array of Strings passed via the command line, containing the words to be converted
	 */
	public static void main(String[] args) {
		
		for (int i = 0; i < args.length; i++) {
			
			/*
			 * For each numerical signature, print out the predicted words on the same line
			 */
			System.out.println(args[i] + " " + ":" + " " + PredictivePrototype.signatureToWords(args[i]));
		}
	}
}