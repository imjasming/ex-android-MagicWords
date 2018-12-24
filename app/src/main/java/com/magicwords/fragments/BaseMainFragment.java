package com.magicwords.fragments;


import android.content.Context;
import android.support.v7.widget.Toolbar;

import com.magicwords.R;

import me.yokeyword.fragmentation.SupportFragment;


/**
 * Created by YoKeyword on 16/2/3.
 */
public class BaseMainFragment extends SupportFragment {

    protected OnFragmentOpenDrawerListener mOnFragmentOpenDrawerListener;

    protected void initToolbarNav(Toolbar toolbar) {
        initToolbarNav(toolbar, false);
    }

    protected void initToolbarNav(Toolbar toolbar, boolean isHome) {
        toolbar.setNavigationIcon(R.drawable.ic_menu_white_24dp);
        toolbar.setNavigationOnClickListener(v -> {
            if (mOnFragmentOpenDrawerListener != null) {
                mOnFragmentOpenDrawerListener.onOpenDrawer();
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentOpenDrawerListener) {
            mOnFragmentOpenDrawerListener = (OnFragmentOpenDrawerListener) context;
        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentOpenDrawerListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mOnFragmentOpenDrawerListener = null;
    }

    public interface OnFragmentOpenDrawerListener {
        void onOpenDrawer();
    }
}