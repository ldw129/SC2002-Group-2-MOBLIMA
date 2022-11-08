package moblima.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Used to read all ticket prices from prices.txt
 * @version 1.0
 */


public class TicketPrice {
	
private ArrayList<Double> prices = new ArrayList<>(); 

/**
 * read prices line by line from data/prices.txt
 *  File Format
 *  3DPrice
 *  Class - Standard
 *  Class - Premium
 *  Class - Platinum
 *  Movie Goer Category - Child
 *  Movie Goer Category - Senior Citizen
 *  Public Holiday Price
 *  GST Percentage
 * @return array of all surcharge prices
 */
public ArrayList<Double> readPrices() {
        
        /**
         *  File Format
         *  3DPrice
         *  Class - Standard
         *  Class - Premium
         *  Class - Platinum
         *  Movie Goer Category - Child
         *  Movie Goer Category - Senior Citizen
         *  Public Holiday Price
         *  GST Percentage
        */
        
        File file = new File("Database/prices.txt");
        
        try {
    
            Scanner sc = new Scanner(file);
    
            while (sc.hasNextLine()) {
                double i = sc.nextDouble();
                prices.add(i);
            }
            sc.close();
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        return prices;
        
}

}