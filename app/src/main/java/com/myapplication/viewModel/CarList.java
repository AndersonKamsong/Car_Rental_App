package com.myapplication.viewModel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.myapplication.view.DetailActivity;
import com.myapplication.R;
import com.myapplication.model.Car;

import java.util.ArrayList;

public class CarList extends ArrayAdapter<Car> {
    private final Context context;
    private final ArrayList<Car> data;
    public CarList(Context context, ArrayList<Car> data) {
        super(context, R.layout.card_layout, data);
        this.context = context;
        this.data = data;
    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Inflate the item_card layout
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.card_layout, parent, false);

        // Get the TextView and ImageView and basic items
        TextView textView = view.findViewById(R.id.map_item_title);
        ImageView imageView = view.findViewById(R.id.map_item_image);  // Get the ImageView by ID
        TextView makeView = view.findViewById(R.id.map_item_make);
        TextView modelView = view.findViewById(R.id.map_item_model);
        TextView priceView = view.findViewById(R.id.map_item_price);
        // Set the data for the current list item
        textView.setText(data.get(position).name);
        makeView.setText(data.get(position).make);
        modelView.setText(data.get(position).model);
        priceView.setText(String.format("%dXAF", data.get(position).pricePerDay));

//            imageView.setImageResource(R.drawable.audi_car);  // Example using a drawable resource
        imageView.setImageResource(data.get(position).imageResourceId);  // Example using a drawable resource
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the car data for the clicked position
                String carName = data.get(position).name;
                String year = String.valueOf(data.get(position).year);
                String category = data.get(position).category;
                String pricePerDay = String.valueOf(data.get(position).pricePerDay);
                String transmission = data.get(position).transmission;
                String numberOfSites = String.valueOf(data.get(position).numberOfSites);
                String fuelType = data.get(position).fuelType;
                String mileage = String.valueOf(data.get(position).mileage);
                String make = data.get(position).make;
                String model = data.get(position).model;
                String imageResourceId = String.valueOf(data.get(position).imageResourceId);

                // Create an Intent to launch the DetailActivity
                Intent intent = new Intent(context, DetailActivity.class);

                // Optionally, send data (car detail) to the DetailActivity
                intent.putExtra("carName", carName);
                intent.putExtra("year",year);
                intent.putExtra("category",category);
                intent.putExtra("pricePerDay",pricePerDay);
                intent.putExtra("transmission",transmission);
                intent.putExtra("numberOfSites",numberOfSites);
                intent.putExtra("fuelType",fuelType);
                intent.putExtra("mileage",mileage);
                intent.putExtra("make",make);
                intent.putExtra("model",model);
                intent.putExtra("imageResourceId",imageResourceId);

                // Start the DetailActivity
                context.startActivity(intent);
            }
        });
        return view;
    }
}
