package moblima.model;

import java.util.Calendar;


/**
 * Class to contain the booking info for each booking
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
	/**
	 * ID of cineplex chosen
	 */
	private int cineplexID;
	
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
		this.firstSeat = firstSeat;
	}
	
	/**
	 * separate constructor for BookingInfo
	 * @param cust_name
	 * @param transaction_id
	 * @param email_id
	 * @param movieBooked
	 * @param numOfSeats
	 * @param firstSeat
	 * @param cineplexID
	 */
	
	public BookingInfo(String cust_name, String transaction_id, String email_id, String movieBooked, int numOfSeats, String firstSeat, int cineplexID) {
		this(cust_name, transaction_id, email_id, movieBooked, numOfSeats, firstSeat);
		this.cineplexID = cineplexID;
	}
	
	/**
	 * return cinemaCode
	 * @return cinemaCode
	 */
	public String createCinemaCode() {
		if (cineplexID+1 == 1)
			cinemaCode = "CCO";
		else if (cineplexID+1 == 2)
			cinemaCode = "GVJ";
		else {
			cinemaCode = "STN";
		}
		
		return cinemaCode;
	}
	/**
	 * return customer name
	 * @return customerName
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
	 * @return transactionID
	 */
	public String createTID() {
		/* --- Cineplex Listing --- // to be changed
		1. Cathay Cineplexes Cineleisure Orchard
		2. Golden Village Jurong Point
		3. Shaw Theatres Nex
		*/
		cinemaCode = createCinemaCode();
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
	 * @return transactionID
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
	 * @return email
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
	 * @return movie
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
	 * @return seatNum
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
	 * @return dateTime
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