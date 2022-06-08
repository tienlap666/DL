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

public class BookActivity extends AppCompatActivity {
    DBHelper dbHelper ;
    ArrayAdapter<String> adapter;
    ArrayList<Book> list;
    ArrayList<String> list_string;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        dbHelper = new DBHelper(this);
        GridView grv = findViewById(R.id.grV_book);
        EditText ed1 = findViewById(R.id.ed1);
        EditText ed2 = findViewById(R.id.ed2);
        EditText ed3 = findViewById(R.id.ed3);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);

        list = dbHelper.getAllBook();

        for(Book au:list){
            list_string.add(au.getId()+"");
            list_string.add(au.getTitle());
            list_string.add(au.getId_author()+"");
        }
        adapter = new ArrayAdapter<String>(BookActivity.this
                , android.R.layout.simple_list_item_1,list_string);
        grv.setAdapter(adapter);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book = new Book();
                book.setId(Integer.parseInt(ed1.getText().toString()));
                book.setTitle(ed2.getText().toString());
                book.setId_author(Integer.parseInt(ed3.getText().toString()));
                if(dbHelper.InsertBook(book)>0){
                    Toast.makeText(BookActivity.this, "Lưu thành công!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(BookActivity.this, "Lưu thất bại!", Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(BookActivity.this, "Không tìm thấy Author có id là: "+ed1.getText().toString(), Toast.LENGTH_SHORT).show();
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
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(BookActivity.this
                        , android.R.layout.simple_list_item_1,list_string);
                grv.setAdapter(adapter);
            }
        });
    }
}