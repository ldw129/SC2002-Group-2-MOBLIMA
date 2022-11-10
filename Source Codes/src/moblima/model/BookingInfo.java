package moblima.model;

public class BookingInfo extends Movie_goer {

	private int customerName;
	String transactionID;
	private String emailAdd;
	private String movie;
	private int seatNum;
	private int dateTime;
	private String firstSeat;
	
	public BookingInfo() {}
	
	public BookingInfo(int cust_name, String transaction_id, String email_id, String movieBooked, int numOfSeats, String firstSeat) {
		this.customerName = cust_name;
		this.transactionID = transaction_id;
		this.emailAdd = email_id;
		this.movie = movieBooked;
		this.seatNum = numOfSeats;
		// Assume the user books neighbouring seats, to the left or right of firstSeat.
		this.firstSeat = firstSeat;
	}

	public String getTID() {
		return this.transactionID;
	}

	public void setTID(String transactionID) {
		this.transactionID = transactionID;
	}

	public int getSeatNum() {
		return this.seatNum;
	}

	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}

	public int getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(int dateTime) {
		this.dateTime = dateTime;
	}

}