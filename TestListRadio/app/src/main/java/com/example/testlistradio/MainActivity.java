package com.example.testlistradio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Integer[] values = new Integer[] {1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,};

        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, R.layout.row, R.id.textview, values) {

            int selectedPosition = 0;

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v = convertView;
                if (v == null) {
                    LayoutInflater vi = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    v = vi.inflate(R.layout.row, null);
                    RadioButton r = (RadioButton)v.findViewById(R.id.radiobutton);
                }
                TextView tv = (TextView)v.findViewById(R.id.textview);
                tv.setText("Text view #" + position);
                RadioButton r = (RadioButton)v.findViewById(R.id.radiobutton);
                r.setChecked(position == selectedPosition);
                r.setTag(position);
                r.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        selectedPosition = (Integer)view.getTag();
                        notifyDataSetChanged();
                    }
                });
                return v;
            }

        };
        setListAdapter(adapter);

        

    }
}