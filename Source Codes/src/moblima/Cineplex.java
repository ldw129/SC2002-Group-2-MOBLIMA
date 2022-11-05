package moblima;

public class Cineplex {
	
	private String location;
	private Cinema[] cinema;
	private int numCinema;
	
	public Cineplex(String location, Cinema[] cinema, int numCinema) {
		this.location = location;
		this.cinema = cinema;
		this.numCinema = numCinema;
	}

	public String getLocation() {
		return location;
	}

	public Cinema[] getCinema() {
		return cinema;
	}

	public int getNumCinema() {
		return numCinema;
	}
	
}
