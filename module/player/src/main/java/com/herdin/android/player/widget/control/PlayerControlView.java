package com.herdin.android.player.widget.control;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import androidx.databinding.DataBindingUtil;

import com.herdin.android.base.ViewExtKt;
import com.herdin.android.player.R;
import com.herdin.android.player.databinding.PlayerControlViewBinding;
import com.herdin.android.player.widget.GesturePlayerListener;
import com.herdin.android.player.widget.PlayerViewGroup;

/**
 * Copyright © 2014-2021, ArcVideo 杭州当虹科技股份有限公司
 *
 * @author: herdin
 * @email： heding@arcvideo.com
 * @date: 2021/8/27
 * @desc:
 * @version: V-1.0.0
 **/
public abstract class PlayerControlView extends PlayerViewGroup{

    public static final String TAG = PlayerControlView.class.getSimpleName();

    protected View mRootView;

    public PlayerControlView(Context context) {
        this(context, null);
    }

    public PlayerControlView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PlayerControlView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    protected abstract int getLayoutId();

    @Override
    protected void init(Context context, AttributeSet attrs) {
        super.init(context, attrs);
        mRootView = inflate(context,getLayoutId(),this);
    }
}
