package com.example.a19433361_nguyentienlap_ad_tk3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_ChiTietSanPham extends AppCompatActivity {


    int[] hinhs = {R.drawable.ic_launcher_background, R.drawable.ic_launcher_foreground};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_san_pham);

        Bundle bundle = getIntent().getExtras();
        ImageView img = findViewById(R.id.img_ct_hinh);
        TextView txt_ten = findViewById(R.id.txt_ct_ten);
        TextView txt_gia = findViewById(R.id.txt_ct_gia);
        TextView txt_chatLieu = findViewById(R.id.txt_ct_chatLieu);
        TextView txt_trongLuong = findViewById(R.id.txt_ct_trongLuong);
        TextView txt_Mota = findViewById(R.id.txt_ct_moTa);

        int hinhanh = bundle.getInt("hinh");
        String ten = bundle.getString("ten");
        String gia = bundle.getString("gia");
        String chatlieu = bundle.getString("chatL");
        String trongLuong = bundle.getString("trongL");
        String moTa = bundle.getString("moTa");

        img.setImageResource(hinhanh);
        txt_ten.setText(ten);
        txt_gia.setText(gia);
        txt_chatLieu.setText(chatlieu);
        txt_trongLuong.setText(trongLuong);
        txt_Mota.setText(moTa);

    }
}