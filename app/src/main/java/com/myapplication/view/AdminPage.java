package com.myapplication.view;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.myapplication.MainActivity;
import com.myapplication.R;
import com.myapplication.model.Users;

public class AdminPage extends Activity {
    private ImageButton logoutBtn;
    private TextView adminUname;
    private ImageView adminImage;
    private LinearLayout manageCar,settings,viewOrder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_layout);
        logoutBtn = findViewById(R.id.logout_btn);
        adminUname = findViewById(R.id.admin_uname);
        adminImage = findViewById(R.id.admin_image);
        manageCar = findViewById(R.id.manage_car);
        settings = findViewById(R.id.settings);
        viewOrder = findViewById(R.id.view_order);
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("name")) {
            String name = intent.getStringExtra("name");
            String image = intent.getStringExtra("imageResourceId");
            int imageResourceId = Integer.parseInt(image);

            // Update UI elements with car data (replace with your logic)
            adminUname.setText(name);
            adminImage.setImageResource(imageResourceId); // Example for a specific car image
        }

        manageCar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(AdminPage.this, "Manage Car pressed!", Toast.LENGTH_SHORT).show();
            }
        });
        settings.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(AdminPage.this, "Settings pressed!", Toast.LENGTH_SHORT).show();
            }
        });
        viewOrder.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(AdminPage.this, "View Order pressed!", Toast.LENGTH_SHORT).show();
            }
        });
        logoutBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(AdminPage.this, LoginPage.class);
                startActivity(intent);
            }
        });

    }
}
