package moblima;

import java.util.ArrayList;
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
	
	public Movie_goer(String name, int age, String mobile, String email, ArrayList<Bookings> bookings) {
		this.name = name;
		this.age = age;
		this.mobile = mobile;
		this.email = email;
		this.bookings = bookings;
	}
	
	/*public Movie_goer(String name, int age, String mobile, String email, String password) {
		Movie_goer(name, age, mobile, email, bookings);
		this.password = password;
	}*/

	public void ListMovie(Movie[] movieListing, int numOfMovies) {
		// Movie_goer can have a glance at a full list of all movies currently showing.
		
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
		
		System.out.println("Movie not found. Please search for another movie.");
	}

	public void CheckSeat(int row, int col) {
		// Movie_goer can check for empty seats in a cineplex before booking.
		
		CinemaSeat seat = new CinemaSeat(row, col);
		
		if (seat.isAssigned() == true)
			System.out.println("Seat is not available. Please choose another seat instead.");
		else
			System.out.println("Seat is available! Would you like to pick this seat?");
	}

	public void Book() {
		// Movie_goer can book a movie ticket for a particular chosen movie.
		Bookings b = new Bookings();
		b.getBookingID();
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
