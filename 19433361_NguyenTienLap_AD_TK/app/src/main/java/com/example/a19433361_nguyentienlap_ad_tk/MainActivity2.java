package com.example.a19433361_nguyentienlap_ad_tk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    int manghinhbai[]={
            R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,
            R.drawable.c6,R.drawable.c7,R.drawable.c8,R.drawable.c9,R.drawable.c10,
            R.drawable.cj,R.drawable.cq,R.drawable.ck,
            R.drawable.d1,R.drawable.d2,R.drawable.d3,R.drawable.d4,R.drawable.d5,
            R.drawable.d6,R.drawable.d7,R.drawable.d8,R.drawable.d9,R.drawable.d10,
            R.drawable.dj,R.drawable.dq,R.drawable.dk,
            R.drawable.h1,R.drawable.h2,R.drawable.h3,R.drawable.h4,R.drawable.h5,
            R.drawable.h6,R.drawable.h7,R.drawable.h8,R.drawable.h9,R.drawable.h10,
            R.drawable.hj,R.drawable.hq,R.drawable.hk,
            R.drawable.s1,R.drawable.s2,R.drawable.s3,R.drawable.s4,R.drawable.s5,
            R.drawable.s6,R.drawable.s7,R.drawable.s8,R.drawable.s9,R.drawable.s10,
            R.drawable.sj,R.drawable.sq,R.drawable.sk};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ImageView imgV1 = findViewById(R.id.La_1);
        ImageView imgV2 = findViewById(R.id.La_2);
        ImageView imgV3 = findViewById(R.id.La_3);
        ImageView imgV4 = findViewById(R.id.La_4);
        ImageView imgV5 = findViewById(R.id.La_5);
        ImageView imgV6 = findViewById(R.id.La_6);

        TextView tVKetQua1 = findViewById(R.id.ketQua);
        TextView tVKetQua2 = findViewById(R.id.ketQua2);
        TextView tVKetQua3 = findViewById(R.id.Dem);
        Button btnLayBai = findViewById(R.id.rutBai);

        btnLayBai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int[] sauLaBai = lay6LaNgauNhien(0,51);
                imgV1.setImageResource(manghinhbai[sauLaBai[0]]);
                imgV2.setImageResource(manghinhbai[sauLaBai[1]]);
                imgV3.setImageResource(manghinhbai[sauLaBai[2]]);
                imgV4.setImageResource(manghinhbai[sauLaBai[3]]);
                imgV5.setImageResource(manghinhbai[sauLaBai[4]]);
                imgV6.setImageResource(manghinhbai[sauLaBai[5]]);
                int[] N1 = {sauLaBai[0],sauLaBai[1],sauLaBai[2]};
                int[] N2 = {sauLaBai[3],sauLaBai[4],sauLaBai[5]};
                tVKetQua1.setText(tinhKetQua(N1));
                tVKetQua2.setText(tinhKetQua(N2));
                tVKetQua3.setText(tinhKetQua2(N1,N2));

            }
        });

    }
    private String tinhKetQua2(int[] arr,int[] arr2 ){
        String ketQua = "";
        if(tinhSoTay(arr)==3 && tinhSoTay(arr2)==3)
            ketQua="Hòa";
        else if (tinhSoTay(arr)==3)
            ketQua = "Ngườii thắng";
        else if (tinhSoTay(arr2)==3)
            ketQua = "Máy thắng";
        else if(tinhSoNut(arr)>tinhSoNut(arr2))
            ketQua="Người thắng";
        else if(tinhSoNut(arr)<tinhSoNut(arr2))
            ketQua="Máy thắng";
        else if(tinhSoNut(arr)==tinhSoNut(arr2))
            ketQua="Hòa";
        return ketQua;
    }

    private String tinhKetQua(int arr[]){
        String ketQua = "";
        if (tinhSoTay(arr) == 3)
            ketQua = "Kết quả 3 tây";
        else {
            int tong = 0;
            for (int i = 0;i<arr.length;i++)
                if(arr[1]%13 <10)
                    tong = arr[i]%13 +1;
            if (tong %10 ==0)
                ketQua="Kết qur bù, số tây là"+tinhSoTay(arr);
            else
                ketQua = "Kết quả là" + (tong % 10) +"nút, số tây là"+tinhSoTay(arr);
        }
        return ketQua;
    }
    private int tinhSoNut(int[] arr){
        int tong = 0;
        for (int i = 0;i<arr.length;i++)
            if(arr[1]%13 <10)
                tong = arr[i]%13 +1;
            return tong;
    }
    private int tinhSoTay(int[] arr){
        int k = 0;
        for (int i = 0 ; i < arr.length; i ++)
            if (arr[i]%13 >= 10 && arr[i]%13<13)
                k++;
            return k;
    }
    private int[] lay6LaNgauNhien(int min,int max){
        int[] sauLa = new int[6];
        int i = 0;
        sauLa[i++]=random(min,max);
        do {
            int k = random(min,max);
            if (!kiemTraTrung(k,sauLa))
                sauLa[i++]=k;
        }while (i<6);
        return sauLa;
    }
    private Boolean kiemTraTrung(int k,int[] arr){
        for (int i = 0;i<arr.length;i++)
            if (arr[i]==k)
                return  true;
        return false;
    }
    private int random(int min,int max){
        return min + (int)(Math.random()*((max-min)+1));
    }
}