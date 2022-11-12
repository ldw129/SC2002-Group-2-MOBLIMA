package moblima.model;

import java.time.*;
import moblima.controller.GetPrice;

public class MovieTicket {
    /**
     * 
     */
    private boolean is3D;

    /**
     * 
     */
    private String cinemaClass;

    /**
     * 
     */
    private int age;

    /**
     * 
     */
    private int date;

    /**
     * 
     */
    private double price;
    GetPrice getPrice = new GetPrice();

    /**
     * Constructor
     * @param is3D
     * @param cinemaClass
     * @param age
     * @param date
     */
    public MovieTicket(boolean is3D, String cinemaClass, int age, int date) {
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
        double price = 0;

        switch(cinemaClass) {
            case "Standard":
                price = getPrice.getStandardPrice();
                break;
            case "Premium":
                price = getPrice.getPremiumPrice();
                break;
            case "Plainum":
                price = getPrice.getPlatinumPrice();
                break;
        }

        price += is3D ? getPrice.get3DPrice() : 0;
        return price;
    }

    public double getPrice() {
        return price;
    }
}
