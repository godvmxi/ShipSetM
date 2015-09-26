package com.juntuanyi.www.helloworld;

import android.content.Context;

import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.app.Activity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout ;
import android.widget.TextView;
import android.util.Log;


/**
 * TODO: document your custom view class.
 */
public class TankView extends LinearLayout {
    public TankView(Context context) {
        super(context);

    }

    public TankView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.tank_view, this, true);
    }
}
