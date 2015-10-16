package com.juntuanyi.www.shipsetm;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.content.Context;

import java.util.Date;

/**
 * Created by dan on 15-9-30.
 */
public class SqlUtils extends  Object {
    private  Integer shipId ;
    private String logTag ;
    private  DatabaseHelper dbHelper ;
    private SQLiteDatabase sqliteDatabase ;
    private DatabaseHelper databaseHelper ;
    public SqlUtils(Context context,String dbName){
      //  this.logTag =  this.getLocalClassName() + "Log" ;
        this.logTag =  "SqlUtils" + "Log" ;
        databaseHelper = new DatabaseHelper(context,dbName,1);
        sqliteDatabase = databaseHelper.getReadableDatabase();
//        Cursor sqlCursor = sqliteDatabase.rawQuery("select * from shipInfo",null) ;
//        Log.d(logTag, "ShipInfo affect lines -> " + sqlCursor.getCount()) ;
//        while (sqlCursor.moveToNext() ){
//            Log.d(logTag,sqlCursor.getInt(0)+"  "+ sqlCursor.getString(1) +"  "+  sqlCursor.getString(2) + "  "+ sqlCursor.getString(3) +"  "+ sqlCursor.getString(4)) ;
//        }

        Cursor sqlCursor = sqliteDatabase.rawQuery("select * from tankInfo",null) ;
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
    public Integer  queryShipList(ShipInfoList shipInfoList){
        shipInfoList.clearList();
        Cursor cursor = sqliteDatabase.rawQuery("select * from shipInfo",null) ;
        Log.d(logTag, "ShipInfo affect lines -> " + cursor.getCount()) ;
        ShipInfo shipInfo ;
        while (cursor.moveToNext() ){

            Log.d(logTag,cursor.getInt(0)+"  "+ cursor.getString(1) +"  "+  cursor.getString(2) + "  "+ cursor.getString(3) +"  "+ cursor.getString(4)) ;
            shipInfo = new ShipInfo();
            shipInfo.setShipId(cursor.getInt(0));
            shipInfo.setCrt(cursor.getString(1)) ;
            shipInfo.setName(cursor.getString(2));
            shipInfo.setTankNumber(cursor.getInt(3));
            shipInfo.setCapacityNumber(cursor.getInt(4));
            shipInfo.setShipTrimMin(cursor.getFloat(5));
            shipInfo.setShipTrimStep(cursor.getFloat(6));
            shipInfo.setValidDate(new Date(cursor.getInt(7)));
            shipInfo.setCalType(cursor.getInt(8));
            shipInfo.setVersion(cursor.getString(9));

            shipInfoList.appendShipInfo(shipInfo);
        }
        Log.d(logTag,"ships number -> " + shipInfoList.size());
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
