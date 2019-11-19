package com.nghia02253.myandroid;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FragmentResponActivity extends AppCompatActivity implements DataKyhopInterface {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_respon_activity);
    }

    @Override
    public void GetDataKH(KyHop kyHop) {
        FragmentResponDetail fragmentResponDetail = (FragmentResponDetail) getSupportFragmentManager().findFragmentById(R.id.fragmentKyhopDetail);
        fragmentResponDetail.setDataKyhop(kyHop);
    }
}