package com.magicwords.fragments;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.magicwords.R;

import database.MagicwordDbSchema.MagicwordBaseHelper;

import static com.magicwords.db.DatabaseClient.WritableDatabaseHolder.Magicworddb;

public class ListenFragments extends BaseBackFragment {
    private TextView Textview1;
    private String content; //用以显示文本数据
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;


    public static ListenFragments newInstence() {
        return new ListenFragments();
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

        MagicwordBaseHelper dbHelper = new MagicwordBaseHelper(getContext(),"Magicworddb",null,1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("Magicworddb",null,null,null,null,null,null);
        cursor.moveToFirst();
        content= cursor.getString(1)+("\n")+cursor.getString(2)+("\n")+cursor.getString(3)+("\n")+cursor.getString(4);

        Textview1 = (TextView) v.findViewById(R.id.textView);
        Textview1.setText(content);
        button1 = v.findViewById(R.id.button1);
        button2 = v.findViewById(R.id.button2);
        button3 = v.findViewById(R.id.button3);
        button4 = v.findViewById(R.id.button4);
        button3.setVisibility(View.GONE);
        button4.setVisibility(View.GONE);
        //按钮功能（目前仅有跳转）
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
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //再来一句
                int i=0;
                if(i<cursor.getColumnCount() ) {
                    //光标移动成功
                    cursor.moveToNext();
                    content= cursor.getString(1)+("  ")+cursor.getString(2)+("  ")+cursor.getString(3)+("  ")+cursor.getString(4);
                    Textview1.setText(content);
                    //把数据取出
                }
                i++;


            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button4.setVisibility(View.GONE);
                //显示答案
            }
        });
        return v;
    }

    @Override
    public boolean onBackPressedSupport() {
        return super.onBackPressedSupport();
    }
}