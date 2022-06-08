package com.example.casestudy3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TextView txtKQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtKQ = findViewById(R.id.txt);
        Button btn_Nhap = findViewById(R.id.btn_NhapThongTin);

        btn_Nhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivityForResult(intent,9999);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 9999 && requestCode == RESULT_OK){
            String hoTen = data.getStringExtra("ht").toString();
            String namSinh = data.getStringExtra("ns").toString();
            Calendar calendar = Calendar.getInstance();
            int yearNow = calendar.get(Calendar.YEAR);
            int namSinh1 = Integer.parseInt(namSinh);
            String st = "";
            st += "HO Va Ten: "+ hoTen;
            st += "Nam SInh: "+ namSinh;
            st += "Tuoi: "+(yearNow - namSinh1);
            txtKQ.setText(st);
        }
    }
}