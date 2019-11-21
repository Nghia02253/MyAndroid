package com.nghia02253.myandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MediaAudioActivity extends AppCompatActivity {
    Button btnPlayMediaVideo, btnPrevAudio, btnPlayAudio, btnStopAudio, btnNextAudio, btnPlayOnline, btnPlayVideoOnline;
    VideoView vdPlayMedia;
    TextView tvTimePlayMedia, tvTimePlayTotal, tvNameMedia;
    SeekBar sbPlayAudio;

    MediaPlayer mediaPlayer;
    ArrayList<ListMedia> listMedia;
    int position = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_audio);

        init();
        addMedia();
        initMediaPlayer();

        setTotalMedia();

        btnPrevAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                position--;
                if(position < 0) {
                    position = listMedia.size() - 1;
                }
                initMediaPlayer();
                setTotalMedia();
                mediaPlayer.start();
                btnPlayAudio.setText("Pause");
            }
        });
        btnPlayAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    btnPlayAudio.setText("Play");
                }else{
                    mediaPlayer.start();
                    btnPlayAudio.setText("Pause");
                }
                updateTimeMedia();
            }
        });
        btnStopAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                mediaPlayer.release();
                btnPlayAudio.setText("Play");
                initMediaPlayer();
            }
        });
        btnNextAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
                position++;
                if(position > (listMedia.size() - 1)) {
                    position = 0;
                }
                initMediaPlayer();
                setTotalMedia();
                mediaPlayer.start();
                btnPlayAudio.setText("Pause");
                updateTimeMedia();
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

        btnPlayVideoOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri url = Uri.parse("https://khoapham.vn/download/vuoncaovietnam.mp4");
                vdPlayMedia.setVideoURI(url);
                vdPlayMedia.setMediaController(new MediaController(MediaAudioActivity.this));
                vdPlayMedia.start();
            }
        });
        btnPlayOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://khoapham.vn/download/vietnamoi.mp3";

                MediaPlayer mediaPlayer = new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    mediaPlayer.setDataSource(url);
                    mediaPlayer.prepareAsync();
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            mp.start();
                            SimpleDateFormat dinhDangGio = new SimpleDateFormat("mm:ss");
                            tvTimePlayTotal.setText(dinhDangGio.format(mp.getDuration()));
                            sbPlayAudio.setMax(mp.getDuration());
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    private  void setTotalMedia() {
        SimpleDateFormat dinhDangGio = new SimpleDateFormat("mm:ss");
        tvTimePlayTotal.setText(dinhDangGio.format(mediaPlayer.getDuration()));
        sbPlayAudio.setMax(mediaPlayer.getDuration());
    }

    private void initMediaPlayer(){
        mediaPlayer = MediaPlayer.create(MediaAudioActivity.this, listMedia.get(position).getUrlFile());
        tvNameMedia.setText("" + listMedia.get(position).getNameMedia());
    }
    private void updateTimeMedia() {
        final Handler handler = new Handler();
        handler.postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        SimpleDateFormat dinhDangGio = new SimpleDateFormat("mm:ss");
                        tvTimePlayMedia.setText(dinhDangGio.format(mediaPlayer.getCurrentPosition()));
                        sbPlayAudio.setProgress(mediaPlayer.getCurrentPosition());

                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                if(mediaPlayer.isPlaying()) {
                                    mediaPlayer.stop();
                                }
                                position++;
                                if(position > (listMedia.size() - 1)) {
                                    position = 0;
                                }
                                initMediaPlayer();
                                setTotalMedia();
                                mediaPlayer.start();
                                btnPlayAudio.setText("Pause");
                                updateTimeMedia();
                            }
                        });
                        handler.postDelayed(this, 500);
                    }
                }
        , 100);
    }
    private void addMedia() {
        listMedia = new ArrayList<>();
        listMedia.add(new ListMedia("ring_tone", R.raw.ring_tone));
        listMedia.add(new ListMedia("ring_tone 2", R.raw.ring_tone));
    }

    private void init() {
        tvTimePlayMedia = findViewById(R.id.tvTimePlayMedia);
        tvTimePlayTotal = findViewById(R.id.tvTimePlayTotal);
        tvNameMedia = findViewById(R.id.tvNameMedia);
        btnPlayAudio = (Button) findViewById(R.id.btnPlayAudio);
        btnPrevAudio = findViewById(R.id.btnPrevAudio);
        btnStopAudio = findViewById(R.id.btnStopAudio);
        btnNextAudio = findViewById(R.id.btnNextAudio);
        btnPlayMediaVideo = findViewById(R.id.btnPlayMediaVideo);
        btnPlayVideoOnline = findViewById(R.id.btnPlayVideoOnline);
        btnPlayOnline = findViewById(R.id.btnPlayOnline);
        vdPlayMedia = findViewById(R.id.vdPlayMedia);
        sbPlayAudio = findViewById(R.id.sbPlayAudio);
    }
}
