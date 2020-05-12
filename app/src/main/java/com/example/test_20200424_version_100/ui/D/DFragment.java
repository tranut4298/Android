package com.example.test_20200424_version_100.ui.D;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.test_20200424_version_100.Class.PagerView_Adapter;
import com.example.test_20200424_version_100.MainActivity.MainActivity;
import com.example.test_20200424_version_100.R;
import com.example.test_20200424_version_100.ui.Z_CSDL.DSFragment;
import com.example.test_20200424_version_100.ui.Z_CSDL.OnClickItemTab1;
import com.example.test_20200424_version_100.ui.Z_CSDL.TTFragment;
import com.google.android.material.tabs.TabLayout;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class DFragment extends Fragment {


    public DFragment() {
        // Required empty public constructor
    }

    ImageView imageViewD1, imageViewD2, imageViewD3;
    Button btnD4;
    int REQUEST_CODE_CAMERA = 123;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_d,null);

        imageViewD1 = (ImageView) view.findViewById(R.id.imageViewD1);
        imageViewD2 = (ImageView) view.findViewById(R.id.imageViewD2);
        imageViewD3 = (ImageView) view.findViewById(R.id.imageViewD3);

        imageViewD3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentCompat.requestPermissions(getContext(),
                        new String[]{Manifest.permission.CAMERA},REQUEST_CODE_CAMERA);
            }
        });

        return view;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_CODE_CAMERA && grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,REQUEST_CODE_CAMERA);
        }else{
            Toast.makeText(getContext(), "Bạn Không Cấp Phép Truy Cập Camera!", Toast.LENGTH_SHORT).show();
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    //---Kiem tra dieu kien
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == REQUEST_CODE_CAMERA && resultCode == RESULT_OK && data != null){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageViewD1.setImageBitmap(bitmap);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
