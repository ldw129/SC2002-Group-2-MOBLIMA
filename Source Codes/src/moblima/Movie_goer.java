package moblima;

import moblima.CinemaSeat;
import moblima.Bookings;

import java.util.ArrayList;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDate;
import java.time.LocalTime;
import java.text.ParseException; 
import java.util.Scanner;

public class Movie_goer extends Person {

	private String name;
	private int age;
	private Age ageVal;
	private String mobile;
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
	public Movie_goer(String cust_name, String cust_mobile, String cust_email) {
		this.name = cust_name;
		this.mobile = cust_mobile;
		this.email = cust_email;
	}
	
	public Movie_goer(String cust_name, int cust_age, String cust_mobile, String cust_email, ArrayList<Booking> bookings) {
		this(cust_name, cust_mobile, cust_email);
		this.age = cust_age;
		this.bookings = bookings;
	}
	
	/*public Movie_goer(String name, int age, String mobile, String email, String password) {
		Movie_goer(name, age, mobile, email, bookings);
		this.password = password;
	}*/

	public void ListMovie(Movie[] movieListing, int numOfMovies) {
		// Movie_goer can have a glance at a full list of all movies currently showing.
		// For example:
		// 1. Black Adam
		// 2. Come Back Home
		// 3. Black Panther - Wakanda Forever
		// Movie = ['Black Adam', 'Come Back Home', 'Black Panther - Wakanda Forever']
		// numOfMovies = 3
		
		for (int i=0; i<numOfMovies; i++)
			System.out.println(i+1 + ". " + movieListing[i]);
	}

	public void SearchMovie(Movie[] movieListing, int numOfMovies, String movie) {
		// Movie_goer can search for a particular movie from the list of available movies.
		
		for (int i=0; i<numOfMovies; i++) {
			if (movie == movieListing[i]) {
				System.out.println("Movie found!");
				System.out.println(movieListing[i]);
				return;
			}
		}
		
		System.out.println("Movie not found. Please search for another movie instead.");
	}

	public void CheckSeat(int row, int col) {
		// Movie_goer can check for empty seats in a cineplex before booking.
		
		CinemaSeat seat = new CinemaSeat(row, col);
		
		if (seat.isAssigned() == true)
			System.out.println("Seat is not available. Please choose another seat instead.");
		else
			System.out.println("Seat is available! Would you like to pick this seat?");
	}

	public int selectMovie() {
		// List out all available movies that are Now Showing or for Preview. -> Movie.getStatus()
		// ListMovie();
		// User chooses the movie he / she wants to watch at the cinema.
		int movieChoice = sc.nextInt();
		return movieChoice;
	}
	
	public int selectCineplex(int movieChoice) {
		int i;
		int cineplexChoice;
		int numOfCineplexes;
		
		switch (movieChoice) {
			case 1:
				// List out all cineplexes that screens the user's desired (chosen) movie.
				for (i=0; i<numOfCineplexes; i++) {
					System.out.println(i+1 + ". " + Cineplex.showLocation());
				}
				cineplexChoice = sc.nextInt();
				break;
			case 2:
				// List out all cineplexes that screens the user's desired (chosen) movie.
				for (i=0; i<numOfCineplexes; i++) {
					System.out.println(i+1 + ". " + Cineplex.showLocation());
				}
				cineplexChoice = sc.nextInt();
				break;
			case 3:
				// List out all cineplexes that screens the user's desired (chosen) movie.
				for (i=0; i<numOfCineplexes; i++) {
					System.out.println(i+1 + ". " + Cineplex.showLocation());
				}
				cineplexChoice = sc.nextInt();
				break;
			case 4:
				// List out all cineplexes that screens the user's desired (chosen) movie.
				for (i=0; i<numOfCineplexes; i++) {
					System.out.println(i+1 + ". " + Cineplex.showLocation());
				}
				cineplexChoice = sc.nextInt();
				break;
			case 5:
				// List out all cineplexes that screens the user's desired (chosen) movie.
				for (i=0; i<numOfCineplexes; i++) {
					System.out.println(i+1 + ". " + Cineplex.showLocation());
				}
				cineplexChoice = sc.nextInt();
				break;
		}
		
		return cineplexChoice;
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

	public void PopularMovies() {
		// Movie_goer can view the top 5 movies ranked / sorted based on ticket sales or overall reviewrs' ratings.
		// popularMovie[] ?
		
		System.out.println("Here are the top 5 rated movies: ");
		
		for (int i=0; i<5; i++) {
			System.out.println(i+1 + ". " + popularMovie[i]);
		}
	}

	public void Review() {
		// Movie_goer can enter his / her review and rating for a particular movie.
		System.out.println("Rate this movie: ");
		int movieRating = sc.nextInt();
		
		System.out.println("Write your review for this movie.");
		String review = sc.next();
		
		System.out.println();
		
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

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmailAddress() {
		return this.email;
	}

	public void setEmailAddress(String email) {
		this.email = email;
	}
	
	public ArrayList<Bookings> getBookingHistory(){
		// Movie_goer can browse through his / her past movie bookings with ease.
		return this.bookings;
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
}
