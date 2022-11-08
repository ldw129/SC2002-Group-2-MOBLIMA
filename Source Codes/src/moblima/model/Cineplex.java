package moblima.model;

import java.util.ArrayList;

public class Cineplex {
	
	private String location;
	private ArrayList<Cinema> cinema;
	private int numCinema;
	private int cineplexID;
	
	public Cineplex(String location, ArrayList<Cinema> cinema, int numCinema) {
		this.location = location;
		this.cinema = cinema;
		this.numCinema = numCinema;
	}

	public String showLocation() {
		return location;
	}

	public ArrayList<Cinema> getCinema() {
		return cinema;
	}

	public int getNumCinema() {
		return numCinema;
	}
	
}
