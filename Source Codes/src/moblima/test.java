package moblima;

import moblima.model.Movie;
import moblima.model.master;
import moblima.view.ConfigureHoliday;

import java.util.ArrayList;
import java.util.Scanner;

// use this to test whatever
public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        master m = new master();
        m.readCineplexes();
        m.readMovies();
        ArrayList<Movie> movie_list = m.getMovies();

        for (Movie mov: movie_list) {
            mov.readShowDetails(m);
        }

        try {
            ConfigureHoliday.main(args);
        }
        catch (Exception e){

        };
        
    }
}
