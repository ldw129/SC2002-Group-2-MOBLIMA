package moblima.controller;

import java.io.*;

/**
 * function used to read all the holiday dates and update them
 * @version 1.0
 */
public class HolidayConfig {
		/**
		 * Opens Holidays.txt and reads the file contents.
		 * @return holiday dates
		 * @throws FileNotFoundException
		 */
	
	    public String[] readHolidays() throws FileNotFoundException {
	    	
			FileReader fr = new FileReader("Database/Holidays.txt");
			BufferedReader br = new BufferedReader(fr);
			
			try {
				return br.readLine().split("[|]");
			}
			catch(Exception e) {
				String[] temp = new String[0];
				return temp;
			}
		    		
		}	
	    
	    /**
	     * to write a new holiday date into Holidays.txt
	     * @throws FileNotFoundException
	     */
	    public static void writeHoliday(String[] holidays) throws FileNotFoundException {
	    	
	    	try {
				FileWriter fw = new FileWriter("Database/Holidays.txt", false);
				BufferedWriter bw = new BufferedWriter(fw);
				
				for(int i=0;i<holidays.length;i++)
					bw.write(holidays[i] + "|");

				bw.close();				
			} 
	    	catch (IOException e) {
				e.printStackTrace();
			}
	    	
	    }
	    
}
