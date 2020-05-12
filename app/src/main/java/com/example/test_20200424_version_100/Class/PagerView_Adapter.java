package com.example.test_20200424_version_100.Class;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class PagerView_Adapter extends FragmentPagerAdapter {
    ArrayList<Fragment> frmlist = new ArrayList<>();
    ArrayList<String> title     = new ArrayList<>();

    public PagerView_Adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return  frmlist.get(position);
    }

    @Override
    public int getCount() {
        return frmlist.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }

    public  void add(Fragment frm, String til){
        frmlist.add(frm);
        title.add(til);
    }
}
