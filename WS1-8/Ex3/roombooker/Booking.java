package roombooker;
/**
 * Booking is a class to create the profile of a room booking.
 * We establish four field variables:
 * 
 * room 	- is the room to be booked of type String
 * date 	- is the date for the room to be booked of type Date
 * hour 	- is the hour for the room to be booked from of type int
 * purpose 	- is the reason for the room booking of type String
 * @author Chirag
 *
 */

public class Booking {

	private String room;
	private Date date;
	private int hour;
	private String purpose;
	
	/**
	 * Booking is a constructor to create the profile of a booking
	 * @param room is the room to be booked as type String
	 * @param date is the date for the room to be booked as type Date
	 * @param hour is the hour for the room to be booked from as type int
	 * @param purpose is the reason for booking the room as type String
	 */
	public Booking(String room, Date date, int hour, String purpose) { 
		this.room = room;
		this.date = date;
		this.hour = hour;
		this.purpose = purpose;
	}

	/**
	 * 
	 * @return the room to be booked as a String
	 */
	public String getRoom() {
		return room;
	}

	/**
	 * 
	 * @return the date the room is to be booked as type Date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * 
	 * @return the hour from which the room is to booked from as type int
	 */
	public int getHour() {
		return hour;
	}

	/**
	 * 
	 * @return the purpose for the room booking as type String
	 */
	public String getPurpose() {
		return purpose;
	}

	/**
	 * Sets the room to be booked
	 * @param room
	 */
	public void setRoom(String room) {
		this.room = room;
	}

	/**
	 * Sets the date for the room to be booked
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/** 
	 * Sets the hour the room is to be booked from
	 * @param hour
	 */
	public void setHour(int hour) {
		this.hour = hour;
	}

	/** 
	 * Sets the purpose for the room booking
	 * @param purpose
	 */
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

}
