package com.magicwords.fragments;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
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

import database.MagicwordDbSchema.MagicwordBaseHelper;

public class ActivityWord2 extends BaseBackFragment implements View.OnClickListener {
    private TextView depth1;
    private TextView depth2;
    private String content;
    private TextView word;
    private TextView yinbiao;
    private TextView lizi;
    private ImageView listen2;
    private MediaPlayer mediaPlayer;

    private static final String ARG_INDEX = "index";

    private int mIndex;

    public ActivityWord2(){}

    public static ActivityWord2 newInstance(int i){
        ActivityWord2 fragment = new ActivityWord2();
        Bundle args = new Bundle();
        args.putInt(ARG_INDEX, i);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mIndex = getArguments().getInt(ARG_INDEX);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_word2, container, false);

        depth1 = (TextView)v.findViewById(R.id.depth2_1);
        depth1.setOnClickListener(this);
        depth2 = (TextView)v.findViewById(R.id.depth2_2);
        depth2.setOnClickListener(this);
        word=(TextView)v.findViewById(R.id.word2);
        yinbiao=(TextView)v.findViewById(R.id.phonetic2);
        lizi=(TextView)v.findViewById(R.id.sentence2);
        listen2 = (ImageView)v.findViewById(R.id.listen2);
        listen2.setOnClickListener(this);

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

        content=wordsLab.get(mIndex).toword();
        word.setText(content);

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


        content=wordsLab.get(mIndex).toyinbiao();
        yinbiao.setText(content);
        content=wordsLab.get(mIndex).tolizi();
        lizi.setText(content);

        Toolbar toolbar = v.findViewById(R.id.toolbar);
        toolbar.setTitle("单词");
        initToolbarNav(toolbar);

        return v;
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.depth2_1:
                mIndex++;
                startWithPop(ActivityWord1.newInstance(mIndex));
                break;
            case R.id.depth2_2:
                startWithPop(ActivityWord3.newInstance(mIndex));break;
            case R.id.listen2:
//            Toast.makeText(getContext(), "listening", Toast.LENGTH_SHORT).show();
            try {
                if (mediaPlayer != null) {
                    mediaPlayer.start();
//                    Toast.makeText(getContext(), "播放", Toast.LENGTH_SHORT).show();
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
