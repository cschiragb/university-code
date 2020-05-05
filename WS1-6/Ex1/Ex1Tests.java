import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class Ex1Tests {
	public static final double TOLERANCE = 0.00001;
	private Vehicle vehicle1, vehicle2;
	private Bus bus;
	
	@Before
	public void setUp() {
		
		vehicle1 = new Vehicle(5,110);
		bus = new Bus(80,90,45.8);
		vehicle2 = new Bus(150,100,39.9);
	}

	// testing getters of vehicle1
	@Test
	public void test1() {
		
		int expectedNumOfPassengers = 5;
		int actualNumOfPassengers = vehicle1.getPassengerNumber();
		assertEquals(expectedNumOfPassengers,actualNumOfPassengers);
	
		int expectedMaxSpeed = 110;
		int actualMaxSpeed = vehicle1.getMaxSpeed();
		assertEquals(expectedMaxSpeed,actualMaxSpeed);
	}
	
	//testing getters of bus
	@Test
	public void test2() {
		
		int expectedNumOfPassengers = 80;
		int actualNumOfPassengers = bus.getPassengerNumber();
		assertEquals(expectedNumOfPassengers,actualNumOfPassengers);
	
		int expectedMaxSpeed = 90;
		int actualMaxSpeed = bus.getMaxSpeed();
		assertEquals(expectedMaxSpeed,actualMaxSpeed);
		
		double expectedFuelCons = 45.8;
		double actualFuelCons = bus.getFuelConsumption();
		assertEquals(expectedFuelCons,actualFuelCons,TOLERANCE);
	}
	
	//testing setters of vehicle1
	@Test
	public void test3() {
		
		vehicle1.setPassengerNumber(38);
		int expectedNumOfPassengers = 38;
		int actualNumOfPassengers = vehicle1.getPassengerNumber();
		assertEquals(expectedNumOfPassengers,actualNumOfPassengers);
	
		vehicle1.setMaxSpeed(150);
		int expectedMaxSpeed = 150;
		int actualMaxSpeed = vehicle1.getMaxSpeed();
		assertEquals(expectedMaxSpeed,actualMaxSpeed);
	}
	
	// Test exception for passenger setter of vehicle1
	@Test(expected = IllegalArgumentException.class)
	public void test5() {
        
        // exception should be thrown
        vehicle1.setPassengerNumber(-5);
	}
	
	// Test exception for max speed setter of vehicle 1
	@Test(expected = IllegalArgumentException.class)
	public void test6() {
        
        // exception should be thrown
        vehicle1.setMaxSpeed(-100);
	}
	
	//testing setters of bus
	@Test
	public void test7() {
		
		bus.setPassengerNumber(150);
		int expectedNumOfPassengers = 150;
		int actualNumOfPassengers = bus.getPassengerNumber();
		assertEquals(expectedNumOfPassengers,actualNumOfPassengers);
	
		bus.setMaxSpeed(110);
		int expectedMaxSpeed = 110;
		int actualMaxSpeed = bus.getMaxSpeed();
		assertEquals(expectedMaxSpeed,actualMaxSpeed);
		
		
		bus.setFuelConsumption(47.2);
		double expectedFuelCons = 47.2;
		double actualFuelCons = bus.getFuelConsumption();
		assertEquals(expectedFuelCons,actualFuelCons,TOLERANCE);
	
	}
	
	@Test
	public void test8() {
		
		bus.setFuelConsumption(0.0);
		double expectedFuelCons = 0.0;
		double actualFuelCons = bus.getFuelConsumption();
		assertEquals(expectedFuelCons,actualFuelCons,TOLERANCE);
	}
	
	//test exception for fuel consumption setter for bus
	@Test(expected = IllegalArgumentException.class)
	public void test9() {
        
        // exception should be thrown
        bus.setFuelConsumption(-28.9);
	}
	
	//testing getters of vehicle2
	@Test
	public void test10() {
		
		int expectedNumOfPassengers = 150;
		int actualNumOfPassengers = vehicle2.getPassengerNumber();
		assertEquals(expectedNumOfPassengers,actualNumOfPassengers);
	
		int expectedMaxSpeed = 100;
		int actualMaxSpeed = vehicle2.getMaxSpeed();
		assertEquals(expectedMaxSpeed,actualMaxSpeed);
	}
	
	//testing setters of vehicle2
	@Test
	public void test11() {
		
		vehicle2.setPassengerNumber(180);
		int expectedNumOfPassengers = 180;
		int actualNumOfPassengers = vehicle2.getPassengerNumber();
		assertEquals(expectedNumOfPassengers,actualNumOfPassengers);
	
		vehicle2.setMaxSpeed(190);
		int expectedMaxSpeed = 190;
		int actualMaxSpeed = vehicle2.getMaxSpeed();
		assertEquals(expectedMaxSpeed,actualMaxSpeed);
		
	}
	
	//testing exception for setters of vehicle 2
	@Test(expected = IllegalArgumentException.class)
	public void test12() {
		
		// exception should be thrown
		vehicle2.setPassengerNumber(-10);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test13() {
		
		// exception should be thrown
		vehicle2.setMaxSpeed(-100);
	}
}
