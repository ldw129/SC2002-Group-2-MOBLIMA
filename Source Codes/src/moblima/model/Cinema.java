package moblima.model;

import java.util.ArrayList;

public class Cinema {

	private String cinema_name;
	private String cinema_class;
	private int cinemaID;
	private ArrayList<show> showlist;
	// seating information
	private CinemaSeat[][] seats = new CinemaSeat[9][9];

	// constructors
	public Cinema() {

	}

	public Cinema(String name, String cinema_class, int ID) {
		this.cinema_name = name;
		this.cinema_class = cinema_class;
		this.cinemaID = ID;
		showlist = new ArrayList<show>();
	}

	public void addShow(show s) {
		showlist.add(s);
	}

	public ArrayList<show> getCinemaShows() {
		return showlist;
	}

	public String getCinemaName() {
		return cinema_name;
	}

	public void setCinemaName(String cinema_name) {
		this.cinema_name = cinema_name;
	}

	public int getCinemaID() {
		return cinemaID;
	}

	public void setCinemaID(int cinemaID) {
		this.cinemaID = cinemaID;
	}

	public String getCinemaClass() {
		return cinema_class;
	}

	public void setCinemaClass(String cinema_class) {
		this.cinema_class = cinema_class;
	}
}