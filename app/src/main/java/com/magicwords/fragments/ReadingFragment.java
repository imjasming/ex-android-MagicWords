package com.magicwords.fragments;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;

import com.magicwords.R;
import com.magicwords.model.StenceBean;
import com.magicwords.model.StenceLab;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import database.MagicwordDbSchema.MagicreadBaseHelper;
import database.MagicwordDbSchema.MagicstenceBaseHelper;


public class ReadingFragment extends BaseBackFragment {

    @BindView(R.id.passage_title)
    TextView title;
    @BindView(R.id.passage_content)
    TextView content;
    @BindView(R.id.btn_translation_next)
    Button next_translate;
    int mInt=0;
    String content1;
    private boolean is_next;
    StenceLab wordsLab = StenceLab.getInstance();


    public ReadingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return a new instance of fragment ReadingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ReadingFragment newInstance() {
        return new ReadingFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_reading, container, false);
        ButterKnife.bind(this, v);

        Toolbar toolbar = v.findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.read);
        initToolbarNav(toolbar);
        if (wordsLab.getLen() <= 0) {
            MagicreadBaseHelper dbHelper = new MagicreadBaseHelper(getContext(), "Magicworddb3", null, 1);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            Cursor cursor = db.query("Magicreaddb", null, null, null, null, null, null);
            cursor.moveToFirst();

            for (int i = 0; i < cursor.getColumnCount(); i++) {
                wordsLab.add(new StenceBean(cursor.getInt(0), cursor.getString(1),cursor.getString(2)));
                cursor.moveToNext();
            }
            cursor.close();
        }



        content1=wordsLab.get(mInt).toString1();
        content.setText(content1);


        return v;
    }

    @Override
    public boolean onBackPressedSupport() {
        return super.onBackPressedSupport();
    }

    @OnClick(R.id.btn_translation_next)
    public void onClick(View v) {
        if(is_next==false){
            is_next=true;
            content1=wordsLab.get(mInt).toString2();
            content.setText(content1);
            next_translate.setText("next passage");
        }
        else {
            is_next=false;
            content1=wordsLab.get(++mInt).toString1();
            content.setText(content1);
            next_translate.setText("translate it");
        }
    }

}