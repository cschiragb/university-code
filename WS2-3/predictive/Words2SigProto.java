package predictive;

/**
 * Words2SigProto is a class to enable a user to provide String word(s) to the command line and return back the equivalent 
 * T9 numeric signature(s).
 * 
 * No field variables are established in this class
 * 
 * @author Chirag Bhatti
 * @version 2020-02-09
 */
public class Words2SigProto {
	
	/**
	 * The main method is used to pass String word arguments required for conversion to their respective T9 numeric signatures.
	 * The method calls the wordToSignature method of the PredictivePrototype class to perform the conversion and the
	 * returned results are printed back in the command line.
	 * @param args, is the array of String words passed via the command line that need to be converted
	 */
	public static void main(String[] args) {
		
		for (int i = 0; i < args.length; i++) {
			
			/* 
			 * Print out the matching signature to each word on a separate line in the command window
			 */
			System.out.println(PredictivePrototype.wordToSignature(args[i]));
		}
	}
}
 