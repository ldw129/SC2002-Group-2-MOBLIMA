package moblima.model;

import java.util.ArrayList;
import java.util.Scanner;


public class Movie_goer extends Person {

	private int custID;
	private String name;
	private int age;
	private int mobile;
	private String email;
	private String review;
	private double rating;
	private ArrayList<BookingInfo> bookings = new ArrayList<>();
	//private String password;
	
	Scanner sc = new Scanner(System.in);
	
	public Movie_goer() {};
	
	// to be captured by Bookings
	public Movie_goer(String cust_name, int cust_mobile, String cust_email) {
		this.name = cust_name;
		this.mobile = cust_mobile;
		this.email = cust_email;
	}
	
	public Movie_goer(String cust_name, int cust_mobile, String cust_email, int cust_age, ArrayList<BookingInfo> bookings) {
		this(cust_name, cust_mobile, cust_email);
		this.age = cust_age;
		this.bookings = bookings;
	}
	
	/*public Movie_goer(String name, int age, String mobile, String email, String password) {
		Movie_goer(name, age, mobile, email, bookings);
		this.password = password;
	}*/
	
	public ArrayList<BookingInfo> getBooking() {
		return this.bookings;
	}
	
	public void setBooking (BookingInfo b) {
		if (!bookings.contains(b))
			bookings.add(b);
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
