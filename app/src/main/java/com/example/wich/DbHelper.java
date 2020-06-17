package com.example.wich;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "mycontacts.db";
    private static final int DB_VERSION = 1;

    public static final String REV1 = "title";
    public static final String REV2 = "review";



    public DbHelper(Context context) {
        super(context, DB_NAME,null,DB_VERSION);
    }

    // 테이블 생성
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "create table contacts(_ID INTEGER primary key autoincrement, " + REV1 + "TEXT," + REV2 + " TEXT);";
        db.execSQL(createTable);
    }

    //테이블 리셋
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion ){
        db.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(db);
    }
}
