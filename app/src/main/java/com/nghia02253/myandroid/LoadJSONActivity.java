package com.nghia02253.myandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class LoadJSONActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_json);

        // Demo1: new LoadJSON().execute("https://khoapham.vn/KhoaPhamTraining/json/tien/demo2.json");
        new LoadJSON().execute("https://khoapham.vn/KhoaPhamTraining/json/tien/demo2.json");
    }

    private class LoadJSON extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            StringBuilder content = new StringBuilder();

            try {
                URL url = new URL(strings[0]);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));

                String line = "";

                while ((line = bufferedReader.readLine()) != null) {
                    content.append(line);
                }
                bufferedReader.close();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return content.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {
                JSONObject objectJson = new JSONObject(s);
                //Demo 1
                //String monHoc = objectJson.getString("monhoc");
                //Demo 2 Array in Object
                JSONArray danhSach = objectJson.getJSONArray("danhsach");
                String khoaHocGroup = "";
                for(int i = 0; i < danhSach.length(); i++) {
                    JSONObject objectKH = danhSach.getJSONObject(i);
                    String khoaHoc = objectKH.getString("khoahoc");
                    khoaHocGroup += khoaHoc + "\n";
                    Toast.makeText(LoadJSONActivity.this, khoaHocGroup, Toast.LENGTH_LONG).show();
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
