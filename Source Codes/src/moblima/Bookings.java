package moblima;

public class Bookings extends Movie_goer {

	private int customerName;
	String transactionID;
	private String emailAdd;
	private String movie;
	private int seatNum;
	private int dateTime;
	
	public Bookings() {}
	
	public Bookings(int cust_name, String transaction_id, String email_id, String movieBooked, int numOfSeats, String firstSeat) {
		this.customerName = cust_name;
		this.transactionID = transaction_id;
		this.emailAdd = email_id;
		this.movie = movieBooked;
		this.seatNum = numOfSeats;
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
// For reference:
/*
package model;

import model.show;
import controller.*;
import java.io.*;
/**
 * holds information about a particular booking
 * @version 1.0
 *
 *
public class Booking{

    /**
     * customer ID of the person who has made the booking
     *
	private int custID;
	/**
	 * unique booking ID of the booking
	 *
    String bookingID;
    /**
     * movie name booked by the customer
     *
    private String movieBooked;
    /**
     * number of seats to be booked
     *
    private int numseats;
    /**
     * first and last seat to be booked
     *
    private String firstseat;
    /**
     * show object of the show to booked
     *
    private show show;
    /**
     * email ID of the customer
     *
    private String emailID;
    /**
     * date and time of the show
     *
    private String dateTime;
    
    public Booking() {};
    /**
     * booking constructor 
     * @param custID customer ID of the person making the booking
     * @param movieBooked name of the movie booked
     * @param numseats number of seats to be booked
     * @param firstseat first seat of the booking
     * @param lastseat last seat of the booking
     * @param show show object of the show to be booked
     * @param emailID email ID of the customer
     *
    public Booking(int custID, String bookingID, String movieBooked,int numseats, String firstseat, show show, String emailID){
        this.custID = custID;
    	
        //assign according to number of bookings
   
        this.movieBooked = movieBooked;
        
        this.bookingID = bookingID;

        this.numseats = numseats;
       
        this.firstseat = firstseat;
        
        this.emailID = emailID;
        
        this.setShow(show);
    }
    /**
     * gets the name of the movie booked
     * @return name of the movie booked
     *
    public String getmovieBooked() {
    	return movieBooked;
    }
    /**
     * gets the ID of the booking made
     * @return ID of the booking
     *
    public String getbookingID() {
    	return bookingID;
    }
    /**
     * gets the number of seats booked in the booking
     * @return number of seats booked
     *
    public int getnumseats() {
    	return numseats;
    }
    /**
     * gets the first seat of the booking
     * @return first seat of the booking
     *
    public String getfirstseat() {
    	return firstseat;
    }
    /**
     * sets the name of the movie booked
     * @param movieBooked	object of the movie to be booked
     *
    public void setmovieBooked(String movieBooked) {
    	this.movieBooked = movieBooked;
    }
    /**
     * sets the booking ID of the booking
     * @param bookingID transaction ID of the booking to be booked
     *
    public void setbookingID(String bookingID ) {
    	this.bookingID = bookingID;
    }
    /**
     * sets the number of seats booked
     * @param numseats number of seats
     *
    public void setnumseats(int numseats) {
    	this.numseats = numseats;
    }
    /**
     * sets the first seat of the booking
     * @param firstseat first seat of the booking
     *
    public void setfirstseat(String firstseat) {
    	this.firstseat = firstseat;
    }
    /**
     * gets the customer ID of the person making the booking
     * @return customer ID of the booker
     *
	public int getCustID() {
		return custID;
	}
	/**
	 * sets the customer ID of the booker
	 * @param custID customer ID of the booker
	 *
	public void setCustID(int custID) {
		this.custID = custID;
	}
	/**
	 * gets the show for which the booking is done
	 * @return show object for which the booking is made
	 *
	public show getShow() {
		return show;
	}
	/**
	 * sets the show for which the booking is made
	 * @param show show for which the booking is to be made
	 *
	public void setShow(show show) {
		this.show = show;
	}
	/**
	 * gets the email ID of the customer
	 * @return email ID	email ID of the customer
	 *
	public String getemailID() {
		return emailID;
	}
	/**
	 * sets the customer email ID of the customer
	 * @param emailID customer ID of the customer
	 *
	public void setemailID(String emailID) {
		this.emailID = emailID;
	}
	/**
	 * get the date and time of the show
	 * @return	date and time of the show
	 *
	public String getDateTime() {
		return dateTime;
	}
	/**
	 * sets the date and time of the show
	 * @param dateTime date and time of the show
	 *
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
}
*/