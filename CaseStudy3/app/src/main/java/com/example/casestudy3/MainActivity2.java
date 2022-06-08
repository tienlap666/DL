package com.example.casestudy3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        EditText editText_HoTen = findViewById(R.id.editText_HoTen);
        EditText editText_NamSinh = findViewById(R.id.editText_NamSinh);
        Button btn_Submit = findViewById(R.id.btn_Submit);

        btn_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("ht",editText_HoTen.getText().toString());
                intent.putExtra("ns",editText_NamSinh.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }

}