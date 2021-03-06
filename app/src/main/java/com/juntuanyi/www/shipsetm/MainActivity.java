package com.juntuanyi.www.shipsetm;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    private String logTag ;
    private TankView tankView1;
    private TankView tankView2;
//    private DatabaseHelper sqlUtils;
    private TankViewEvent tankViewEvent = null ;
    private SqlUtils sqlUtils;
    private ShipInfoList shipInfoList ;
    private TextView textViewTopInfo ;
    private LinearLayout linearLayoutTankList = null ;

    private List<TankView> tankViewList =null ;
    private Integer tankNumber = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.logTag =  this.getLocalClassName() + "Log" ;


        setContentView(R.layout.activity_main);
        linearLayoutTankList = (LinearLayout) findViewById(R.id.linearLayoutTankList);
        textViewTopInfo = (TextView) findViewById(R.id.textViewTopInfo);
        this.initBasicData((Context) this);
        shipInfoList = new ShipInfoList();

        tankViewEvent = new TankViewEvent() {
            @Override
            public void onButtonCalResultClick(TankInfo info) {
                Log.d(logTag, "button event-> " + info.toString());
                Log.d(logTag, "callback-> " + info.ref.toString() );
            }
            @Override
            public void onSoundingChanged(TankInfo info) {
                Log.d(logTag, "changed event-> " + info.toString());
                Log.d(logTag, "callback-> " + info.ref.toString() );
            }
        };
        TankInfo.soundingMax = 9999;
        TankInfo.soundingMin = 0;
        TankInfo.shipId = 1001;
        Context context = this;
        tankViewList =  new ArrayList<TankView>( 0) ;


        this.updateTankViewItem();
        Log.d(logTag,"total object number -> " +  tankViewList.size());


        sqlUtils = new SqlUtils(context ,"ships.db3");

        textViewTopInfo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                tankNumber++ ;
                if(tankNumber >= 20){
                    tankNumber = 1;
                }
                Log.d(logTag,"top info click ->  " + tankNumber);
                updateTankViewItem();
                sqlUtils.queryShipList(shipInfoList);
                Log.d(logTag,shipInfoList.toString() );
            }
        });
        return ;
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
    public void updateTankViewItem(){

        this.linearLayoutTankList.removeAllViews();
        this.tankViewList.clear();
        TankView  view ;
        TankInfo info ;
        for(int i = 0 ;i<tankNumber; i++){
            view = new TankView(this);
            info = new TankInfo(i+1);
            view.setInfo(info);
            view.setTankViewEvent(tankViewEvent);
            tankViewList.add(view) ;

            linearLayoutTankList.addView((View)view);
        }
    }
    public void initBasicData(Context context){
        String filesDir =  context.getFilesDir().getAbsolutePath() ;
        Log.d(logTag,"file dir-> "+filesDir.toString());
        String baseDataDir = filesDir.replaceAll("files","") ;
        String databasesDir = baseDataDir + "/databases" ;
        String demoDbFileName = databasesDir + "/ships.db3" ;
        Log.d(logTag,"database dir-> "+demoDbFileName);
        Log.d(logTag,"files dir-> "+filesDir);
        Log.d(logTag,"base dir-> "+baseDataDir);

        if ( !(new File(databasesDir)).exists()  ) {
            (new File(databasesDir)).mkdir() ;
        }
        else {
            Log.d(logTag,"no need to create databases dir");
        }
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
    }


}
