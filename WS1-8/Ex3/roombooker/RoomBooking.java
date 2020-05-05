package roombooker;
import java.util.ArrayList;

public class RoomBooking {
	
	private int year;
	private String[] rooms;
	private int[] allowableTimes = {9, 10, 11, 12, 13, 14, 15, 16, 17};
	private ArrayList <Booking> bookings;
	
	
	/**
	 * 
	 * @param year
	 * @param rooms
	 */
	public RoomBooking(int year, String[] rooms) {
		this.year = year;
		this.rooms = rooms;
		this.bookings = new ArrayList <Booking>();
	}
	
	
	/**
	 * 
	 * @return the year for the room bookings as type int
	 */
	public int getYear() {
		return year;
	}

	
	/**
	 * 
	 * @return the rooms available for booking for the year as type String[]
	 */
	public String[] getRooms() {
		return rooms;
	}

	
	/**
	 * 
	 * @return the hours / times at which the rooms can be booked for the year as type int[]
	 */
	public int[] getAllowableTimes() {
		return allowableTimes;
	}
	
	
	/**
	 * 
	 * @return the arrayList of bookings of type Booking
	 */
	public ArrayList<Booking> getBookings() {
		return bookings;
	}

	
	/**
	 * Sets the year for the bookings
	 * @param year
	 */
	public void setYear(int year) {
		this.year = year;
	}

	
	/**
	 * Sets the rooms available for booking for the given year
	 * @param rooms
	 */
	public void setRooms(String[] rooms) {
		this.rooms = rooms;
	}

	
	/**
	 * Sets the room bookings for the year on an arrayList of type Booking
	 * @param bookings
	 */
	public void setBookings(ArrayList<Booking> bookings) {
		this.bookings = bookings;
	}
	
	
	/**
	 * sets the allowable hours / times the rooms can be booked for this year
	 * @param allowableTimes
	 */
	public void setAllowableTimes(int[] allowableTimes) {
		this.allowableTimes = allowableTimes;
	}
	
	
	/**
	 * hourChecker is a method to check if the time requested is on the array of allowable
	 * times that rooms can be booked for the year.
	 * @param hour
	 * @return TRUE is the time is on the array, otherwise FALSE.
	 */
	public boolean hourChecker(int hour) {
		for (int i = 0; i < allowableTimes.length; i++) {
			if (allowableTimes[i] == hour) {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * roomChecker is a method to check if the room requested is on the array of rooms
	 * that can be booked for the year.
	 * @param room
	 * @return TRUE if the room is on the array, otherwise FALSE.
	 */
	public boolean roomChecker(String room) {
		for (int i = 0; i < rooms.length; i++) {
			if (room.equals(rooms[i]) == true) {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * roomAdder is a method for adding a new room that can be booked for the year.
	 * The method checked the existing rooms to see if the room already exists, if it does exist an exception is thrown. 
	 * Otherwise the new room is added onto the end of the existing array of rooms that can be booked for future use,
	 * and the rooms array is therefore updated with the new room.
	 * @param room
	 */
	public void roomAdder(String room) {
		
		if (roomChecker(room) == false) {
			String [] newrooms = new String[rooms.length +1];
			for (int i=0; i < rooms.length; i++) {
				newrooms[i] = rooms[i];
			}
			newrooms[newrooms.length-1] = room;
			rooms = newrooms;
		}
		else throw new IllegalArgumentException();
	}
	
	
	/**
	 * bookingChecker is a method to check whether a booking already exists for the same room,
	 * same date and same hour.
	 * 
	 * @param room
	 * @param date
	 * @param hour
	 * @return TRUE if there is already a booking, otherwise FALSE.
	 */
	public boolean bookingChecker(String room, Date date, int hour) {
		
		if (date.getYear() != getYear()) {
			throw new IllegalArgumentException();
			
		} else {
			for (Booking element:bookings) {
				if (element.getRoom().equals(room) && element.getDate() == date && element.getHour() == hour) {
					return true;
				}
			}
			return false;
		}
			
	}
	
	
	/**
	 * book is a method to record the booking of a room if no existing booking for the same room, same date 
	 * and same time is not already present, and that the room and time requested is valid and able to be booked.
	 * @param room
	 * @param date
	 * @param hour
	 * @param purpose
	 * @return TRUE if the booking has been added to the list of bookings. Return FALSE if the booking cannot be made.
	 */
	public boolean book(String room, Date date, int hour, String purpose) {
		
		if (date.getYear() != getYear()) {
			
			throw new IllegalArgumentException();
			
		} else if (roomChecker(room) == true && hourChecker(hour) == true && bookingChecker(room, date, hour) == false) {
			
			Booking newBooking = new Booking(room, date, hour, purpose);
			
			bookings.add(newBooking);
			
			return true;
		}
		return false;
	}
	

	/**
	 * bookingPurposeChecker is a method to find the purpose for a room booking, if such a
	 * booking can be found.
	 * @param room
	 * @param date
	 * @param hour
	 * @return the purpose as a String if the booking is found, otherwise return a blank String.
	 */
	public String bookingPurposeChecker(String room, Date date, int hour) {
		
		if (date.getYear() != getYear()) {
			
			throw new IllegalArgumentException();
			
		} else {
			
			for (Booking element:bookings) {
				
				if (element.getRoom().equals(room) && element.getDate() == date && element.getHour() == hour) {
					
					return element.getPurpose();
				}
			}
			return " ";
		}
	}
	
	
	/**
	 * cancel is a method to remove an existing booking from the list of bookings. If the booking to be cancelled can be
	 * found on the list, an exception is thrown. Otherwise the booking is removed from the list of bookings.
	 * @param room
	 * @param date
	 * @param hour
	 */
	public void cancel(String room, Date date, int hour) {
	
		if (date.getYear() != getYear()) {
			
			throw new IllegalArgumentException();
			
		} else if (bookingChecker(room, date, hour) == false) {
			
			throw new IllegalArgumentException();
			
		} else for (int i=0; i<bookings.size(); i++) {
			
			if (bookings.get(i).getRoom().equals(room) && bookings.get(i).getDate() == date && bookings.get(i).getHour() == hour) {
				
				bookings.remove(i);
				
				break;
			}
		}
	}

	/*
	 *The methods below are used to create a String showing the room bookings on a particular date, on a timetable format
	 *of room versus time booked.
	 */
	
	
	/**
	 * displayHeader is a method to create a string of the available rooms to be printed at the top of a room booking 
	 * time table
	 * @return the displayHeader
	 */
	public String displayHeader(Date date) {
		
		StringBuilder displayHeader = new StringBuilder(); // Use a string builder to build the display header
		
		displayHeader.append(String.format("%70s" , (date.toString() + "\n"))); // Add the date and a new line at the top of the header
		
		displayHeader.append("\n\t" + "|"); // Add a blank portion before listing the rooms along the top header
		
		for (int i = 0; i < rooms.length; i++) {
			
			displayHeader.append(String.format("%20s %12s" , rooms[i], "|")); // List the rooms in their own portions in the header
			
		}
		
		return displayHeader.toString();
	}
	
	/**
	 * lineBreaker is a method to create a string of a line breaker to be used in the print of a room booking timetable
	 * @return the line break
	 */
	public String lineBreaker() {
		
		StringBuilder lineBreaker = new StringBuilder(); // Use a string builder to build the line breakers
		
		String linebreakfirstpart = "\n" + "--------"; // Make the first part of a line breaker on a new line. Add dashes for the time column
		String linebreaksecondpart = "+" + "--------------------------------"; // Put a plus and dashes onto the line breaker for the room columns
		String linebreakend = "+" + "\n"; // Put a plus and move the string onto a new line at the end of a line breaker
		
		lineBreaker.append(linebreakfirstpart); // Add the first part of a line breaker to the string
		
		for (int i = 0; i < rooms.length; i++) {
			
			lineBreaker.append(String.format("%15s", linebreaksecondpart, "+")); // Add line breakers under each room, accounting for all rooms.
			
		}
		
		lineBreaker.append(linebreakend); // Add the end of a line breaker once all the rooms have been accounted for by the line breaker.
		
		return lineBreaker.toString();
	}

	/**
	 * displayBookings is a method to create a string of the times rooms can be booked on a timetable, and the bookings in a given
	 * room and time for a particular date.
	 * The results are printed on to a complete room booking timetable.
	 * @param date
	 * @return
	 */
	public String displayBookings(Date date) {
		
		StringBuilder displayBookings = new StringBuilder(); // Use a string builder to build up the string of room bookings
		
		for (int i = 0; i < allowableTimes.length; i++) {
			
			String time = allowableTimes[i] + ":00" + "\t" + "|"; // for each bookable time, make a string of the time in a clock format
			
			displayBookings.append(time); // add the time in a clock format to the string builder
			
			for (int j = 0; j < rooms.length; j++) {
						displayBookings.append(String.format("%20s %12"
								+ "s", bookingPurposeChecker(rooms[j], date, allowableTimes[i]), "|"));
						// for each room and time, if there is a booking, get the purpose of the booking and add this to the string builder
			}
			displayBookings.append(lineBreaker());  // for each hour to be considered in the string, make a line breaker below it.
		}
		return displayBookings.toString();
	}
	
	/**
	 * Display day is method to compile the final string containing the room booking timetable for a given date.
	 * It is constructed of the display header, a line breaker, and then all the booking details.
	 * The display is dynamic, as in it considers all rooms and times that are available to book for that year
	 * and prints the display string accordingly.
	 * @param date
	 * @return the room booking timetable for a given date
	 */
	public String displayDay(Date date) {
		
		StringBuilder displayDay = new StringBuilder(); // Use a string builder to build up String for the room booking timetable
		
		displayDay.append(displayHeader(date)); // add the room header to the room booking timetable first
		displayDay.append(lineBreaker()); // add a line breaker under the room header next
		displayDay.append(displayBookings(date)); // add all the hours available to book and the bookings next
		
		return displayDay.toString();
	}
	
	
//	/** 
// 	 * PLEASE REMOVE COMMENTS IF REQUIRED TO TEST THE STRING DISPLAY / displayDay method IF REQUIRED
//   * ---------------
//	 * Main method has been provided to able to test the string screen display with the provided question example bookings.
//	 * A new display is also printed that adds room R999 to the display with further allowable times also.
//	 * New further additional bookings are added and displayed following these changes.
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		
//		String[] testrooms = {"R217", "R222", "R225", "R245"};
//		RoomBooking bookings2018 = new RoomBooking(2018, testrooms);
//		
//		Date nov22 = new Date(22, "November", 2018);
//		
//		bookings2018.book("R222", nov22, 12, "Tutor meeting");
//		bookings2018.book("R222", nov22, 12, "Java meeting");
//		bookings2018.book("R222", nov22, 13, "Interviews");
//		bookings2018.book("R245", nov22, 16, "Project meeting");
//		bookings2018.book("R225", nov22, 14, "Top-up tutorial");
//		
//		System.out.println(bookings2018.displayDay(nov22));
//	
//		int[] newtimes = {8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
//		bookings2018.setAllowableTimes(newtimes);
//		bookings2018.roomAdder("R999");
//		bookings2018.book("R217", nov22, 10, "Seminar");
//		bookings2018.book("R999", nov22, 8, "Class Test");
//		bookings2018.book("R999", nov22, 18, "Rehearsal");
//		
//		System.out.println(bookings2018.displayDay(nov22));
		
//	}
	
}
	
