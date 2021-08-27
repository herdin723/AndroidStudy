package com.herdin.android.player.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

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
public class PlayerControlView extends PlayerViewGroup {

    private Context mContext;
    private ViewDataBinding mBinding;


    public PlayerControlView(Context context) {
        this(context, null);
    }

    public PlayerControlView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PlayerControlView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }


    private void init() {
//        inflate(mContext, getLayoutId(), this);
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),
                getLayoutId(), this, true);


    }

    private int getLayoutId() {
        return R.layout.player_control_view;
    }

}
