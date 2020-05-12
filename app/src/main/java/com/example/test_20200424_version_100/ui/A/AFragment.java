package com.example.test_20200424_version_100.ui.A;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.test_20200424_version_100.Class.PagerView_Adapter;
import com.example.test_20200424_version_100.R;
import com.example.test_20200424_version_100.ui.B.BFragment;
import com.example.test_20200424_version_100.ui.C.CFragment;
import com.example.test_20200424_version_100.ui.D.DFragment;
import com.example.test_20200424_version_100.ui.Z_CSDL.CameraFragment;
import com.example.test_20200424_version_100.ui.Z_CSDL.DSFragment;
import com.example.test_20200424_version_100.ui.Z_CSDL.OnClickItemTab1;
import com.example.test_20200424_version_100.ui.Z_CSDL.TTFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends Fragment {


    public AFragment() {
        // Required empty public constructor
    }

    ViewPager viewPagerD;
    TabLayout tabLayoutD;
    DSFragment dsFragment;
    TTFragment ttFragment;
    CameraFragment cameraFragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_a,null);
        AnhXa(view);
        dsFragment.setOnClickItemTab1(ttFragment.getOnClickItemTab1());

        addTab(viewPagerD);
        tabLayoutD.setupWithViewPager(viewPagerD);
        return view;
    }

    private void addTab(ViewPager viewPagerD) {
        PagerView_Adapter adapter = new PagerView_Adapter(getChildFragmentManager());
        adapter.add(dsFragment,"Danh Sách");
        adapter.add(ttFragment,"Thông Tin");
        //adapter.add(cameraFragment,"Quét BB");
        viewPagerD.setAdapter(adapter);
    }

    private void AnhXa(View view) {
        viewPagerD      = (ViewPager) view.findViewById(R.id.viewpagerD);
        tabLayoutD      = (TabLayout) view.findViewById(R.id.tabD);
        dsFragment      = new DSFragment();
        ttFragment      = new TTFragment();
        cameraFragment  = new CameraFragment();

    }
}
