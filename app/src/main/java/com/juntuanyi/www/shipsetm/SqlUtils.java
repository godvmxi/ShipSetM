package com.juntuanyi.www.shipsetm;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.content.Context;

/**
 * Created by dan on 15-9-30.
 */
public class SqlUtils extends  Object {
    private  Integer shipId ;
    private String logTag ;
    private  DatabaseHelper dbHelper ;
    public SqlUtils(Context context,String dbName){
      //  this.logTag =  this.getLocalClassName() + "Log" ;
        this.logTag =  "SqlUtils" + "Log" ;
        DatabaseHelper database = new DatabaseHelper(context,dbName,1);
        SQLiteDatabase sqliteDatabase = database.getReadableDatabase();
        Cursor sqlCursor = sqliteDatabase.rawQuery("select * from shipInfo",null) ;
        Log.d(logTag, "ShipInfo affect lines -> " + sqlCursor.getCount()) ;
        while (sqlCursor.moveToNext() ){
            Log.d(logTag,sqlCursor.getInt(0)+"  "+ sqlCursor.getString(1) +"  "+  sqlCursor.getString(2) + "  "+ sqlCursor.getString(3) +"  "+ sqlCursor.getString(4)) ;
        }

        sqlCursor = sqliteDatabase.rawQuery("select * from tankInfo",null) ;
        Log.d(logTag,"TankInfo affect lines????? -> "+ sqlCursor.getCount()) ;
        TankInfo tankInfo = new TankInfo(1);
        for (int i = 0; i < 2 ;i++ ){
            sqlCursor.moveToNext() ;
//            Log.d(logTag,sqlCursor.getString(0)+"  "+ sqlCursor.getString(1) +"  "+ sqlCursor.getString(2)   ) ;


            tankInfo.tankId = sqlCursor.getInt(1) ;
            tankInfo.valueType =  sqlCursor.getInt(2);
            tankInfo.sounding =  sqlCursor.getInt(2);
            tankInfo.strResult =  sqlCursor.getString(3);
            Log.d(logTag,tankInfo.toString());

        }
    }
    public Integer  queryShipList(){
        Integer shipList[] = {1,2,3,5};
        return 1 ;
    }
    public Boolean queryTankInfo(TankInfo tankInfo){
        return true ;
    }

    public Integer getShipId() {
        return shipId;
    }

    public void setShipId(Integer shipId) {
        this.shipId = shipId;
    }
}
