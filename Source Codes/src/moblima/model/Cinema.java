package moblima.model;

import java.util.ArrayList;

/**
 * Class to represents the cinema and its attributes
 */
public class Cinema {
	/**
	 * this is the cinema_name
	 */
	private String cinema_name;
	/**
	 * this is the cinema class
	 */
	private String cinema_class;
	/**
	 * this is cinema ID
	 */
	private int cinemaID;
	/**
	 * this is the list of shows
	 */
	private ArrayList<show> showlist;
	/**
	 * array of seats
	 */
	private CinemaSeat[][] seats = new CinemaSeat[9][9];

	/**
	 * Default cinema constructor
	 */
	public Cinema() {

	}

	/**
	 * Cinema constructor
	 * @param name
	 * @param cinema_class
	 * @param ID
	 */
	public Cinema(String name, String cinema_class, int ID) {
		this.cinema_name = name;
		this.cinema_class = cinema_class;
		this.cinemaID = ID;
		showlist = new ArrayList<show>();
	}
	/**
	 * add shows to showlist
	 * @param s
	 */
	public void addShow(show s) {
		showlist.add(s);
	}
	/**
	 * get the shows from showlist
	 * @return showlist
	 */
	public ArrayList<show> getCinemaShows() {
		return showlist;
	}
	/**
	 * return cinema name
	 * @return cinema_name
	 */
	public String getCinemaName() {
		return cinema_name;
	}
	/**
	 * set cinema name
	 * @param cinema_name
	 */
	public void setCinemaName(String cinema_name) {
		this.cinema_name = cinema_name;
	}
	/**
	 * get cinemaID
	 * @return cinemaID
	 */
	public int getCinemaID() {
		return cinemaID;
	}
	/**
	 * set cinemaID
	 * @param cinemaID
	 */
	public void setCinemaID(int cinemaID) {
		this.cinemaID = cinemaID;
	}
	/**
	 * get cinema_class
	 * @return cinema_class
	 */
	public String getCinemaClass() {
		return cinema_class;
	}
	/**
	 * set cinema_class
	 * @param cinema_class
	 */
	public void setCinemaClass(String cinema_class) {
		this.cinema_class = cinema_class;
	}
}