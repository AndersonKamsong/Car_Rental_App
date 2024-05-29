package com.myapplication.view;

import static com.myapplication.model.Users.loginMethod;
import static com.myapplication.model.Users.sampleUsers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.TextView;

import com.myapplication.MainActivity;
import com.myapplication.R;
import com.myapplication.model.Car;
import com.myapplication.model.Users;
import com.myapplication.viewModel.CarList;

import java.util.ArrayList;

public class LoginPage extends Activity {
    private Button submitButton,cancelButton;
    private TextView responseMsg;
    private EditText credsField,passField;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        submitButton = findViewById(R.id.loginsubmitbtn);
        cancelButton = findViewById(R.id.cancelbtn);
        responseMsg = findViewById(R.id.responseMsg);
        credsField = findViewById(R.id.loginName);
        passField = findViewById(R.id.loginPassword);

        cancelButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(LoginPage.this, carListPage.class);
                startActivity(intent);
            }
        });
        submitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String creds = "test2@gmail.com";
//                String creds = String.valueOf(credsField.getText());
                String password = "123";
//                String password = String.valueOf(passField.getText());
                Users user = loginMethod(creds,password,sampleUsers());
                if (user == null) {
                    responseMsg.setText("Invalid User Name ,Email or Password");
                    passField.setText("");
                }else{
                    if (user.accountType.equals("Admin")) {
                        Intent intent = new Intent(LoginPage.this, AdminPage.class);
                        intent.putExtra("name", user.name);
                        String imageResourceId = String.valueOf(user.imageResourceId);
                        intent.putExtra("imageResourceId",imageResourceId);
                        startActivity(intent);
                    }else {
                        Intent intent = new Intent(LoginPage.this, carListPage.class);
                        intent.putExtra("name", user.name);
                        String imageResourceId = String.valueOf(user.imageResourceId);
                        intent.putExtra("imageResourceId",imageResourceId);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}
