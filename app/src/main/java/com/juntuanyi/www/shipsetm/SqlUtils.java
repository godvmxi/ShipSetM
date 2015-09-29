package com.juntuanyi.www.shipsetm;

import android.content.ContentValues;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteQuery;
import android.util.Log;
import android.database.sqlite.SQLiteOpenHelper ;


/**
 * Created by dan on 15-9-29.
 */
public class SqlUtils extends SQLiteOpenHelper {
    private static final String DB_NAME = "mydata.db"; //数据库名称
    private static final int version = 1; //数据库版本

    public SqlUtils(Context context) {
        super(context, DB_NAME, null, version);
        // TODO Auto-generated constructor stub
        Log.d("SqlteUilts","on constructon");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("SqlteUilts","onUpgrade");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + "test" + " (" + "id"
                + " INTEGER primary key autoincrement, " + "name" + " text, "+ "author" +" text);";
        db.execSQL(sql);
        Log.d("SqlteUilts","onCreate");
    }


}
