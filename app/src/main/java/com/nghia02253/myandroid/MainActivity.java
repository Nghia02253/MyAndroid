package com.nghia02253.myandroid;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
    private static final String TAG = "MyActivity";
    public void onClickLogin(View v) {
        String userText = "admin";
        String passText = "admin";

        Log.d(TAG, userText);
        if( textUser.getText().toString().equals(userText) && textPass.getText().toString().equals(passText)){
            Toast.makeText(getBaseContext(), "Login Success", Toast.LENGTH_LONG).show();
            new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        Intent myIntent = new Intent(getBaseContext(), HomeActivity.class);
                        startActivity(myIntent);
                    }
                }, 2000);
        } else {
            Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();
        }

    }

}
