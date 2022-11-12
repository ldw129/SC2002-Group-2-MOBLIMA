package moblima.view;

import java.util.Scanner;

import moblima.controller.HolidayConfig;
import moblima.model.master;

public class ConfigureHoliday {
    /**
     * Configure holidays
     * 
     * @param args default argument
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        master m = new master();
        m.readHolidays();
        String[] holiday_list = m.getHolidays();
        int choice = 0;

        System.out.println("-- Configure Holidays --");

        do {
            System.out.println("1. View Holidays");
            System.out.println("2. Add Holidays");
            System.out.println("3. Remove Holidays");
            System.out.println("4. Back\n");
            System.out.print("Select an option: ");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    for (String holiday : holiday_list) {
                        System.out.printf(holiday + ", ");
                    }
                    break;
                case 2:
                    System.out.print("Please enter month of holiday: ");
                    int month = input.nextInt();
                    System.out.print("Please enter day of holdiay: ");
                    int day = input.nextInt();
                case 3:
                    for (int i = 0; i < holiday_list.length; i++) {
                        System.out.printf("%d. %s", i + 1, holiday_list[i]);
                    }
                    System.out.print("Select holiday to remove: ");
                    int remove_index = input.nextInt() - 1;

                    String[] newholiday_list = new String[holiday_list.length - 1];
                    for (int i = 0, j = 0; i < holiday_list.length; i++) {
                        if (i == remove_index) {
                            continue;
                        }
                        newholiday_list[j++] = holiday_list[i];
                    }

                    holiday_list = newholiday_list;
                case 4:
                    break;
                default:
                    System.out.println("");
                    System.err.println("Invalid Input, Please Try Again!");
                    System.out.println("");
            }
        } while (choice != 4);

        try {
            HolidayConfig.writeHoliday(holiday_list);
        } catch (Exception e) {

        }

        return;
    }
}
