package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextA = findViewById(R.id.editest_soA);
        EditText editTextB = findViewById(R.id.editest_soB);
        Button butonT = findViewById(R.id.button_Tong);
        TextView Kq = findViewById(R.id.Ketqua);


    }
}