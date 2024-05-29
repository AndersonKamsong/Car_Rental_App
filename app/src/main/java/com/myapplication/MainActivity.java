package com.myapplication;

import static com.myapplication.model.Users.loginMethod;
import static com.myapplication.model.Users.sampleUsers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.myapplication.model.Users;
import com.myapplication.view.LoginPage;
import com.myapplication.view.carListPage;


public class MainActivity extends AppCompatActivity {
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, carListPage.class);
                startActivity(intent);
            }
        });
    }
}