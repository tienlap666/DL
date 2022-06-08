package com.example.a19433361_nguyentienlap_tk3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {

    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ImageView sanPham = findViewById(R.id.imageView2);
        ImageView mau1 = findViewById(R.id.imageView3);
        ImageView mau2 = findViewById(R.id.imageView4);
        ImageView mau3 = findViewById(R.id.imageView5);
        ImageView mau4 = findViewById(R.id.imageView6);
        Button btnXong = findViewById(R.id.button4);

        mau1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sanPham.setImageResource(R.drawable.den);
                index = R.drawable.den;
            }
        });
        mau2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sanPham.setImageResource(R.drawable.den);
                index = R.drawable.den;
            }
        });
        mau3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sanPham.setImageResource(R.drawable.trang);
                index = R.drawable.trang;
            }
        });
        mau4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sanPham.setImageResource(R.drawable.xanh);
                index = R.drawable.xanh;
            }
        });
        btnXong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("index",index);

            }
        });
    }
}