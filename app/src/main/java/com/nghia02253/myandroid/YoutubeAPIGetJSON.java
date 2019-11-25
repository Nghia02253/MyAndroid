package com.nghia02253.myandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class YoutubeAPIGetJSON extends AppCompatActivity {

    String API_KEY = "AIzaSyD8l9_vb07B7gG0w0EvJ3HOSvUtkAbBEo8";
    String API_YOUTUBE = "AIzaSyB2s1N6ciGv2kNdWLkVefu6Q6enqJBfFlk";
    String API_PLAYLIST = "PLcEfrMqfmUUFyLscLFKkZuJCnYSM6HjpY";

    String URL_GETJSON = "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId="+ API_PLAYLIST +"&key="+ API_YOUTUBE +"&maxResults=50";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.youtube_apiget_json_activity);

        GetJsonYoutube(URL_GETJSON);
    }
    private void GetJsonYoutube(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(YoutubeAPIGetJSON.this, response.toString(), Toast.LENGTH_LONG).show();
                        Toast.makeText(YoutubeAPIGetJSON.this, "OMG", Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(YoutubeAPIGetJSON.this, "Lỗi !", Toast.LENGTH_LONG).show();
                    }
                });
    }
}
