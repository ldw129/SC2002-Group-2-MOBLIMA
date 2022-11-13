package moblima.model;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Represents the Movie_goer
 */

public class Movie_goer extends Person {
	/**
	 * the ID of the movie_goer
	 */
	private int custID;
	/**
	 * name of the customer
	 */
	private String name;
	/**
	 * age of the movie-goer
	 */
	private int age;
	/**
	 * customer mobile number
	 */
	private int mobile;
	/**
	 * customer emai;
	 */
	private String email;
	/**
	 * review for the movie
	 */
	private String review;
	/**
	 * rating for the movie
	 */
	private double rating;
	/**
	 * movie-goer booking info
	 */
	private ArrayList<BookingInfo> bookings = new ArrayList<>();
	//private String password;
	
	Scanner sc = new Scanner(System.in);
	
	/**
	 * Default Constructor
	 */
	public Movie_goer() {};
	
	/**
	 * Constructor for movie goer
	 * @param cust_name
	 * @param cust_mobile
	 * @param cust_email
	 */
	public Movie_goer(String cust_name, int cust_mobile, String cust_email) {
		this.name = cust_name;
		this.mobile = cust_mobile;
		this.email = cust_email;
	}
	
	/**s
	 * add in booking info
	 * @param cust_name
	 * @param cust_mobile
	 * @param cust_email
	 * @param cust_age
	 * @param bookings
	 */
	public Movie_goer(String cust_name, int cust_mobile, String cust_email, int cust_age, ArrayList<BookingInfo> bookings) {
		this(cust_name, cust_mobile, cust_email);
		this.age = cust_age;
		this.bookings = bookings;
	}
	
	/*public Movie_goer(String name, int age, String mobile, String email, String password) {
		Movie_goer(name, age, mobile, email, bookings);
		this.password = password;
	}*/
	/**
	 * return the bookings
	 * @return bookings
	 */
	public ArrayList<BookingInfo> getBooking() {
		return this.bookings;
	}
	/**
	 * set booking
	 * @param b
	 */
	public void setBooking (BookingInfo b) {
		if (!bookings.contains(b))
			bookings.add(b);
	}
	/**
	 * return customer id
	 * @return custID
	 */
	public int getCustomerID() {
		return this.custID;
	}
	/**
	 * set customer id
	 * @param cust_id
	 */
	public void setCustomerID(int cust_id) {
		this.custID = cust_id;
	}
	/**
	 * return customer age
	 * @return age
	 */
	public int getAge() {
		return this.age;
	}
	/**
	 * set customer age
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * retrun customer name
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * set customer name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * get mobile number
	 * @return mobile
	 */
	public int getMobile() {
		return this.mobile;
	}
	/**
	 * set mobile number
	 * @param mobile
	 */
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	/**
	 * get email address
	 * @return email
	 */
	public String getEmailAddress() {
		return this.email;
	}
	/**
	 * set email address
	 * @param email
	 */
	public void setEmailAddress(String email) {
		this.email = email;
	}

}
