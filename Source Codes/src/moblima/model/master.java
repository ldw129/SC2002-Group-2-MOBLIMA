package moblima.model;

import java.util.ArrayList;
import moblima.controller.*;
import java.io.IOException;

/**
 * Master class to serve as the primary backend layer for the UI
 * 
 * @version 1.0
 */

public class master { // HOLIDAY IS COMMENTED OUT FOR TESTING

	// static private ArrayList<Holiday> holidayList;

	/**
	 * Array of all movies
	 */
	static private ArrayList<Movie> movieList;

	/**
	 * Array of all Cineplexes
	 */
	private ArrayList<Cineplex> cineplexList;

	/**
	 * Array of all holidays
	 */
	private String[] holiday_list;

	/**
	 * file for all movies
	 */
	private static String filename = "Database/movies.txt";

	/**
	 * add a movie to the database
	 * 
	 * @param m movie object containing all the movie details
	 */
	public static void addMovieListing(Movie m) {
		movieList.add(m);
		// add to txt file

	}

	/**
	 * add a cineplex to the cineplex list
	 * 
	 * @param c cinema details
	 */
	public void addCineplex(Cineplex c) {
		cineplexList.add(c);
	}

	/**
	 * get all movies
	 * 
	 * @return array of all movies
	 */
	public ArrayList<Movie> getMovies() {
		return movieList;
	}

	/**
	 * get all cineplexes
	 * 
	 * @return array of all cineplexes
	 */
	public ArrayList<Cineplex> getCineplexes() {
		return cineplexList;
	}

	public String[] getHolidays() {
		return holiday_list;
	}

	/**
	 * delete a movie from a database
	 * 
	 * @param index ID of the movie in the file to be deleted
	 */
	public void deleteMovie(int index) {
		Movie mov = movieList.get(index);
		for (show sh : mov.getShows()) {
			mov.deleteShow(this, sh);
		}
		movieList.remove(index);
	}

	/**
	 * read movies from the text file
	 */
	public void readMovies() {
		movieIO temp = new movieIO();
		try {
			movieList = temp.readMovie(filename);
		} catch (IOException e) {

		}
	}

	/**
	 * save movies into the text file
	 */
	public void saveMovies() {
		try {
			movieIO.saveMovie(filename, movieList);
		} catch (IOException e) {

		}
	}

	/**
	 * read all cineplexes from the file
	 */
	public void readCineplexes() {

		CineplexIO temp = new CineplexIO();
		cineplexList = temp.readCineplex();

	}

	/**
	 * Save all cineplexes into the file
	 */
	public void saveCineplexes() {
		try {
			CineplexIO.saveCineplex(cineplexList);
		} catch (IOException e) {

		}
	}

	/**
	 * set a cineplex
	 * 
	 * @param c cineplex object
	 */
	public void setCineplexes(ArrayList<Cineplex> c) {
		cineplexList = c;
	}

	/**
	 * read all holidays from the file
	 */
	public void readHolidays() {
		HolidayConfig temp = new HolidayConfig();
		try {
			holiday_list = temp.readHolidays();
		} catch (Exception e) {
		}
	}

	/**
	 * save all holidays into the file
	 */
	public void saveHolidays() {
		try {
			HolidayConfig.writeHoliday(holiday_list);
		} catch (Exception e) {
		}
	}
}
