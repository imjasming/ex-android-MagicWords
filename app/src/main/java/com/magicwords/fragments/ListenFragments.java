package com.magicwords.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.magicwords.R;
import com.magicwords.model.User;

import me.yokeyword.fragmentation.SupportFragment;

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
        Textview1 = (TextView) v.findViewById(R.id.textView);
        content = "gogogo";   //test
        Textview1.setText(content);


        button1 = v.findViewById(R.id.button1);
        button2 = v.findViewById(R.id.button2);
        button3 = v.findViewById(R.id.button3);
        button4 = v.findViewById(R.id.button4);
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
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //再来一句
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
