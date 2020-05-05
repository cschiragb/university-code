public class solution1 {

	public static void main(String[] args) {

		// -------------------------------------------------
		// Training Data setup
		// -------------------------------------------------
		
		double[] data_x_j = { -100, -10, -3, 0, 1, 2, 3,  4,  10,  100   }; 
		double[] data_y_j = { 9901, 91,  7,  1, 3, 7, 13, 21, 111, 10101 };

		// -------------------------------------------------
		// Gradient Descent Alogrithm
		// -------------------------------------------------
		
		// Initialise iterations / number of sweeps we want to run through the complete training set
		final int epochs = 15000000;  

		// We want to calculate suitable weights for the hypothesis function, h_w(x) = w0 + (w1 * x) + (w2 * x^2) 
		// The hypothesis function will be used for Univariate Non-Linear Regression
		// Initialise starting weights
		double w2 = 0.00;
		double w1 = 0.00;
		double w0 = 0.00;

		// Initialise learning rate
		double alpha = 0.00000002;

		// Main Gradient Descent Function
		for(int i = 0; i < epochs; i++) { // For each Epoch

			double cost = 0; // Initialise cost to zero

			for(int j = 0; j < data_x_j.length; j++) { // For each training data point

				double x_j = data_x_j[j]; // Extract x-value from data
				double y_j = data_y_j[j]; // Extract y-value from data

				double prediction = w0 + (w1 * x_j) + (w2 * x_j * x_j); // Calculate the predicted value using the current weights on the hypothesis function

				// Calculate cost using the equation (y_j - h_w(x))^2, i.e. the actual y-value minus the predicted y value squared which is called the L2 loss
				cost += (y_j - prediction) * (y_j - prediction); // Add the cost calculated to the current total cost

				// Update the weights based on the update rules which use the partial differentiation of the L2 loss equation above with respect to each of the weights
				w2 += alpha * (y_j - prediction) * x_j * x_j;
				w1 += alpha * (y_j - prediction) * x_j;
				w0 += alpha * (y_j - prediction);

			}

			System.out.println("Current Cost: " + cost + " w2: " + w2 + " w1: " + w1 + " w0: " + w0); // Print out the current total cost and weights of the current epoch

		}

		System.out.println("Final Equation: h(x) = (" + w2 + " * x^2) + (" + w1 + " * x) + " + w0); // Print out the final weights for the hypothesis function to fit the trained data
	}  
}
