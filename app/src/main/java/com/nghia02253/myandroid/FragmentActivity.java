package com.nghia02253.myandroid;

//import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FragmentActivity extends AppCompatActivity implements DeleteDataInterface{

    FragmentManager fragmentManager = getSupportFragmentManager();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_activity);
    }

    public void LoadFragment(View view){

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = null;

        switch (view.getId()) {
            case R.id.btnFragmentA:
                fragment = new Fragment_A();
                break;
            case  R.id.btnFragmentB:
                fragment = new Fragment_B();
                break;
            case R.id.btnListFragment:
                fragment = new FragmentList();
                break;
            case R.id.btnDialogInterface:
                fragment = new FragmentDialogInterface();
                break;
        }
        fragmentTransaction.replace(R.id.frame_fragment, fragment);
        fragmentTransaction.commit();
    }
    public void LoadFragmentInterface(View view) {

    }
    public void BackFragment(View view) {
        getSupportFragmentManager().popBackStack();
    }
    public void DialogFragment(View view) {
        FragmentDialog fragmentDialog = new FragmentDialog();
        fragmentDialog.show(getSupportFragmentManager(), "dialog");
    }
    public void DialogFragmentInterface(View view) {
        FragmentDialogInterface fragmentDialogInterface = new FragmentDialogInterface();
        fragmentDialogInterface.show(getSupportFragmentManager(), "dialog");
    }

    @Override
    public void XoaGiaTri(boolean delete) {
        if(delete){
            Toast.makeText(FragmentActivity.this, "Chọn xóa với Interface", Toast.LENGTH_LONG).show();
        } else{
            Toast.makeText(FragmentActivity.this, "Chọn không xóa với Interface", Toast.LENGTH_LONG).show();
        }
    }
}
