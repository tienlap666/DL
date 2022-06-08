package com.example.casestud4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView txtKQ ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_GiaiPT = findViewById(R.id.btn_GPT);
        Button btn_GiaiPTB1 = findViewById(R.id.btn_GPTB1);
        txtKQ = findViewById(R.id.txt_KQ);

        btn_GiaiPT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivityForResult(intent,9898);
            }
        });
        btn_GiaiPTB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MainActivity3.class);
                startActivityForResult(intent,9899);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 9898 && requestCode == RESULT_OK){
            String getdata = data.getStringExtra("nghiem").toString();
            String kq="";
            kq += getdata;
            txtKQ.setText(kq);
        }
        if (requestCode == 9899 && requestCode == RESULT_OK){
            String getdata = data.getStringExtra("nghiem").toString();
            String kq="";
            kq += getdata;
            txtKQ.setText(kq);
        }
    }
}