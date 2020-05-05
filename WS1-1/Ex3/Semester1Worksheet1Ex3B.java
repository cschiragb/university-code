/** Semester 1 Worksheet 1 Exercise 3B
 * The class calculates the anti-clockwise angle between the hours and minutes hand of a clock, based on the time given in a 24-hour format.
 * The method converts the clock reading from 24hour to 12hour format in order to make it easier to compute the angle.
 * Results are also normalised so that the anti-clockwise angle returned is an integer between 0 and 359 (does not read negative angles).
 * Notably, the movement of the hour hand based on the minutes elapsed, as well as the movement of both the hands (though marginal) based on the seconds elapsed is also considered
 */ 

public class Semester1Worksheet1Ex3B
{
    public static int timeToAngle(int hours, int minutes, double seconds)
    {
	
    /* This method has all the steps to compute the anti-clockwise angle between the hours and minutes hand of a clock */
	
	int hours12format = hours % 12;
	/* this converts the hours from a 24-hour to a 12-hour format */
	
	double hourscoreangle =     ((double) hours * 30);
	/* this calculates the intial hour hand angle position, clockwise from 12 o'clock based purely on number of hours elapsed */

	double hourscorrection =    ((double)  ((minutes / 60.0) * 30) + ((seconds / 3600.0) * 30));
	/* this calculates the additional hour hand angle movement, based on the number of minutes and seconds elapsed. Allows fractional numbers */

	double hoursangle =         (hourscoreangle + hourscorrection);
	/* calculates the final hour angle position, clockwise from 12 o'clock */

	double minutescoreangle =   ((double) minutes * 6);
	/* calculates the initial minutes hand angle position, clockwise from 12 o'clock based purely on the number of minutes elapsed */
	
	double minutescorrection =  ((double) (seconds / 60.0) * 6);
	/* this calculates the additional minute hand angle movement, based on the number of seconds elapsed */
	
	double minutesangle =       (minutescoreangle + minutescorrection);
	/* this calculates the final minute angle position, clockwise from 12 o'clock */

	double anglebetween =       Math.round((hoursangle - minutesangle));
	/* calculates the angle between the hours hand and the minutes hand and rounds the number to ensure the nearest integer is returned */
	
	double ANTICWanglebetween = (((360 + anglebetween) % 360));
	/* this normalise the angle from 0 - 359. If the anglebetween returns as negative, it will also return it as a positive anti-clockwise angle */

	return ((int) (ANTICWanglebetween));
	/* returns the final angle as an integer, as required by the method */
	}

    public static void main (String[] args)
    {

	/* Contains all the times requested for computations as a list of arguments */

	System.out.println(timeToAngle(0,0,20));                /* Time 0:00:20 */
	System.out.println(timeToAngle(13,05,27.272727272727)); /* Time 13:05:272727272727 */
    }
}
