package com.magicwords.fragments;

import android.content.Intent;
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

public class ActivityWord3 extends BaseBackFragment {
    private TextView next3;

    public ActivityWord3() {
    }

    public static ActivityWord3 newInstance() {
        ActivityWord3 fragment = new ActivityWord3();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_word3, container, false);

        next3 = (TextView) v.findViewById(R.id.next3);
        next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startWithPop(ActivityWord1.newInstance());
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
