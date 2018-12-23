package com.magicwords.fragments;

import android.support.v7.widget.Toolbar;
import android.view.View;

import com.magicwords.R;

import me.yokeyword.fragmentation.SupportFragment;

public class BaseBackFragment extends SupportFragment {
    protected void initToolbarNav(Toolbar toolbar) {
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(v -> pop());
    }
}
