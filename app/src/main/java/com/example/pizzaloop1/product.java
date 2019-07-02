package com.example.pizzaloop1;

public class product {

    private int id;
    private String title,shortedesc;
    private double rating;
    private double price;
    private String image;

    public product(int id, String title, String shortedesc, double rating, double price, String image) {
        this.id = id;
        this.title = title;
        this.shortedesc = shortedesc;
        this.rating = rating;
        this.price = price;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getShortedesc() {
        return shortedesc;
    }

    public double getRating() {
        return rating;
    }

    public double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }
}
