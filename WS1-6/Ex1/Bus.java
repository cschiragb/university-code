/** 
 * Bus is a class that is a sub-class of Vehicle, and is for creating a Bus from the number of passengers
 * it can hold, the maximum speed it can achieve, and the fuel consumption of the bus.
 * 
 * We use two field variables from the superclass:
 * passengerNumber 	- the number of passengers the bus can seat
 * maxSpeed 		- the highest speed the bus can reach
 * 
 * We establish a further field variable specific to bus:
 * fuelConsumption 	- which is the fuel consumption of a vehicle in miles per gallon
 * 
 * @author Chirag Bhatti
 * @version 19/11/2018
 */
public class Bus extends Vehicle {
	
	private double fuelConsumption;
	
	/** Bus is a constructor to create the profile of a Bus
	 * 
	 * @param passengerNumber - the number of passengers the bus can seat
	 * @param maxSpeed - the highest speed the bus can reach
	 * @param fuelConsumption - the fuel consumption of the bus in miles per gallon
	 */
	public Bus(int passengerNumber, int maxSpeed, double fuelConsumption) {
		super(passengerNumber, maxSpeed);
		this.fuelConsumption = fuelConsumption;
	}

	/**
	 * 
	 * @return the fuel consumption of the bus as a number of type double
	 */
	public double getFuelConsumption() {
		return fuelConsumption;
	}
	
	/**
	 * Sets the fuel consumption of a bus
	 * @param fuelConsumption
	 */
	public void setFuelConsumption(double fuelConsumption) {
		if (fuelConsumption < 0) {
			throw new IllegalArgumentException();
			/* as a bus cannot have a negative fuel consumption but could have a zero consumption if it is electrical */
		}
		else this.fuelConsumption = fuelConsumption;
	}
	
	/**
	 * toString defines how the details of a bus are to be printed. 
	 * Overrides and utilises the toString of the vehicle superclass so that the fuel consumption
	 * is also included
	 * 
	 * @return the print type of Bus
	 */
	@Override
	public String toString() {
		return super.toString() + "The vehicle has a fuel consumption of: " + getFuelConsumption();
	}
}
