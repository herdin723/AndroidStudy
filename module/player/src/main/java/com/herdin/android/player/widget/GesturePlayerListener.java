package com.herdin.android.player.widget;

import android.view.MotionEvent;

/**
 * Copyright © 2014-2021, ArcVideo 杭州当虹科技股份有限公司
 *
 * @author: herdin
 * @email： heding@arcvideo.com
 * @date: 2021/8/30
 * @desc:
 * @version: V-1.0.0
 **/
public interface GesturePlayerListener {

    /**
     * 亮度手势，在View左半部区域上下滑动时候调用
     * @param e1
     * @param e2
     * @param distanceX
     * @param distanceY
     */
    public void onBrightnessGesture(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY);


    /**
     * 音量手势，在View右半部区域上下滑动时候调用
     * @param e1
     * @param e2
     * @param distanceX
     * @param distanceY
     */
    public void onVolumeGesture(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY);

    /**
     * 快进快退手势，在View左右滑动的时候调用
     * @param e1
     * @param e2
     * @param distanceX
     * @param distanceY
     */
    public void onVideoSpeedGesture(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY);

    /**
     * 打击手势
     * @param e
     */
    public void onSingleTapGesture(MotionEvent e);


    /**
     * 双击手势
     * @param e
     */
    public void onDoubleTapGesture(MotionEvent e);


    /**
     * 按下手势
     * @param e
     */
    public void onDown(MotionEvent e);


    /**
     * 快进快退执行后的松开时候调用
     * @param e
     */
    public void onVideoSpeedEnd(MotionEvent e);

}
