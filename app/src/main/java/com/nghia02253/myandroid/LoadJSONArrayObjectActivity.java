package com.nghia02253.myandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class LoadJSONArrayObjectActivity extends AppCompatActivity {

    ListView lvArrayObject;
    ArrayList<String> arrayCourse;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_jsonarray_object);

        lvArrayObject = (ListView) findViewById(R.id.lvArrayObject);
        arrayCourse = new ArrayList<>();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayCourse);
        lvArrayObject.setAdapter((ListAdapter) adapter);

        new LoadJSONArrayObject().execute("https://khoapham.vn/KhoaPhamTraining/json/tien/demo4.json");
    }

    private class LoadJSONArrayObject extends AsyncTask<String, Void, String> {
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

                JSONArray array = new JSONArray(s);

                for (int i = 0; i<array.length(); i++) {
                    JSONObject object = array.getJSONObject(i);
                    String khoaHoc = object.getString("khoahoc");
                    String hocPhi = object.getString("hocphi");
                    arrayCourse.add(khoaHoc + " - " + hocPhi);
                }
                adapter.notifyDataSetChanged();

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
