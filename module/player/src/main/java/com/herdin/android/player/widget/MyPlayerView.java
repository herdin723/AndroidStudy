package com.herdin.android.player.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.herdin.android.player.R;

/**
 * Copyright © 2014-2021, ArcVideo 杭州当虹科技股份有限公司
 *
 * @author: herdin
 * @email： heding@arcvideo.com
 * @date: 2021/8/27
 * @desc:
 * @version: V-1.0.0
 **/
public class MyPlayerView extends AbPlayerView {
    private Context mContext;
    public MyPlayerView(Context context) {
        this(context,null);
    }

    public MyPlayerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyPlayerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }

    private void init() {
        View.inflate(mContext, getLayoutId(), this);
    }

    private int getLayoutId() {
        return R.layout.player_video_view;
    }





}
