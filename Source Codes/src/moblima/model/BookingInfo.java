package moblima.model;

import java.util.Calendar;
/**
 * Contains the booking info for each booking
 */

public class BookingInfo extends Movie_goer {

	/**
	 * this is the customer name
	 */
	private String customerName;
	/** 
	 * the transcation id when booking the tickets
	 */ 
	private String transactionID;
	/**
	 * Contains the cinema code 
	 */
	private String cinemaCode;
	/**
	 * customer email
	 */
	private String emailAdd;
	/**
	 * movie listed
	 */
	private String movie;
	/**
	 * seat booked
	 */
	private int seatNum;
	/**
	 * date and time of the movie
	 */
	private String dateTime;
	/**
	 * pointer to the seats booked
	 */
	private String firstSeat;
	
	public BookingInfo() {}
	/**
	 * constructor for BookingInfo
	 * @param cust_name
	 * @param transaction_id
	 * @param email_id
	 * @param movieBooked
	 * @param numOfSeats
	 * @param firstSeat
	 */
	public BookingInfo(String cust_name, String transaction_id, String email_id, String movieBooked, int numOfSeats, String firstSeat) {
		this.customerName = cust_name;
		this.transactionID = transaction_id;
		this.emailAdd = email_id;
		this.movie = movieBooked;
		this.seatNum = numOfSeats;
		// Assume the user books neighbouring seats, to the left or right of firstSeat.
		this.firstSeat = firstSeat;
	}
	
	/**
	 * gives the cinemaCode
	 * @param cineplexID
	 */
	public BookingInfo(int cineplexID) {
		if (cineplexID+1 == 1)
			cinemaCode = "CCO";
		else if (cineplexID+1 == 2)
			cinemaCode = "GVJ";
		else {
			cinemaCode = "STN";
		}
	}
	/**
	 * return customer name
	 * @return
	 */
	public String getCustName() {
		return this.customerName;
	}
	/**
	 * set customer name
	 * @param cust_name
	 */
	public void setCustName(String cust_name) {
		this.customerName = cust_name;
	}
	/**
	 * creates a transaction ID to record
	 * @return
	 */
	private String createTID() {
		/* --- Cineplex Listing --- // to be changed
		1. Cathay Cineplexes Cineleisure Orchard
		2. Golden Village Jurong Point
		3. Shaw Theatres Nex
		*/
		transactionID = cinemaCode + 
				Calendar.getInstance().get(Calendar.YEAR) + 
				Calendar.getInstance().get(Calendar.MONTH) + 
				Calendar.getInstance().get(Calendar.DATE) + 
				Calendar.getInstance().get(Calendar.HOUR_OF_DAY) + 
				Calendar.getInstance().get(Calendar.MINUTE);
			
		return transactionID;
	}
	/**
	 * return CreatedID
	 * @return
	 */
	public String getTID() {
		return createTID();
	}
	/**
	 * set transaction id
	 * @param transaction_id
	 */
	public void setTID(String transaction_id) {
		this.transactionID = transaction_id;
	}
	/**
	 * return the customer's email address
	 */
	public String getEmailAddress() {
		return this.emailAdd;
	}
	/**
	 * set the email address
	 */
	public void setEmailAddress(String email_id) {
		this.emailAdd = email_id;
	}
	/**
	 * return the movie that was booked
	 * @return
	 */
	public String getMovieBooked() {
		return this.movie;
	}
	/**
	 * set the movie booked
	 * @param movieBooked
	 */
	public void setMovieBooked(String movieBooked) {
		this.movie = movieBooked;
	}
	/**
	 * get the seatNum
	 * @return
	 */
	public int getSeatNum() {
		return this.seatNum;
	}
	/**
	 * set the seatNum
	 * @param seatNum
	 */
	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}
	/**
	 * get the pointer of the first seat
	 * we assume if booking as a group they will book adjacent seats
	 */
	public String getFirstSeat() {
		return this.firstSeat;
	}
	/**
	 * set firstSeat
	 * @param firstSeat
	 */
	public void setFirstSeat(String firstSeat) {
		this.firstSeat = firstSeat;
	}
	/**
	 * return date and time of the movie
	 * @return
	 */
	public String getDateTime() {
		return this.dateTime;
	}
	/**
	 * set the movie date and time
	 * @param dateTime
	 */
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

}