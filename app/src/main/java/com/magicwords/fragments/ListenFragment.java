package com.magicwords.fragments;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.magicwords.R;
import com.magicwords.MainActivity;
import com.magicwords.model.StenceBean;
import com.magicwords.model.StenceLab;
import com.magicwords.model.WordBean;
import com.magicwords.model.WordsLab;

import database.MagicwordDbSchema.MagicstenceBaseHelper;
import database.MagicwordDbSchema.MagicwordBaseHelper;

import static com.magicwords.db.DatabaseClient.WritableDatabaseHolder.Magicworddb;

public class ListenFragment extends BaseBackFragment {
    private TextView Textview1;
    private TextView Textview3;
    private String content=""; //用以显示文本数据
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private TextInputEditText input;
    private TextInputLayout layout;
    private ImageButton listen;

    private int mInt = 0;


    public static ListenFragment newInstence() {
        return new ListenFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_listen, container, false);
        Textview1 = (TextView) v.findViewById(R.id.textView);
        Textview3= (TextView) v.findViewById(R.id.textView3);

/*        WordsLab wordsLab = WordsLab.getInstance();
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
        content = wordsLab.get(mInt).toString();*/

        StenceLab wordsLab = StenceLab.getInstance();
        if (wordsLab.getLen() <= 0) {
            MagicstenceBaseHelper dbHelper = new MagicstenceBaseHelper(getContext(), "Magicworddb1", null, 1);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            Cursor cursor = db.query("Magicsentencedb", null, null, null, null, null, null);
            cursor.moveToFirst();

            for (int i = 0; i < cursor.getColumnCount(); i++) {
                wordsLab.add(new StenceBean(cursor.getInt(0), cursor.getString(1),cursor.getString(2)));
                cursor.moveToNext();
            }
            cursor.close();
        }
        button1 = v.findViewById(R.id.button1);
        button2 = v.findViewById(R.id.button2);
        button3 = v.findViewById(R.id.button3);
        button4 = v.findViewById(R.id.button4);
        button3.setVisibility(View.GONE);
        button4.setVisibility(View.GONE);
        input=v.findViewById(R.id.listen_edt);
        Textview3=v.findViewById(R.id.textView3);
        input.setVisibility(View.GONE);
        layout=v.findViewById(R.id.listen_input);
        listen=v.findViewById(R.id.listen);


        Textview1.setText(content);
        //按钮功能（目前仅有跳转）
        listen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //播放听力


            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //重放听力


            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setVisibility(View.GONE);
                button2.setVisibility(View.GONE);
                button3.setVisibility(View.VISIBLE);
                button4.setVisibility(View.VISIBLE);
                input.setVisibility(View.VISIBLE);
                layout.setVisibility(View.VISIBLE);
                content = wordsLab.get(mInt).toString1();
                Textview1.setText(content);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //再来一句
                /*if (i < cursor.getColumnCount()) {
                    //光标移动成功
                    cursor.moveToNext();
                    content = cursor.getString(1) + ("  ") + cursor.getString(2) + ("  ") + cursor.getString(3) + ("  ") + cursor.getString(4);
                    Textview1.setText(content);
                    //把数据取出
                }*/
                button1.setVisibility(View.VISIBLE);
                button2.setVisibility(View.VISIBLE);
                button3.setVisibility(View.GONE);
                button4.setVisibility(View.GONE);
                layout.setVisibility(View.INVISIBLE);
                Textview3.setVisibility(View.INVISIBLE);
                content = "";
                mInt++;
                Textview1.setText(content);

            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button4.setVisibility(View.GONE);
                //显示答案
                content=wordsLab.get(mInt).toString2();
                Textview3.setText(content);
                content="";
            }
        });

        Toolbar toolbar = v.findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.listen);
        initToolbarNav(toolbar);

        return v;
    }

    @Override
    public boolean onBackPressedSupport() {
        return super.onBackPressedSupport();
    }
}