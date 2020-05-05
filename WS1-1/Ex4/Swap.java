
/* The original code did not work because:
   (1) - When going to print the values after the "swapping", the i and k being referred to were the instance variables in the main method rather than those from the swap method
   (2) - The variables in the swap method cannot be accessed brought in by the main method as they are local to the method. Only a variable declared for the class would be acessible. 
   See where the comments (1) and (2) apply in the code below:
*/

/*
public class Swap {
/**
 * swaps i and j
 * @param i 1st variable.
 * @param j 2nd variable.
 */

/*
    public static void swap(int i, int j){
        i = j; // as per comment (2) above
	j = i; // as per comment (2) above
    }

    public static void main(String[] args){
	int i = 2;
	int k = 6;
	System.out.println("Original i: " + i + " k: " + k);

	swap(i,k);
	System.out.println("After swapping i: " + i + " k: " + k); // as per comment (1) above

    }
}

*/


/* -------------------------------------------- */
/* One correct way to do this would be as below */

public class Swap {
    
/**
 * swaps i and j
 * @param i 1st variable.
 * @param j 2nd variable.
 */

    public static int i; /* declares variable i for the class */
    public static int j; /* declares variable j for the class */

    /* This method will enable a swap of the variable values by changing the value of the class variables, which we can then print in the main method below */
    public static void variableSwapper(int i, int j){
	Swap.i = j; 
	Swap.j = i;
    }

    /* The main method will set the initial values of i and j and print the results before and after the swap */
    public static void main(String[] args){
	int i = 2; /* value to be used for the initial state */
	int j = 6; /* value to be used for the initial state */
	
	System.out.println("Original i: " + i + " j: " + j); /* prints values of i and j in the initial state from as provided above */

	variableSwapper(i,j);
	System.out.println("After swapping i: " + Swap.i + " j: " + Swap.j); /*  prints the value of i and j from the Swap Class which were manipulated by the variableSwapper method */

    }
}


/* -------------------------------------------------------------------------------------------------------- */
/* Notably, another way to do this is by using just a main method and introducing a third variable as below */

/*
public class Semester1Worksheet1Ex4 {
    
/**
 * swaps i and j
 * @param i 1st variable.
 * @param j 2nd variable.
 */

/*
    public static void main(String[] args){
	int i = 2;
	int j = 6;

	int k = i;
	int NewI = j;
	int NewJ = k;
	
	System.out.println("Original i: " + i + " k: " + j);

	System.out.println("After swapping i: " + NewI + " k: " + NewJ);
    }
}
     
*/
