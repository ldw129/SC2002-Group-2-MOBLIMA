package moblima.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Used to read all ticket prices from prices.txt
 * 
 * @version 1.0
 */

public class TicketPriceIO {

    /**
     * read prices line by line from Database/prices.txt
     * File Format
     * 3DPrice
     * Class - Standard
     * Class - Premium
     * Class - Platinum
     * Movie Goer Category - Child
     * Movie Goer Category - Senior Citizen
     * Movie Goer Category - Student
     * Public Holiday Price
     * GST Percentage
     * 
     * @return array of all surcharge prices
     */

    public static ArrayList<Double> readPrices() {

        /**
         * File Format
         * 3DPrice
         * Class - Standard
         * Class - Premium
         * Class - Platinum
         * Movie Goer Category - Child
         * Movie Goer Category - Senior Citizen
         * Movie Goer Category - Student
         * Public Holiday Price
         * GST Percentage
         */

        ArrayList<Double> prices = new ArrayList<>();
        File file = new File("Database/prices.txt");

        try {

            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                double i = sc.nextDouble();
                prices.add(i);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return prices;
    }

    public static void writePrices(ArrayList<Double> newPrices) {

        try {
            PrintWriter writer = new PrintWriter("Database/prices.txt");

            for (int i = 0; i < newPrices.size(); i++) {
                if (i == newPrices.size() - 1)
                    writer.print(newPrices.get(i));
                else
                    writer.println(newPrices.get(i));
            }
            writer.close();
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}