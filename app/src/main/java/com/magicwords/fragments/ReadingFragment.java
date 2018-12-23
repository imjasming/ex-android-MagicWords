package com.magicwords.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;

import com.magicwords.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ReadingFragment extends BaseBackFragment {

    @BindView(R.id.passage_title)
    TextView title;
    @BindView(R.id.passage_content)
    TextView content;
    @BindView(R.id.btn_translation_next)
    Button next_translate;

    private boolean is_next;
    public ReadingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ReadingFragment.
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_reading, container, false);
        ButterKnife.bind(this, v);

        Toolbar toolbar = v.findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.read);
        initToolbarNav(toolbar);
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
            next_translate.setText("next passage");
        }
        else {
            is_next=false;
            next_translate.setText("translate it");
        }
    }

}
