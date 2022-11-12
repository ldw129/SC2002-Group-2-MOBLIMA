package moblima.model;

public class MovieTicket {
    private String movieType;
    private String cinemaClass;
    private int age;
    private int date;
    private double price;

    public MovieTicket(String movieType, String cinemaClass, int age, int date) {
        this.movieType = movieType;
        this.cinemaClass = cinemaClass;
        this.age = age;
        this.date = date;
        this.price = calculatePrice(movieType, cinemaClass, age, date);
    }

    private double calculatePrice(String movieType, String cinemaClass, int age, int date) {
        return 0;
    }

    public double getPrice() {
        return price;
    }
}
