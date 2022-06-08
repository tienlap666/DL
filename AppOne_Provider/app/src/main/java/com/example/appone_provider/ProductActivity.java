package com.example.appone_provider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {

    static final String uri = "content://com.example.appone_provider";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        EditText ed_Id = findViewById(R.id.ed_A1);
        EditText ed_Name = findViewById(R.id.ed_A2);
        EditText ed_Unit = findViewById(R.id.ed_A3);
        EditText ed_Madein = findViewById(R.id.ed_A4);
        GridView gv_display = findViewById(R.id.grV_Product);

        Button btn_Select = findViewById(R.id.btnA1);
        Button btn_Save = findViewById(R.id.btnA2);
        Button btn_Delete = findViewById(R.id.btnA3);
        Button btn_Update = findViewById(R.id.btnA4);

        btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues values = new ContentValues();
                values.put("id",ed_Id.getText().toString());
                values.put("name",ed_Name.getText().toString());
                values.put("unit",ed_Unit.getText().toString());
                values.put("madein",ed_Madein.getText().toString());

                Uri product = Uri.parse(uri);
                Uri insert_uri = getContentResolver().insert(product,values);
                Toast.makeText(getApplicationContext(),"Save completed",Toast.LENGTH_SHORT).show();
            }
        });
        btn_Select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> String_list = new ArrayList<>();
                Uri product = Uri.parse(uri);
                Cursor cursor = getContentResolver().query(product,null,null,null,"name");
                if (cursor!= null){
                    cursor.moveToFirst();
                    do {
                        String_list.add(cursor.getInt(0)+"");
                        String_list.add(cursor.getString(1));
                        String_list.add(cursor.getString(2));
                        String_list.add(cursor.getString(3));

                    }while (cursor.moveToNext());
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(ProductActivity.this,
                            android.R.layout.simple_list_item_1,String_list);
                    gv_display.setAdapter(adapter);
                }else
                    Toast.makeText(getApplicationContext(),"Select failed",Toast.LENGTH_SHORT).show();
            }
        });

    }
}