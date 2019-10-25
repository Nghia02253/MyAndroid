package com.nghia02253.myandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

import java.text.SimpleDateFormat;

public class MediaAudioActivity extends AppCompatActivity {
    Button btnPlayMedia, btnPlayMediaVideo;
    VideoView vdPlayMedia;
    TextView tvTimePlayTotal;
    SeekBar sbPlayAudio;

    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_audio);

        tvTimePlayTotal = findViewById(R.id.tvTimePlayTotal);
        btnPlayMedia = (Button) findViewById(R.id.btnPlayMedia);
        btnPlayMediaVideo = findViewById(R.id.btnPlayMediaVideo);
        vdPlayMedia = findViewById(R.id.vdPlayMedia);
        sbPlayAudio = findViewById(R.id.sbPlayAudio);

        mediaPlayer = MediaPlayer.create(MediaAudioActivity.this, R.raw.ring_tone);
        setTotalMedia();

        btnPlayMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
            }
        });

        sbPlayAudio.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(sbPlayAudio.getProgress());
            }
        });

        btnPlayMediaVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vdPlayMedia.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.intro_video));
                vdPlayMedia.start();

                MediaController mediaController = new MediaController(MediaAudioActivity.this);
                mediaController.setMediaPlayer(vdPlayMedia);
                vdPlayMedia.setMediaController(mediaController);

            }
        });
    }

    private  void setTotalMedia() {
        SimpleDateFormat dinhDangGio = new SimpleDateFormat("mm:ss");
        tvTimePlayTotal.setText(dinhDangGio.format(mediaPlayer.getDuration()));
        sbPlayAudio.setMax(mediaPlayer.getDuration());
    }
}
