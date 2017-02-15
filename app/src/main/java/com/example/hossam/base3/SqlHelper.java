package com.example.hossam.base3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Hossam on 8/22/2016.
 */
public class SqlHelper extends SQLiteOpenHelper {

    public static final String name="unity.db";
    public static final int version=1;

    public SqlHelper(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if NOT EXISTS google(id INTEGER primary key,name TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("Drop table if EXISTS google");
        onCreate(db);
    }


    public void insert(String name)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name", name);
        db.insert("google", null, cv);
    }

    public ArrayList select()
    {
        ArrayList arrayList=new ArrayList();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from google",null);
        res.moveToFirst();
        while (res.isAfterLast()==false) {
            arrayList.add(res.getString(res.getColumnIndex("id"))+":"+res.getString(res.getColumnIndex("name")));
            res.moveToNext();
        }
        return arrayList;
    }
    public void delete(Integer id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("delete from google where id="+Integer.toString(id));
    }

    public void update(String name,Integer id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("update google set name='"+name+"'where id="+Integer.toString(id));
    }
    public Cursor selectGeographic_Area() {
        SQLiteDatabase db=this.getReadableDatabase();
        String sql="Select * from google";

        return db.rawQuery(sql, null);
    }

}
