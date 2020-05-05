import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class qLearning {

	static List<Integer> listZero 	= new ArrayList<Integer>();
	static List<Integer> listOne 	= new ArrayList<Integer>();
	static List<Integer> listTwo 	= new ArrayList<Integer>();
	static List<Integer> listThree 	= new ArrayList<Integer>();
	static List<Integer> listFour 	= new ArrayList<Integer>();
	static List<Integer> listFive 	= new ArrayList<Integer>();
	
	private static Double[][] qTable= new Double[6][6];
	
	// Initialise learning and discount rates
	static double alpha 			= 0.2;
	static double gamma 			= 0.5;

	public static void qLearn() {

		// Initialise zero q-table
		makeZero(qTable);
		
		qTable[0][4] = 13.03;
		qTable[1][3] = 1.12;
		qTable[1][5] = 20.2;
		qTable[2][3] = 1.58;
		qTable[3][1] = 0.11;
		qTable[3][4] = 15.75;
		qTable[4][0] = 0.36;
		qTable[4][3] = 1.74;
		qTable[4][5] = 74.46;
		qTable[5][4] = 2.0;
		qTable[5][5] = 20.2;
		
		// Make lists of all possible actions from each state
		possibleActions(listZero, listOne, listTwo, listThree, listFour, listFive);

		// Create random number generator for formulating different episodes
		Random r = new Random();

		// For the number of episodes specified
		for (int k = 0; k < 1000; k++) { 

			// Generate a random intial state
			int state = r.nextInt(5);
			System.out.print(state + ": ");
			
			// Initialise possile actions variable
			int action;
			// Initialise goal counter to zero
			int goalCounter = 0;
			
			double original;

			// We allow to reach the goal state, 5, two times to allow this to be populated in the table
			while (goalCounter != 2) {
				
				// Based on the state we are in, we need to determine the actions we can take from there by looking at the lists and picking random actions
				// We then work out the qTable value by working out the reward
				// If the action involves going to the goal state we update the counter
				// We then state to the action to complete the action
				switch (state) {

				case 0:
					action = listZero.get(0); // only one possible action from the state 0
					
					original = qTable[state][action];
					
					qTable[state][action] = ((1 - alpha) * qTable[state][action]) + (alpha * (getReward(state,action) + (gamma * maxFutureQValues(action))));
					qTable[state][action] = Math.round(qTable[state][action] * 100.0) / 100.0;

					if (action == 5)
						goalCounter++;	
					
					System.out.print(action + " , ");
					
//					if (qTable[state][action] - original < 1 && qTable[state][action] - original !=0)
//						System.out.print("CONVERGED");
					
					state = action;

					break;
					
				case 1:
					Random r1 = new Random();
					action = listOne.get(r1.nextInt(listOne.size()));
					
					original = qTable[state][action];
					
					qTable[state][action] = ((1 - alpha) * qTable[state][action]) + (alpha * (getReward(state,action) + (gamma * maxFutureQValues(action))));
					qTable[state][action] = Math.round(qTable[state][action] * 100.0) / 100.0;

					if (action == 5)
						goalCounter++;	
					
					System.out.print(action + " , ");
					
//					if (qTable[state][action] - original < 1 && qTable[state][action] - original !=0)
//						System.out.print("CONVERGED");
					
					state = action;

					break;

				case 2:
					action = listTwo.get(0); // only one possible action from the state 2
					
					original = qTable[state][action];

					qTable[state][action] = ((1 - alpha) * qTable[state][action]) + (alpha * (getReward(state,action) + (gamma * maxFutureQValues(action))));
					qTable[state][action] = Math.round(qTable[state][action] * 100.0) / 100.0;

					if (action == 5)
						goalCounter++;	
					
					System.out.print(action + " , ");
					
//					if (qTable[state][action] - original < 1 && qTable[state][action] - original !=0)
//						System.out.print("CONVERGED");
					
					state = action;

					break;

				case 3:
					Random r3 = new Random();
					action = listThree.get(r3.nextInt(listThree.size()));
					
					original = qTable[state][action];
					
					qTable[state][action] = ((1 - alpha) * qTable[state][action]) + (alpha * (getReward(state,action) + (gamma * maxFutureQValues(action))));
					qTable[state][action] = Math.round(qTable[state][action] * 100.0) / 100.0;

					if (action == 5)
						goalCounter++;	
					
					System.out.print(action + " , ");
					
//					if (qTable[state][action] - original < 1 && qTable[state][action] - original !=0)
//						System.out.print("CONVERGED");
					
					state = action;

					break;

				case 4:
					Random r4 = new Random();
					action = listFour.get(r4.nextInt(listFour.size()));
					
					original = qTable[state][action];

					qTable[state][action] = ((1 - alpha) * qTable[state][action]) + (alpha * (getReward(state,action) + (gamma * maxFutureQValues(action))));
					qTable[state][action] = Math.round(qTable[state][action] * 100.0) / 100.0;

					if (action == 5)
						goalCounter++;	
					
					System.out.print(action + " , ");
					
//					if (qTable[state][action] - original < 1 && qTable[state][action] - original !=0)
//						System.out.print("CONVERGED");
					
					state = action;

					break;

				case 5:
					Random r5 = new Random();
					action = listFive.get(r5.nextInt(listFive.size()));

					original = qTable[state][action];

					qTable[state][action] = ((1 - alpha) * qTable[state][action]) + (alpha * (getReward(state,action) + (gamma * maxFutureQValues(action))));
					qTable[state][action] = Math.round(qTable[state][action] * 100.0) / 100.0;

					if (action == 5)
						goalCounter++;	
					
					System.out.print(action + " , ");
					
//					if (qTable[state][action] - original < 1 && qTable[state][action] - original !=0)
//						System.out.print("CONVERGED");
					
					state = action;

					break;

				}
				
			}
			
			System.out.println(" ");
			System.out.println(Arrays.deepToString(qTable));
			System.out.println(" ");
			
		}

	}
	
	public static void makeZero(Double[][] qTable) {

		for (int i = 0; i < qTable.length; i++) {
			for (int j = 0; j < qTable.length; j++) {
				qTable[i][j] = (double) 0;
			}
		}
	}
	
	public static void possibleActions(List<Integer> listZero, List<Integer> listOne, List<Integer> listTwo, List<Integer> listThree, List<Integer> listFour, List<Integer> listFive) {
		
		listZero.add(4);

		listOne.add(3);
		listOne.add(5);

		listTwo.add(3);

		listThree.add(1);
		listThree.add(2);
		listThree.add(4);

		listFour.add(0);
		listFour.add(3);
		listFour.add(5);

		listFive.add(1);
		listFive.add(4);
		listFive.add(5);
	}
	
	public static double getReward(int state, int action) {
		
		if (state == 1 && action == 5 || state == 4 && action == 5 || state == 5 && action == 5)
			return 100.00;
		else 
			return 0.00;
	}
	
	public static double maxFutureQValues (int action) {
		

		List<Integer> listToIterate;
		
		if (action == 0) {
			listToIterate = listZero;
			double maximum = 0;
			for (int i = 0; i < listToIterate.size(); i++) {
				if (qTable[0][listToIterate.get(i)] >= maximum)
					maximum = qTable[0][listToIterate.get(i)];
			}
			return maximum;
			
		}
		
		else if (action == 1) {
			listToIterate = listOne;
			double maximum = 0;
			for (int i = 0; i < listToIterate.size(); i++) {
				if (qTable[1][listToIterate.get(i)] >= maximum)
					maximum = qTable[1][listToIterate.get(i)];
			}
			return maximum;
		}
		
		else if (action == 2) {
			listToIterate = listTwo;
			double maximum = 0;
			for (int i = 0; i < listToIterate.size(); i++) {
				if (qTable[2][listToIterate.get(i)] >= maximum)
					maximum = qTable[2][listToIterate.get(i)];
			}
			return maximum;
		}
		
		else if (action == 3) {
			listToIterate = listThree;
			double maximum = 0;
			for (int i = 0; i < listToIterate.size(); i++) {
				if (qTable[3][listToIterate.get(i)] >= maximum)
					maximum = qTable[3][listToIterate.get(i)];
			}
			return maximum;
		}
		
		else if (action == 4) {
			listToIterate = listFour;
			double maximum = 0;
			for (int i = 0; i < listToIterate.size(); i++) {
				if (qTable[4][listToIterate.get(i)] >= maximum)
					maximum = qTable[4][listToIterate.get(i)];
			}
			return maximum;
		}
		
		else if (action == 5) {
			listToIterate = listFive;
			double maximum = 0;
			for (int i = 0; i < listToIterate.size(); i++) {
				if (qTable[5][listToIterate.get(i)] >= maximum)
					maximum = qTable[5][listToIterate.get(i)];
			}
			return maximum;
		}
		
		throw new IllegalArgumentException("Action exceeds those possible");	
	}
	
	
	public static void main(String[] args) {
		qLearn();
	}

}
