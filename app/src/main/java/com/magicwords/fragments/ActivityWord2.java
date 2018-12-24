package com.magicwords.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.magicwords.R;

public class ActivityWord2 extends BaseBackFragment implements View.OnClickListener {
    private TextView depth1;
    private TextView depth2;
    private Intent intent;

    public ActivityWord2(){}

    public static ActivityWord2 newInstance(){
        ActivityWord2 fragment = new ActivityWord2();
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
        View v = inflater.inflate(R.layout.activity_word2, container, false);

        depth1 = (TextView)v.findViewById(R.id.depth2_1);
        depth1.setOnClickListener(this);
        depth2 = (TextView)v.findViewById(R.id.depth2_2);
        depth2.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.depth2_1:
                Toast.makeText(getContext(), "点击depth1", Toast.LENGTH_SHORT).show();
                replaceFragment(ActivityWord3.newInstance(), false);
                break;
            case R.id.depth2_2:
                Toast.makeText(getContext(), "点击depth2", Toast.LENGTH_SHORT).show();
                replaceFragment(ActivityWord3.newInstance(), false);
                break;
        }
    }

    @Override
    public boolean onBackPressedSupport() {
        return super.onBackPressedSupport();
    }
}
