/** 
 * The problem with the code was the due to both uses of the IllegalArgumentException.
 * By doing this, there was no opportunity to signal that there was an error with the instrument
 * and to register a value of -1 as an exception was thrown instead.
 * 
 * The code was fixed by replacing the first throw exception with a return of -1 (see commented out exception)
 * This meant, whenever a 0 was simulated to have been read by the instrument, it could be assumed there was an error
 * and therefore this could be flagged by returning a -1 to the measurementSeries calling the 
 * measurement method.
 * The second illegal argument exception was also removed (commented out below), in order to allow the -1 measurement error
 * flag to be stored in the results array.
 *
 * ----
 * 
 *  The class firstly simulates a measurement performed by an
 *  instrument and that can take on two different values, 1 and 2. The
 *  instrument may also malfunction. We perform a series of
 *  measurments and store the values in the an array and print this
 *  out.
 *
 *  @author Chirag Bhatti
 *  @version 08/11/2018
 */
public class Measurement {

    /**
     *  The method is used to simulate an instrument that randomly
     *  return either 1 or 2, or malfunctions.
     *  @return The method returns randomly either 1 or 2.
     *  @exception IllegalArgumentException if the instrument
     *  malfunctions. This is simulated only and done when a random
     *  number of 0 is created (out of numbers 0, 1, or 2).
     */ 
    public static int measurement() {
        //Create a random integer of either 0, 1, or 2.
        int res = (int) (Math.random() * 3);
        if (res == 0) {
            return -1;
            // throw new IllegalArumentException();
        } else {
            return res;
        }
    }

    /**
     *  The method stores the result of n measurements in an array and
     *  return this.
     *  @param n The number of measurements.
     *  @return An array with the result of n measurements being
     *  either 1 or 2. If the measurement failed, a -1 is stored in
     *  the array.
     *  @exception IllegalArgumentException if the result of the
     *  measurement is -1. */ 
    public static int[] measurementSeries(int n) {
        int[] result = new int[n];
        //Loop to do exactly n measurments
        for (int i = 0; i < n; i++) {
            if (measurement() == -1) {
                result[i] = -1;
                // throw new IllegalArgumentException();
            }
            else {
                result[i] = measurement();
            }
        }
        return result;
    }

    /**
     *  Print out the elements of a one-dimensional integer array,
     *  separated by empty spaces.
     *  @param a A one-dimensional int array.
     */
    public static void printArray(int[] a) {
        for (int el : a) {
            System.out.print(el + " ");
        }
        System.out.println();
    }

    /* 
     * Main method to test the program with 10 measurements.
     */
    public static void main(String[] args) {
        printArray(measurementSeries(10));
    }
}
