package com.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private ImageView carImageView,backButton;
    private TextView carNameTextView;
    private Button rentButton;
    private TextView carNameYear;
    private TextView carNameCategory;
    private TextView carNamePricePerDay;
    private TextView carNameTransmission;
    private TextView carNameNumberOfSites;
    private TextView carNameFuelType;
    private TextView carNameMileage;;
    private TextView carMake;
    private TextView carModel;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_detail);

        // Get references to UI elements
        this.carImageView = findViewById(R.id.car_image_view);
        this.carNameTextView = findViewById(R.id.car_name_text_view);
        this.carNameYear = findViewById(R.id.car_year);
        this.carNameCategory = findViewById(R.id.car_category);
        this.carNamePricePerDay = findViewById(R.id.car_price);
        this.carNameTransmission = findViewById(R.id.car_transmission);
        this.carNameNumberOfSites = findViewById(R.id.car_no_site);
        this.carNameFuelType = findViewById(R.id.car_fuel_type);
        this.carNameMileage = findViewById(R.id.car_mileage);
        this.carModel = findViewById(R.id.car_make_model);
        this.carMake = findViewById(R.id.car_make_model);
        this.rentButton = findViewById(R.id.rent_button);
        this.backButton = findViewById(R.id.car_detail_back);
        // Get data from the Intent (optional)
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("carName")) {
            String carName = intent.getStringExtra("carName");
            String year = intent.getStringExtra("year");
            String category = intent.getStringExtra("category");
            String pricePerDay = intent.getStringExtra("pricePerDay");
            String transmission = intent.getStringExtra("transmission");
            String numberOfSites = intent.getStringExtra("numberOfSites");
            String fuelType = intent.getStringExtra("fuelType");
            String mileage = intent.getStringExtra("mileage");
            String make = intent.getStringExtra("carMake");
            String model = intent.getStringExtra("carModel");
            String image = intent.getStringExtra("imageResourceId");
            int imageResourceId = Integer.parseInt(image);

            // Update UI elements with car data (replace with your logic)
            carNameTextView.setText(carName);
            carNameYear.setText(year);
            carNameCategory.setText(category);
            carNamePricePerDay.setText(String.format("%sXAF/day", pricePerDay));
            carNameTransmission.setText(transmission);
            carNameNumberOfSites.setText(numberOfSites);
            carNameFuelType.setText(fuelType);
            carNameMileage.setText(mileage);
            carMake.setText(make);
            carModel.setText(model);
            carImageView.setImageResource(imageResourceId); // Example for a specific car image
        }

        // Set click listener for rent button (handle rental logic here)
        rentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle rent button click (e.g., show rental confirmation or navigate to rental process)
                Toast.makeText(DetailActivity.this, "Rent button clicked!", Toast.LENGTH_SHORT).show();
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to launch the DetailActivity
                Intent intent = new Intent(DetailActivity.this,carListPage.class);
                // Start the DetailActivity
                startActivity(intent);
            }
        });
    }
}


