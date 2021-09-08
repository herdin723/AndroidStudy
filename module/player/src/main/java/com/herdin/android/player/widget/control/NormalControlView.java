package com.herdin.android.player.widget.control;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.herdin.android.player.R;
import com.herdin.android.player.databinding.PlayerNormalControlViewBinding;
import com.herdin.android.player.databinding.PlayerStandardControlViewBinding;
import com.herdin.android.player.widget.PlayerViewGroup;

/**
 * Copyright © 2014-2021, ArcVideo 杭州当虹科技股份有限公司
 *
 * @author: herdin
 * @email： heding@arcvideo.com
 * @date: 2021/8/30
 * @desc:
 * @version: V-1.0.0
 **/
public class NormalControlView extends PlayerControlView {

    private PlayerNormalControlViewBinding mBinding;
    public NormalControlView(@NonNull Context context) {
        this(context,null);
    }

    public NormalControlView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public NormalControlView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.player_normal_control_view;
    }

    @Override
    protected void init(Context context, AttributeSet attrs) {
        super.init(context, attrs);
//        mBinding = PlayerNormalControlViewBinding.bind(mRootView);

    }
}
