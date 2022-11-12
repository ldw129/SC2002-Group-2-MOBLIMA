package moblima.view;
import java.util.*;

import javax.swing.ToolTipManager;

import moblima.model.master;
import moblima.model.Movie;

import java.io.*;
import moblima.model.*;

public class CreateUpdateMovieListing {

    private static master Master;
    private static String filepath = "Database/movies.txt";

    public CreateUpdateMovieListing(master m)
    {
        Master = m;
    }

    public static void main(String[] agrs) throws IOException{

        Scanner sc = new Scanner(System.in);

        boolean backBtn = false;

        ArrayList<Movie> movies = new ArrayList<Movie>();

        int i;

        System.out.println("1. Create a new Movie Listing\n"
        + 	"2. Update a Movie Listing\n"
        + 	"3. Remove a Movie Listing\n"
        +   "4. Back");

        System.out.println("");
		
		System.out.println("Please select an option");
		int choice = sc.nextInt();

        switch(choice)
        {
            case 1:
                String movieTitle, movieDirector, showStatus = null, movieSynopsis;
                String[] movieCast = new String[5];

                sc.nextLine();
                
                System.out.println("Enter Movie Title: ");
                movieTitle = sc.nextLine();

                System.out.println("Enter Movie Director: ");
                movieDirector = sc.nextLine();

                System.out.println("Enter Movie Synopsis: ");
                movieSynopsis = sc.nextLine();

                System.out.println("Enter Movie Status: \n"
                + 	"1. COMING SOON\n"
                + 	"2. PREVIEW\n"
                +   "3. NOW SHOWING");

                System.out.println("");

                int statusSel = sc.nextInt();
                
                switch (statusSel)
                {
                    case 1:
                        showStatus = "COMING SOON";
                        break;

                    case 2:
                        showStatus = "PREVIEW";
                        break;

                    case 3:
                        showStatus = "NOW SHOWING";
                        break;
                    
                    default:
                        System.out.println("Invalid input, please try again!");
                        break;

                }



                boolean incorrectInput = true;
                int numCast = 0;

                while(incorrectInput)
                {
                    try
                    {
                        do
                        {
                            System.out.println("Enter the number of casts in the movie (Minimum 2)");
                            numCast = sc.nextInt();

                            if(numCast>=2)
                            {
                                incorrectInput = false;
                            }
                            else
                            {
                                System.err.println("Please enter at least 2 cast members!");
                            }

                        }while(numCast<2);

                    }
                    catch(Exception e)
                    {
                        System.err.println("Please enter at least 2 cast members!");
                    }
                }
                

                for(i=0;i<numCast;i++) 
                {
                    Scanner scanCast = new Scanner(System.in);
                    System.out.printf("Enter Cast No. %d Name: \n",(i+1));
                    movieCast[i] = scanCast.nextLine();
                    System.out.println("");
                }

                //add string array to string
                StringBuffer sb = new StringBuffer();
                for(i=0;i<movieCast.length;i++)
                {
                    sb.append(movieCast[i]+",");
                }

                String movieCastStr = sb.toString();
                //System.out.println(movieCastStr);
                //maybe can delete
                String[] review = new String[0];
                double[] rating = new double[0];

                //might have to edit this
                Movie newMovie = new Movie(movieTitle, movieDirector, review, rating, showStatus, movieSynopsis, movieCast, 0);
                    
                //master.addMovieListing(newMovie);
                master.addMovieListing(newMovie);
                //String filepath = "Database/movies.txt";
                File showFile = new File("Database/Shows/"+movieTitle+".txt"); 
                showFile.createNewFile();
                File file = new File("Database/movies.txt");
                FileWriter fw = new FileWriter(file, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                
                pw.println(movieTitle+"|"+movieDirector+"|"+"Emotional movie!"+"|"+5.0+"|"+showStatus+"|"+movieSynopsis+"|"+movieCastStr+"|"+0);
                pw.flush();
                pw.close();

                System.out.println("");
                System.out.println("Movie successfully added!\n");
                break;
                


            case 2:
                            
                movies = Master.getMovies();
                
                Movie mov;
                show s;
                
                for(i=0; i< movies.size();i++)
                    System.out.printf("%d) "+movies.get(i).getMovieName()+"\n",i+1);
                
                System.out.print("Please select a Movie Number: ");
                int mov_num = sc.nextInt();
                
                System.out.print("Current Status of the Movie: ");
                
                System.out.println(movies.get(mov_num-1).getShowingStatus());
                
                System.out.println("Enter Movie Status: \n"
                + 	"1. COMING SOON\n"
                + 	"2. PREVIEW\n"
                +   "3. NOW SHOWING");

                System.out.println("");

                int statusSel2 = sc.nextInt();
                String currentStatus = movies.get(mov_num-1).getShowingStatus();
                File uFile = new File(filepath);
                Scanner updateFile = new Scanner(uFile);
                StringBuffer buffer = new StringBuffer();
                while(updateFile.hasNextLine())
                {
                    buffer.append(updateFile.nextLine()+System.lineSeparator());
                }
                String fileContents = buffer.toString();

                
                switch (statusSel2)
                {
                    case 1:
                        showStatus = "COMING SOON";
                        movies.get(mov_num-1).setShowingStatus(showStatus);
                        fileContents = fileContents.replaceAll(currentStatus, showStatus);

                        break;

                    case 2:
                        showStatus = "PREVIEW";
                        movies.get(mov_num-1).setShowingStatus(showStatus);
                        fileContents = fileContents.replaceAll(currentStatus, showStatus);

                        break;

                    case 3:
                        showStatus = "NOW SHOWING";
                        movies.get(mov_num-1).setShowingStatus(showStatus);
                        fileContents = fileContents.replaceAll(currentStatus, showStatus);

                        break;
                    
                    default:
                        System.out.println("Invalid input, please try again!");
                        break;

                }
                
                //String filePath = "Database/movies.txt";
                FileWriter writer = new FileWriter(uFile);
                writer.append(fileContents);
                writer.flush();

                System.out.println("");
                
                //System.out.println(AdminChangeStatus.SUCCESSFUL.returningStatus());
                System.out.println("Movie updated successfully!");
                
                System.out.println("");
                break;
                

            case 3:
                movies = Master.getMovies();
                Movie mov_1;
                show s_1;
                for(i=0; i< movies.size();i++)
                    System.out.printf("%d) "+movies.get(i).getMovieName()+"\n",i+1);
                
                System.out.print("Please select a Movie Number: ");
                int mov_num_1 = sc.nextInt();
                //int sho_num_2 = sc.nextInt();

                File inputFile = new File(filepath);
                File tempFile = new File("Database/myTempFile.txt");

                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer2 = new BufferedWriter(new FileWriter(tempFile));

                //removes from arrayList but not from txt file
                //i choose 6 but i get 7?
                String lineToRemove = movies.get(mov_num_1-1).getMovieName();
                
                String currentLine;

                while((currentLine = reader.readLine()) != null)
                {
                    String trimmedLine = currentLine.trim(); //issue
                    //if(trimmedLine.equals(lineToRemove))
                    if(trimmedLine.contains(lineToRemove))
                    {
                        continue;
                    }

                    writer2.write((currentLine + System.getProperty("line.separator")));
                }

                File file3 = new File("Database/Shows/"+movies.get(mov_num_1-1).getMovieName()+".txt");
                file3.delete();
                Master.deleteMovie(mov_num_1-1);

                writer2.close();
                reader.close();
                inputFile.delete();
                tempFile.renameTo(inputFile);

                System.out.println("");
                
                System.out.println("Movie successfully removed!");
                
                System.out.println("");
                
                break;

            case 4:
                backBtn = true;
                break;

            default:
                System.out.println("Invalid input, please try again!");
                break;
        }

        if(backBtn == true)
        {
            return;
        }
    }
}