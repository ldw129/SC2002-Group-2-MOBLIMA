package moblima;

public class Bookings extends Movie_goer {

	private int bookingID;
	private int seatNum;
	private int dateTime;

	public int getBookingID() {
		return this.bookingID;
	}

	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
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