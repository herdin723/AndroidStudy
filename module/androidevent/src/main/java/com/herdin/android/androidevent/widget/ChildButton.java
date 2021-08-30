package com.herdin.android.androidevent.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.widget.AppCompatButton;

/**
 * Copyright © 2014-2021, ArcVideo 杭州当虹科技股份有限公司
 *
 * @author: herdin
 * @email： heding@arcvideo.com
 * @date: 2021/8/30
 * @desc:
 * @version: V-1.0.0
 **/
public class ChildButton extends AppCompatButton implements View.OnTouchListener {
    public static final String TAG = "MainActivity_Button";
    public ChildButton(Context context) {
        super(context);
        setOnTouchListener(this);
    }

    public ChildButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnTouchListener(this);
    }

    public ChildButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOnTouchListener(this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d(TAG, "dispatchTouchEvent: "+event.getAction());
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouchEvent: "+event.getAction());
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.e(TAG, "onTouch: "+event.getAction());
        return false;
    }
}
