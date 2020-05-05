
import java.util.Scanner;

/**
 * The class MiniInterpreter is a class to convert the Toy Programming Language
 * into Java code that can be executed.
 * 
 * We establish 4 field variables:
 * symbolictable 		- is a String array containing any variable names to be stored from the toy programme
 * variablevalues 		- is an Integer array containing values of any variables from the toy programme
 * instructions			- is a String array containing the toy programme instructions spread through the array
 * instructionsscanner 	- is a Scanner used for determining if the toy programme result to be returned is
 * 						  the number given by the toy programme, or the value of a variable.
 * 
 * @author 	Chirag Bhatti
 * @version 2018 - 12 - 10
 */
public class MiniInterpreter {
	
	private static String[] 	symbolictable 	= new String[20];
	private static int[] 		variablevalues 	= new int	[20];
	private static String[] 	instructions;
	private static Scanner 		instructionscanner; 
	
	/**
	 * The class programLoader calls the symbolic table initialiser.
	 * It then splits the toy programme code by lines and puts them into the String array instructions.
	 * It then calls the instructionHandler with the String array instructions 
	 * @param program - the toy program as a String
	 */
	public static void programLoader (String program) {
		
		symbolictableInitialiser(symbolictable);
		
		instructions = program.split("\n");
		
		for (int i = 0; i < instructions.length; i++) {
			instructions[i] = instructions[i].replaceAll("\\s+", "");
		}
		
		instructionHandler(instructions);
	}
	
	/**
	 * The method symbolictableInitialiser takes the pre-made symbolic table, and sets all the elements
	 * to the String "empty"
	 * @param array - as a String array
	 */
	public static void symbolictableInitialiser (String[] array) {
		for (int i = 0; i < symbolictable.length; i++) {
			symbolictable[i] = "empty";
		}
	}
	
	/**
	 * The method instructionHandler takes the String array instructions, and loops through each element
	 * on the array.
	 * Based on the string in the element (or instruction), it decides which method to call, depending on
	 * recognising the string as a return statement, an addition instruction or assignment instruction.
	 * @param instructions - as a String array
	 */
	public static void instructionHandler (String[] instructions) {
		
		for (int i = 0; i < instructions.length; i++) {
			
			if (instructions[i].length() == 1) {
				Returner(instructions[i]);
			} else if (instructions[i].contains("+")) {
				additionInstruction(instructions[i]);
			} else {
				assignmentInstruction(instructions[i]);
			}
		}
	}
	
	/**
	 * The method Returner takes a String instruction, and scans it.
	 * If the scanner detects that the String is an integer, it will parse it as in integer
	 * and return it.
	 * Otherwise, it is assumed that the value of a variable is to be returned. So the method calls the 
	 * method indexChecker with the instruction String containing the variable name, and then returns the 
	 * value of the variable based on the determined index using the array variableValues.
	 * @param instruction
	 * @return an integer or the integer value of a variable
	 */
	public static int Returner(String instruction) {
		
		instructionscanner = new Scanner(instruction);
		
		if (instructionscanner.hasNextInt() == true) {
			return Integer.parseInt(instruction);	
		} else {
			return variablevalues[indexChecker(instruction)];
		}
	}
	
	/**
	 * The method additionInstruction is called with a String instruction.
	 * It splits this String by "=" and stores this in String array splitbyequals (effectively Left and Right side)
	 * It then takes the RHS of the original instruction and splits this further by "+", storing it String
	 * array splitbyplus.
	 * If the variable on the LHS of the instruction exists in the symbolic table, it updates the corresponding value
	 * in the Variable Values array. Otherwise, it will find a slot in the symbolic table that is "empty", and 
	 * populate the corresponding slot in the variableValues array with the sum.
	 * The Returner method is used to determine the values on the RHS of the additon instruction.
	 * 
	 * @param instruction
	 */
	public static void additionInstruction (String instruction) {
		
		String [] splitbyequals = instruction.split("\\=");
		String [] splitbyplus;
		
		splitbyplus = splitbyequals[1].split("\\+");
		
		for (int i = 0; i < symbolictable.length; i++) {
			
			if (symbolictable[i].equals("empty")) {
			symbolictable[i] = splitbyequals[0];
			variablevalues[i] = Returner(splitbyplus[0]) + Returner(splitbyplus[1]);
			break;
			} else if (symbolictable[i].equals(splitbyequals[0])) {
				variablevalues[indexChecker(splitbyequals[0])] = Returner(splitbyplus[0]) + Returner(splitbyplus[1]);
				break;
			}
		}
	}
	
	/**
	 * The method assignmentInstruction takes a String instruction and splits it by "=", and stores this
	 * in the String array splitbyequals.
	 * 
	 * If the variable name on the LHS is in the symbolictable, it will update the corresponding value in 
	 * the variablevalues.  
	 * Otherwise if it is not found, the index is set to the first slot on the symbolictable, and the variable is
	 * added into this index.
	 * The corresponding variablevalue is also updated.
	 * 
	 * @param instruction - as a String
	 */
	public static void assignmentInstruction (String instruction) {
		
		String [] splitbyequals = instruction.split("\\=");
		
		int index = -1;
		
		for (int i = 0; i < symbolictable.length; i++) {
					
			if (symbolictable[i] == splitbyequals[0]) {
				index = i;
				break;
			} else if (symbolictable[i].equals("empty")) {
				index = i;
				symbolictable[index] = splitbyequals[0];
				break;
			}
		}
		
		variablevalues[index] = Returner(splitbyequals[1]);
	}
	
	/**
	 * The method indexChecker takes a variable name as a String and finds the index of it 
	 * in the symbolictable, if it exists. Otherwise the index is returned as -1 which will
	 * throw an error in any subsequent use of the index in another method.
	 * This is because the indexChecker is only called when the variable is expected to be 
	 * in the symbolictable.
	 * 
	 * @param variable - as a String
	 * @return index - as an integer
	 */
	public static int indexChecker (String variable) {
		
		int index = -1;
		
		for (int i = 0; i < symbolictable.length; i++) {
			
			if (symbolictable[i].equals(variable)) {
				index = i;
				break;
			}
		}
		
		return index;
	}

	/**
	 * The method result returns the result from the interpretation.
	 * It will look at returning the variable value / integer in the last line of code / instruction
	 * from the original toy programme that was parsed.
	 * @return the result as an integer from interpreting the toy programme
	 */
	public static int result() {
		return Returner(instructions[instructions.length-1]);
	}
	
	/* -----------------------------------------------------------------------------------*/
	
	public static void main (String [] args) {
		
		StringBuilder program1 = new StringBuilder();
		program1.append("A = 2" + "\n" + "B = 8" + "\n" + "C = A + B" + "\n" + "C");
		String program1test = program1.toString();
		
		StringBuilder program2 = new StringBuilder();
		program2.append("A = 2" + "\n" + "B = 22" + "\n" + "Z = 91" + "\n" + "K = A + B"
						+ "\n" + "Z = K + A" + "\n" + "Z");
		String program2test = program2.toString();
		
		StringBuilder program3 = new StringBuilder();
		program3.append("A = 2 + 1" + "\n" + "B = A + 9" + "\n" + "C = A + B" + "\n" + "A");
		String program3test = program3.toString();
		
		programLoader(program1test);
		System.out.println(result());
		programLoader(program2test);
		System.out.println(result());
		programLoader(program3test);
		System.out.println(result());
	}
}
