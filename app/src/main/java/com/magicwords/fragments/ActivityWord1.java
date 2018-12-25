package com.magicwords.fragments;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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
        listen1 = (ImageView) v.findViewById(R.id.listen1);
        listen1.setOnClickListener(this);
        depth1 = (TextView) v.findViewById(R.id.depth1_1);
        depth1.setOnClickListener(this);
        depth2 = (TextView) v.findViewById(R.id.depth1_2);
        depth2.setOnClickListener(this);
        depth3 = (TextView) v.findViewById(R.id.depth1_3);
        depth3.setOnClickListener(this);
        word1 = (TextView) v.findViewById(R.id.word1);

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
        content = wordsLab.get(mInt).toword();
        word1.setText(content);
        switch (content){
            case "A":
                mediaPlayer = MediaPlayer.create(getContext(),R.raw.a);
                break;
            case "abdominal":
                mediaPlayer = MediaPlayer.create(getContext(),R.raw.abdominal);
                break;
            case "across":
                mediaPlayer = MediaPlayer.create(getContext(),R.raw.across);
                break;
            case "bored":
                mediaPlayer = MediaPlayer.create(getContext(),R.raw.bored);
                break;
            case "boring":
                mediaPlayer = MediaPlayer.create(getContext(),R.raw.boring);
                break;
            case "born":
                mediaPlayer = MediaPlayer.create(getContext(),R.raw.born);
                break;
            default:
                break;
        }
        
        content= wordsLab.get(mInt).toyinbiao();
        yinbiao.setText(content);
        
        

        Toolbar toolbar = v.findViewById(R.id.toolbar);
        toolbar.setTitle("单词");
        initToolbarNav(toolbar);

        return v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.depth1_1:
                mInt++;
                startWithPop(ActivityWord1.newInstance(mInt));
                break;
            case R.id.depth1_2:

                startWithPop(ActivityWord2.newInstance(mInt));
                break;
            case R.id.depth1_3:

                startWithPop(ActivityWord3.newInstance(mInt));
                break;
            case R.id.listen1:
//                Toast.makeText(getContext(), "listening", Toast.LENGTH_SHORT).show();
                try {
                    if (mediaPlayer != null) {
                        mediaPlayer.start();
//                        Toast.makeText(getContext(), "播放", Toast.LENGTH_SHORT).show();
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
