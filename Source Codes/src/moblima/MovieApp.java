package moblima;

import java.util.Scanner;
import java.util.ArrayList;
import moblima.controller.*;
import moblima.model.*;
import moblima.view.*;

public class MovieApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        master m = new master();
        m.readMovies();
        ArrayList<Movie> movie_list = m.getMovies();
        m.readCineplexes();

        int choice = 0;
        do {
            System.out.printf("---------------------\n" +
                    "Welcome to MOBLIMA!\n" +
                    "1: Cinema Staff\n" +
                    "2: Movie-Goer\n" +
                    "3: Quit\n");
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
                System.out.println("Welcome to the Admin Module! Please enter username and password.");
                System.out.print("Username: ");
                String username = sc.nextLine();
                System.out.print("Password: ");
                String password = sc.nextLine();

                // placeholder
                if (username.equals("admin") && password.equals("password")) {
                    choice = 0;
                    do {
                        System.out.printf("---------------------\n" +
                                "Welcome to the Admin Module!\n" +
                                "1: Create/Update/Remove Movie Listing\n" +
                                "2: Create/Update/Remove cinema showtimes\n" +
                                "3: Configure Ticket Prices\n" +
                                "4: Configure Holidays\n" +
                                "5: Quit\n");
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
                                    break;
                                case 5:
                                    break;
                            }
                        } catch (Exception e) {
                            System.err.println("Invalid input!");
                            sc.nextLine();
                        }
                    } while (choice != 4);
                    System.out.println("Returning to main screen...");
                } else {
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
                                mainFunctions.CheckSeat();
                                break;
                            case 3:
                                mainFunctions.BookTickets(); // under construction
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