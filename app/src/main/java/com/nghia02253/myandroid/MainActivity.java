package com.nghia02253.myandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView textUser, textPass;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }
    void init() {
        textUser = findViewById(R.id.userText);
        textPass = findViewById(R.id.passText);
        btnLogin = findViewById(R.id.btnLogin);
    }
    public void onClickLogin(View v) {
        String userText = textUser.getText().toString().trim();
        String passText = textPass.getText().toString().trim();
//        if( textUser == "admin" && textPass == "admin"){
//
//        }
        Intent myIntent = new Intent(getBaseContext(), HomeActivity.class);
        startActivity(myIntent);
    }

}
