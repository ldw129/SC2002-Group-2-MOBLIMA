package moblima.controller;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

import moblima.model.*;

/**
 * function used to read all the holiday dates and update them
 * @version 1.0
 */
public class HolidayConfig {

	    public String[] readHolidays() throws IOException,Exception {
	    	
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
	     * @throws IOException
	     * @throws Exception
	     */
	    public void writeHoliday(String[] holidays) throws IOException,Exception {
	    	
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
