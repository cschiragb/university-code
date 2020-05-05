package roombooker;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Ex3Tests {
	
	private String[] testrooms = {"R217", "R222", "R225", "R245"};
	private int year = 2018;
	RoomBooking testbookings2018 = new RoomBooking(year, testrooms);
	Date nov22 = new Date(22, "November", 2018);

	// Testing getter and setter for year
	@Test
	public void test1() {
		
		testbookings2018.setYear(2019);
		int expectedyear = 2019;
		int actualyear = testbookings2018.getYear();
		
		assertEquals(expectedyear, actualyear);
	}
	
	// Testing getter and setter for room
	@Test
	public void test2() {
		
		String[] testrooms = {"H1", "H2", "H3"};
		testbookings2018.setRooms(testrooms);
		
		String expectedroom = "H1";
		String actualroom = testbookings2018.getRooms()[0];
		
		assertEquals(expectedroom, actualroom);
	}
	
	// Testing getter and setter for allowable booking times
	@Test
	public void test3() {
		
		int[] allowableTimes = {8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
		testbookings2018.setAllowableTimes(allowableTimes);
		
		int expectedtime = 8;
		int actualtime = testbookings2018.getAllowableTimes()[0];
		
		assertEquals(expectedtime, actualtime);
	}
	
	// Testing hourChecker method with a non-permitted time
	@Test
	public void test4() {
		
		int[] allowableTimes = {8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
		testbookings2018.setAllowableTimes(allowableTimes);
		
		Boolean expectedboolean = false;
		Boolean actualboolean = testbookings2018.hourChecker(7);
		
		assertEquals(expectedboolean, actualboolean);
	}
	
	// Testing hourChecker method with an already permitted time
	@Test
	public void test5() {
			
		int[] allowableTimes = {8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
		testbookings2018.setAllowableTimes(allowableTimes);
			
		Boolean expectedboolean = true;
		Boolean actualboolean = testbookings2018.hourChecker(8);
			
		assertEquals(expectedboolean, actualboolean);
	}
	
	// Testing roomChecker method with a non-listed room
	@Test
	public void test6() {
		
		Boolean expectedboolean = false;
		Boolean actualboolean = testbookings2018.roomChecker("R999");
		
		assertEquals(expectedboolean, actualboolean);
	}
	
	// Testing roomChecker method with an already listed room
	@Test
	public void test7() {
			
		Boolean expectedboolean = true;
		Boolean actualboolean = testbookings2018.roomChecker("R217");
			
		assertEquals(expectedboolean, actualboolean);
	}
	
	// Testing roomAdder method with a room not currently in the list
	@Test
	public void test8() {
		
		testbookings2018.roomAdder("R300");
		
		String expectedroom = "R300";
		String actualroom = testbookings2018.getRooms()[testbookings2018.getRooms().length - 1];
		
		assertEquals(expectedroom, actualroom);
		
	}
	
	// Testing roomAdder method throws exception when trying to add an already existing room
	@Test (expected = IllegalArgumentException.class)
	public void test9() {
		
		testbookings2018.roomAdder("R217");
		
	}
	
	
	// Testing bookingChecker method throws exception when a booking for a different year is asked to be checked
	@Test (expected = IllegalArgumentException.class)
	public void test10() {
		
		Date nov22 = new Date(22, "November", 2019);
		testbookings2018.bookingChecker("R222", nov22, 12);
	}
	
	// Testing bookingChecker returns true if it finds an already existing booking
	@Test
	public void test11() {
		
		testbookings2018.book("R222", nov22, 12, "Tutor meeting");
		testbookings2018.book("R222", nov22, 12, "Java meeting");
		testbookings2018.book("R222", nov22, 13, "Interviews");
		testbookings2018.book("R245", nov22, 16, "Project meeting");
		testbookings2018.book("R225", nov22, 14, "Top-up tutorial");
		
		Boolean expectedboolean = true;
		Boolean actualboolean = testbookings2018.bookingChecker("R225", nov22, 14);
		
		assertEquals(expectedboolean, actualboolean);
	}
	
	// Testing bookingChecker returns false if it cannot find a booking with the provided details
	@Test
	public void test12() {
		
		testbookings2018.book("R222", nov22, 12, "Tutor meeting");
		testbookings2018.book("R222", nov22, 12, "Java meeting");
		testbookings2018.book("R222", nov22, 13, "Interviews");
		testbookings2018.book("R245", nov22, 16, "Project meeting");
		testbookings2018.book("R225", nov22, 14, "Top-up tutorial");
		
		Boolean expectedboolean = false;
		Boolean actualboolean = testbookings2018.bookingChecker("R225", nov22, 12);
		
		assertEquals(expectedboolean, actualboolean);
	}
	
	// Test book method updates the arrayList of bookings
	// Then check that when you make a booking it returns true.
	// To be sure also check that the bookings are added correctly by cross checking the purpose of the last booking to the arraylist.
	@Test
	public void test13() {
		
		testbookings2018.book("R222", nov22, 12, "Tutor meeting");
		// testbookings2018.book("R222", nov22, 12, "Java meeting");
		testbookings2018.book("R222", nov22, 13, "Interviews");
		testbookings2018.book("R245", nov22, 16, "Project meeting");
		testbookings2018.book("R225", nov22, 14, "Top-up tutorial");
		
		int expectnumberofbookings = 4;
		int actualnumberofbookings = testbookings2018.getBookings().size();
		
		assertEquals(expectnumberofbookings,actualnumberofbookings);
		
		Boolean expectedboolean = true;
		Boolean actualboolean = testbookings2018.book("R225", nov22, 11, "Class Test");
		
		assertEquals(expectedboolean, actualboolean);
		
		String expectedpurpose = "Class Test";
		String actualpurpose = testbookings2018.getBookings().get(testbookings2018.getBookings().size()-1).getPurpose();
		
		assertEquals(expectedpurpose, actualpurpose);
	}
	
	// Test book method throws an exception when a booking on a different year (2019) is requested to be made from 2018.
	@Test (expected = IllegalArgumentException.class)
	public void test14() {
		
		Date nov22 = new Date(22, "November", 2019);
		testbookings2018.book("R222", nov22, 12, "Tutor meeting");
	}	
	
	// Check that when you add a booking for the same room, date and time, the booking is not able to made and the method returns false
	@Test
	public void test15() {
		
		testbookings2018.book("R222", nov22, 12, "Tutor meeting");
		testbookings2018.book("R222", nov22, 13, "Interviews");
		testbookings2018.book("R245", nov22, 16, "Project meeting");
		testbookings2018.book("R225", nov22, 14, "Top-up tutorial");
		
		Boolean expectedboolean = false;
		Boolean actualboolean = testbookings2018.book("R222", nov22, 12, "Java meeting");
		
		assertEquals(expectedboolean, actualboolean);
	}
	
	// Check bookingPurposeChecker method throws exception when the purpose of a booking on a different year (2019) is requested
	@Test (expected = IllegalArgumentException.class)
	public void test16() {
		
		Date nov23 = new Date(23, "November", 2019);
		testbookings2018.bookingPurposeChecker("R222", nov23, 12);
	}
	
	// Check bookingPurposeChecker returns the purpose as expected for an existing booking that is cross checked
	@Test 
	public void test17() {
		
		Date nov22 = new Date(22, "November", 2018);
		testbookings2018.book("R222", nov22, 12, "Tutor meeting");
		testbookings2018.book("R222", nov22, 13, "Interviews");
		testbookings2018.book("R245", nov22, 16, "Project meeting");
		testbookings2018.book("R225", nov22, 14, "Top-up tutorial");
		
		String expectedpurpose = "Tutor meeting";
		String actualpurpose = testbookings2018.bookingPurposeChecker("R222", nov22, 12);
		
		assertEquals(expectedpurpose, actualpurpose);
	}
	
	// Check bookingPurposeChecker returns a blank space if a purpose for a room booking cannot be found for a 
	// valid room, date and time supplied.
	@Test 
	public void test18() {
			
		Date nov22 = new Date(22, "November", 2018);
		testbookings2018.book("R222", nov22, 12, "Tutor meeting");
		testbookings2018.book("R222", nov22, 13, "Interviews");
		testbookings2018.book("R245", nov22, 16, "Project meeting");
		testbookings2018.book("R225", nov22, 14, "Top-up tutorial");
			
		String expectedpurpose = " ";
		String actualpurpose = testbookings2018.bookingPurposeChecker("R222", nov22, 14);
			
		assertEquals(expectedpurpose, actualpurpose);
	}
	
	// Check that cancel method throws an exception if a booking for a different year (2019) is requested from 2018.
	@Test (expected = IllegalArgumentException.class)
	public void test19() {
		
		Date nov23 = new Date(23, "November", 2019);
		testbookings2018.book("R222", nov22, 12, "Tutor meeting");
		testbookings2018.book("R222", nov22, 13, "Interviews");
		testbookings2018.book("R245", nov22, 16, "Project meeting");
		testbookings2018.book("R225", nov22, 14, "Top-up tutorial");
		
		testbookings2018.cancel("R225", nov23, 14);
		
	}
	
	// Check that cancel method throws an exception if a booking represented by valid arguments, is to be cancelled but cannot be found
	@Test (expected = IllegalArgumentException.class)
	public void test20() {

		testbookings2018.book("R222", nov22, 12, "Tutor meeting");
		testbookings2018.book("R222", nov22, 13, "Interviews");
		testbookings2018.book("R245", nov22, 16, "Project meeting");
		testbookings2018.book("R225", nov22, 14, "Top-up tutorial");

		testbookings2018.cancel("R225", nov22, 15);
	}
	
	// Check that cancel method removes a booking from the arraylist of bookings by checking the size of the array list before and after
	// Check that it has removed the correct booking on the list by cross checking the purpose of the last entry on the list following a cancellation
	@Test
	public void test21() {

		testbookings2018.book("R222", nov22, 12, "Tutor meeting");
		testbookings2018.book("R222", nov22, 13, "Interviews");
		testbookings2018.book("R245", nov22, 16, "Project meeting");
		testbookings2018.book("R225", nov22, 14, "Top-up tutorial");
		
		int expectedsize = 4;
		int actualsize = testbookings2018.getBookings().size();
		assertEquals(expectedsize, actualsize);
		
		testbookings2018.cancel("R225", nov22, 14);
		
		int expectedsize2 = 3;
		int actualsize2 = testbookings2018.getBookings().size();
		
		assertEquals(expectedsize2, actualsize2);
		
		String expectedpurpose = "Project meeting";
		String actualpurpose = testbookings2018.getBookings().get(testbookings2018.getBookings().size() - 1).getPurpose();
		
		assertEquals(expectedpurpose, actualpurpose);
	}
}
