package moblima.model;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import moblima.controller.Movie_goer_IO;
import moblima.controller.HolidayConfig;

/**
 * Used to manage all the functionalities of movie goers, both guests and members.
 * @version 1.0
 * 
 */
public class MovieGoerFunctions {
	Scanner sc = new Scanner(System.in);
	
	/**
	 * Object instance of Movie_goer_IO for ease of calling the functions in Movie_goer_IO
	 */
	Movie_goer_IO mg = new Movie_goer_IO();
	
	/**
	 * Enum class to store the different age categories (child, student, adult, senior citizen), for ease of validation
	 * for movie goers aged 54 and below.
	 * @author LDW
	 *
	 */
	public enum AgeCat{
		CHILD(() -> IntStream.range(0,  12)),
		STUDENT(() -> IntStream.range(13, 18)),
		ADULT(() -> IntStream.range(9, 54)),
		SENIOR_CITIZEN(() -> IntStream.range(55, 100));
				
		private Supplier<IntStream> range = null;
		
		private AgeCat(Supplier<IntStream> range) {
			this.range = range;
		}

		public IntStream getRange() {
			return range.get();
		}
	}

    public MovieGoerFunctions() {}
    
    /**
     * Movie goers can see the full list of available movies and their corresponding details at a glance, as well as
     * review and/or rate a particular movie of their interest.
     * @param movies
     * @param numOfMovies
     */
    public void ViewMovies(ArrayList<Movie> movies, int numOfMovies) {
        Movie movie;

        movie = selectMovie(movies, numOfMovies);
        ListMovieDetails(movie);
        Review(movie);
    }
    
    /**
     * Movie goers can see the full details (ie. movie name, cast, showtimes, showing status, reviews, ratings) of a selected movie.
     * @param movie
     */
    public void ListMovieDetails(Movie movie) {
        int c, j, s;
        show show;

        System.out.println("Movie Title: " + movie.getMovieName());
        System.out.println("Directed By: " + movie.getDirectorName());

        System.out.println("Cast: ");
        String[] cast = movie.getCast();
        for (c = 0; c < cast.length; c++) {
            System.out.printf("%s \n", cast[c]);
            if (cast[c].equals("null"))
                continue;
        }
        System.out.println("Showing Status: " + movie.getShowingStatus());

        System.out.println("Movie Synopsis: ");
        System.out.println(movie.getSynopsis());

        System.out.println("Review(s) of the movie: ");
        String[] reviews = movie.getReviews();
        if (reviews.length != 0) {
            for (j = 0; j < reviews.length; j++) {
                System.out.printf("%s \n", reviews[j]);
            }
        } else
            System.out.println("No reviews available.");

        System.out.println("Movie Rating(s): ");
        double[] ratings = movie.getAllRatings();
        if (ratings.length != 0) {
            for (j = 0; j < ratings.length; j++) {
                System.out.printf("%s \n", ratings[j]);
            }
        } else
            System.out.println("No ratings available.");

        System.out.println(" ");
        System.out.println("-------------------------");
        System.out.println(" ");
        System.out.println("--- Shows available for this movie --- ");

        ArrayList<show> showsForSelectedMovie = movie.getShows();

        for (s = 0; s < showsForSelectedMovie.size(); s++) {
            show = showsForSelectedMovie.get(s);
            System.out.printf("Show %d\n", s + 1);
            System.out.println("Showtimes: ");
            System.out.println(show.getDateTime());
            System.out.printf("Cineplex: %d\n", show.getCineplexID() + 1);
            System.out.printf("Theatre: %d\n", show.getScreenNum() + 1);
            System.out.println("\n-------------------------");
        }
    }
    
    /**
     * Movie_goers can leave a review and/or rating for a particular movie of their interest.
     * @param movie
     */
    public void Review(Movie movie) {
        // Movie_goer can enter his / her review and rating for a particular movie.
        int choice = 0;

        System.out.println("Would you like to:\n"
                + "1. Review this movie?\n"
                + "2. Rate this movie?\n"
                + "3. Skip for now.\n");

        choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Write your review for this movie.");
                sc.nextLine();
                String review = sc.nextLine();
                movie.writeReview(review);
                System.out.println("New review added to the movie!");
                break;
            case 2:
                System.out.println("Rate this movie, from 0 to 5.");
                double rating = sc.nextDouble();
                movie.giveRating(rating);
                System.out.println("New rating added to the movie!");
                break;
            case 3:
            	break;
        }
        
