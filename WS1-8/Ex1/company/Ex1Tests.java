package company;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class Ex1Tests {
	
	public static final double TOLERANCE = 0.00001;

	private Company goodsforyou;
	private HourlyEmployee trevor; 
	private MonthlyEmployee john;
		
	@Before
	public void setup() {
		
		trevor 	= new HourlyEmployee ("trevor", "smith", "JM195703B", 10.0);
		john	= new MonthlyEmployee ("john", "mcdonald", "JM175309Z", 2000.0);
		
		ArrayList<Employee> test = new ArrayList<Employee>();
		test.add(trevor);
		test.add(john);
		
		goodsforyou = new Company();
		goodsforyou.setEmployees(test);
		
	}
	
	
	// Test a salary increase across a company with one hourly employee and one monthly employee
	@Test
	public void test1() {
		
		double increase = 10;
		goodsforyou.increaseSalaries(increase);
		
		double expectedtrevor 	= 11.0;
		double actualtrevor 	= trevor.getHourlySalary();
		
		double expectedjohn		= 2200.0;
		double actualjohn		= john.getMonthlySalary();
		
		assertEquals(expectedtrevor,actualtrevor,TOLERANCE);
		assertEquals(expectedjohn,actualjohn,TOLERANCE);
	}
	
	
	// Test that a salary increase two times in a row gives the correct (compounded salary) increase from the original salary
	@Test
	public void test2() {
		double increase = 10;
		goodsforyou.increaseSalaries(increase);
		goodsforyou.increaseSalaries(increase);
		
		double expectedtrevor 	= 12.1;
		double actualtrevor 	= trevor.getHourlySalary();
		
		double expectedjohn		= 2420.0;
		double actualjohn		= john.getMonthlySalary();
		
		assertEquals(expectedtrevor,actualtrevor,TOLERANCE);
		assertEquals(expectedjohn,actualjohn,TOLERANCE);
	}
		
		
	// Test that a salary increase of half a percent is calculated correctly due to the change in salaries to type double
	@Test
	public void test3() {
		double increase = 5.5;
		goodsforyou.increaseSalaries(increase);
		
		double expectedtrevor 	= 10.55;
		double actualtrevor 	= trevor.getHourlySalary();
		
		double expectedjohn		= 2110.0;
		double actualjohn		= john.getMonthlySalary();
		
		assertEquals(expectedtrevor,actualtrevor,TOLERANCE);
		assertEquals(expectedjohn,actualjohn,TOLERANCE);
	}
	
	
	// Test that an attempted salary decrease using the salary increase method throws an illegal argument exception
	@Test(expected = IllegalArgumentException.class)
	public void test4() {
	
		double decrease = -10;
		goodsforyou.increaseSalaries(decrease);
	}
	
	
	// Test that a zero percent salary increase throws an illegal argument exception
	@Test(expected = IllegalArgumentException.class)
	public void test5() {
	
		double decrease = 0;
		goodsforyou.increaseSalaries(decrease);
	}

}
