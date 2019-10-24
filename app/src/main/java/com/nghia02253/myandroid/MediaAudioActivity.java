package com.nghia02253.myandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MediaAudioActivity extends AppCompatActivity {
    Button btnPlayMedia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_audio);

        btnPlayMedia = findViewById(R.id.btnPlayMedia);

        btnPlayMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mediaPlayer = MediaPlayer.create(MediaAudioActivity.this, R.raw.sao_em_vo_tinh);
                mediaPlayer.start();
            }
        });
    }
}
