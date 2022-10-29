package com.example.whatsbuy.Repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "BancoApp2";
    private static final Integer DB_VERSION = 2;

    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String stm = "create table users (id INTEGER PRIMARY KEY, name TEXT,\n" +
                "     userLogin TEXT, password TEXT);";
        sqLiteDatabase.execSQL(stm);
        stm = "create table posts (id INTEGER PRIMARY KEY, userId INTEGER, titlename TEXT,\n" +
                "     body TEXT);";
        sqLiteDatabase.execSQL(stm);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Log.d("dbhelper", "onUpgrade: oldVersion:"+oldVersion+"  new:"+newVersion);
        if (oldVersion == 1) {
            String stm = "create table posts (id INTEGER PRIMARY KEY, userId INTEGER, titlename TEXT,\n" +
                    "     body TEXT);";
            sqLiteDatabase.execSQL(stm);
        }
    }
}
