package com.example.taekwhunchung.finalsmc;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPreviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_preview);

        Intent intent = getIntent();
        String stringURL = intent.getStringExtra("url");

        VideoView videoView = findViewById(R.id.previewVideoView);

        try {
            MediaController mediacontroller = new MediaController(VideoPreviewActivity.this);
            mediacontroller.setAnchorView(videoView);
            // Get the URL from String VideoURL
            Uri video = Uri.parse(stringURL);
            videoView.setMediaController(mediacontroller);
            videoView.setVideoURI(video);
            videoView.start();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
