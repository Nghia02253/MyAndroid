package com.nghia02253.myandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class DatabaseActivity extends AppCompatActivity {

    Database database;
    TextView tvGetData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        tvGetData = findViewById(R.id.tvGetData);

        //tạo database GhiChu
        database = new Database(this, "ghichu.sqlite", null, 1);
        //tạo bảng CongViec
        database.QueryData("CREATE TABLE IF NOT EXISTS CongViec(Id INTEGER PRIMARY KEY AUTOINCREMENT, TenCongViec VARCHAR(200))");
        //insert data
        //database.QueryData("INSERT INTO CongViec VALUES(null, 'Lập trình Android')");
        //database.QueryData("DELETE FROM CongViec WHERE Id = 3");
        //Get data
        Cursor dataCongViec = database.GetData("SELECT * FROM ListUser ORDER BY CreatedDate DESC");
        if(dataCongViec != null) {
            while (dataCongViec.moveToNext()) {
                String ten = dataCongViec.getString(3);
                tvGetData.append(ten + "\n");
            }
        }
    }
}
