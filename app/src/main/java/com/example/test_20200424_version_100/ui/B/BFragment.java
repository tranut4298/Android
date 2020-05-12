package com.example.test_20200424_version_100.ui.B;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.test_20200424_version_100.Class.ListView_Adapter;
import com.example.test_20200424_version_100.Class.Model_BB;
import com.example.test_20200424_version_100.Class.PagerView_Adapter;
import com.example.test_20200424_version_100.R;
import com.example.test_20200424_version_100.ui.Z_CSDL.CameraFragment;
import com.example.test_20200424_version_100.ui.Z_CSDL.DSFragment;
import com.example.test_20200424_version_100.ui.Z_CSDL.TTFragment;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BFragment extends Fragment {


    public BFragment() {
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
        adapter.add(cameraFragment,"Quét BB");
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
