package com.nghia02253.myandroid;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoadRssDetailActivity extends AppCompatActivity {

    WebView wvRssDetail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_rss_detail);

        wvRssDetail = findViewById(R.id.wvRssDetail);

        Intent intent = getIntent();
        String link = intent.getStringExtra("dataTieuDe");

        wvRssDetail.loadUrl(link);
        wvRssDetail.setWebViewClient(new WebViewClient());

    }
}
