package com.example.hossam.base3;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void insert(View v)
    {
        EditText txt1=(EditText)findViewById(R.id.editText);
        ListView l=(ListView)findViewById(R.id.listView);
        SqlHelper db=new SqlHelper(this);
        db.insert(txt1.getText().toString());
        a=db.select();
        l.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, a));
    }
    public void delete(View v) {
        EditText txt1=(EditText)findViewById(R.id.editText2);
        ListView l=(ListView)findViewById(R.id.listView);
        SqlHelper db=new SqlHelper(this);
        db.delete(Integer.parseInt(txt1.getText().toString()));
        //a=db.selectGeographic_Area()
        a=db.select();
        l.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, a));

    }
    public void update(View v) {
        EditText txt1=(EditText)findViewById(R.id.editText);
        EditText txt2=(EditText)findViewById(R.id.editText2);
        ListView l=(ListView)findViewById(R.id.listView);
        SqlHelper db=new SqlHelper(this);
        db.update(txt1.getText().toString(),Integer.parseInt(txt2.getText().toString()));
        a=db.select();
        l.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, a));


    }


}
