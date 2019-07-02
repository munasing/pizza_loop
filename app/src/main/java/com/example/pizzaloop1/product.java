package com.example.pizzaloop1;

public class product {

    private int id;
    private String title,shortedesc;
    private double price;
    private String image;

    public product(int id, String title, String shortedesc, double price, String image) {
        this.id = id;
        this.title = title;
        this.shortedesc = shortedesc;
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

    public double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }
}
