package com.example.hossam.base3;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;

import java.util.ArrayList;

/**
 * Created by Hossam on 8/22/2016.
 */
public class StudentProvider extends ContentProvider {

    MainActivity a;
    ArrayList<String> x=a.a;
    String d=x.get(student),f=x.get(studentid);

    static final String providername="com.example.google.search";
    static final String URL="content://"+providername+"/student";
    static final Uri Content=Uri.parse(URL);

    static final int student=1;
    static final int studentid=2;

    static final UriMatcher urimatch;
    static {

        urimatch=new UriMatcher(UriMatcher.NO_MATCH);
        urimatch.addURI(providername,"student",student);
        urimatch.addURI(providername,"student/#",studentid);

    }




    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {

        switch (urimatch.match(uri))
        {
            case student:
                return "vnd.android.cursor.dir/vnd.example.students";

            case studentid:
                return "vnd.android.cursor.item/vnd.example.students";

            default:throw new IllegalArgumentException("Unsupported url : " +uri);
        }

    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
