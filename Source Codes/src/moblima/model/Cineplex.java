package moblima.model;

import java.util.ArrayList;

/**
 * Class to represent the cineplex and its attributes
 */
public class Cineplex {
	/**
	 * location of the cineplex
	 */
	private String location;
	/**
	 * the cinemas in the cineplex
	 */
	private ArrayList<Cinema> cinema;
	/**
	 * cineplex id
	 */
	private int cineplexID;
	/**
	 * constructor for cineplex
	 * @param location
	 * @param cineplexID
	 * @param cinema
	 */
	public Cineplex(String location, int cineplexID, ArrayList<Cinema> cinema) {
		this.location = location;
		this.cineplexID = cineplexID;
		this.cinema = cinema;
	}
	/**
	 * return location
	 * @return location
	 */
	public String showLocation() {
		return location;
	}
	/**
	 * get the cinemas in cineplex
	 * @return cinema
	 */
	public ArrayList<Cinema> getCinema() {
		return cinema;
	}
	/**
	 * get cineplexID
	 * @return cineplexID
	 */
	public int getCineplexI() {
		return cineplexID;
	}
}
