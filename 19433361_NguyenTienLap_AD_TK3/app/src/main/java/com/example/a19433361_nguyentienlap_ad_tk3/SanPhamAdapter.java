package com.example.a19433361_nguyentienlap_ad_tk3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SanPhamAdapter extends BaseAdapter {
    private Context context;

    private ArrayList<SanPham> sanPhams;

    public SanPhamAdapter(Context context, ArrayList<SanPham> sanPhams) {
        this.context = context;
        this.sanPhams = sanPhams;
    }

    @Override
    public int getCount() {
        return sanPhams.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


//    private class ViewHolder{
//        ImageView img;
//        TextView txtTen;
//        TextView txtGia;
//
//    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
//        ViewHolder viewHolder;
//        if (view == null){
//            viewHolder = new ViewHolder();
//            LayoutInflater inflater = ((LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE));
//            view = inflater.inflate(layout,null);
//            viewHolder.img = view.findViewById(R.id.img_i_hinhSP);
//            viewHolder.txtTen = view.findViewById(R.id.txt_i_TenSP);
//            viewHolder.txtGia = view.findViewById(R.id.txt_i_GiaSP);
//            view.setTag(viewHolder);
//        }else {
//            viewHolder = (ViewHolder) view.getTag();
//        }
//        SanPham sanPham = sanPhams.get(i);
//
//        viewHolder.img.setImageResource(sanPham.getHinh());
//        viewHolder.txtTen.setText(sanPham.getTen());
//        viewHolder.txtGia.setText(sanPham.getGia());
//
//        return view;






        LayoutInflater inflater = ((LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE));
        view = inflater.inflate(R.layout.item_sanpham,null);
        ImageView img = view.findViewById(R.id.img_i_hinhSP);
        TextView txt_Ten = view.findViewById(R.id.txt_i_TenSP);
        TextView txt_Gia = view.findViewById(R.id.txt_i_GiaSP);

        SanPham sanPham = sanPhams.get(i);

        img.setImageResource(sanPham.getHinh());
        txt_Ten.setText(sanPham.getTen());
        txt_Gia.setText(sanPham.getGia());
        return  view;
    }
}
