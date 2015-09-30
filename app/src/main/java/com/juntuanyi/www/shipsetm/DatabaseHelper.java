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
public class DatabaseHelper extends SQLiteOpenHelper {


    public DatabaseHelper(Context context) {
        super(context, "demo", null, 1);
        // TODO Auto-generated constructor stub
        Log.d("SqlteUilts","on constructon");
    }

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {

        super(context, name, null, version);

    }
    public DatabaseHelper(Context context, String name, int version) {
        super(context, name, null, version);
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
