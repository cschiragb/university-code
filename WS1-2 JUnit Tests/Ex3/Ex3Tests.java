
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class Ex3Tests {

	private Employee john;
	private Employee mary;
	private final static double TOLERANCE = 0.0001;

	@Before
	public void setup() {
		john = new Employee("John Smith", 15000, 20);
		mary = new Employee("Mary Jones", 23540, 45);
	}

	//testing getters for john
	@Test
	public void test1() {
		String expectedName = "John Smith";
		double expectedTaxRate = 20;
		double expectedGrossSalary = 15000;
		double expectedNetSalary = 12000;

		String actualName = john.getName();
		double actualTaxRate = john.getTaxRate();
		double actualGrossSalary = john.getMonthlyGrossSalary();
		double actualNetSalary = john.getMonthlyNetSalary();

		assertEquals(expectedName, actualName);
		assertEquals(expectedTaxRate, actualTaxRate, TOLERANCE);
		assertEquals(expectedGrossSalary, actualGrossSalary, TOLERANCE);
		assertEquals(expectedNetSalary, actualNetSalary, TOLERANCE);
	}

	// testing getters for mary
	@Test
	public void test2() {
		String expectedName = "Mary Jones";
		double expectedTaxRate = 45;
		double expectedGrossSalary = 23540;
		double expectedNetSalary = 12947;

		String actualName = mary.getName();
		double actualTaxRate = mary.getTaxRate(); 
		double actualGrossSalary = mary.getMonthlyGrossSalary();
		double actualNetSalary = mary.getMonthlyNetSalary();

		assertEquals(expectedName, actualName);
		assertEquals(expectedTaxRate, actualTaxRate, TOLERANCE);
		assertEquals(expectedGrossSalary, actualGrossSalary, TOLERANCE);
		assertEquals(expectedNetSalary, actualNetSalary, TOLERANCE);
	}

	//testing john's salaries after
	//changing tax rate
	@Test
	public void test3() {

		john.setTaxRate(0);

		double expectedGrossSalary = 15000;
		double expectedNetSalary = 15000;

		double actualGrossSalary = john.getMonthlyGrossSalary();
		double actualNetSalary = john.getMonthlyNetSalary();

		assertEquals(expectedGrossSalary, actualGrossSalary, TOLERANCE);

		assertEquals(expectedNetSalary, actualNetSalary, TOLERANCE);
	}

	//testing mary's salaries after
	//changing tax rate
	@Test
	public void test4() {

		mary.setTaxRate(-22);

		double expectedGrossSalary = 23540;
		double expectedNetSalary = 28718.8;

		double actualGrossSalary = mary.getMonthlyGrossSalary();
		double actualNetSalary = mary.getMonthlyNetSalary();

		assertEquals(expectedGrossSalary, actualGrossSalary, TOLERANCE);

		assertEquals(expectedNetSalary, actualNetSalary, TOLERANCE);
	}

	//testing john's salaries
	@Test
	public void test5() {

		john.setTaxRate(29.34);

		john.setMonthlyGrossSalary(45823);
		
		john.increaseSalary(4.9);
		
		double expectedGrossSalary = 48068.327;
		double expectedNetSalary = 33965.08;

		double actualGrossSalary = john.getMonthlyGrossSalary();
		double actualNetSalary = john.getMonthlyNetSalary();

		assertEquals(expectedGrossSalary, actualGrossSalary, 0.001);

		assertEquals(expectedNetSalary, actualNetSalary, 0.001);
	}
	
	//testing mary's salaries
	@Test
	public void test6() {

		mary.setTaxRate(11.25);

		mary.setMonthlyGrossSalary(45823);
		
		mary.increaseSalary(4.9);
		
		double expectedGrossSalary = 48068.327;
		double expectedNetSalary = 42660.640;

		double actualGrossSalary = mary.getMonthlyGrossSalary();
		double actualNetSalary = mary.getMonthlyNetSalary();

		assertEquals(expectedGrossSalary, actualGrossSalary, 0.001);

		assertEquals(expectedNetSalary, actualNetSalary, 0.001);
	}
}
