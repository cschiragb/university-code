/** Employee is a class for an employee profile created
 * from their name, monthly gross salary and the tax rate.
 * 
 * We establish three field variables:
 * name, a string for the employee's name
 * monthlyGrossSalary, for the employees gross salary per month as double
 * taxRate, for the percentage taxrate the employee is subject to as double
 * 
 * @author Chirag Bhatti
 * @version 20/10/2018
 */

public class Employee {
	private String name;
	private double monthlyGrossSalary;
	private double taxRate;
	
	/** Employee is a constructor to create the profile of an employee
	 * 
	 * @param name is the name associated with the employee as string
	 * @param monthlyGross is is the monthly salary before tax per month as double
	 * @param taxRate is percentage tax the employee pays on their gross month salary as double
	 */
	
	public Employee(String name, double monthlyGrossSalary, double taxRate) {
		this.name = name;
		this.monthlyGrossSalary = monthlyGrossSalary;
		this.taxRate = taxRate;
	}
	
	/* 
	 * Getters to obtain Employee profile
	 */
	
	/**
	 * 
	 * @return the name of the Employee as String 
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @return the monthly gross salary of the Employee as double
	 */
	public double getMonthlyGrossSalary() {
		return monthlyGrossSalary;
	}
	
	/** 
	 * 
	 * @return the tax rate paid as a percentage on the monthly gross salary for the Employee as double
	 */
	public double getTaxRate() {
		return taxRate;
	}
	
	/**
	 * 
	 * @return the monthly net salary from the method to calculate net pay below for the Employee
	 */
	public double getMonthlyNetSalary() {
		return monthlyNetSalary();
	}
	
	/* 
	 * Setters to set parts of an employee profile
	 */
	
	/**
	 * Sets the name of Employee
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Sets the monthly gross salary of the Employee
	 * @param monthlyGrossSalary
	 */
	public void setMonthlyGrossSalary(double monthlyGrossSalary) {
		this.monthlyGrossSalary = monthlyGrossSalary;
	}

	/**
	 * Sets the tax rate the Employee gross pay is subject to
	 * @param taxRate
	 */
	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}
	
	/** 
	 * A separate method for calculating the monthly net salary based on the employee's 
	 * monthly gross salary and the tax rate
	 * @return the monthly net salary based on tax rate and gross monthly salary of the Employee
	 */
	public double monthlyNetSalary() {
		return getMonthlyGrossSalary() * ((100 - getTaxRate())/100);
	}
	
	/** Method for calculating the increase in the gross salary based on
	 * a percentage rate increase
	 * @param rate which represents a percentage pay increase as double of the Employee Gross Salary
	 */
	public void increaseSalary(double rate) {
		setMonthlyGrossSalary(getMonthlyGrossSalary() * ((rate / 100) + 1));
	}
	
	/** toString defines how the details of the employee profile will be printed
	 *  @return the print type of employee
	 */
	public String toString() {
		return name + " has a monthly salary of" + "\u003A" + " \u00A3" + monthlyGrossSalary + " \u007C "  + "With taxrate" + "\u003A " + taxRate + "\u0025" + 
				" \u007C " + "Hence a monthly net salary of: " + "\u00A3" + monthlyNetSalary();
	}
	
}
	
