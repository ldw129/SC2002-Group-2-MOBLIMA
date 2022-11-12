package moblima.model;

import java.util.Calendar;

public class BookingInfo extends Movie_goer {

	private String customerName;
	private String transactionID;
	private String cinemaCode;
	private String emailAdd;
	private String movie;
	private int seatNum;
	private String dateTime;
	private String firstSeat;
	
	public BookingInfo() {}
	
	public BookingInfo(String cust_name, String transaction_id, String email_id, String movieBooked, int numOfSeats, String firstSeat) {
		this.customerName = cust_name;
		this.transactionID = transaction_id;
		this.emailAdd = email_id;
		this.movie = movieBooked;
		this.seatNum = numOfSeats;
		// Assume the user books neighbouring seats, to the left or right of firstSeat.
		this.firstSeat = firstSeat;
	}
	
	public BookingInfo(int cineplexID) {
		if (cineplexID+1 == 1)
			cinemaCode = "CCO";
		else if (cineplexID+1 == 2)
			cinemaCode = "GVJ";
		else {
			cinemaCode = "STN";
		}
	}
	
	public String getCustName() {
		return this.customerName;
	}
	
	public void setCustName(String cust_name) {
		this.customerName = cust_name;
	}
	
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

	public String getTID() {
		return createTID();
	}

	public void setTID(String transaction_id) {
		this.transactionID = transaction_id;
	}
	
	public String getEmailAddress() {
		return this.emailAdd;
	}
	
	public void setEmailAddress(String email_id) {
		this.emailAdd = email_id;
	}
	
	public String getMovieBooked() {
		return this.movie;
	}
	
	public void setMovieBooked(String movieBooked) {
		this.movie = movieBooked;
	}

	public int getSeatNum() {
		return this.seatNum;
	}

	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}
	
	public String getFirstSeat() {
		return this.firstSeat;
	}
	
	public void setFirstSeat(String firstSeat) {
		this.firstSeat = firstSeat;
	}

	public String getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

}