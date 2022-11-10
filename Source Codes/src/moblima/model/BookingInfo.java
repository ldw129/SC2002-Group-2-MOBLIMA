package moblima.model;

public class BookingInfo extends Movie_goer {

	private String customerName;
	String transactionID;
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
	
	public String getCustName() {
		return this.customerName;
	}
	
	public void setCustName(String cust_name) {
		this.customerName = cust_name;
	}

	public String getTID() {
		return this.transactionID;
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