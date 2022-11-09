package moblima;

import java.util.Scanner;
import java.util.ArrayList;
import moblima.controller.*;
import moblima.model.*;
import moblima.view.*;

public class MovieApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        master Master = new master();
        Master.readMovies();
        ArrayList<Movie> movie_list = Master.getMovies();

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

                if (true) { // condition to be determined
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
                                    CreateUpdateMovieListing movieListing_menu = new CreateUpdateMovieListing(Master);
                                    movieListing_menu.main(args);
                                    break;
                                case 2:
                                    CreateUpdateRemoveCinemaShowtimes cinemaShowtimes_menu = new CreateUpdateRemoveCinemaShowtimes(
                                            Master);
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
                Movie_goer user = new Movie_goer();
                do {
                    System.out.printf("---------------------\n" +
                            "Welcome to MovieGoer Module!\n" +
                            "1. Search/List movie\n" +
                            "2. View movie details including reviews and ratings\n" +
                            "3. Check seat availability and selection of seat/s\n" +
                            "4. Book and purchase ticket\n" +
                            "5. View booking history\n" +
                            "6. List the Top 5 ranking by ticket sales OR by overall reviewers' ratings\n" +
                            "7. Back\n");
                    System.out.print("Enter your choice: ");
                    try {
                        choice = sc.nextInt();

                        switch (choice) {
                            case 1:
                                user.ListMovie(movie_list);
                                break;
                            case 2:
                                user.ListMovie(movie_list);
                                // user.selectMovie();
                                ViewMovieDetails view_menu = new ViewMovieDetails(null);
                                view_menu.main(args);
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            case 6:
                                break;
                            case 7:
                                break;
                        }
                    } finally {
                    }
                } while (choice != 7);
                System.out.println("Returning to main screen...");
            }

        } while (choice != 3);
        System.out.println("Thank you for using MOBLIMA!");
        System.exit(0);
    }
}