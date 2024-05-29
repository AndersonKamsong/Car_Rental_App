package com.myapplication.view;

import static com.myapplication.model.Car.sampleCars;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.myapplication.MainActivity;
import com.myapplication.R;
import com.myapplication.model.Car;
import com.myapplication.viewModel.CarList;

import java.util.ArrayList;


public class carListPage extends AppCompatActivity {
    private ListView listView;
    private LinearLayout settingsOpt;
    private ImageButton backButton,optionBtn;
    private Boolean isMenuOpen = false;
    private String userName = null ;
    private int imageResourceId;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_list_layout);
        backButton = findViewById(R.id.map_item_back_btn);
        optionBtn = findViewById(R.id.map_item_opt_btn);
        listView = findViewById(R.id.car_list);
        settingsOpt = findViewById(R.id.settings_opt);

        ArrayList<Car> data = sampleCars();
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("name")) {
            userName = intent.getStringExtra("name");
            String image = intent.getStringExtra("imageResourceId");
            imageResourceId = Integer.parseInt(image);
        }
        if (userName == null) {
            backButton.setImageResource(R.drawable.escape2020);
            optionBtn.setVisibility(View.GONE);
        }else{
            backButton.setImageResource(R.drawable.back);
            optionBtn.setVisibility(View.VISIBLE);
        }

        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(carListPage.this, LoginPage.class);
                intent.putExtra("name", userName);
                String imageResource = String.valueOf(imageResourceId);
                intent.putExtra("imageResourceId",imageResource);
                startActivity(intent);
            }
        });
        optionBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                isMenuOpen = !isMenuOpen;
                if (isMenuOpen) {
                    settingsOpt.setVisibility(View.VISIBLE);
                }else{
                    settingsOpt.setVisibility(View.GONE);
                }
            }
        });
        settingsOpt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(carListPage.this, Settings.class);
                startActivity(intent);
            }
        });
        // Create a custom adapter for the ListView
        CarList adapter = new CarList(this, data);
        listView.setAdapter(adapter);
        if (isMenuOpen) {
            settingsOpt.setVisibility(View.VISIBLE);
        }else{
            settingsOpt.setVisibility(View.GONE);
        }
    }
}
