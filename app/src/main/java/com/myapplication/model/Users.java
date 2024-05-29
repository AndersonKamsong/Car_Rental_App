package com.myapplication.model;

import com.myapplication.R;

import java.util.ArrayList;

public class Users {
    public String name;
    public String accountType;
    public String email;
    public String password;
    public String phone;
    public int imageResourceId;

    public Users(String name,String accountType,String email,String password,
    String phone,int imageResourceId ) {
        this.name = name;
        this.accountType = accountType;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.imageResourceId = imageResourceId;
    }
    public static Users loginMethod(String creds,String password, ArrayList<Users> users) {
        Users userCurrent;
        for (Users user : users) {
            if ( ( (user.name.equalsIgnoreCase(creds)||user.email.equalsIgnoreCase(creds) ) && user.password.equalsIgnoreCase(password))) {
                return user;
            }
        }
        return null;
    }
    public static ArrayList<Users> sampleUsers() {
        ArrayList<Users> users = new ArrayList<>();

        users.add(new Users("John Doe", "Admin", "test@gmail.com", "12345", "+1234567890", R.drawable.audi_car));
        users.add(new Users("Jane Smith", "Client", "test2@gmail.com", "123", "+9876543210", R.drawable.audi_car));
        users.add(new Users("Michael Lee", "Client", "michael.lee@example.com", "welcome123", "+5432198760", R.drawable.audi_car));
        users.add(new Users("Olivia Jones", "Client", "olivia.jones@example.com", "strongpassword", "+7896541230", R.drawable.audi_car));
        users.add(new Users("William Brown", "Admin", "william.brown@example.com", "mysecret", "+3210987654", R.drawable.audi_car));

        return users;
    }
}
