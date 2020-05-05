/** 
 * Vehicle is a superclass for a vehicle created from the number of passengers it can hold and 
 * the maximum speed it can achieve
 *  
 * We establish two field variables:
 * passengerNumber 	- is an integer of the number of passengers the vehicle can hold
 * maxSpeed 		- is an integer of the highest speed the vehicle can reach
 * 
 * @author Chirag Bhatti
 * @version 18/11/2018
 */

public class Vehicle {
	private int passengerNumber;
	private int maxSpeed;
	
	/** Vehicle is a constructor to create a profile of a Vehicle
	 * 
	 * @param passengerNumber is the number of passengers the vehicle can hold as an integer
	 * @param maxSpeed is the highest speed the vehicle can reach as an integer
	 */
	public Vehicle(int passengerNumber, int maxSpeed) {
		this.passengerNumber 	= passengerNumber;
		this.maxSpeed 			= maxSpeed;
	}

	/**
	 * 
	 * @return the number of passengers the vehicle can hold as an integer
	 */
	public int getPassengerNumber() {
		return passengerNumber;
	}

	/**
	 * 
	 * @return the maximum speed the vehicle can reach as an integer
	 */
	public int getMaxSpeed() {
		return maxSpeed;
	}

	/**
	 * Sets the number of passengers the vehicle can hold
	 * @param passengerNumber
	 */
	public void setPassengerNumber(int passengerNumber) {
		if (passengerNumber <= 0) {
			throw new IllegalArgumentException(); 
			/* as a vehicle cannot have a negative or zero passenger capacity */
		}
		else this.passengerNumber = passengerNumber;
	}

	/**
	 * Sets the maximum speed the vehicle can achieve safely
	 * @param maxSpeed
	 */
	public void setMaxSpeed (int maxSpeed) {
		if (maxSpeed <= 0) {
			throw new IllegalArgumentException();
			/* as a vehicle cannot have a negative or zero max speed */
		}
		else this.maxSpeed = maxSpeed;
	}
	
	/**
	 * toString defines how the details of a vehicle will be printed
	 * @return the print type of a vehicle
	 */
	public String toString() {
		return "This vehicle has passenger number: " + passengerNumber + 
				"and has max speed of: " + maxSpeed;
	}
}
