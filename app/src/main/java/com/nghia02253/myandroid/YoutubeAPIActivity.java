package com.nghia02253.myandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubeAPIActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    String API_YOUTUBE = "AIzaSyB2s1N6ciGv2kNdWLkVefu6Q6enqJBfFlk";
    int REQUEST_VIDEO = 123;

    YouTubePlayerView youTubePlayerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.youtube_api_activity);

        youTubePlayerView = findViewById(R.id.myYoutubeView);
        youTubePlayerView.initialize(API_YOUTUBE, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.cueVideo("9_KZ_tyLA_4");
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if(youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(YoutubeAPIActivity.this, REQUEST_VIDEO);
        }else{
            Toast.makeText(YoutubeAPIActivity.this, "Lỗi play video", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_VIDEO){
            youTubePlayerView.initialize(API_YOUTUBE, YoutubeAPIActivity.this);
        }
    }
}
