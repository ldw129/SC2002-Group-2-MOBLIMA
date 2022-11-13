package moblima.controller;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

import moblima.model.*;

/**
 * Used to read and write bookings made by a MovieGoer
 * @version 1.0
 * 
 */

public class Movie_goer_IO{
    
	/**
	 * text file for the input and output
	 */
    private File customerFile = new File("Database/Customers.txt");
    
    /**
     * ArrayList of the MovieGoers
     */
    private static ArrayList<Movie_goer> customers = new ArrayList<>();
    
    /**
     * Different parameters to be recorded with the booking
     */
    private int custID; 
    private String bookingID;
    private String movieBooked;
    private int numseats;
    private String emailID;
    private String dateTime;
    private String firstseat;
	private String customerName;
	private int age;
    private int phoneNumber;
    private static int linecounter=0;
    
    public int [][] seats = new int[9][9];
    
    public Movie_goer_IO() {};
	
    /**
     * to count the number of previous bookings in the Bookings file
     * @throws IOException
     * @throws Exception
     */
    public void countPreviousBookings() throws IOException {
    	FileReader fr = new FileReader("Database/Customers.txt");
		BufferedReader br = new BufferedReader(fr);
		
		String s;
		while((s=br.readLine())!=null) {
			linecounter ++;
		}
		br.close();
    }	
    
