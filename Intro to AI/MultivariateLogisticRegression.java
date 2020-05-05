public class solution2 {

	public static void main(String[] args) {

		// -------------------------------------------------
		// Training Data setup
		// -------------------------------------------------
		
		double[] data_x1_j = { 1, 2, 0.3, 0.6, 1.2, 1.3, 1.8, 1.5, 3, 4, 3.1, 3.6, 3.8, 3.5, 3.25 }; 
		double[] data_x2_j = { 1, 2, 1.2, 0.8, 1,   1,   2,   1.4, 3, 4, 3.3, 3.8, 2.1, 2.2, 2.8  };
		double[] data_y_j  = { 0, 0, 0,   0,   0,   0,   0,   0,   1, 1, 1,   1,   1,   1,   1    };

		// -------------------------------------------------
		// Gradient Descent Algorithm
		// -------------------------------------------------
		
		// Initialise iterations / number of sweeps we want to run through the complete training set
		final int epochs = 107000;

		// We want to calculate suitable weights for the hypothesis function, h(x) = w0 + (w1 * x) + (w2 * x2) 
		// The hypothesis function will be used for Multivariate Logistic Regression
		// Initialise starting weights
		double w2 = 0.00;
		double w1 = 0.00;
		double w0 = 0.00;

		// Initialise learning rate
		double alpha = 0.1;

		// Main Gradient Descent Function
		for(int i = 0; i < epochs; i++) { // For each Epoch
			
			double cost = 0; // Initialise cost to zero

			for(int j = 0; j < data_x1_j.length; j++) { // For each training data point

				double x1_j = data_x1_j[j];  // Extract x1-value from data
				double x2_j = data_x2_j[j];  // Extract x2-value from data
				double y_j  = data_y_j[j];   // Extract y-value  from data

				// Calculate the predicted value using the sigmoid function g(z) = 1 / (1 + e^-z)
				// Where h_w(X) = g(wTX), i.e. substitute z for the hypothesis function above
				double prediction = 1 / (1 + Math.exp(-(w0 + (x1_j * w1) + (x2_j * w2)))); 

				// Calcuate the cost using the Logistic Cost Function, cost = (y_j * log(h_w(x_j)) + ((1-y_j) * (log(h_w(x_j))))
				cost += (y_j * Math.log(prediction)) + ((1 - y_j) * (Math.log(1-prediction))); 

				// Update the weights based on the update rules
				// Each weight updated is based on the corresponding x
				w2 += alpha * (y_j - prediction) * x2_j;
				w1 += alpha * (y_j - prediction) * x1_j;
				w0 += alpha * (y_j - prediction);

			}
			
			System.out.println("Current Cost: " + cost + " w2: " + w2 + " w1: " + w1 + " w0: " + w0); // Print out the current total cost and weights of the current epoch

		}
		
		System.out.println("Final Equation: h(x) = (" + w2 + " * x2) + (" + w1 + " * x1) + " + w0); // Print out the final weights for the hypothesis function to fit the trained data
	}
}
