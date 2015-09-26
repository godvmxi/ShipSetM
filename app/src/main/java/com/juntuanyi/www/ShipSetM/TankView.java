package com.juntuanyi.www.ShipSetM;

import android.content.Context;

import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.util.Log;


/**
 * TODO: document your custom view class.
 */
public class TankView extends LinearLayout {

    private String name;
    private Float sounding ;
    private Float result ;
    private Integer soundingMax ;
    private Integer soundingMin ;

    private TextView textViewTankName ;
    private TextView textViewResult ;
    private EditText editTextSounding ;
    private TankViewEvent tankViewEvent = null ;




    public TankView(Context context) {
        super(context);
    }



    public TankView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.tank_view, this, true);
        textViewTankName = (TextView) findViewById(R.id.textViewTankName);
        editTextSounding = (EditText) findViewById(R.id.editTextSounding) ;
        textViewResult = ( TextView) this.findViewById(R.id.textViewResult);
        textViewTankName.setText("ddd");
        textViewResult.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TankView","click is here" + this);
                tankViewEvent.onSoundingChanged("100");

            }
        });
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getResult() {
        return result;
    }

    public void setResult(Float result) {
        this.result = result;
    }

    public Float getSounding() {
        return sounding;
    }

    public void setSounding(Float sounding) {
        this.sounding = sounding;
    }

    public Integer getSoundingMax() {
        return soundingMax;
    }

    public void setSoundingMax(Integer soundingMax) {
        this.soundingMax = soundingMax;
    }

    public Integer getSoundingMin() {
        return soundingMin;
    }

    public void setSoundingMin(Integer soundingMin) {
        this.soundingMin = soundingMin;
    }
    public TankViewEvent getTankViewEvent() {
        return tankViewEvent;
    }

    public void setTankViewEvent(TankViewEvent tankViewEvent) {
        this.tankViewEvent = tankViewEvent;
    }
}
