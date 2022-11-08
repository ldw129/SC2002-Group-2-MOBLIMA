package moblima.model;

import java.util.ArrayList;
import java.util.Collections;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDate;
import java.time.LocalTime;
import java.text.ParseException; 
import java.util.Scanner;

import moblima_test.model.Bookings;
import moblima_test.model.Cineplex;
import moblima_test.model.Movie;
import moblima_test.model.master;
import moblima_test.model.show;

public class Movie_goer extends Person {

	private int custID;
	private String name;
	private int age;
	private Age ageVal;
	private int mobile;
	private String email;
	private int review;
	private ArrayList<Bookings> bookings = new ArrayList<>();
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
	
	public Movie_goer(String cust_name, int cust_age, int cust_mobile, String cust_email, ArrayList<Bookings> bookings) {
		this(cust_name, cust_mobile, cust_email);
		this.age = cust_age;
		this.bookings = bookings;
	}
	
	/*public Movie_goer(String name, int age, String mobile, String email, String password) {
		Movie_goer(name, age, mobile, email, bookings);
		this.password = password;
	}*/

	public void ViewMovies(ArrayList<Movie> movies, int numOfMovies) {
		// Movie_goer can have a glance at a full list of all movies currently showing.
		// For example:
		// 1. Black Adam
		// 2. Come Back Home
		// 3. Black Panther - Wakanda Forever
		// Movie = ['Black Adam', 'Come Back Home', 'Black Panther - Wakanda Forever']
		// numOfMovies = 3
		int i;
		int movie_index;
		Movie movie;
		
		movie = selectMovie(movies, numOfMovies);
		ListMovieDetails(movie);
		Review(movie);
		
	}
	
	public void ListMovieDetails(Movie movie) {
		int c, j, s;
		show show;
		
		System.out.println("Movie Title: " + movie.getMovieName());
		System.out.println("Directed By: " + movie.getDirectorName());
		
		System.out.println("Cast: ");
		String [] cast = movie.getCast();
		for (c=0; c<cast.length; c++) {
			System.out.printf("%s \n", cast[c]);
			if (cast[c].equals("null"))
				continue;
		}
		System.out.println("Showing Status: " + movie.getShowingStatus());
		
		System.out.println("Movie Synopsis: ");
		System.out.println(movie.getSynopsis());
		
		System.out.println("Review(s) of the movie: ");
		String [] reviews = movie.getReviews();
		if (reviews.length != 0) {
			for (j=0; j<reviews.length; j++) {
				System.out.printf("%s \n", reviews[j]);
			}
		}
		else
			System.out.println("No reviews available.");
		
		System.out.println("Movie Rating(s): ");
		double [] ratings = movie.getAllRatings();
		if (ratings.length != 0) {
			for(j=0; j<ratings.length; j++) {
				System.out.printf("%s \n", ratings[j]);
			}
		}
		else
			System.out.println("No ratings available.");
		
		System.out.println(" ");
		System.out.println("-------------------------");
		System.out.println(" ");
		System.out.println("--- Shows available for this movie --- ");
		
		ArrayList<show> showsForSelectedMovie = movie.getShows();
		
		for (s=0; s<showsForSelectedMovie.size(); s++) {
			show = showsForSelectedMovie.get(s);
			System.out.printf("Show %d\n", s+1);
			System.out.println("Showtimes: ");
			System.out.println(show.getDateTime());
			System.out.printf("Cineplex: %d\n", show.getCineplexID()+1);
			System.out.printf("Theatre: %d\n", show.getScreenNum()+1);
			System.out.println("\n-------------------------");
		}
	}
	
	public void Review(Movie movie) {
		// Movie_goer can enter his / her review and rating for a particular movie.
		int choice;
		
		System.out.println("Would you like to:\n"
				+ "1. Review this movie?\n"
				+ "2. Rate this movie?\n"
				+ "3. Skip for now.\n");
		
		choice = sc.nextInt();
		do {
			switch(choice) {
				case 1:
					System.out.println("Write your review for this movie.");
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
			}
		} while(choice != 3);
		return;
	}

	public void CheckSeat() {
		// Movie_goer can check for empty seats in a cineplex before booking.
		master m = new master();
		int cinemaChoice;
		Cineplex cineplexChoice;
		
		System.out.println("--- Seat Availability ---");
		
		ArrayList<Cineplex> Cineplexes = new ArrayList<Cineplex>();
		Cineplexes = m.getCineplexes();
		
		cineplexChoice = selectCineplex(Cineplexes, Cineplexes.size());
		
		System.out.println("Select theatre - 1, 2 or 3:");
		cinemaChoice = sc.nextInt();
		while (cinemaChoice > 3) {
			System.out.println("Invalid input!");
			sc.nextLine();
		}
		
		System.out.println("--- All available movies at selected theatre ---");
		ArrayList<show> movieList = cineplexChoice.getCinema().get(cinemaChoice - 1).getCinemaShows();
		
		for (show show:movieList)
			show.printSeats();
	}

