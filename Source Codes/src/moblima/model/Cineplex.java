package moblima.model;

import java.util.ArrayList;

public class Cineplex {
	
	private String location;
	private ArrayList<Cinema> cinema;
	private int cineplexID;
	
	public Cineplex(String location, int cineplexID, ArrayList<Cinema> cinema) {
		this.location = location;
		this.cineplexID = cineplexID;
		this.cinema = cinema;
	}

	public String showLocation() {
		return location;
	}

	public ArrayList<Cinema> getCinema() {
		return cinema;
	}
	
	public int getCineplexId() {
		return cineplexID;
	}
}