    /**
     * to read all the previous bookings from the text file
     * @throws IOException
     * @throws Exception
     */
    public void readBookingsFile() throws IOException {
		countPreviousBookings();
		
		FileReader fr = new FileReader("Database/Customers.txt");
		BufferedReader br = new BufferedReader(fr);
		
		String s;
		int i =1;
		while(i<=linecounter) {
			s=br.readLine();
			if(s!=null) {
    			String[] var = s.split("[|]");
    			this.custID = Integer.parseInt(var[0]);
        		this.bookingID = var[1];
            	this.customerName = var[2];
            	this.age = Integer.parseInt(var[3]);
            	this.phoneNumber = Integer.parseInt(var[4]);
            	this.movieBooked = var[5];
            	this.emailID = var[6];
            	this.dateTime = var[7];
            	this.numseats = Integer.parseInt(var[8]);
            	this.firstseat = var[9];
            	
            	addMovieGoer();
        	}
			i+=1;
    	}
	}	
    
    
    /**
     * to write a new booking to the customers.txt file
     * @param custID	customer ID of the customer
     * @param bookingID	transaction ID of the booking
     * @param customerName	Name of the customer
     * @param phoneNumber	Phone number of the customer
     * @param movieBooked	Name of the movie booked
     * @param emailID	email ID of the customer
     * @param time	time of the show booked
     * @param numseats	number of seats booked
     * @param firstseat	first-seat of the booking
     * @throws IOException
     * @throws Exception
     */
    public void writeNewBooking(int custID, String bookingID, String customerName, int phoneNumber, int custAge, String movieBooked, String emailID, String time, int numseats, String firstseat) throws IOException, Exception {
		countPreviousBookings();    
		customerFile = getCustomerFile();
    	String temp;
    	try {
			Scanner sc = new Scanner(System.in);
			
			
			FileWriter fw = new FileWriter(customerFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.newLine();
			bw.write(Integer.toString(custID) + "|");
			bw.write(bookingID + "|");
			bw.write(customerName + "|");
			bw.write(custAge + "|");
			bw.write(Integer.toString(phoneNumber) + "|");
			bw.write(movieBooked + "|");
			bw.write(emailID + "|");
			bw.write(time + "|");
			bw.write(Integer.toString(numseats) + "|");
			bw.write(firstseat + "|");
			bw.close();
			
			linecounter+=1;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }
    
    
    /**
     * to add a movieGoer to the ArrayList of customers
     */
    public void addMovieGoer() {
    		Movie_goer m1 = new Movie_goer();
    		
    		m1.setCustomerID(custID);
    		m1.setName(customerName);
    		m1.setMobile(phoneNumber);
    		
    		int length = customers.size();
    		int flag=1;
    		int i;
    		for(i=0; i<length; i++) {
    			int c = customers.get(i).getCustomerID();
    			if(c==custID) {flag = 0; addBooking(i); break;}
    		}
    		
    		if(flag==1){m1.setBooking(createBooking());}
    		
   
    		
    		if(!customers.contains(m1)){customers.add(m1);}
    		
    	
    }
    
    /**
     * to add a booking to an existing customer
     * @param i index of the existing customer in the ArrayList
     */
    public void addBooking(int i) {
    	Movie_goer m = new Movie_goer();
    	m = customers.get(i);
    	
    	m.setBooking(createBooking());
    	
    }
    
    /**
     * to create a Booking object to be associated with the customer
     * @return booking
     */
    public BookingInfo createBooking() {
    	BookingInfo b1 = new BookingInfo();	
    	
    	b1.setCustomerID(custID);;
    	b1.setTID(bookingID);
    	b1.setFirstSeat(firstseat);
    	b1.setMovieBooked(movieBooked);
    	b1.setCustName(customerName);
    	b1.setSeatNum(numseats);
    	b1.setDateTime(dateTime);
    	b1.setEmailAddress(emailID);
    	
    	
    	return b1;
    }
    
    
	/**
	 * assign seats to a customer
	 * @param m MovieGoer object
	 * @param b Booking details of the movie-goer
	 * @param row row of the theater to be booked
	 * @param numseats number of seats to be booked
	 * @param firstseat first seat of the booking
	 * @throws Exception 
	 * @throws IOException 
	 */
   public void assignFinalSeatsbyMovie(Movie mo, int index, String custName, int custID, String emailID, int phoneNumber, int custAge, String bookingID, int numseats, String firstseat) throws IOException, Exception {
    	try{
    		readBookingsFile();
    		
    		this.movieBooked = mo.getMovieName();
    		this.numseats = numseats;
    		this.bookingID = bookingID;
    		
    		BookingInfo b = new BookingInfo();
			ArrayList<BookingInfo> bookings = new ArrayList<>();
			Movie_goer m = new Movie_goer();
    		
    		int length = customers.size();
    		int flag = 1;
    		int i, numOfBookings;
    		
    		for(i = 0; i < length; i++) {
    			int c = customers.get(i).getCustomerID();
    			
    			if(c == custID) {
    				flag = 0; 
    				break;
    			}
    		}
    		
    		if(flag == 1) {
    			m.setName(custName);
    			m.setCustomerID(custID);
    			
    			b = createBooking();
            	m.setBooking(b);
    		}
    		else {
    			m = customers.get(i);
    			addBooking(i);
    			bookings = m.getBooking();
    			numOfBookings = bookings.size();
    			m.setBooking(bookings.get(numOfBookings-1));
    		}
    	
    	ArrayList<show> shows = new ArrayList<>();
    	
    	shows = mo.getShows();
    	
    	char ch = firstseat.charAt(0);
		int row = ch - 'A' + 1;
		int firstseatnum = Character.getNumericValue(firstseat.charAt(1));
    	
    	show s = shows.get(index);
    
	    	for(int j=1; j<=numseats; j++) {
	    		s.assignSeat(row-1, j+firstseatnum-2);
	    	}   
    	String time = s.getDateTime(); 	
    	writeNewBooking(custID, bookingID, custName, phoneNumber, custAge, movieBooked, emailID, time, numseats, firstseat); 	
    	} finally{customers.clear();}
    	    	//write new booking after assigning seats
    }

    /**
     * get the bookings file
     * @return customer file
     */
    public File getCustomerFile() {
		return customerFile;
	}

	/**
	 * search and return the movieGoer object by customer ID
	 * @param custID customer ID of the movie-goer
	 * @return MovieGoer Object
	 * @throws IOException
	 * @throws Exception
	 */
	public Movie_goer getMovieGoer(int custID) throws IOException {
		try {
			readBookingsFile();
			int length = customers.size();
			int i;
			
			for(i=0; i<length; i++) {
				int c = customers.get(i).getCustomerID();
				if(c==custID) break;
			}
			return customers.get(i);
		} finally {
			customers.clear();
		}
		
		
	}


}