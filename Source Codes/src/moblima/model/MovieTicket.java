package moblima.model;

import java.time.*;
import moblima.controller.GetPrice;
import moblima.controller.HolidayConfig;

public class MovieTicket {

    /**
     * 3D movie
     */
    private boolean is3D;

    /**
     * class of cinema
     */
    private String cinemaClass;

    /**
     * age of movie-goer
     */
    private int age;

    /**
     * date of movie
     */
    private String date;

    /**
     * price of movie ticket
     */
    private double price;
    GetPrice categoryPrice = new GetPrice();

    /**
     * Constructor
     * @param is3D
     * @param cinemaClass
     * @param age
     * @param date
     */
    public MovieTicket(boolean is3D, String cinemaClass, int age, String date) {
        this.is3D = is3D;
        this.cinemaClass = cinemaClass;
        this.age = age;
        this.date = date;
        this.price = calculatePrice();
    }

    /**
     * Calculates price of movie ticket
     * @return price of movie ticket
     */
    private double calculatePrice() {
        master m = new master();
        m.readHolidays();
        
        double price = 0;
        String[] holiday_list;
        holiday_list = m.getHolidays();

        // base price of ticket
        switch(cinemaClass) {
            case "Standard":
                price = categoryPrice.getStandardPrice();
                break;
            case "Premium":
                price = categoryPrice.getPremiumPrice();
                break;
            case "Plainum":
                price = categoryPrice.getPlatinumPrice();
                break;
        }

        // add 3D surcharge if any
        price += is3D ? categoryPrice.get3DPrice() : 0;

        // add holiday surchage if any
        for(String i: holiday_list) {
            if (i.equals(date)) price += categoryPrice.getPublicHolidayPrice();
        }
        // add discount if any (MIGHT NEED TO EDIT)
        if(age >= 0 && age < 13 ) {
            price -= categoryPrice.getChildPrice();
        }
        else if (age >= 19 && age < 55) {
            price -= categoryPrice.getStudentPrice();
        }
        else if (age >= 55 && age < 101) {
            price -= categoryPrice.getSeniorCitizenPrice();
        }

        return price;
    }

    /**
     * Get price of movie ticket
     * @return price of movie ticket
     */
    public double getPrice() {
        return price;
    }
}
