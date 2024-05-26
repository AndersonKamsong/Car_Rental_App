package com.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class carListPage extends AppCompatActivity {
    private ListView listView;
    private ImageButton backButton;
    private Button moreButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_list_layout);
        backButton = findViewById(R.id.map_item_back_btn);
        listView = findViewById(R.id.car_list);
        // Create an ArrayList to hold your data (can be String, custom objects, etc.)
//        ArrayList<String> data = new ArrayList<>();
        ArrayList<Car> data = new ArrayList<>();
        data.add(new Car("Toyota", "Camry",2022, "Sedan", 50000, "Automatic", 5, "Gasoline", 30, "Toyota",R.drawable.camry2022));
        data.add(new Car("Honda", "Civic",2021, "Compact", 40000, "Manual", 5, "Gasoline", 35, "Honda",R.drawable.civic_2021));
        data.add(new Car("Ford", "Escape",2020, "SUV", 60000, "Automatic", 5, "Gasoline", 25, "Ford",R.drawable.escape2020));
        data.add(new Car("Hyundai", "Elantra",2019, "Sedan", 45000, "Automatic", 5, "Gasoline", 32, "Hyundai",R.drawable.elantra2019));
        data.add(new Car("Chevrolet", "Malibu",2014, "Sedan", 55000, "Automatic", 5, "Gasoline", 28, "Chevrolet",R.drawable.malibu2014));


        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(carListPage.this,MainActivity.class);
                startActivity(intent);
            }
        });
        // Create a custom adapter for the ListView
        CarList adapter = new CarList(this, data);
        listView.setAdapter(adapter);
    }
}
