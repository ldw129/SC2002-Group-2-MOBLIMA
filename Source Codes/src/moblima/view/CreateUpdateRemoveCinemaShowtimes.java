package moblima.view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.tools.FileObject;

import moblima.model.AdminChangeStatus;
import moblima.model.Cineplex;
import moblima.model.master;
import moblima.model.Movie;
import moblima.model.show;

/**
 * UI Class to Create, Update and Remove Cinema Showtimes
 * @version 1.0
 */

public class CreateUpdateRemoveCinemaShowtimes {
	
private static master Master;
	
	/**
	 * Initialises the master class which calls the backend of the application
	 * @param m object of the Master UI class
	 */
	public CreateUpdateRemoveCinemaShowtimes(master m){
		Master = m;
	}
	
	public static void main(String[] args)  throws IOException{
		// TODO Auto-generated method stub
		System.out.println("");
		Scanner sc = new Scanner(System.in);
		int selection;
		boolean flag = true;
		
		
		while (flag) {
		System.out.println("Please select an option:\n"
				+ "1) Create show listing\n"
				+ "2) Update show listing\n"
				+ "3) Delete show listing\n"
				+ "4) Back");
        selection = sc.nextInt();
		System.out.println("");

		switch(selection) {
		case 1:
			ArrayList<Movie> movies=new ArrayList<Movie>();
			int i;
			String movieName;
			
			ArrayList<Cineplex> Cineplexes_1 = new ArrayList<Cineplex>();
			
			Cineplexes_1 = Master.getCineplexes();
	        
	        for(i=0; i< Cineplexes_1.size();i++)
	        	System.out.printf("%d) "+Cineplexes_1.get(i).showLocation()+"\n",i+1);
	        
	        System.out.println("");
	        
	        System.out.print("Select a Cineplex: ");
	        int choice_1 = sc.nextInt();
	        
	        System.out.print("Select a Screen (1 / 2 / 3): ");
	        int cinema_id = sc.nextInt();
	       
	        System.out.print("Is the Movie 3D? (true/false): ");
	        boolean threed = sc.nextBoolean();
	        
	        System.out.print("Enter the Date Time (e.g. 13/12/11 12:30):  ");
	        sc.nextLine();
	        String s_1 = sc.nextLine(); 
			
	        System.out.println("");
	        
	        movies = Master.getMovies();
			
	        Movie mov;
			Movie mov2;
	        show s;
			show s2;
	        System.out.println("-- All Movies --");
	        
	        for(i=0; i< movies.size();i++)
	        	System.out.printf("%d) "+movies.get(i).getMovieName()+"\n",i+1);
	        
	        System.out.println("");
	        
	        System.out.print("Please select a Movie to be added: ");
	        int mov_num = sc.nextInt();

			movieName = movies.get(mov_num-1).getMovieName();
	        
	        Movie m = movies.get(mov_num-1);
	        
	        if (m.getShowingStatus().equals("NOW SHOWING")||m.getShowingStatus().equals("PREVIEW"))
	        {
	        s = m.createShowListing(s_1, choice_1-1, cinema_id-1, threed);
	        
	        Cineplexes_1.get(choice_1-1).getCinema().get(cinema_id-1).addShow(s);
	        
	        Master.setCineplexes(Cineplexes_1);
			File file = new File("data/Shows/"+movies.get(mov_num-1).getMovieName()+".txt");
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			pw.println(s_1 +"|"+(cinema_id-1)+"|"+(choice_1-1)+"|"+m.getEmptySeats()+"|"+threed);

			pw.flush();
			pw.close();
	        
	        System.out.println(AdminChangeStatus.SUCCESSFUL.returningStatus());
	        }
	        else {
	        	System.err.println("Please set the showing status to now showing");
	        }
			
			break;
		
			case 2:
	        //update
	        movies = Master.getMovies();
	        int choice;
			int choice2;
			int updateSelection;
			int show_num;
			show ss;

	        System.out.println("");
	        System.out.println("-- All Movies --");
	        for(i=0; i< movies.size();i++)
	        	System.out.printf("%d) "+movies.get(i).getMovieName()+"\n",i+1);
	        
	        do {	System.out.print("\n"
	                + "Please make a selection:\n"
	                + " 1) Select  to update show\n"
	                + " 2) Back\n");
	                selection = sc.nextInt();
	                
	                if (selection > 2) {
	                	System.out.println("");
	                	System.err.print("Invalid Input, Please Try Again!"); 
	                	System.out.println("");
	                }
	                
	                if (selection == 1) {
	                	System.out.print("Please select a Movie Index to list its details and shows: ");
	                	selection = sc.nextInt();
	                	if (selection-1 > movies.size()) {
	                		System.out.println("");
	                		System.err.println("Please enter a valid movie number!");
	                		continue;
	                	}
	                	
	                	System.out.println("");
	                	mov = movies.get(selection-1);
						mov2 = movies.get(selection-1);
						System.out.println(mov.getMovieName());
						System.out.println(mov.getDirectorName());
						String [] reviews = mov.getReviews();
						for(int x =0;x<reviews.length;x++) 
							System.out.printf("%s ",reviews[x]);
						
						System.out.printf("\n");
						double [] ratings = mov.getAllRatings();
						for(int x =0;x<ratings.length;x++) 
							System.out.printf("%f ",ratings[x]);
						System.out.printf("\n");
	
						
						System.out.println(mov.getShowingStatus());
						System.out.println(mov.getSynopsis());
						String[] Cast = mov.getCast();
						for(int x =0;x<Cast.length;x++) 
							System.out.printf("%s ",Cast[x]);
						System.out.printf("\n");

	
						ArrayList<show> temp = mov.getShows();
						String keyWord = "";

						for (int k =0 ;k<temp.size();k++) {
							s = temp.get(k);
							System.out.printf("\n\nShow %d:\n",k+1);
							System.out.println(s.getDateTime());
							System.out.printf("CineplexID: %d\n",s.getCineplexID()+1);
							System.out.printf("CinemaID: %d\n",s.getScreenNum()+1);
							s.printSeats();
							
						}

						System.out.println("Please input the show number to be updated");
						choice =sc.nextInt();
						choice --;
						choice2 = choice;
						ss = temp.get(choice);

						System.out.println("Current show date and time: ");
						String currentDT = ss.getDateTime();
						System.out.println(currentDT);
						System.out.println("Current Cineplex: ");
						int currentCineplex = ss.getCineplexID();
						currentCineplex++;
						System.out.println(currentCineplex);
						System.out.println("Current Cinema: ");
						int currentCinema = ss.getScreenNum();
						currentCinema++;
						System.out.println(currentCinema);

						System.out.print("\n"
						+ "Please make a selection:\n"
						+ " 1) Update Show Date and Time\n"
						+ " 2) Update Cineplex\n"
						+ " 3) Update Cinema\n"
						+ " 4) Back\n");
						updateSelection = sc.nextInt();

						File uFile = new File("data/Shows/"+movies.get(selection-1).getMovieName()+".txt");
						Scanner updateFile = new Scanner(uFile);
						StringBuffer buffer = new StringBuffer();
						while(updateFile.hasNextLine())
						{
							buffer.append(updateFile.nextLine()+System.lineSeparator());
						}
						String fileContents = buffer.toString();
						
						switch(updateSelection)
						{
							case 1:
							Scanner scanDT = new Scanner(System.in);
							System.out.println("Enter updated show date and time: ");
							String newDT = scanDT.nextLine();
							ss.setDateTime(newDT);
							fileContents = fileContents.replaceAll(currentDT, newDT);
							break;

							case 2:
							ArrayList<Cineplex> Cineplexes_2 =new ArrayList<Cineplex>();
			
							Cineplexes_2 = Master.getCineplexes();
							for(i=0; i< Cineplexes_2.size();i++)
							{
								System.out.printf("%d) "+Cineplexes_2.get(i).showLocation()+"\n",i+1);
							}
							System.out.println("");
						
							System.out.print("Select a Cineplex: ");
							Scanner scanCineplex = new Scanner(System.in);
							System.out.println("Enter updated cineplex number: ");
							
							int newCineplex = scanCineplex.nextInt();
							newCineplex--;
							ss.setCineplexID(newCineplex);
							String strCurrentCineplex = Integer.toString(currentCineplex);
							String strNewCineplex = Integer.toString(newCineplex);
							fileContents = fileContents.replaceAll(strCurrentCineplex, strNewCineplex);
							break;

							case 3:
							Scanner scanCinema = new Scanner(System.in);
							System.out.println("Enter updated cinema number: ");
							System.out.print("Select a Screen (1 / 2 / 3): ");
							int newCinema = scanCinema.nextInt();
							newCinema--;
							ss.setCineplexID(newCinema);
							String strCurrentCinema = Integer.toString(currentCinema);
							String strNewCinema = Integer.toString(newCinema);
							fileContents = fileContents.replaceAll(strCurrentCinema, strNewCinema);
							break;

							case 4:
							flag = false;
						}

						FileWriter uWriter = new FileWriter(uFile);
						uWriter.append(fileContents);
						uWriter.flush();

						System.out.println("");
						System.out.printf("Show %d updated!", choice+1);
						System.out.println("");
						

                }
        } while(selection!= 2);
		break;

		case 3:
	        //delete
	        movies = Master.getMovies();
	        int deleteChoice;
			int deleteChoice2;
	        System.out.println("");
	        System.out.println("-- All Movies --");
	        for(i=0; i< movies.size();i++)
	        	System.out.printf("%d) "+movies.get(i).getMovieName()+"\n",i+1);
	        
	        do {	System.out.print("\n"
	                + "Please make a selection:\n"
	                + " 1) Select  to delete show\n"
	                + " 2) Back\n");
	                selection = sc.nextInt();
	                
	                if (selection > 2) {
	                	System.out.println("");
	                	System.err.print("Invalid Input, Please Try Again!"); 
	                	System.out.println("");
	                }
	                
	                if (selection == 1) {
	                	System.out.print("Please select a Movie Index to list its details and shows: ");
	                	selection = sc.nextInt();
	                	if (selection-1 > movies.size()) {
	                		System.out.println("");
	                		System.err.println("Please enter a valid movie number!");
	                		continue;
	                	}
	                	
	                	System.out.println("");
	                	mov = movies.get(selection-1);
						mov2 = movies.get(selection-1);
						System.out.println(mov.getMovieName());
						System.out.println(mov.getDirectorName());
						String [] reviews = mov.getReviews();
						for(int x =0;x<reviews.length;x++) 
							System.out.printf("%s ",reviews[x]);
						
						System.out.printf("\n");
						double [] ratings = mov.getAllRatings();
						for(int x =0;x<ratings.length;x++) 
							System.out.printf("%f ",ratings[x]);
						System.out.printf("\n");
	
						
						System.out.println(mov.getShowingStatus());
						System.out.println(mov.getSynopsis());
						String[] Cast = mov.getCast();
						for(int x =0;x<Cast.length;x++) 
							System.out.printf("%s ",Cast[x]);
						System.out.printf("\n");

	
						ArrayList<show> temp = mov.getShows();
						String keyWord = "";


						for (int k =0 ;k<temp.size();k++) {
							s = temp.get(k);
							System.out.printf("\n\nShow %d:\n",k+1);
							System.out.println(s.getDateTime());
							System.out.printf("CineplexID: %d\n",s.getCineplexID()+1);
							System.out.printf("CinemaID: %d\n",s.getScreenNum()+1);
							s.printSeats();
							
						}

						System.out.println("Please input the show number to be removed");
						deleteChoice =sc.nextInt();
						deleteChoice --;
						deleteChoice2 = deleteChoice;
						

						for(int j=0;j<temp.size();j++)
						{
							s2 = temp.get(j);

							if(j==deleteChoice)
							{
								keyWord = s2.getDateTime();
							}
						}

						String lineToRemove = keyWord;



						File inputFile = new File("data/Shows/"+movies.get(selection-1).getMovieName()+".txt");
						File tempFile = new File("data/Shows/myTempFile.txt");

						BufferedReader reader = new BufferedReader(new FileReader(inputFile));
						BufferedWriter writer2 = new BufferedWriter(new FileWriter(tempFile));
						
						
						String currentLine;

						while((currentLine = reader.readLine()) != null)
						{
							String trimmedLine = currentLine.trim();
							if(trimmedLine.contains(lineToRemove))
							{
								continue;
							}

							writer2.write((currentLine + System.getProperty("line.separator")));
						}

						File file3 = new File("data/Shows/"+movies.get(selection-1).getMovieName()+".txt");
						file3.delete();

						writer2.close();
						reader.close();
						inputFile.delete();
						tempFile.renameTo(inputFile);

						mov.deleteShow(Master, deleteChoice2);
						System.out.println("");
						System.out.printf("Show %d removed!", deleteChoice+1);
						System.out.println("");


                }
        } while(selection!= 2);
		break;
		case 4:
			flag = false;
	}
	}
	}
}
