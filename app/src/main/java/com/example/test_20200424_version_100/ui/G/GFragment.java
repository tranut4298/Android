package com.example.test_20200424_version_100.ui.G;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.test_20200424_version_100.Class.PagerView_Adapter;
import com.example.test_20200424_version_100.R;
import com.example.test_20200424_version_100.ui.Z_CSDL.DSFragment;
import com.example.test_20200424_version_100.ui.Z_CSDL.OnClickItemTab1;
import com.example.test_20200424_version_100.ui.Z_CSDL.TTFragment;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class GFragment extends Fragment {


    public GFragment() {
        // Required empty public constructor
    }

    ViewPager viewPagerD;
    TabLayout tabLayoutD;
    DSFragment dsFragment;
    TTFragment ttFragment;
    OnClickItemTab1 onClickItemTab1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_g,null);
        return view;
    }
}
