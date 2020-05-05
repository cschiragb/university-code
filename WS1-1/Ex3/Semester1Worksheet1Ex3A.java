/** Semester 1 Workshet 1 Exercise 3A
 * The class calculates the anti-clockwise angle between the hours and minutes hand of a clock, based on the time given in a 24-hour format.
 * The method converts the clock reading from 24hour to 12hour format in order to make it easier to compute the angle.
 * Results are also normalised so that the anti-clockwise angle returned is an integer between 0 and 359 (does not read negative angles).
 * Notably, the movement of the hour hand based on the minutes elapsed is also considered.
 */

public class Semester1Worksheet1Ex3A
{
    public static int timeToAngle(int hours, int minutes)
    {
	/* The method has all the steps to compute the anti-clockwise angle between the hours and minutes hand of a clock */

	
	int hours12format =         hours % 12;
	/* this converts the hours from a 24-hour to 12-hour format */
	
	double hourscoreangle =     (hours12format * 30);
	/* this calculates the initial hour hand angle position, clockwise from 12 o'clock based purely on number of hours elapsed */
	
	double hourscorrection =    ((minutes / 60.0) * 30);
	/* this calculates the additional hour hand angle movement, based on the number of minutes elapsed. Allows fractional numbers */
	
	double hoursangle =         (hourscoreangle + hourscorrection);
	/* calculates the final hour angle position, clockwise from 12 o'clock */

	double minutesangle =       (minutes * 6);
	/* calculates the minute angle position, clockwise from 12 o'clock */
	
	double anglebetween =       Math.round(hoursangle - minutesangle);
	/* calculates the angle between the hours hand and the minutes hand and rounds the number to ensure the nearest integer is returned. */
	
	double ANTICWanglebetween = ((360 + anglebetween) % 360);
	/* this normalises the angle to 0 - 359. If the anglebetween returns as negative, it will also return it as a positive anticlockwise angle */

	return ((int) ANTICWanglebetween);
	/* returns the final angle as an integer, as required by the method */
	}

    public static void main (String[] args)
    {

	/* contains all the times requested for computation as a list of arguments */
	
	System.out.println(timeToAngle(9,0));  /* Time 9:00  */
	System.out.println(timeToAngle(3,0));  /* Time 3:00  */
	System.out.println(timeToAngle(18,0)); /* Time 18:00 */
	System.out.println(timeToAngle(1,0));  /* Time 1:00  */
	System.out.println(timeToAngle(2,30)); /* Time 2:30  */
	System.out.println(timeToAngle(4,41)); /* Time 4:41  */
    }
}
