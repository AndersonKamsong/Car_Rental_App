package com.myapplication.view;

import static com.myapplication.model.Users.loginMethod;
import static com.myapplication.model.Users.sampleUsers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.myapplication.MainActivity;
import com.myapplication.R;
import com.myapplication.model.Users;

public class Settings extends Activity {
    private ImageButton backButton,imageSetting;
    private TextView unameSetting;
    private LinearLayout favourites,viewHistory,editPayment,editProfile;
    private String userName = null ;
    private int imageResourceId;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_layout);
        backButton = findViewById(R.id.settings_item_back_btn);
        unameSetting = findViewById(R.id.uname_setting);
        imageSetting = findViewById(R.id.image_setting);
        favourites = findViewById(R.id.favourites);
        viewHistory = findViewById(R.id.view_history);
        editPayment = findViewById(R.id.edit_payment);
        editProfile = findViewById(R.id.edit_profile);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("name")) {
            userName = intent.getStringExtra("name");
            String image = intent.getStringExtra("imageResourceId");
            imageResourceId = Integer.parseInt(image);
            unameSetting.setText(userName);
            imageSetting.setImageResource(imageResourceId);
        }
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Settings.this, carListPage.class);
                intent.putExtra("name", userName);
                String imageResource = String.valueOf(imageResourceId);
                intent.putExtra("imageResourceId",imageResource);
                startActivity(intent);
            }
        });
        favourites.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(Settings.this, "Favourites pressed!", Toast.LENGTH_SHORT).show();
            }
        });
        viewHistory.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(Settings.this, "View History pressed!", Toast.LENGTH_SHORT).show();
            }
        });
        editPayment.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(Settings.this, "Edit Payment pressed!", Toast.LENGTH_SHORT).show();
            }
        });
        editProfile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(Settings.this, "Edit Profile pressed!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
