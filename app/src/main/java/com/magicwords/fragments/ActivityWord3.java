package com.magicwords.fragments;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.magicwords.R;
import com.magicwords.model.WordBean;
import com.magicwords.model.WordsLab;

import database.MagicwordDbSchema.MagicwordBaseHelper;

public class ActivityWord3 extends BaseBackFragment {
    private TextView next3;

    private static final String ARG_INDEX = "index";
    private int mIndex;
    private TextView word;
    private TextView yinbiao;
    private TextView lizi;
    private String content;
    private TextView mean;
    public ActivityWord3() {
    }

    public static ActivityWord3 newInstance(int i) {
        ActivityWord3 fragment = new ActivityWord3();
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
        View v = inflater.inflate(R.layout.activity_word3, container, false);

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

        next3 = (TextView) v.findViewById(R.id.next3);
        word=(TextView)v.findViewById(R.id.word3);
        yinbiao=(TextView)v.findViewById(R.id.phonetic3);
        lizi=(TextView)v.findViewById(R.id.sentence3);
        mean=(TextView)v.findViewById(R.id.mean);
        content=wordsLab.get(mIndex).toword();
        word.setText(content);
        content=wordsLab.get(mIndex).toyinbiao();
        yinbiao.setText(content);
        content=wordsLab.get(mIndex).tolizi();
        lizi.setText(content);
        content=wordsLab.get(mIndex).toshili();
        mean.setText(content);

        next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startWithPop(ActivityWord1.newInstance(++mIndex));
            }
        });

        Toolbar toolbar = v.findViewById(R.id.toolbar);
        toolbar.setTitle("单词");
        initToolbarNav(toolbar);

        return v;
    }

    @Override
    public boolean onBackPressedSupport() {
        return super.onBackPressedSupport();
    }
}
