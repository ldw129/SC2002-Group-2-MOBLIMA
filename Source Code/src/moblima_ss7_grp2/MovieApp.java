package moblima_ss7_grp2;

import java.util.Scanner;

public class MovieApp {
    // placeholder to be removed
    public class Cineplex {
        public String getName() {
            return "";
        }
    }

    private Cineplex[] cineplexes;
    private int numCineplex;

    public void showCineplex() {
        System.out.println("Cineplexes Available: ");
        for (int i = 0; i < cineplexes.length; i++) {
            System.out.printf("%d: %s\n", i + 1, cineplexes[i].getName());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice = 0;
        do {
            System.out.printf("---------------------\n" +
                    "Welcome to MOBLIMA!\n" +
                    "1: Cinema Staff\n" +
                    "2: Movie-Goer\n" +
                    "3: Quit\n");
            System.out.print("Enter your choice: ");

            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.err.println("Invalid input!");
                sc.nextLine();
            }

            // Admin
            if (choice == 1) {
                sc.nextLine();
                System.out.println("Welcome to the Admin Module! Please enter username and password.");
                System.out.print("Username: ");
                String username = sc.nextLine();
                System.out.print("Password: ");
                String password = sc.nextLine();

                // placeholder
                if (username.equals("admin") && password.equals("password")) {
                    choice = 0;
                    do {
                        System.out.printf("---------------------\n" +
                                "Welcome to the Admin Module!\n" +
                                "1: Create/Update/Remove Movie Listing\n" +
                                "2: Create/Update/Remove cinema showtimes\n" +
                                "3: Update system settings\n" +
                                "4: Quit\n");
                        System.out.print("Enter your choice: ");

                        try {
                            choice = sc.nextInt();
                        } catch (Exception e) {
                            System.err.println("Invalid input!");
                            sc.nextLine();
                        }
                    } while (choice != 4);
                    System.out.println("Returning to main screen...");
                } else {
                    System.out.println("Wrong username or password entered! Returning to main screen...");
                }
            }

            // MovieGoer
            else if (choice == 2) {
                choice = 0;
                do {
                    System.out.printf("---------------------\n" +
                            "Welcome to MovieGoer Module!\n" +
                            "1. Search/List movie\n" +
                            "2. View movie details including reviews and ratings\n" +
                            "3. Check seat availability and selection of seat/s\n" +
                            "4. Book and purchase ticket\n" +
                            "5. View booking history\n" +
                            "6. List the Top 5 ranking by ticket sales OR by overall reviewers’ ratings\n" +
                            "7. Quit\n");
                    System.out.print("Enter your choice: ");
                    try {
                        choice = sc.nextInt();
                    } catch (Exception e) {
                        System.err.println("Invalid input!");
                        sc.nextLine();
                    }
                } while (choice != 7);
                System.out.println("Returning to main screen...");
            }

        } while (choice != 3);
        System.out.println("Thank you for using MOBLIMA!");
    }
}