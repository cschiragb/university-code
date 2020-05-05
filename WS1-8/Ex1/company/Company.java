package company;

/**
 * Company is a class containing a list of Employees that work for the company.
 * 
 * We establish a field variable:
 * employees - the list of employees working for the company
 * 
 * @author - Chirag Bhatti
 * @version - 06/12/2018
 * 
 */
import java.util.ArrayList;
import java.util.Arrays;

public class Company {
	
	private ArrayList<Employee> employees;
	
	
	/**
	 * Company is an argument-less Constructor defining the employee profile of a company
	 * 
	 * @param employees is a new ArrayList of employees, of type Employee, 
	 * created every time a Company is constructed.
	 */
	public Company () {
		this.employees = new ArrayList<Employee> ();
	}
	
	
	/**
	 * 
	 * @return the list of employees working at the company as an ArrayList of type Employee
	 */
	public ArrayList<Employee> getEmployees() {
		return employees;
	}
	
	
	/**
	 * Sets the list of employees of type Employee working at a Company
	 * @param employees is an ArrayList of type Employee, to be set as the list of company employees.
	 */
	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}
 
	
	/**
	 * addEmployee is a separate method for adding single additional employees onto the ArrayList of employees,
	 * of type Employee.
	 * @param employee is a single employee of type Employee, to be add to the list of company employees.
	 */
	public void addEmployee(Employee employee) {
		employees.add(employee);
	}
	
	
	/**
	 * increaseSalaries is a method for increasing the salary of all employees of a company.
	 * If the employee is of Employee sub-class type HourlyEmployee, their hourly salary will be increased.
	 * If the employee is of Employee sub-class type MonthlyEmployee, their monthly salary will be increased.
	 * @param rate is the percentage increase of the wage to be applied (e.g. 3.0) to all the employee salaries of the company.
	 */
	public void increaseSalaries(double rate) {
		
		if (rate <= 0) {
			throw new IllegalArgumentException();
		}
		else for (int i = 0; i < employees.size(); i++) {
			employees.get(i).increaseSalaries(rate);
		}
	}
	
	/**
	 * toString method for printing all the details of employees who work for a company
	 * @return companyemployees as a String containing all the details of the employees working at the company.
	 */
	public String toString() {
		
		StringBuilder companyemployees = new StringBuilder();
		
		for (int i = 0; i < employees.size(); i++) {
			companyemployees.append(employees.get(i).toString() + "\n");
		}
		return companyemployees.toString();
	}
}
