package com.magicwords.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.magicwords.R;

public class TeachingActivity extends AppCompatActivity {


    private VideoView videoView;
    private MediaController mediaController;
    private Button movie_1;
    private Button movie_2;
    private Button movie_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_teaching);
        initView();
    }

    private void initView() {
        videoView= (VideoView) findViewById(R.id.video_movie);
        movie_1 = findViewById(R.id.btn_movie_1);
        movie_2 = findViewById(R.id.btn_movie_2);
        movie_3 = findViewById(R.id.btn_movie_3);
        movie_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    init();
            }
        });
        movie_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                init();
            }
        });
        movie_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                init();
            }
        });
    }

    private void init() {
        videoView = (VideoView) findViewById(R.id.video_movie);
        mediaController = new MediaController(this);
        String uri = "android.resource://" + getPackageName() + "/" + R.raw.mv;
        videoView.setVideoURI(Uri.parse(uri));
        videoView.setMediaController(mediaController);
        mediaController.setMediaPlayer(videoView);
        videoView.requestFocus();
        videoView.start();
    }

}