        return;
    }
    
    /**
     * Movie goers can check the availability of seats in a cinema theatre at a particular cineplex for a chosen movie.
     * @param movies
     */
    public void CheckSeats(ArrayList<Movie> movies) {
        // Movie_goer can check for empty seats in a cineplex before booking.
        master m = new master();
        m.readCineplexes();
        int cinemaChoice = 0;
        int cineplexChoice = 0;
        
        for (Movie movie : movies)
        	movie.readShowDetails(m);

        System.out.println("--- Seat Availability ---");

        ArrayList<Cineplex> Cineplexes = new ArrayList<Cineplex>();
        Cineplexes = m.getCineplexes();

        cineplexChoice = selectCineplex(Cineplexes, Cineplexes.size());
        
        try {
        	System.out.println("Select theatre - 1, 2 or 3:");
            cinemaChoice = sc.nextInt();
        } catch (Exception e) {
            System.err.println("Invalid input!");
            sc.nextLine();
        }

        System.out.println("--- All available movies at selected theatre ---");
        ArrayList<show> showList = m.getCineplexes().get(cineplexChoice-1).getCinema().get(cinemaChoice - 1).getCinemaShows();
        System.out.println(showList);
        for (show show : showList) {
            show.printSeats();
        }
    }
    
    /**
     * Movie goers can choose a movie they wish to watch at the cinema.
     * @param movies
     * @param numOfMovies
     * @return
     */
    public Movie selectMovie(ArrayList<Movie> movies, int numOfMovies) {
        // List out all available movies that are Now Showing or for Preview. ->
        // Movie.getStatus()
        // ListMovie();
        // User chooses the movie he / she wants to watch at the cinema.
        int i;
        int movie_index = 0;
        Movie movie = null;

        do {
            System.out.println("Select a movie below: ");
            System.out.println("--- Movie Listing ---");
            for (i = 0; i < numOfMovies; i++)
                System.out.printf(i + 1 + ". " + movies.get(i).getMovieName() + "\n");

            try {
                movie_index = sc.nextInt();

            } catch (Exception e) {
                System.err.println("Invalid input!");
                sc.nextLine();
            }

            if (movie_index > 0 && movie_index <= numOfMovies) {
                movie = movies.get(movie_index - 1);
                break;
            }

        } while (movie_index > numOfMovies);
        
        System.out.println(movie.getMovieName());
        return movie;
    }

	/**
	 * Movie goers can choose a cineplex they wish to watch a movie at.
	 * @param Cineplexes
	 * @param numOfCineplexes
	 * @return
	 */
    public int selectCineplex(ArrayList<Cineplex> Cineplexes, int numOfCineplexes) {
        int i;
        int cineplexChoice = 0;
        Cineplex cineplex;

        do {
            System.out.println("Select Cineplex: ");
            System.out.println("--- Cineplex Listing ---");
            for (i = 0; i < numOfCineplexes; i++)
                System.out.printf(i + 1 + ". " + Cineplexes.get(i).showLocation() + "\n");

            try {
                cineplexChoice = sc.nextInt();
            } catch (Exception e) {
                System.err.println("Invalid input!");
                sc.nextLine();
            }

            cineplex = Cineplexes.get(cineplexChoice - 1);

        } while (cineplexChoice > numOfCineplexes);
        
        System.out.println(cineplex.showLocation());
        return cineplexChoice;
    }

    /**
     * Movie goers can view the top 5 movies ranked / sorted based on ticket sales or overall reviewers' ratings.
     * @param movieList
     */
    public void PopularMovies(ArrayList<Movie> movieList) {
        int i;
        int selection = 0;

        do {
            System.out.println("--- HIGHLY RATED MUST-WATCH MOVIES! ---");
            System.out.println("Here are the top 5 rated movies, based on: \n"
                    + "1. Overall ratings by reviewers \n"
                    + "2. Overall ticket sales \n"
                    + "3. Back \n");
            System.out.println("Select an option: ");
            try {
                selection = sc.nextInt();

                switch (selection) {
                    case 1:
                        Collections.sort(movieList, Movie.topratings);
                        System.out.println(
                        "Top 5 rated movies based on overall reviewers' ratings, with first movie having highest rating: ");
                        for (i = movieList.size() - 1; i >= 0; i--)
                            System.out.println(
                                    movieList.get(i).getMovieName() + ": " + movieList.get(i).getTotalRating());
                        break;
                    case 2:
                        Collections.sort(movieList, Movie.topticketsales);
                        System.out.println(
                        "Top 5 rated movies based on overall ticket sales, with first movie having highest ticket sales: ");
                        for (i = movieList.size() - 1; i >= 0; i--)
                            System.out.println(movieList.get(i).getMovieName() + ": " + movieList.get(i).getTsales());
                        break;
                }
            } catch (Exception e) {
                System.err.println("Invalid input!");
                sc.nextLine();
                //throw e;
            }

        } while (selection != 3);
        return;
    }

    /**
     * Movie goers can book movie tickets for a chosen movie they wish to watch at the cinema.
     * @param moviesAvailableForBooking
     * @throws FileNotFoundException
     */
    public void BookTickets(ArrayList<Movie> moviesAvailableForBooking) throws FileNotFoundException {
        // Movie_goer can book and purchase movie ticket(s) for a particular chosen
        // movie.
        show show = null;
        HolidayConfig holIO = new HolidayConfig();
        master Master = new master();
        Movie m;
        Movie_goer_IO mg = new Movie_goer_IO();
        Movie_goer user = new Movie_goer();
        
        int cust_id = 0;
        int movie_ID = 0;
        int cineplexChoice = 0;
        int selection = 0;
        int numSeats = 0;
        int cust_mobile = 0;
        int cust_age = 0;
        int show_index = 0;
        int firstSeatNum = 0;
        int row = 0;
        String movieBooked, showtime, firstSeat = null, cust_name, cust_email, ageCat, bookingConfirmation, cancel, transaction_id, cinemaClass;
        String[] holidayList = null;
        boolean validAge, inputValidation, seatAssigned;
        boolean publicHols = false;
        char ch;

        System.out.println("--- Ticket Booking & Purchase ---");
        
        System.out.println("Enter your customer ID to proceed: ");
    	cust_id = sc.nextInt();
        
        System.out.println("Enter your name: ");
        sc.nextLine();
        cust_name = sc.nextLine();
             
        System.out.println("Enter your mobile number: ");
        cust_mobile = sc.nextInt();
        
        System.out.println("Enter your email address: ");
        cust_email = sc.next();
             
        do {
        	ageCat = null;
        	selection = 0;
        	System.out.println("Choose your age category: "
            		+ "1. Senior Citizen \n"
            		+ "2. Adult \n"
            		+ "3. Student \n"
            		+ "4. Child \n\n"
            		+ "Note: \n"
            		+ "- Senior Citizen: Aged 55 and above  \n"
            		+ "- Student: Between 13 and 18 years old \n"
            		+ "- Child: Below 12 years old");       	
        	
        	try {
        		// to be referenced with enum Age in Movie_goer.java
        		selection = sc.nextInt();
        		switch (selection) {
        			case 1:
        				System.out.println("Validation of your age and identity will be carried out physically at the cineplex.");
        				ageCat = "Senior Citizen";
        				break;
        			case 2:
        				System.out.println("Enter your age: ");
        		        cust_age = sc.nextInt();
        				validateAge(cust_age, selection);
        				ageCat = "Adult";
        				break;
        			case 3:
        				System.out.println("Enter your age: ");
        		        cust_age = sc.nextInt();
        				validateAge(cust_age, selection);
        				ageCat = "Student";
        				break;
        			case 4:
        				System.out.println("Enter your age: ");
        		        cust_age = sc.nextInt();
        				validateAge(cust_age, selection);
        				ageCat = "Child";
        				break;
        		}
        	} catch (Exception e) {
                System.err.println("Invalid input!");
                sc.nextLine();
        	}
        } while (selection > 4);
        
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
    
    /**
     * Movie goers can see their past movie bookings at a glance, but they need to validate their customerID
     * in order to access their booking history.
     * @throws IOException
     */
    public void viewBookingHistory() throws IOException {
		// Movie_goer can browse through his / her past movie bookings with ease.
		int cust_id = 0;
		int i;
		ArrayList<BookingInfo> bookings = new ArrayList<>();
		Movie_goer customer = new Movie_goer();
    	
		try {
        	System.out.println("Enter your customer ID to proceed: ");
        	cust_id = sc.nextInt();
        } catch (Exception e) {
            System.err.println("Invalid input!");
            sc.nextLine();
        }
    	
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
    
    /**
     * The app will prompt movie goers to enter their age for age validation purposes, if they are purchasing child, student
     * and/or adult tickets. For senior citizens, age validation will be conducted physically at the cineplex.
     * @param ageVal
     * @param ageCat
     */
    public void validateAge(int ageVal, int ageCat) {
		// Movie_goer needs to validate their age when purchasing tickets online, except if he / she is a senior citizen then
		// he / she will only validate his / her age upon entering the cinema.
		boolean validAge = false;
    	
		if (ageVal < 54 & ageVal > 18 & ageCat == 2)
    		validAge = AgeCat.ADULT.getRange().anyMatch(i -> i == ageVal);
    	else if (ageVal < 19 & ageVal > 12 & ageCat == 3)
    		validAge = AgeCat.STUDENT.getRange().anyMatch(i -> i == ageVal);
    	else if (ageVal < 13 & ageCat == 4)
    		validAge = AgeCat.CHILD.getRange().anyMatch(i -> i == ageVal);
    	
    	if (validAge == true)
			System.out.println("You are eligible to purchase tickets of this age category!");
		else
			System.out.println("You are NOT eligible to purchase tickets of this age category!");
	}

}