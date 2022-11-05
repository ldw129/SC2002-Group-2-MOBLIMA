package model;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import controller.*;
import java.io.IOException;

/**
 * Master class to serve as the primary backend layer for the UI
 * @version 1.0
 */

public class master {

	static private ArrayList<Holiday> holidayList;
	/**
	 * Array of all movies
	 */
	static private ArrayList<movie> movieList;
	
	/**
	 * Array of all Cineplexes
	 */
	private ArrayList<Cineplex> cineplexList;
	
	/**
	 * file for all movies
	 */
	private static String filename = "data/movies.txt";

	/**
	 * add a movie to the database
	 * @param m movie object containing all the movie details
	 */
	public static void addMovieListing(movie m) {
		movieList.add(m);
		//add to txt file

	}
	
	/**
	 * add a cineplex to the cineplex list
	 * @param c cinema details 
	 */
	public void addCineplex(Cineplex c) {
		cineplexList.add(c);
	}
	
	/**
	 * get all movies
	 * @return array of all movies
	 */
	public ArrayList<movie> getMovies(){
		return movieList;
	}

	public ArrayList<Holiday> getHolidays()
	{
		return holidayList;
	}
	
	/**
	 * get all cineplexes
	 * @return array of all cineplexes
	 */
	public ArrayList<Cineplex> getCineplexes(){
		return cineplexList;
	}
	
	/**
	 * delete a movie from a database
	 * @param index ID of the movie in the file to be deleted
	 */
	public void deleteMovie(int index) {
		movie mov = movieList.get(index);
		for (show sh:mov.getShows()) {
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
		}catch(IOException e){
			
		}
	}
	
	/**
	 * save movies into the text file
	 */
	public void saveMovies() {
		movieIO temp = new movieIO();
		try {
		temp.saveMovie(filename, movieList);
		}catch(IOException e){
			
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

		CineplexIO temp = new CineplexIO();
		try {
		temp.saveCineplex(cineplexList);
		}
		catch(IOException e){
			
		}
	}
	
	/**
	 * set a cineplex
	 * @param c	cineplex object
	 */
	public void setCineplexes(ArrayList<Cineplex> c) {
		cineplexList = c;
	}
}