	public Movie selectMovie(ArrayList<Movie> movies, int numOfMovies) {
		// List out all available movies that are Now Showing or for Preview. -> Movie.getStatus()
		// ListMovie();
		// User chooses the movie he / she wants to watch at the cinema.
		int i;
		int movie_index = 0;
		Movie movie;
		
		do {
			System.out.println("Select a movie below: ");
			System.out.println("--- Movie Listing ---");
			for (i=0; i<numOfMovies; i++)
				System.out.printf(i+1 + ". " + movies.get(i).getMovieName() + "\n");
			System.out.println((i+1) + ". Back");
			
			try {
				movie_index = sc.nextInt();
				
			}
			catch (Exception e) {
                System.err.println("Invalid input!");
                sc.nextLine();
			}
			
			movie = movies.get(movie_index-1);
			
		} while (movie_index != (i+1));
		return movie;
	}
	
	public Cineplex selectCineplex(ArrayList<Cineplex> Cineplexes, int numOfCineplexes) {
		int i;
		int cineplexChoice = 0;
		Cineplex cineplex;
		
		do {
			System.out.println("Select Cineplex: ");
			System.out.println("--- Cineplex Listing ---");
			for (i=0; i<numOfCineplexes; i++)
				System.out.printf(i+1 + ". " + Cineplexes.get(i).showLocation() + "\n");
			System.out.println((i+1) + ". Back");
			
			try {
				cineplexChoice = sc.nextInt();
			}
			catch (Exception e) {
                System.err.println("Invalid input!");
                sc.nextLine();
			}
			
			cineplex = Cineplexes.get(cineplexChoice-1);
			
		} while(cineplexChoice != (i+1));
		return cineplex;
	}
	
	public int selectDate() {
		// List out the next 5 dates (in advance), from the day the user logs into the app.
		int dateChoice;
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		LocalDate currDate = LocalDate.now();
		String date = currDate.format(dateFormatter);
		LocalDate parsedCurrDate = LocalDate.parse(date, dateFormatter);
		 
		for (int i=0; i<=5; i++) {
			String dateAfterCurrDate = LocalDate.parse(date).plusDays(i).toString();  
			System.out.printf(i+1 + ". " + dateAfterCurrDate + "\n");
		}
		
		dateChoice = sc.nextInt();
		return dateChoice;
	}
	
	public int selectTime(int movieChoice, int cineplexChoice, int dateChoice) {
		// List out all the available time slots of when the user's desired (chosen) movie will be screened on a chosen date.
		// Cinema.getShowtime();
		int timeChoice;
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");  
		LocalTime currTime = LocalTime.now();
		String time = currTime.format(timeFormatter);
		LocalTime parsedCurrTime = LocalTime.parse(time,timeFormatter);
		
		// get movie showtimes on the chosen day (use switch case statement, based on dateChoice)
		// list out movie showtimes that are available for booking, if they are beyond parsedCurrTime, otherwise do not show
		timeChoice = sc.nextInt();
		return timeChoice;
	}
		
	public void BookTickets() {
		// Movie_goer can book and purchase movie ticket(s) for a particular chosen movie.
		Bookings b = new Bookings();
		int movieChoice;
		int cineplexChoice;
		int dateChoice;
		int timeChoice;
		
		System.out.println("--- Ticket Booking & Purchase ---");
		
		ArrayList<Movie> movies = new ArrayList<Movie>();
		int custID = 0;
		int movieID = 0;
		String movieBooked, temp, firstSeat;
		int numSeats;
		Movie m;
		master Master = new master();
		movies = Master.getMovies();
		
		
		System.out.println("Select a movie:");
		movieChoice = selectMovie();
		
		System.out.println("Select a cineplex: ");
		cineplexChoice = selectCineplex(movieChoice);
		
		System.out.println("Select a date: ");
		dateChoice = selectDate();
		
		System.out.println("Select a timeslot: ");
		timeChoice = selectTime(movieChoice, cineplexChoice, dateChoice);
		
		b.getBookingID();
		b.getSeatNum();
		b.getDateTime();
	}

	public void PopularMovies(ArrayList<Movie> movieList) {
		// Movie_goer can view the top 5 movies ranked / sorted based on ticket sales or overall reviewrs' ratings.
		// popularMovie[] ?
		master m = new master();
		Movie movie;
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
				
				switch(selection) {
				case 1:
					Collections.sort(movieList, Movie.topratings);
					System.out.println("Top 5 rated movies based on overall reviewers' ratings, with first movie having highest rating: ");
					for (i=movieList.size()-1; i>=0; i--)
						System.out.println(movieList.get(i).getMovieName() + ": " + movieList.get(i).getTotalRating());
					break;
				case 2:
					Collections.sort(movieList, Movie.topticketsales);
					System.out.println("Top 5 rated movies based on overall ticket sales, with first movie having highest ticket sales: ");
					for (i=movieList.size()-1; i>=0; i++)
						System.out.println(movieList.get(i).getMovieName() + ": " + movieList.get(i).getTsales());
					break;
				}
			}
			catch (Exception e) {
				System.err.println("Invalid input!");
                sc.nextLine();
			}
			
		} while(selection != 3);
		return;
	}
	
	public ArrayList<Bookings> viewBookingHistory(){
		// Movie_goer can browse through his / her past movie bookings with ease.
		System.out.println("--- Your Past Bookings ---");
		return this.bookings;
	}
	
	public void setBooking (Bookings b) {
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
