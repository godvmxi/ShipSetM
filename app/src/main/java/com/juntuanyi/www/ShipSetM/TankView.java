package com.juntuanyi.www.shipsetm;

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
    private TankInfo info ;

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

                if (tankViewEvent == null) {
                    Log.d("TankView", "click is here" + info.toString());
                    Log.e("TankView", "not set event handler");
                    return;
                    //shoud raise a exception
                }
                tankViewEvent.onSoundingChanged(info);

            }
        });
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        textViewTankName.setText(this.name);
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

    public TankInfo getInfo() {
        return info;
    }

    public void setInfo(TankInfo info) {
        this.info = info;
        this.info.ref =this;
        this.setName(getTankNameById(this.info.tankId));

    }
    private  String getTankNameById(Integer id){
        Integer tankIndex = (id+1) / 2 ;
        Integer lrIndex =  id  % 2 ;
        String tank = new String();

        switch (tankIndex){
            case 1 :
                tank = "一";
                break ;
            case 2 :
                tank = "二";
                break ;
            case 3 :
                tank = "三";
                break ;
            case 4 :
                tank = "四";
                break ;
            case 5 :
                tank = "五";
                break ;
            case 6 :
                tank = "六";
                break ;
            case 7 :
                tank = "七";
                break ;
            case 8 :
                tank = "八";
                break ;
            case 9 :
                tank = "九";
                break ;
            case 10 :
                tank = "十";
                break ;
            default:
//                throw new Exception();
                break;
        }
        if (lrIndex != 0 ) {
            return "左" + tank + "仓" ;
        }
        else
            return "右" + tank + "仓" ;

    }
    @Override
    public String toString() {
        return "TankView{" +
                "name='" + name + '\'' +
                ", sounding=" + sounding +
                ", result=" + result +
                '}';
    }
}
