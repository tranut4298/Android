package com.example.test_20200424_version_100.Class;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test_20200424_version_100.R;

import java.util.ArrayList;

public class RecyclerView_Adapter extends  RecyclerView.Adapter<RecyclerView_Adapter.ViewHodler>{

    Context context;
    ArrayList<Model_BB> model_bbs;
    int layout;
    //RequestOptions options;


    public RecyclerView_Adapter(Context context, int layout,ArrayList<Model_BB> model_bbs) {
        this.context = context;
        this.model_bbs = model_bbs;
        this.layout = layout;
        // Request option for Glide
        //options = new RequestOptions().centerCrop().placeholder(R.drawable.ic_shadow).error(R.drawable.ic_shadow);
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.i_dong_item, parent, false);
        return new ViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHodler holder, int position) {
        holder.txtName.setText(model_bbs.get(position).getName());
        holder.txtCode.setText(model_bbs.get(position).getCode());
        holder.txtYear.setText(model_bbs.get(position).getYear());
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
                                Toast.makeText(context, "Sửa Thành Công", Toast.LENGTH_SHORT).show();
                                holder.imgMenuPopup.setImageResource(R.drawable.ic_more_vert);
                                break;
                            case R.id.menuDelete:
                                Toast.makeText(context, "Xóa Thành Công", Toast.LENGTH_SHORT).show();
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
        //holder.image.setImageResource(model_bbs.get(position).getImage());
        //Load Image from Internet and set it into ImageView using Glide
        //Glide.with(context).load(model_bbs.get(position).getImage()).apply(options).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return model_bbs.size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder {

        TextView txtCode, txtName, txtYear;
        ImageView image,imgMenuPopup;
        public ViewHodler(@NonNull View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.textViewA2);
            txtCode = (TextView) itemView.findViewById(R.id.textViewA3);
            txtYear = (TextView) itemView.findViewById(R.id.textViewA4);
            image = (ImageView) itemView.findViewById(R.id.imageViewA1);
            imgMenuPopup = (ImageView) itemView.findViewById(R.id.more_vert);
        }
    }
}
