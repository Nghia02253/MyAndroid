package com.nghia02253.myandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class LoadJSONLanguageActivity extends AppCompatActivity {

    TextView btVN, btEN, tvLanguage;
    String noiDung = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_jsonlanguage);
        anhxa();

        new LoadJSONLanguage().execute("https://khoapham.vn/KhoaPhamTraining/json/tien/demo3.json");

        btVN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoadJSONLanguageOption("vn");
            }
        });
        btEN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoadJSONLanguageOption("en");
            }
        });
    }

    private class LoadJSONLanguage extends AsyncTask<String, Void, String> {
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

            noiDung = s;
            LoadJSONLanguageOption("vn");
        }
    }

    private void LoadJSONLanguageOption(String lang) {
        try {
            JSONObject objectLanguage = new JSONObject(noiDung);
            JSONObject objectLang = objectLanguage.getJSONObject("language");
            JSONObject objectVN = objectLang.getJSONObject(lang);



            String ten = objectVN.getString("name");
            String diaChi = objectVN.getString("address");
            String monHoc1 = objectVN.getString("course1");
            String monHoc2 = objectVN.getString("course2");
            String monHoc3 = objectVN.getString("course3");

            tvLanguage.setText(ten + "\n" + diaChi + "\n" + monHoc1 + "\n" + monHoc2 + "\n" + monHoc3);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void anhxa() {
        btVN = findViewById(R.id.btVn);
        btEN = findViewById(R.id.btEn);
        tvLanguage = findViewById(R.id.tvLanguage);
    }
}
