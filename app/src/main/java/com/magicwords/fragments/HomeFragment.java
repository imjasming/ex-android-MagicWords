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
import android.widget.ImageView;

import com.magicwords.R;
import com.magicwords.model.User;
import com.zhengsr.viewpagerlib.callback.PageHelperListener;
import com.zhengsr.viewpagerlib.indicator.ZoomIndicator;
import com.zhengsr.viewpagerlib.view.ArcImageView;
import com.zhengsr.viewpagerlib.view.BannerViewPager;
import com.zhengsr.viewpagerlib.bean.PageBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.yokeyword.fragmentation.ISupportFragment;
import me.yokeyword.fragmentation.SupportFragment;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends SupportFragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_USER = "user";
    private static final String ARG_PARAM2 = "param2";

    private String mParamUser;
    private String mParam2;

    @BindView(R.id.home_banner)
    BannerViewPager mBanner;
    @BindView(R.id.home_banner_zoom_indicator)
    ZoomIndicator mZoomIndicator;
    @BindView(R.id.home_btn_word)
    Button mBtnWord;
    @BindView(R.id.home_btn_say)
    Button mBtnSay;
    @BindView(R.id.home_btn_read)
    Button mBtnRead;
    @BindView(R.id.home_btn_listen)
    Button mBtnListen;

    private ArrayList<Integer> mImgRes = new ArrayList<>();

    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * @return A new instance of fragment HomeFragment.
     */
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        //args.putSerializable(ARG_USER, user);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParamUser = getArguments().getString(ARG_USER);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, v);

        initBanner();
        return v;
    }

    @Override
    public boolean onBackPressedSupport() {
        return super.onBackPressedSupport();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @OnClick({R.id.home_btn_listen, R.id.home_btn_read, R.id.home_btn_word, R.id.home_btn_say,})
    public void onClick(View v) {
        final ISupportFragment topFragment = getTopFragment();
        SupportFragment home = (SupportFragment) topFragment;

        switch (v.getId()) {
            case R.id.home_btn_listen:
                home.start(ListenFragments.newInstence(), SupportFragment.SINGLETASK);
                break;
        }
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private void initBanner() {
        mImgRes.add(R.mipmap.img_3);
        mImgRes.add(R.mipmap.img_2);

        PageBean bean = new PageBean.Builder<Integer>()
                .setDataObjects(mImgRes)
                .setIndicator(mZoomIndicator)
                .builder();

        mBanner.setPageListener(bean, R.layout.home_banner_layout, (PageHelperListener<Integer>) (view, data) -> {
            ImageView imageView = view.findViewById(R.id.arc_icon);
            imageView.setImageResource(data);
        });
    }
}
