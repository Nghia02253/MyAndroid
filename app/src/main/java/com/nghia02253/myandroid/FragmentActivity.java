package com.nghia02253.myandroid;

import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FragmentActivity extends AppCompatActivity {
    Button btnFragmentA, btnFragmentB;
    FrameLayout frame_fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_activity);
        btnFragmentA = findViewById(R.id.btnFragmentA);
        btnFragmentB = findViewById(R.id.btnFragmentB);
        frame_fragment = findViewById(R.id.frame_fragment);
    }

    public void LoadFragment(String fragmentName){
        Toast.makeText(FragmentActivity.this, "Load Fragment", Toast.LENGTH_LONG).show();
    }
}
