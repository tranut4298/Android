package com.example.test_20200424_version_100.Class;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.test_20200424_version_100.R;
import com.example.test_20200424_version_100.ui.Z_CSDL.OnClickItemTab1;

import java.util.ArrayList;
import java.util.List;

public class ListView_Adapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Model_BB> model_bbs;
    RequestOptions options;
    OnClickItemTab1 onClickItemTab1;

    public ListView_Adapter(Context context, int layout, List<Model_BB> model_bbs) {
        this.context = context;
        this.layout = layout;
        this.model_bbs = model_bbs;
        // Request option for Glide
        options = new RequestOptions().centerCrop().placeholder(R.drawable.new_shadow).error(R.mipmap.ic_launcher);
    }

    public ListView_Adapter(Context context, int layout, List<Model_BB> model_bbs, OnClickItemTab1 onClickItemTab1) {
        this.context = context;
        this.layout = layout;
        this.model_bbs = model_bbs;
        this.onClickItemTab1 = onClickItemTab1;
        // Request option for Glide
        options = new RequestOptions().centerCrop().placeholder(R.drawable.new_shadow).error(R.mipmap.ic_launcher);
    }

    @Override
    public int getCount() {
        return model_bbs.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder extends Fragment {
        TextView txtCode, txtName, txtYear;
        ImageView imgMenuPopup,image;
        RelativeLayout rl;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView  = inflater.inflate(layout, null);
            holder.txtName      = (TextView) convertView.findViewById(R.id.textViewA2);
            holder.txtYear      = (TextView) convertView.findViewById(R.id.textViewA4);
            holder.txtCode      = (TextView) convertView.findViewById(R.id.textViewA3);
            holder.image        = (ImageView) convertView.findViewById(R.id.imageViewA1);
            holder.rl           =(RelativeLayout) convertView.findViewById(R.id.dong_item);
            holder.imgMenuPopup = (ImageView) convertView.findViewById(R.id.more_vert);
            convertView.setTag(holder);
        }else{
            holder = (ListView_Adapter.ViewHolder) convertView.getTag();
        }

        final Model_BB sinhVien = model_bbs.get(position);
        holder.txtName.setText(sinhVien.getName());
        holder.txtYear.setText("Năm: " + sinhVien.getYear());
        holder.txtCode.setText("Số hiệu: " + sinhVien.getCode());

        holder.imgMenuPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.imgMenuPopup.setImageResource(R.drawable.ic_more_horiz);
                PopupMenu popupMenu = new PopupMenu(context,holder.imgMenuPopup );
                popupMenu.getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu()); //tra ve menu
                //--Bat su kien
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.menuEdit:
                                holder.imgMenuPopup.setImageResource(R.drawable.ic_more_vert);
                                Toast.makeText(context, "Sửa Thành Công", Toast.LENGTH_SHORT).show();

                                break;
                            case R.id.menuDelete:
                                XacNhanXoa(position);
                                break;
                            case R.id.menuCancle:
                                Toast.makeText(context, "Đã Hủy", Toast.LENGTH_SHORT).show();
                                holder.imgMenuPopup.setImageResource(R.drawable.ic_more_vert);
                                break;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });

        //holder.image.setImageResource(sinhVien.getImage()); //--img(int)
        //Load Image from Internet and set it into ImageView using Glide
        Glide.with(context).load(sinhVien.getImage()).apply(options).into(holder.image);//--img(string)

        holder.rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, sinhVien.getName(), Toast.LENGTH_SHORT).show();
                onClickItemTab1.onClickItem(sinhVien.getImage(),"Tiêu Đề: " + sinhVien.getName(),
                        "- Số Hiệu: " + sinhVien.getCode(), "- Phân Loại: "+ sinhVien.getKind(),
                        "- Nội Dung: " + sinhVien.getDetail(), "- Năm: " + sinhVien.getYear());
            }
        });
        return convertView;
    }

    private  void  XacNhanXoa(final int position){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setTitle("Thông Báo!");
        alertDialog.setIcon(R.mipmap.ic_launcher);
        alertDialog.setMessage("Bạn có chắc muốn xóa "+ model_bbs.get(position).getName() + " không?");

        alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "Xóa Thành Công", Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        alertDialog.show();
    }

    public void filterList(ArrayList<Model_BB> filteredList){
        model_bbs = filteredList;
        notifyDataSetChanged();
    }
}
