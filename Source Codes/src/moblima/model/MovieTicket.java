package moblima.model;

public class MovieTicket {
    private String typeofmovie;
    private String cinemaclass;
    private int age;
    private int date;
    private double price;

    public MovieTicket(String typeofmovie, String cinemaclass, int age, int date) {
        this.typeofmovie = typeofmovie;
        this.cinemaclass = cinemaclass;
        this.age = age;
        this.date = date;
        this.price = calculatePrice(typeofmovie, cinemaclass, age, date);
    }

    private double calculatePrice(String typeofmovie, String cinemaclass, int age, int date) {
        return 0;
    }

    public double getPrice() {
        return price;
    }
}
