package moblima.model;

import java.time.*;
import moblima.controller.GetPrice;
import moblima.controller.HolidayConfig;

public class MovieTicket {
    /**
     * 
     */
    private boolean is3D;

    /**
     * Class of cinema
     */
    private String cinemaClass;

    /**
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
     * 
     * @return Price of Movie Ticket
     */
    private double calculatePrice() {
        master m = new master();
        m.readHolidays();
        
        double price = 0;
        String[] holiday_list;
        holiday_list = m.getHolidays();

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

        price += is3D ? categoryPrice.get3DPrice() : 0;

        for(String i: holiday_list) {
            if (i.equals(date)) price += categoryPrice.getPublicHolidayPrice();
        }

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

    public double getPrice() {
        return price;
    }
}
