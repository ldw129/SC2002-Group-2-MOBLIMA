package moblima.controller;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Used to write all ticket prices to prices.txt
 * @version 1.0
 */

public class UpdateTicketPrices {
	
	/**
	 * write the new movie ticket prices into the text file
	 * @param newPrices the new array of prices
	 */
	public void writePrices(ArrayList newPrices) {
		
		try {
			PrintWriter writer = new PrintWriter("Database/prices.txt");
		
			for(int i = 0; i < 8; i++) {
				writer.println(newPrices.get(i));
			}
			
			writer.close();
		
		}
		
		catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		
	}
	
	
}
