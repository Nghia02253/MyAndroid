package com.nghia02253.myandroid;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends Activity {

    TextView textUser, textPass, tvResetPass;
    Button btnLogin;
    CheckBox cbRemember;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        sharedPreferences = getSharedPreferences("dataLogin", MODE_PRIVATE);
        init();

        //lấy giá trị acount
        textUser.setText(sharedPreferences.getString("user", ""));
        textPass.setText(sharedPreferences.getString("pass", ""));
        cbRemember.setChecked(sharedPreferences.getBoolean("checked", false));

        tvResetPass.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, ResetPass.class);
//                intent.putExtra("dulieu", 2019);

                String[] arrayData = {"Data 1", "Data 2", "Data 3"};
                intent.putExtra("arrayData", arrayData);
                //Object
                ListUser listUser = new ListUser("15/10/2019", "Đang diễn ra", "Kỳ họp khóa VI", "Đang cập nhật nội dung...", R.drawable.logo, 1);
                //Bundle
                Bundle bundle = new Bundle();
                bundle.putStringArray("arrayData", arrayData);
                bundle.putSerializable("objectData", listUser);

                intent.putExtra("dataGroup", bundle);
//                intent.putExtra("objectData", listUser);
                startActivity(intent);
            };
        });

        Log.d("AAA","onCreate Main");

    }

    @Override
    protected void onStart() {
        Log.d("AAA","onStart Main");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        Log.d("AAA","onRestart Main");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.d("AAA","onResume Main");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("AAA","onPause Main");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("AAA","onStop Main");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("AAA","onDestroy Main");
        super.onDestroy();
    }

    void init() {
        textUser = findViewById(R.id.userText);
        textPass = findViewById(R.id.passText);
        btnLogin = findViewById(R.id.btnLogin);
        tvResetPass = findViewById(R.id.tvResetPass);
        cbRemember = findViewById(R.id.cbRemember);
    }

    public void onClickLogin(View v) {
        String userText = "admin";
        String passText = "admin";

        String user = textUser.getText().toString();
        String pass = textPass.getText().toString();

        if( user.equals(userText) && pass.equals(passText)){
            Toast.makeText(getBaseContext(), "Login Success", Toast.LENGTH_SHORT).show();
            //Sửa file xml dataLogin
            if(cbRemember.isChecked()){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("user", user);
                editor.putString("pass", pass);
                editor.putBoolean("checked", true);
                editor.commit();
            }else {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("user");
                editor.remove("pass");
                editor.remove("checked");
                editor.commit();
            }

            new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        Intent myIntent = new Intent(getBaseContext(), HomeActivity.class);
                        startActivity(myIntent);
                    }
                }, 10);
        } else {
            Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();
        }

    }

}
