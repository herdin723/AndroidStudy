package com.herdin.android.player.widget;

/**
 * Copyright © 2014-2021, ArcVideo 杭州当虹科技股份有限公司
 *
 * @author: herdin
 * @email： heding@arcvideo.com
 * @date: 2021/8/30
 * @desc:  全屏播放时手势触摸操作的状态
 * @version: V-1.0.0
 **/
public class GestureTouchState {

    /**
     * 无操作
     */
    public static final int STATE_NONE = 0;
    /**
     * 快进或后退
     */
    public static final int STATE_VIDEO_PROGRESS = 1;
    /**
     * 调节音量
     */
    public static final int STATE_VOLUME = 2;
    /**
     * 调节亮度
     */
    public static final int STATE_BRIGHTNESS = 3;
}
