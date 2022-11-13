package moblima.model;

/**
 * This class uses the objects from the movie.java class to create shows for the movie in different
 * cinemaplexes and screens
 * @version 1.0
 */

public class show {
	
	/**
	 * date and time of a show
	 */
	private String dateTime;
	
	/**
	 * movie object from movie.java class
	 */
	private Movie mov;
	
	/**
	 * screen number in the Cinemaplex
	 */
	private int screenNum;
	
	/**
	 * ID of the Cinemaplex
	 */
	private int cineplexID;
	
	/**
	 * array of all seats
	 */
	private CinemaSeat[][] seats = new CinemaSeat[9][9];
	
	/**
	 * boolean value to specify whether the movie is 3D or not
	 */
	private boolean is3D;
	
	/**
	 * auto construct seats
	 * @param mov 			movie object
	 * @param dt 			data-time of show
	 * @param cineplexID	ID of the CinemaPlex 
	 * @param screenNum 	Screen Number in the CinemaPlex
	 * @param is3D 			boolean value - true if the movie is 3D
	 */
	public show(Movie mov, String dt, int cineplexID, int screenNum, boolean is3D) {
		this.mov = mov;
		dateTime = dt;
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				seats[i][j] = new CinemaSeat();
			}
		}
		this.cineplexID = cineplexID;
		this.screenNum = screenNum;
		this.is3D = is3D;
	}
	
	/**
	 * manually construct seats, called by readShows in movieIO
	 * @param mov 			movie object
	 * @param dt 			date-time of show
	 * @param cineplexID 	ID of the CinemaPlex
	 * @param screenNum		Screen Number in the CinemaPlex
	 * @param is3D			boolean value - true if the movie is 3D
	 * @param seats			array of seats
	 */
	public show(Movie mov, String dt, int cineplexID, int screenNum, boolean is3D, CinemaSeat[][] seats) {
		this.mov = mov;
		dateTime = dt;
		
			
		this.seats = seats;

		this.cineplexID = cineplexID;
		this.screenNum = screenNum;
		this.is3D = is3D;
	}
	
	/**
	 * print Seats 
	 */
	public void printSeats() {
		System.out.printf("Movie %s by Director %s\n",mov.getMovieName(),mov.getDirectorName());
		System.out.printf("Show Location: Cineplex ID: %d, Screen Number: %d\n",cineplexID+1,screenNum+1);
		System.out.printf("Show Time: %s\n\n\n",dateTime);
		System.out.printf("      1 2 3   4 5 6   7 8 9\n");
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if (j%3 == 0) {
					System.out.print("  ");
				}
				if (j == 0) {
					System.out.printf("%c   ",(char)i+65);
				}
				if (seats[i][j].isAssigned()) {
					System.out.printf("X ");
				}
				else {
					System.out.printf("_ ");
				}
			}
			System.out.print("\n");
		}
		System.out.printf("\n           Screen Here     \n");
		System.out.printf("\n          X  -  Occupied   \n");
		System.out.printf("          _  -  Vaccant    \n");

	}
	
	/**
	 * assign seat
	 * @param s1 x co-ordinate of the seat
	 * @param s2 y co-ordinate of the seat
	 */
	public void assignSeat(int s1,int s2) {
		if (!seats[s1][s2].isAssigned()) {
			seats[s1][s2].assign();
			mov.incTsales();
		}
		else
			System.out.println("Error");
	}
	
	/**
	 * check if seat is assigned
	 * @param s1
	 * @param s2
	 * @return
	 */
	public boolean checkSeat(int s1,int s2) {
		return seats[s1][s2].isAssigned();
	}
	
	/**
	 * get the date and time of the show
	 * @return date-time of the movie show
	 */
	public String getDateTime() {
		return dateTime;
	}

	/**
	 * set dateTime
	 * @param dt
	 */
	public void setDateTime(String dt)
	{
		dateTime = dt;
	}
	
	/**
	 * get the Cineplex ID
	 * @return Cineplex ID
	 */
	public int getCineplexID() {
		return cineplexID;
	}

	/**
	 * set Cineplex ID
	 * @param id
	 */
	public void setCineplexID(int id)
	{
		cineplexID = id;
	}
	
	/**
	 * screen number in the Cinemplex
	 * @return screen number
	 */
	public int getScreenNum() {
		return screenNum;
	}

	/**
	 * set screenNum
	 * @param screenNumber
	 */
	public void setScreenNum(int screenNumber)
	{
		screenNum = screenNumber;
	}
	
	/**
	 * get the seat array
	 * @return the seat array
	 */
	public CinemaSeat[][] getSeats(){
		return seats;
	}
	
	/**
	 * return whether the movie is 3D or not using a boolean value
	 * @return boolean value - true if the movie is 3D
	 */
	public boolean get3D() {
		return is3D;
	}
}
