package com.juntuanyi.www.shipsetm;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;



public class MainActivity extends Activity {
    private String logTag ;
    private TankView tankView1;
    private TankView tankView2;
    private DatabaseHelper sqlUtils;
    private TankViewEvent tankViewEvent = null ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.logTag =  this.getLocalClassName() + "Log" ;


        setContentView(R.layout.activity_main);
        tankViewEvent = new TankViewEvent() {
            @Override
            public void onSoundingChanged(TankInfo info) {
                Log.d(logTag, "event-> " + info.toString());
                Log.d(logTag, "callback-> " + info.ref.toString() );
            }
        };
        TankInfo.soundingMax = 9999;
        TankInfo.soundingMin = 0;
        TankInfo.shipId = 1001;
        tankView1 = (TankView) findViewById(R.id.tankView1);

        tankView1.setInfo(new TankInfo( 1));
        tankView1.setTankViewEvent(tankViewEvent);
        tankView2 = (TankView) findViewById(R.id.tankView2);
        tankView2.setInfo(new TankInfo( 2));
        tankView2.setTankViewEvent(tankViewEvent);


//        db.execSql("Create table help");

        Context context = this;
//        File dbFile =  context.getDatabasePath("demo.db");
//        Log.d(logTag,"---> "+dbFile.getAbsolutePath());


        String filesDir =  context.getFilesDir().getAbsolutePath() ;
        Log.d(logTag,"file dir-> "+filesDir.toString());
        String baseDataDir = filesDir.replaceAll("files","") ;
        String databasesDir = baseDataDir + "/databases" ;
        String demoDbFileName = databasesDir + "/demo.db3" ;
        Log.d(logTag,"database dir-> "+demoDbFileName);
        Log.d(logTag,"files dir-> "+filesDir);
        Log.d(logTag,"base dir-> "+baseDataDir);

        if ( !(new File(databasesDir)).exists()  ) {
            (new File(databasesDir)).mkdir() ;
        }
//        else {
//            Log.d(logTag,"no need to create databases dir");
//        }






        if(!( new File(demoDbFileName) ).exists() ){ //no demo db file ,copy
            Resources resources  = this.getResources();
            InputStream dbRawStream = resources.openRawResource(R.raw.demo);
            Log.d(logTag,"---> "+dbRawStream.toString());
            try {
                FileOutputStream fos = new FileOutputStream(demoDbFileName);
                byte[] buffer = new byte[8192];
                int count = 0;
                while ((count = dbRawStream.read(buffer)) > 0) {
                    fos.write(buffer, 0, count);
                }
//关闭资源
                fos.close();
                dbRawStream.close();
            }
            catch (Exception e) {
                Log.e(logTag, "copy db from res to cache error");
            }
        }

        DatabaseHelper database = new DatabaseHelper(this,"demo.db3",1);
        SQLiteDatabase sqliteDatabase = database.getReadableDatabase();
        Cursor  sqlCursor = sqliteDatabase.rawQuery("select * from shipInfo",null) ;
        Log.d(logTag,"affect lines -> "+ sqlCursor.getCount()) ;
        while (sqlCursor.moveToNext() ){
            Log.d(logTag,sqlCursor.getInt(0)+"  "+ sqlCursor.getString(1) +"  "+  sqlCursor.getString(2) + "  "+ sqlCursor.getString(3) +"  "+ sqlCursor.getString(4)) ;

        }









    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
