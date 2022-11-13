package moblima.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;

import moblima.model.Cinema;
import moblima.model.Cineplex;

/**
 * Class to handle all read cineplexes list and handle update functions
 * 
 * @version 1.0
 */

public class CineplexIO {

	// private static String SEPERATOR = "|";
	/**
	 * file name to read all cineplex data
	 */
	public static String filename = "Database/cineplex.txt";

	/**
	 * default constructor
	 */
	public CineplexIO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * read cineplexes
	 * 
	 * @return cineplex list
	 */
	public ArrayList<Cineplex> readCineplex() {
		try {
			ArrayList<Cineplex> cineplexesList = new ArrayList<Cineplex>();
			String[] temp;
			String[] temp2;
			Cinema c;
			Scanner fileScanner = new Scanner(new File(filename));
			while (fileScanner.hasNext()) {
				temp = fileScanner.nextLine().split(";");

				ArrayList<Cinema> tempCinemaList = new ArrayList<>();
				for (int i = 2; i < temp.length; i++) {
					temp2 = temp[i].split("[|]");
					c = new Cinema(temp2[0], temp2[1], Integer.parseInt(temp2[2]));
					tempCinemaList.add(c);
				}
				// System.out.println(temp[0]);
				cineplexesList.add(new Cineplex(
						temp[0], Integer.parseInt(temp[1]),
						tempCinemaList)); // 0 to be confirmed
			}

			fileScanner.close();
			return cineplexesList;
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * save cineplex list into the text file
	 * 
	 * @param al list of cineplex
	 * @throws IOException handle read file errors
	 */
	public static void saveCineplex(List al) throws IOException {
		List alw = new ArrayList();
		Cineplex c;
		ArrayList<Cinema> temp1;
		Cinema cm;
		StringBuilder st;
		final String SEPARATOR = ";";

		for (int i = 0; i < al.size(); is++) {
			c = (Cineplex) al.get(i);
			st = new StringBuilder();
			st.append(c.showLocation().trim());
			st.append(SEPARATOR);
			st.append(c.getCineplexID());
			st.append(SEPARATOR);
			temp1 = c.getCinema();
			for (int j = 0; j < temp1.size(); j++) {
				cm = temp1.get(j);
				st.append(cm.getCinemaName());
				st.append("|");
				st.append(cm.getCinemaClass());
				st.append("|");
				st.append(String.valueOf(cm.getCinemaID()));
				if (j != temp1.size() - 1)
					st.append(SEPARATOR);

			}
			st.append(SEPARATOR);

			alw.add(st.toString());
		}
		write(filename, alw);
	}

	/**
	 * read cineplexes list
	 * 
	 * @param fileName name of the file to read cineplexes list from
	 * @return list of cineplexes
	 * @throws IOException to handle file read errors
	 */
	public static List read(String fileName) throws IOException {
		List data = new ArrayList();
		Scanner scanner = new Scanner(new FileInputStream(fileName));
		try {
			while (scanner.hasNextLine()) {
				data.add(scanner.nextLine());
			}
		} finally {
			scanner.close();
		}
		return data;
	}

	/**
	 * Write fixed content to the given file
	 * 
	 * @param fileName name of the file to write data
	 * @param data     new list of cineplexes
	 * @throws IOException handle file write errors
	 */
	public static void write(String fileName, List data) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(fileName));

		try {
			for (int i = 0; i < data.size(); i++) {
				out.println((String) data.get(i));
			}
		} finally {
			out.close();
		}
	}
}
