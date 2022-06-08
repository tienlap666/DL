package com.example.sqlitetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class AuthorActivity extends AppCompatActivity {

    DBHelper dbHelper ;
    ArrayList<String> list_string;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = new DBHelper(this);
        ArrayList<Author> list = dbHelper.getAllAuthor();
        GridView grv = findViewById(R.id.grV_author);
        setContentView(R.layout.activity_author);
        EditText ed1 = findViewById(R.id.ed_A1);
        EditText ed2 = findViewById(R.id.ed_A2);
        EditText ed3 = findViewById(R.id.ed_A3);
        EditText ed4 = findViewById(R.id.ed_A4);
        Button btn1 = findViewById(R.id.btnA1);
        Button btn2 = findViewById(R.id.btnA2);
        Button btn3 = findViewById(R.id.btnA3);
        Button btn4 = findViewById(R.id.btnA4);

        for(Author au:list){
            list_string.add(au.getId()+"");
            list_string.add(au.getName());
            list_string.add(au.getAddress());
            list_string.add(au.getEmial());
        }
        adapter = new ArrayAdapter<String>(AuthorActivity.this
                , android.R.layout.simple_list_item_1,list_string);
        grv.setAdapter(adapter);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Author author = new Author();
                author.setId(Integer.parseInt(ed1.getText().toString()));
                author.setName(ed2.getText().toString());
                author.setAddress(ed3.getText().toString());
                author.setEmial(ed4.getText().toString());
                if(dbHelper.InsertAuthor(author)>0){
                    Toast.makeText(AuthorActivity.this, "Lưu thành công!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(AuthorActivity.this, "Lưu thất bại!", Toast.LENGTH_SHORT).show();
            }
        }});
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Author> list = new ArrayList<Author>();
                ArrayList<String> list_string = new ArrayList<>();

                if(ed1.getText().toString().equals("")){
                    list = dbHelper.getAllAuthor();
                }else if(!ed1.getText().toString().equals("")){
                    Author s = dbHelper.getAuthor(Integer.parseInt(ed1.getText().toString()));
                    if(s.getId()==0){
                        Toast.makeText(AuthorActivity.this, "Không tìm thấy Author có id là: "+ed1.getText().toString(), Toast.LENGTH_SHORT).show();
                    }else{
                        list.add(s);
                    }
                }
                for(Author au:list){
                    list_string.add(au.getId()+"");
                    list_string.add(au.getName());
                    list_string.add(au.getAddress());
                    list_string.add(au.getEmial());
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(AuthorActivity.this
                        , android.R.layout.simple_list_item_1,list_string);
                grv.setAdapter(adapter);
            }
        });
    }
}