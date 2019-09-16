package com.nghia02253.myandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    CheckBox int_id, double_id, string_id, all;
    Button test, hint, btnListUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Trang chủ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:break;
        }

        return super.onOptionsItemSelected(item);
    }
    //Listener nhận sự kiện khi các Checkbox thay đổi trạng thái
    CompoundButton.OnCheckedChangeListener m_listener
            = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (compoundButton == all)
            {
                detachListener();
                int_id.setEnabled(!b);
                double_id.setEnabled(!b);
                string_id.setEnabled(!b);

                int_id.setChecked(b);
                double_id.setChecked(b);
                string_id.setChecked(b);
                attachListener();
            }
            else {
                Toast.makeText(compoundButton.getContext(),
                        compoundButton.getText() + " | "
                                + compoundButton.isChecked(),
                        Toast.LENGTH_SHORT).show();
            }
        }
    };

    //Gán Listener vào CheckBox
    void attachListener()
    {
        int_id.setOnCheckedChangeListener(m_listener);
        double_id.setOnCheckedChangeListener(m_listener);
        string_id.setOnCheckedChangeListener(m_listener);
        all.setOnCheckedChangeListener(m_listener);

    }
    //Bỏ các Listener khỏi CheckBox
    void detachListener()
    {
        int_id.setOnCheckedChangeListener(null);
        double_id.setOnCheckedChangeListener(null);
        string_id.setOnCheckedChangeListener(null);
        all.setOnCheckedChangeListener(null);

    }


    void init() {
        int_id    = findViewById(R.id.int_id);
        double_id = findViewById(R.id.double_id);
        string_id = findViewById(R.id.string_id);
        all       = findViewById(R.id.all);
        btnListUser = findViewById(R.id.btnListUser);
        attachListener();


        test = findViewById(R.id.test);
        hint  = findViewById(R.id.hint);

        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                detachListener();
                int_id.setChecked(false);
                double_id.setChecked(false);
                all.setChecked(false);
                attachListener();
                string_id.setChecked(true);

            }
        });

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mgs = "";
                if (!int_id.isChecked() &&
                        !double_id.isChecked() &&
                        string_id.isChecked())
                    mgs = "Đúng, chúc mừng";
                else
                    mgs = "Sai rồi";

                Toast.makeText(view.getContext(),
                        mgs,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void onClickListUsers(View v) {
        Intent myIntent = new Intent(getBaseContext(), ListUserActivity.class);
        startActivity(myIntent);
    }

}
