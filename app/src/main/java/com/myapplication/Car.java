package com.myapplication;

public  class Car {
    String name;
    String model;
    String category;
    int pricePerDay;
    int year;
    String transmission;
    int numberOfSites;
    String fuelType;
    int mileage;
    String make;
    int imageResourceId;

    public Car(String name, String model,int year, String category, int pricePerDay,
               String transmission, int numberOfSites, String fuelType, int mileage, String make,int imageResourceId ) {
        this.name = name;
        this.model = model;
        this.year = year;
        this.category = category;
        this.pricePerDay = pricePerDay;
        this.transmission = transmission;
        this.numberOfSites = numberOfSites;
        this.fuelType = fuelType;
        this.mileage = mileage;
        this.make = make;
        this.imageResourceId = imageResourceId;
    }
}
