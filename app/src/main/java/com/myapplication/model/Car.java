package com.myapplication.model;

import com.myapplication.R;

import java.util.ArrayList;

public  class Car {
    public String name;
    public String model;
    public String category;
    public int pricePerDay;
    public int year;
    public String transmission;
    public int numberOfSites;
    public String fuelType;
    public int mileage;
    public String make;
    public int imageResourceId;

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
    public static ArrayList<Car> sampleCars() {
        ArrayList<Car> data = new ArrayList<>();
        data.add(new Car("Toyota", "Camry",2022, "Sedan", 50000, "Automatic", 5, "Gasoline", 30, "Toyota",R.drawable.camry2022));
        data.add(new Car("Honda", "Civic",2021, "Compact", 40000, "Manual", 5, "Gasoline", 35, "Honda",R.drawable.civic_2021));
        data.add(new Car("Ford", "Escape",2020, "SUV", 60000, "Automatic", 5, "Gasoline", 25, "Ford",R.drawable.escape2020));
        data.add(new Car("Hyundai", "Elantra",2019, "Sedan", 45000, "Automatic", 5, "Gasoline", 32, "Hyundai",R.drawable.elantra2019));
        data.add(new Car("Chevrolet", "Malibu",2014, "Sedan", 55000, "Automatic", 5, "Gasoline", 28, "Chevrolet",R.drawable.malibu2014));

        return data;
    }
}
