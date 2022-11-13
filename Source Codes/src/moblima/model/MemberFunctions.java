package moblima.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import moblima.controller.HolidayConfig;
import moblima.controller.Movie_goer_IO;
import moblima_test.model.Movie;

public class MemberFunctions extends MovieGoerFunctions{

    public void BookTickets(String login, ArrayList<Movie> moviesAvailableForBooking) throws FileNotFoundException {
        // Movie_goer can book and purchase movie ticket(s) for a particular chosen
        // movie.
        show show = null;
        HolidayConfig holIO = new HolidayConfig();
        master Master = new master();
        Movie m;
        Movie_goer_IO mg = new Movie_goer_IO();
        Movie_goer user = new Movie_goer();
        
        String[] var = login.split("[|]");
        int cust_id = Integer.parseInt(var[0]);
        String cust_name = var[4];
        int cust_mobile = Integer.parseInt(var[5]);
        String cust_email = var[6];
        int cust_age = Integer.parseInt(var[7]);
        String ageCat = var[8];
        
        int movie_ID = 0;
        int cineplexChoice = 0;
        int selection = 0;
        int numSeats = 0;
        int show_index = 0;
        int firstSeatNum = 0;
        int row = 0;
        String movieBooked, showtime, firstSeat = null, bookingConfirmation, cancel, transaction_id, cinemaClass;
        String[] holidayList = null;
        boolean validAge, inputValidation, seatAssigned;
        boolean publicHols = false;
        char ch;

        System.out.println("--- Ticket Booking & Purchase ---");
        
        m = selectMovie(moviesAvailableForBooking, moviesAvailableForBooking.size());        

        ArrayList<show> showsOfSelectedMovie = m.getShows();
        holidayList = holIO.readHolidays();
        
        for (int i = 0; i < showsOfSelectedMovie.size(); i++) {
        	publicHols = false;
        	show = showsOfSelectedMovie.get(i);
        	showtime = show.getDateTime().split(" ")[0];
        	
        	for (int h = 0; h < holidayList.length; h++) {
        		if (holidayList[h].equals(showtime)) {
        			publicHols = true;
        			break;
        		}
        	}
        	
			cinemaClass = Master.getCineplexes().get(show.getCineplexID()).getCinema().get(show.getScreenNum()).getCinemaClass();
			// MovieTicket price = new MovieTicket(show.get3D(), movieDetails, ageCat, publicHols);
			// MovieTicket price = new MovieTicket(String typeofmovie, String cinemaclass, int age, int date);
			System.out.println(" ");
			System.out.printf("\nShow %d:\n", i+1);
			System.out.println("Date & Time: \n" + show.getDateTime());
			System.out.printf("Cineplex ID: %d\n", show.getCineplexID()+1);
			System.out.printf("Cinema ID: %d\n", show.getScreenNum()+1);
			System.out.printf("Cinema Class: %s\n", cinemaClass);
			System.out.printf("3D Movie? %s\n", show.get3D());
			// System.out.printf("Ticket Price: S$%s (Inclusive of GST)\n", price.getPrice());
			System.out.println("----------------------------------------------");
        }
        
        try {
        	System.out.println("Enter show index: ");
            show_index = sc.nextInt() - 1;
            
            show = showsOfSelectedMovie.get(show_index);
            show.printSeats();
            
            System.out.println("Enter the total number of seats: ");
            numSeats = sc.nextInt();
            
            System.out.println("Enter the first seat (ie. A1: Row 1 Seat 1; B2: Row 2 Seat 2): "); // seat ID formatting to be confirmed
            firstSeat = sc.next();
        } catch (Exception e) {
            System.err.println("Invalid input!");
            sc.nextLine();
        }
        
        inputValidation = true;
        
        while (inputValidation) {
    		System.out.println("Confirm booking? Y/N");
            bookingConfirmation = sc.next();
            
        	if (bookingConfirmation.equals("n" ) || bookingConfirmation.equals("N" )) {
            	System.out.println("Confirm cancellation? Y/N");
            	cancel = sc.next();
            	if (cancel.equals("y") || cancel.equals("Y")) {
            		System.out.println("Booking cancelled!");
            		break;
            	}
            	else
            		System.out.println("Booking continued");
        			continue;
            }
            else if (bookingConfirmation.equals("y" ) || bookingConfirmation.equals("Y" )) {
            	BookingInfo b = new BookingInfo(show.getCineplexID());
            	transaction_id = b.getTID();
            	ch = firstSeat.charAt(0);
	    		firstSeatNum = Character.getNumericValue(firstSeat.charAt(1))-1;
	        	row = ch - 'a';
	        	seatAssigned = false;
	        	
	        	for (int i = 0; i < numSeats;i++) {
	        		if (show.checkSeat(row, firstSeatNum + i)) // seat has already been assigned
	        			seatAssigned = true;
	        	}
	        	
	        	if (!seatAssigned) { // seatAssigned = false
	        		try {
	        			mg.assignFinalSeatsbyMovie(m, show_index, cust_name, cust_id, cust_email, cust_mobile, transaction_id, numSeats, firstSeat);
	        		} catch (Exception e) {
	        			e.printStackTrace();
	        		}
	        		
	        	}
	        	
	        	System.out.println("Booking ID: " + transaction_id);
            	System.out.println("Movie tickets successfully booked!");
            	inputValidation = false;
            }
            else {
            	System.err.println("Invalid input!");
        		continue;
            }   	
        }
        
        return;
    }
    
    public void viewBookingHistory(String login) throws IOException {
		// Movie_goer can browse through his / her past movie bookings with ease.
    	String[] var = login.split("[|]");
        int cust_id = Integer.parseInt(var[0]);
		int i;
		ArrayList<BookingInfo> bookings = new ArrayList<>();
		Movie_goer customer = new Movie_goer();
    	
    	customer = mg.getMovieGoer(cust_id);
    	
    	bookings = customer.getBooking();
    	
    	System.out.println("--- Your Past Bookings ---");
    	
    	for (i = 0; i < bookings.size(); i++) {
    		System.out.println("BOOKING " + (i+1) + ": ");
			System.out.println("Transaction ID: " + bookings.get(i).getTID());
			System.out.println("Customer ID: " + cust_id);
			System.out.println("Customer Name: " + bookings.get(i).getCustName());
    		System.out.println("Customer Email ID: " + bookings.get(i).getEmailAddress());
			System.out.println("Movie Booked: " + bookings.get(i).getMovieBooked());
			System.out.println("Date & Time: " + bookings.get(i).getDateTime());
			System.out.println("Total number of seats booked: " + bookings.get(i).getSeatNum());
			System.out.println("First seat booked: " + bookings.get(i).getFirstSeat());
    	}
	}
    

}
