package com.nghia02253.myandroid;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class ResetPass  extends Activity {
    Button btnPopupMenu;
    EditText tvDate, editTextTime;
    TextView tvData, tvObjectData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reset_pass);

        btnPopupMenu = (Button) findViewById(R.id.btnPopupMenu);
        tvDate = (EditText) findViewById(R.id.editTextDate);
        editTextTime = (EditText) findViewById(R.id.editTextTime);
        tvData = (TextView) findViewById(R.id.tvData);
        tvObjectData = (TextView) findViewById(R.id.tvObjectData);

        btnPopupMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowPopupMenu();
            }
        });
        Log.d("AAA","onCreate ResetPass");

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("dataGroup");

        //Get data bundle
        String[] arrayDataBundle = bundle.getStringArray("arrayData");
        ListUser objectBundle = (ListUser) bundle.getSerializable("objectData");

        int duLieu = intent.getIntExtra("dulieu", 2020);
        if (bundle != null) {
            ListUser listUser = (ListUser) intent.getSerializableExtra("objectData");
            tvObjectData.setText("Thơi gian: "+ objectBundle.getTvTime()+ "\n Noi dung: " + objectBundle.getTvTitle() + "\n" + arrayDataBundle[0]);
        }

        String[] arrayData = intent.getStringArrayExtra("arrayData");
        btnPopupMenu.setText(""+duLieu);
        tvData.setText("Số phần tử mảng là: "+arrayData.length + " - Phần tử thứ 2 là: " + arrayData[1]);



        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChonNgay();
            }
        });

        editTextTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChonGio();
            }
        });
    }

    @Override
    protected void onStart() {
        Log.d("AAA","onStart ResetPass");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        Log.d("AAA","onRestart ResetPass");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.d("AAA","onResume ResetPass");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("AAA","onPause ResetPass");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("AAA","onStop ResetPass");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("AAA","onDestroy ResetPass");
        super.onDestroy();
    }

    private void ShowPopupMenu() {
        PopupMenu popupMenu = new PopupMenu(this, btnPopupMenu);
        popupMenu.getMenuInflater().inflate(R.menu.menu_user, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menuSearch:
                        btnPopupMenu.setText("Search");
                        break;
                    case R.id.menuSetting:
                        btnPopupMenu.setText("Settings");
                        break;
                    case R.id.menuShare:
                        btnPopupMenu.setText("Share");
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_user, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //menu

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuSearch:
                Toast.makeText(this, "Menu Search", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuSetting:
                Toast.makeText(this, "Menu Setting", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuShare:
                Toast.makeText(this, "Menu Share", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    private void ChonNgay() {
        final Calendar calendar = Calendar.getInstance();
        final Calendar calendar2 = Calendar.getInstance();
        int ngay = calendar.get(Calendar.DATE);
        int thang = calendar.get(Calendar.MONTH);
        int nam = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                //i:Năm i1: tháng i2: ngày
                calendar.set(i, i1, i2);
                calendar2.set(2019,9, 15); //15/10/2019
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                tvDate.setText(simpleDateFormat.format(calendar.getTime()));
                int DemNgay = (int) ((calendar.getTimeInMillis() - calendar2.getTimeInMillis()) / (1000*60*60*24));
                btnPopupMenu.setText("Số ngày đến hiện tại: " + DemNgay);
            }
        }, nam, thang, ngay);
        datePickerDialog.show();
    }
    private void ChonGio() {
        final Calendar calendar = Calendar.getInstance();
        int gio = calendar.get(Calendar.HOUR_OF_DAY);
        int phut = calendar.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                calendar.set(0,0,0, i, i1);
                editTextTime.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, gio, phut, true);
        timePickerDialog.show();
    }
}
