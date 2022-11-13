package moblima.model;

import moblima.controller.GetPrice;

/**
 * Class for MovieTicket and its corresponding attributes
 * 
 * @version 1.0
 */
public class MovieTicket {

    /**
     * 3D movie
     */
    private boolean is3D;

    /**
     * Class of cinema
     */
    private String cinemaClass;

    /**s
     * Age of movie-goer
     */
    private int age;

    /**
     * Date of movie
     */
    private String date;

    /**
     * Price of movie ticket
     */
    private double price;
    GetPrice categoryPrice = new GetPrice();

    /**
     * Constructor
     * 
     * @param is3D
     * @param cinemaClass
     * @param age
     * @param date
     */
    public MovieTicket(boolean is3D, String cinemaClass, int age, String date) {
        this.is3D = is3D;
        this.cinemaClass = cinemaClass;
        this.age = age;
        this.date = date.substring(0, 4);
        System.out.printf("Passed in: %s\nConverted to: %s", date, this.date);
        this.price = calculatePrice();
    }

    /**
     * Calculates price of movie ticket
     * 
     * @return price of movie ticket
     */
    private double calculatePrice() {
        master m = new master();
        m.readHolidays();

        double price = 0;
        String[] holiday_list;
        holiday_list = m.getHolidays();

        // base price of ticket
        switch (cinemaClass) {
            case "Standard":
                price = categoryPrice.getStandardPrice();
                break;
            case "Premium":
                price = categoryPrice.getPremiumPrice();
                break;
            case "Platinum":
                price = categoryPrice.getPlatinumPrice();
                break;
        }

        // add 3D surcharge if any
        if (is3D) {
            price = price + categoryPrice.get3DPrice();
        }

        // add holiday surchage if any
        for (String i : holiday_list) {
            if (i.equals(date))
                price = price + categoryPrice.getPublicHolidayPrice();
        }
        // add discount if any
        if (age >= 0 && age < 13) {
            price = price - categoryPrice.getChildPrice();
        } else if (age >= 13 && age < 19) {
            price = price - categoryPrice.getStudentPrice();
        } else if (age >= 55 && age < 101) {
            price = price - categoryPrice.getSeniorCitizenPrice();
        }

        // GST
        price = price + price * categoryPrice.getGSTPrice() / 100;

        return price;
    }

    /**
     * Get price of movie ticket
     * 
     * @return price of movie ticket
     */
    public double getPrice() {
        return price;
    }
}
