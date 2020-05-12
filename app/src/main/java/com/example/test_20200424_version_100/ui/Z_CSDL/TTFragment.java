package com.example.test_20200424_version_100.ui.Z_CSDL;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.test_20200424_version_100.R;
import com.example.test_20200424_version_100.ui.Z_CSDL.OnClickItemTab1;

/**
 * A simple {@link Fragment} subclass.
 */
public class TTFragment extends Fragment implements OnClickItemTab1 {


    public TTFragment() {
        // Required empty public constructor
    }
    TextView m2, m3, m4,m5,m6;
    ImageView m1;

    OnClickItemTab1 onClickItemTab1 = (OnClickItemTab1) this;
    public OnClickItemTab1 getOnClickItemTab1() {
        return onClickItemTab1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_we_tt,null);

        m1 = (ImageView) view.findViewById(R.id.imageViewB1);
        m2 = (TextView) view.findViewById(R.id.textViewB2);
        m3 = (TextView) view.findViewById(R.id.textViewB3);
        m4 = (TextView) view.findViewById(R.id.textViewB4);
        m5 = (TextView) view.findViewById(R.id.textViewB5);
        m6 = (TextView) view.findViewById(R.id.textViewB6);


        return view;
    }

    @Override
    public void onClickItem(String image, String name, String code, String kind, String detail, String year) {
        Glide.with(getContext()).load(image).into(m1);
        m2.setText(name);
        m3.setText(code);
        m4.setText(kind);
        m5.setText(detail);
        m6.setText(year);
    }
}
