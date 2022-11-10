package moblima.model;

import java.util.ArrayList;
import java.util.Collections;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDate;
import java.time.LocalTime;
import java.text.ParseException; 
import java.util.Scanner;

import moblima.model.BookingInfo;
import moblima.model.Cineplex;
import moblima.model.Movie;
import moblima.model.master;
import moblima.model.show;

public class Movie_goer extends Person {

	private int custID;
	private String name;
	private int age;
	private Age ageVal;
	private int mobile;
	private String email;
	private String review;
	private double rating;
	private ArrayList<BookingInfo> bookings = new ArrayList<>();
	//private String password;
	
	Scanner sc = new Scanner(System.in);
	
	public enum Age{
		CHILD(0, 12),
		STUDENT(13, 18),
		ADULT(19, 54),
		SENIOR_CITIZEN(55, 100);
		
		private final int low;
		private final int high;
		
		private Age(int low, int high) {
			this.low = low;
			this.high = high;
		}
	}
	
	public Movie_goer() {};
	
	// to be captured by Bookings
	public Movie_goer(String cust_name, int cust_mobile, String cust_email) {
		this.name = cust_name;
		this.mobile = cust_mobile;
		this.email = cust_email;
	}
	
	public Movie_goer(String cust_name, int cust_age, int cust_mobile, String cust_email, ArrayList<BookingInfo> bookings) {
		this(cust_name, cust_mobile, cust_email);
		this.age = cust_age;
		this.bookings = bookings;
	}
	
	/*public Movie_goer(String name, int age, String mobile, String email, String password) {
		Movie_goer(name, age, mobile, email, bookings);
		this.password = password;
	}*/
	
	public void setBooking (BookingInfo b) {
		if (!bookings.contains(b))
			bookings.add(b);
	}

	public int ValidateAge() {
		// Movie_goer needs to validate their age when purchasing tickets online, except if he / she is a senior citizen then
		// he / she will only validate his / her age upon entering the cinema.
		if (ageVal == Age.CHILD) {
			return 1;
		}
		else if (ageVal == Age.STUDENT) {
			return 2;
		}
		else if (ageVal == Age.ADULT)
			return 3;
		
		return 0;
	}
	
	public int getCustomerID() {
		return this.custID;
	}
	
	public void setCustomerID(int cust_id) {
		this.custID = cust_id;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMobile() {
		return this.mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public String getEmailAddress() {
		return this.email;
	}

	public void setEmailAddress(String email) {
		this.email = email;
	}

}
