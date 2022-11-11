package moblima.controller;

import java.io.*;
import java.util.ArrayList;

public class UpdateHolidays {
	/**
	 * write the new movie ticket prices into the text file
	 * @param newPrices the new array of prices
	 */
	public void writeHolidays(ArrayList newHolidays) {
		
		try {
		
		PrintWriter writer = new PrintWriter("Database/Holidays.txt");
		
		for(int i = 0; i < 7; i++) {
			writer.println(newHolidays.get(i));
		}
		
		writer.print(newHolidays.get(7));
		
		writer.close();
		
		}
		
		catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		
	}
}
