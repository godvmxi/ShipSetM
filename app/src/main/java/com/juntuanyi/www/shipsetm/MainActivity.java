package com.juntuanyi.www.shipsetm;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import android.content.Context;
import android.content.ContentValues;


public class MainActivity extends Activity {
    private TankView tankView1;
    private TankView tankView2;
    private SqlUtils sqlUtils;
    private TankViewEvent tankViewEvent = null ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        tankViewEvent = new TankViewEvent() {
            @Override
            public void onSoundingChanged(TankInfo info) {
                Log.d("Main", "event-> " + info.toString());
                Log.d("Main", "callback-> " + info.ref.toString() );


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

        this.sqlUtils = new SqlUtils(this);



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
