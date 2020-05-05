/** 
 * Patient is a class for a creation of a patient profile and implements the interface Measurable interface for
 * obtaining values of type double that are measurable.
 * 
 * We define three field variables:
 * 
 * name 	- is a String of the name of the patient 
 * age 		- is an integer of the age of the patient
 * weight 	- is a double of the weight of the patient 
 * 
 * @author Chirag
 * @version 18/11/2018
 */

public class Patient implements Measurable {
	private String name;
	private int age;
	private double weight;
	
	/** Patient is a constructor defining the profile of a patient.
	 * 
	 * @param name is the name of the patient as a String
	 * @param age is the age of the patient as an integer
	 * @param weight is the weight of the patient as type double
	 */
	public Patient (String name, int age, double weight) {
		this.name 	= name;
		this.age 	= age;
		this.weight = weight;
	}
	
	/**
	 * 
	 * @return the name of the patient as a String
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @return the age of patient as an integer
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * 
	 * @return the weight of a patient as a double 
	 */
	public double getWeight() {
		return weight;
	}
	
	/**
	 * getValue is a getter that is specified by the Measurable interface that is being overridden
	 * @return the weight of the patient of type double by calling the getWeight() method
	 */
	@Override
	public double getValue() {
		return getWeight();
	}
	
	/**
	 * Sets the name of a patient
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Sets the age of a patient
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * Sets the weight of a patient
	 * @param weight
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
}
