package com.nghia02253.myandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class KyhopDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kyhop_detail_activity);

        Intent intent = getIntent();
        KyHop kyHop = (KyHop) intent.getSerializableExtra("dataKyHop");

        FragmentKyhopDetail fragmentKyhopChitiet = (FragmentKyhopDetail) getSupportFragmentManager().findFragmentById(R.id.fragmentthongtinKyhop);
        fragmentKyhopChitiet.setDataKyhop(kyHop);
    }
}
