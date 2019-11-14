package com.nghia02253.myandroid;

//import android.app.Fragment;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_activity);
    }

    public void LoadFragment(View view){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = null;

        switch (view.getId()) {
            case R.id.btnFragmentA:
                fragment = new Fragment_A();
                break;
            case  R.id.btnFragmentB:
                fragment = new Fragment_B();
                break;
        }
        fragmentTransaction.replace(R.id.frame_fragment, fragment);
        fragmentTransaction.commit();
    }
}
