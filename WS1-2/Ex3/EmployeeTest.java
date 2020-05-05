
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {

	private Employee wilfred;
	private Employee darth;
	private final static double TOLERANCE = 0.0001;

	@Before
	public void setup() {
		wilfred = new Employee("Wilfred Jones", 28001, 30);
		darth = new Employee("Darth Vader", 2000000.01, 10);
	}

	//testing getters for wilfred jones
	@Test
	public void test1() {
		String expectedName = "Wilfred Jones";
		double expectedTaxRate = 30;
		double expectedGrossSalary = 28001;
		double expectedNetSalary = 19600.7;

		String actualName = wilfred.getName();
		double actualTaxRate = wilfred.getTaxRate();
		double actualGrossSalary = wilfred.getMonthlyGrossSalary();
		double actualNetSalary = wilfred.getMonthlyNetSalary();

		assertEquals(expectedName, actualName);
		assertEquals(expectedTaxRate, actualTaxRate, TOLERANCE);
		assertEquals(expectedGrossSalary, actualGrossSalary, TOLERANCE);
		assertEquals(expectedNetSalary, actualNetSalary, TOLERANCE);
	}

	// testing getters for darth vader
	@Test
	public void test2() {
		String expectedName = "Darth Vader";
		double expectedTaxRate = 10;
		double expectedGrossSalary = 2000000.01;
		double expectedNetSalary = 1800000.009;

		String actualName = darth.getName();
		double actualTaxRate = darth.getTaxRate(); 
		double actualGrossSalary = darth.getMonthlyGrossSalary();
		double actualNetSalary = darth.getMonthlyNetSalary();

		assertEquals(expectedName, actualName);
		assertEquals(expectedTaxRate, actualTaxRate, TOLERANCE);
		assertEquals(expectedGrossSalary, actualGrossSalary, TOLERANCE);
		assertEquals(expectedNetSalary, actualNetSalary, TOLERANCE);
	}

	//testing wilfred's salaries after
	//changing tax rate
	@Test
	public void test3() {

		wilfred.setTaxRate(0);

		double expectedGrossSalary = 28001;
		double expectedNetSalary = 28001;

		double actualGrossSalary = wilfred.getMonthlyGrossSalary();
		double actualNetSalary = wilfred.getMonthlyNetSalary();

		assertEquals(expectedGrossSalary, actualGrossSalary, TOLERANCE);

		assertEquals(expectedNetSalary, actualNetSalary, TOLERANCE);
	}

	//testing darth's salaries after
	//changing tax rate
	@Test
	public void test4() {

		darth.setTaxRate(-22.5);

		double expectedGrossSalary = 2000000.01;
		double expectedNetSalary = 2450000.01225;

		double actualGrossSalary = darth.getMonthlyGrossSalary();
		double actualNetSalary = darth.getMonthlyNetSalary();

		assertEquals(expectedGrossSalary, actualGrossSalary, TOLERANCE);
		
		assertEquals(expectedNetSalary, actualNetSalary, TOLERANCE);
	}

	//testing john's salaries
	@Test
	public void test5() {

		wilfred.setTaxRate(29.34);

		wilfred.setMonthlyGrossSalary(45823);
		
		wilfred.increaseSalary(4.9);
		
		double expectedGrossSalary = 48068.327;
		double expectedNetSalary = 33965.08;

		double actualGrossSalary = wilfred.getMonthlyGrossSalary();
		double actualNetSalary = wilfred.getMonthlyNetSalary();

		assertEquals(expectedGrossSalary, actualGrossSalary, 0.001);

		assertEquals(expectedNetSalary, actualNetSalary, 0.001);
	}
	
	//testing darth's salaries
	@Test
	public void test6() {

		darth.setTaxRate(11.25);

		darth.setMonthlyGrossSalary(45823);
		
		darth.increaseSalary(4.9);
		
		double expectedGrossSalary = 48068.327;
		double expectedNetSalary = 42660.640;

		double actualGrossSalary = darth.getMonthlyGrossSalary();
		double actualNetSalary = darth.getMonthlyNetSalary();

		assertEquals(expectedGrossSalary, actualGrossSalary, 0.001);

		assertEquals(expectedNetSalary, actualNetSalary, 0.001);
	}
	
	//testing darth's pay increase by 103.5%
	@Test
	public void test7() {
		darth.increaseSalary(103.5);
		
		double expectedGrossSalary = 4070000.02035;
		double expectedNetSalary = 3663000.018315;
		
		double actualGrossSalary = darth.getMonthlyGrossSalary();
		double actualNetSalary = darth.getMonthlyNetSalary();
		
		assertEquals(expectedGrossSalary, actualGrossSalary, 0.001);
		
		assertEquals(expectedNetSalary, actualNetSalary, 0.001);
	}
	
	//testing darth's pay decrease(!) by 50%
	@Test
	public void test8() {
		darth.increaseSalary(-50);
		
		double expectedGrossSalary = 1000000.005;
		double expectedNetSalary = 900000.0045;
		
		double actualGrossSalary = darth.getMonthlyGrossSalary();
		double actualNetSalary = darth.getMonthlyNetSalary(); 
		
		assertEquals(expectedGrossSalary, actualGrossSalary, 0.001);
		
		assertEquals(expectedNetSalary, actualNetSalary, 0.001);
	}
	
	//testing wilfred's pay increase by 5%
	@Test
	public void test9() {
		wilfred.increaseSalary(10);
		
		double expectedGrossSalary = 30801.1;
		double expectedNetSalary = 21560.77;
		
		double actualGrossSalary = wilfred.getMonthlyGrossSalary();
		double actualNetSalary = wilfred.getMonthlyNetSalary();
		
		assertEquals(expectedGrossSalary, actualGrossSalary, 0.001);
		
		assertEquals(expectedNetSalary, actualNetSalary, 0.001);
		
	}
}
