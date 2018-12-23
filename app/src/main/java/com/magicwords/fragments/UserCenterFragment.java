package com.magicwords.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import com.magicwords.R;
import com.magicwords.model.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportFragment;


public class UserCenterFragment extends BaseBackFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "user";

    @BindView(R.id.person_username)
    TextView mUsername;
    @BindView(R.id.person_level)
    TextView mLevel;
    @BindView(R.id.person_intro_content)
    TextView mUserIntro;

    public UserCenterFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment UserCenterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UserCenterFragment newInstance() {
        return new UserCenterFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*if (getArguments() != null) {
        }*/
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_person_page, container, false);
        ButterKnife.bind(this, v);

        /*Toolbar toolbar = v.findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.user_center);*/
        return v;
    }

    @Override
    public boolean onBackPressedSupport() {
        return super.onBackPressedSupport();
    }
}
