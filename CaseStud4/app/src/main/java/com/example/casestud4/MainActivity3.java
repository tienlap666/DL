package com.example.casestud4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        EditText editText_SoA = findViewById(R.id.edt_soA1);
        EditText editText_SoB = findViewById(R.id.edt_soB1);
        Button btn_Submit = findViewById(R.id.btn_Submit1);


        btn_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int soA = Integer.parseInt(editText_SoA.getText().toString());
                int soB = Integer.parseInt(editText_SoB.getText().toString());

                GPTB1 hai = new GPTB1(soA,soB);

                Intent intent = new Intent();
                intent.putExtra("nghiem",hai.NPT());
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}