package moblima;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import moblima.controller.*;
import moblima.model.*;
import moblima.view.*;

public class MovieApp {
	public static final String accountFile = "Database/accounts.txt";
	
/*	private static int authenticator(String username, String password, String login, boolean valid) {
		int usertype = -1;
		
		try {
			FileReader frStream = new FileReader(accountFile);
			BufferedReader brStream = new BufferedReader(frStream);
			login = brStream.readLine();
		
			while(login != null) {
				String[] var = login.split("[|]");
				if(username.equals(var[1]) && password.equals(var[2])) {
					valid = true;
					usertype = Integer.parseInt(var[3]);
					break;
				}
				login = brStream.readLine();
			}
			brStream.close();
		} catch(IOException e) {}
		return usertype;
	}
*/	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        master m = new master();
        m.readMovies();
        ArrayList<Movie> movie_list = m.getMovies();
        System.out.println(movie_list);
        m.readCineplexes();
        for (Movie mov: movie_list) {
            mov.readShowDetails(m);
        }

        int choice = 0;
        do {
        	  System.out.println("-------------------");
              System.out.println("Welcome to MOBLIMA!");
              System.out.println("1: Log in");
              System.out.println("2: Guest Session");
              System.out.println("3: Quit");
              System.out.print("Enter your choice: ");

            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.err.println("Invalid input!");
                sc.nextLine();
            }

            // Admin
            if (choice == 1) {
                sc.nextLine();
                System.out.println("Please enter username and password.");
                System.out.print("Username: ");
                String username = sc.nextLine();
                System.out.print("Password: ");
                String password = sc.nextLine();
                
                boolean valid = false;
                String login = null;
        		int usertype = -1;
        		
        		try {
        			FileReader frStream = new FileReader(accountFile);
        			BufferedReader brStream = new BufferedReader(frStream);
        			login = brStream.readLine();
        		
        			while(login != null) {
        				String[] var = login.split("[|]");
        				if(username.equals(var[1]) && password.equals(var[2])) {
        					valid = true;
        					usertype = Integer.parseInt(var[3]);
        					break;
        				}
        				login = brStream.readLine();
        			}
        			brStream.close();
        		} catch(IOException e) {}

                // placeholder
                if (valid){
                    switch(usertype) {
                    case 1:
	                    do {
	                    	System.out.println("----------------------------");
	                        System.out.println("Welcome to the Admin Module!");
	                        System.out.println("1: Create/Update/Remove Movie Listing");
	                        System.out.println("2: Create/Update/Remove cinema showtimes");
	                        System.out.println("3: Configure Ticket Prices");
	                        System.out.println("4: Configure Holidays");
	                        System.out.println("5: Quit");
	                        System.out.print("Enter your choice: ");
	
	                        try {
	                            choice = sc.nextInt();
	                            switch (choice) {
	                                case 1:
	                                    CreateUpdateMovieListing movieListing_menu = new CreateUpdateMovieListing(m);
	                                    movieListing_menu.main(args);
	                                    break;
	                                case 2:
	                                    CreateUpdateRemoveCinemaShowtimes cinemaShowtimes_menu = new CreateUpdateRemoveCinemaShowtimes(
	                                            m);
	                                    cinemaShowtimes_menu.main(args);
	                                    break;
	                                case 3:
	                                    ConfigureTicketPrices.main(args);
	                                case 4:
	                                	ConfigureHoliday.main(args);
	                                    break;
	                                case 5:
	                                    break;
	                            }
	                        } catch (Exception e) {
	                            System.err.println("Invalid input!");
	                            sc.nextLine();
	                        }
	                    } while (choice < 5);
	                    System.out.println("Returning to main screen...");
                    case 2:
                    	choice = 0;
                        MemberFunctions mainFunctions = new MemberFunctions();

                        do {
                        	System.out.println("----------------------------");
                            System.out.println("Welcome to MovieGoer Module!");
                            System.out.println("1. Search / List movies and view movie details");
                            System.out.println("2. Check seat availability and selection of seat/s");
                            System.out.println("3. Book and purchase tickets");
                            System.out.println("4. View your booking history");
                            System.out.println("5. List the top 5 movies ranked by ticket sales OR by overall reviewers’ ratings");
                            System.out.println("6. Quit");
                            System.out.print("Enter your choice: ");
                            try {
                                choice = sc.nextInt();

                                switch (choice) {
                                    case 1:
                                        mainFunctions.ViewMovies(movie_list, movie_list.size());
                                        break;
                                    case 2:
                                        mainFunctions.CheckSeats(movie_list);
                                        break;
                                    case 3:
                                        mainFunctions.BookTickets(login, movie_list); // under construction
                                        break;
                                    case 4:
                                    	mainFunctions.viewBookingHistory(login); // under construction
                                        break;
                                    case 5:
                                        mainFunctions.PopularMovies(movie_list);
                                        break;
                                    case 6:
                                        break;
                                    default:
                                        System.err.println("Invalid input!");
                                }
                            } catch (Exception e) {
                                System.err.println("Invalid input!");
                                sc.nextLine();
                            }
                        } while (choice != 6);
                        System.out.println("Returning to main screen...");
                    }
                }
                else {
                    System.out.println("Wrong username or password entered! Returning to main screen...");
                }
            }

            // MovieGoer
            else if (choice == 2) {
                choice = 0;
                MovieGoerFunctions mainFunctions = new MovieGoerFunctions();

                do {
                    System.out.printf("---------------------\n" +
                            "Welcome to MovieGoer Module!\n" +
                            "1. Search / List movies and view movie details\n" +
                            "2. Check seat availability and selection of seat/s\n" +
                            "3. Book and purchase tickets\n" +
                            "4. View your booking history\n" +
                            "5. List the top 5 movies ranked by ticket sales OR by overall reviewers’ ratings\n" +
                            "6. Quit\n");
                    System.out.print("Enter your choice: ");
                    try {
                        choice = sc.nextInt();

                        switch (choice) {
                            case 1:
                                mainFunctions.ViewMovies(movie_list, movie_list.size());
                                break;
                            case 2:
                                mainFunctions.CheckSeats(movie_list);
                                break;
                            case 3:
                                mainFunctions.BookTickets(movie_list); // under construction
                                break;
                            case 4:
                            	mainFunctions.viewBookingHistory(); // under construction
                                break;
                            case 5:
                                mainFunctions.PopularMovies(movie_list);
                                break;
                            case 6:
                                break;
                            default:
                                System.err.println("Invalid input!");
                        }
                    } catch (Exception e) {
                        System.err.println("Invalid input!");
                        sc.nextLine();
                    }
                } while (choice != 6);
                System.out.println("Returning to main screen...");
            }

        } while (choice != 3);
        System.out.println("Thank you for using MOBLIMA!");
        System.exit(0);
    }
}
