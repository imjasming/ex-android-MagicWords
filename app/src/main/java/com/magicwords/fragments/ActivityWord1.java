package com.magicwords.fragments;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.magicwords.R;
import com.magicwords.model.WordBean;
import com.magicwords.model.WordsLab;

import java.io.IOException;

import database.MagicwordDbSchema.MagicwordBaseHelper;

public class ActivityWord1 extends BaseBackFragment implements View.OnClickListener {
    private TextView depth1;
    private TextView depth2;
    private TextView depth3;
    private Intent intent;
    private ImageView listen1;
    private MediaPlayer mediaPlayer;
    private TextView word1;
    private String content;
    private TextView yinbiao;
    private TextView lizi;

    private static final String ARG_INDEX = "index";

    private int mInt=0;

    public ActivityWord1() {
    }

    public static ActivityWord1 newInstance(int i) {
        ActivityWord1 fragment = new ActivityWord1();
        Bundle args = new Bundle();
        args.putInt(ARG_INDEX, i);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mInt = getArguments().getInt(ARG_INDEX);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_word1, container, false);
        yinbiao=(TextView) v.findViewById(R.id.phonetic1);
        lizi=(TextView) v.findViewById(R.id.sentence1);

        WordsLab wordsLab = WordsLab.getInstance();
        if (wordsLab.getLen() <= 0) {
            MagicwordBaseHelper dbHelper = new MagicwordBaseHelper(getContext(), "Magicworddb", null, 1);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            Cursor cursor = db.query("Magicworddb", null, null, null, null, null, null);
            cursor.moveToFirst();

            for (int i = 0; i < cursor.getColumnCount(); i++) {
                wordsLab.add(new WordBean(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4)));

                cursor.moveToNext();
            }
            cursor.close();
        }
        content = wordsLab.get(mInt).toString();



        listen1 = (ImageView) v.findViewById(R.id.listen1);
        listen1.setOnClickListener(this);
        depth1 = (TextView) v.findViewById(R.id.depth1_1);
        depth1.setOnClickListener(this);
        depth2 = (TextView) v.findViewById(R.id.depth1_2);
        depth2.setOnClickListener(this);
        depth3 = (TextView) v.findViewById(R.id.depth1_3);
        depth3.setOnClickListener(this);

        word1 = (TextView) v.findViewById(R.id.word1);
        content = word1.getText().toString();
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource("http://192.168.78.1:8080/ad/accelerate.mp3");
        } catch (IOException e) {
            Toast.makeText(getContext(), "url is false", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
//        mediaPlayer = MediaPlayer.create(ActivityWord1.this,Uri.parse("http://192.168.78.1:8080/ad/accelerate.mp3"));

        return v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.depth1_1:
                Toast.makeText(getContext(), "点击depth1", Toast.LENGTH_SHORT).show();
                replaceFragment(ActivityWord2.newInstance(mInt), false);
                break;
            case R.id.depth1_2:
                Toast.makeText(getContext(), "点击depth2", Toast.LENGTH_SHORT).show();
                replaceFragment(ActivityWord2.newInstance(mInt), false);
                break;
            case R.id.depth1_3:
                Toast.makeText(getContext(), "点击depth3", Toast.LENGTH_SHORT).show();
                replaceFragment(ActivityWord2.newInstance(mInt), false);
                break;
            case R.id.listen1:
                Toast.makeText(getContext(), "listening", Toast.LENGTH_SHORT).show();
                try {
                    if (mediaPlayer != null) {
                        mediaPlayer.start();
                        Toast.makeText(getContext(), "播放", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), "资源加载错误", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(getContext(), "play false", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }

    @Override
    public boolean onBackPressedSupport() {
        return super.onBackPressedSupport();
    }
}
