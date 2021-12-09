package com.codeup.adlister.models;

import java.util.Date;

public class Car {
    private long id;
    private long userId;
    private int year;
    private String make;
    private String model;
    private double price;
    private String description;
    private Date creationDate;

    //one constructor for insertion and one for extraction

    public Car(long id, long userId, int year, String make, String model, double price, String description, Date creationDate) {
        this.id = id;
        this.userId = userId;
        this.year = year;
        this.make = make;
        this.model = model;
        this.price = price;
        this.description = description;
        this.creationDate = creationDate;

    }

    public Car(long userId, int year, String make, String model, double price, String parameter) {
        this.userId = userId;
        this.year = year;
        this.make = make;
        this.model = model;
        this.price = price;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
