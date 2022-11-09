package moblima.view;

import java.io.IOException;
import java.util.Scanner;
import moblima.model.Movie;

public class ViewMovieDetails {
    private static Movie movie;

    public ViewMovieDetails(Movie movie) {
        this.movie = movie;
    }
    public static void main(String[] args) {
        int choice = 0;
        Scanner input = new Scanner(System.in);

        do {
            System.out.printf("--------------\n" +
            "View Movie Details\n" +
            "1: Movie Title\n" +
            "2: Showing Status\n" +
            "3: Synopsis\n" +
            "4: Director\n" +
            "5: Cast\n" +
            "6: Overall reviewer rating\n" +
            "7: Past reviews and reviewer rating\n" +
            "8: Back\n");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();
            switch(choice) {
                case 1:
                    movie.getMovieName();
                    break;
                case 2:
                    movie.getShowingStatus();
                    break;
                case 3:
                    movie.getSynopsis();
                    break;
                case 4:
                    movie.getDirectorName();
                    break;
                case 5:
                    movie.getCast();
                    break;
                case 6:
                    movie.getTotalRating();
                    break;
                case 7:
                    movie.getAllRatings();
                    movie.getReviews();
                    break;
                case 8:
                    break;
                default:
                    System.out.println("");
                    System.err.println("Invalid Input, Please Try Again!");
                    System.out.println("");
                    break;
            }
    } while (choice != 8);

    }
}