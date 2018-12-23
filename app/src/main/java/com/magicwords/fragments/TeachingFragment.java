package com.magicwords.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.magicwords.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.yokeyword.fragmentation.ISupportFragment;
import me.yokeyword.fragmentation.SupportFragment;

public class TeachingFragment extends BaseBackFragment {
    @BindView(R.id.video_movie)
    VideoView videoView;
    @BindView(R.id.btn_movie_1)
    Button movie_1;
    @BindView(R.id.btn_movie_2)
    Button movie_2;
    @BindView(R.id.btn_movie_3)
    Button movie_3;

    private String get_package_name;
    private MediaController mediaController;
    public TeachingFragment() {
        // Required empty public constructor
    }

    public static TeachingFragment newInstance() {
        return new TeachingFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void init() {
        String uri = "android.resource://" + get_package_name + "/" + R.raw.mv;
        videoView.setVideoURI(Uri.parse(uri));
        videoView.setMediaController(mediaController);
        mediaController.setMediaPlayer(videoView);
        videoView.requestFocus();
        videoView.start();
}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_teaching, container, false);
        ButterKnife.bind(this, v);
        mediaController = new MediaController(v.getContext());
        get_package_name = v.getContext().getPackageName();
        return v;
    }

    @OnClick({R.id.btn_movie_1, R.id.btn_movie_2, R.id.btn_movie_3})
    public void onClick(View v) {
        final ISupportFragment topFragment = getTopFragment();
        SupportFragment teaching = (SupportFragment) topFragment;
        switch (v.getId()) {
            case R.id.btn_movie_1:
                init();
                break;
        }
    }
    @Override
    public boolean onBackPressedSupport() {
        return super.onBackPressedSupport();
    }


}
