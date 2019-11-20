package com.nghia02253.myandroid;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class KyhopActivity extends AppCompatActivity implements DataKyhopInterface {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kyhop_activity);

    }

    @Override
    public void GetDataKH(KyHop kyHop) {
        FragmentKyhopDetail fragmentKyhopDetail = (FragmentKyhopDetail) getSupportFragmentManager().findFragmentById(R.id.fragmentKyhopDetail);
        if(fragmentKyhopDetail != null && fragmentKyhopDetail.isInLayout()) {
            fragmentKyhopDetail.setDataKyhop(kyHop);
        } else {
            Intent intent = new Intent(KyhopActivity.this, KyhopDetailActivity.class);
            intent.putExtra("dataKyHop", kyHop);
            startActivity(intent);
        }
    }
}