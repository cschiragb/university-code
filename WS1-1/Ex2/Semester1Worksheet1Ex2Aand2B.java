/** Semester1 Worksheet1 Ex2A and Ex2B combined -  Conversion from Imperial mass units to Kilograms
 * The class will calculate the total number of pounds, and then multiply by the conversion number to determine pounds to kilograms
 */

public class Semester1Worksheet1Ex2Aand2B
{
    public static double imperialToKg(double ton, double hundredweight, double quarter, double stone, double pound, double ounce, double drachm, double grain)
	
    {
	/* The variables in this equation are listed in the same order as the type declarations above for the static double method. */
        /* This makes it easier to populate the arguments in the correct order in the main method below */
	
	return ((( ton * 2240 ) + ( hundredweight * 112 ) + ( quarter * 28 ) + ( stone * 14 ) + ( pound ) + ( ounce * (1/16) ) + ( drachm * (1/256) ) + ( grain * (1/7000))) * 0.45359237);

    }

    public static void main(String[] args) {
	
	System.out.println(imperialToKg(0,0,0,11,6,0,0,0));
    }
}

	 
       
