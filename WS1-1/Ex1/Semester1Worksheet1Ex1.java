/** Semster 1 Worksheet 1 Ex1 - Calculating the area of a circle
 * The program takes the radius as an argument and returns the area of a cirlce using the expression 
 * Pi * radius * radius. 
 * Rather than use square, we simply multiply by radius twice
 * The program will return the calculated area with type double
 */ 

public class Semester1Worksheet1Ex1
{
    public static double areaCircle(double radius)
    {
	/* formula for area of a cirlce */
	return Math.PI * radius * radius; 
    }

    public static void main(String[] args)
    {
	/* Arguments for the requested radiuses requiring computation are provided here. 
Println ensures the output results are printed on separate lines in the terminal */
	
	System.out.println("The area of a circle with radius 0 is: " + areaCircle(0));
	System.out.println("The area of a circle with radius 5 is: " + areaCircle(5));
        System.out.println("The area of a cirlce with radius 10 is: " + areaCircle(10));
	
    }
}
    
	    
