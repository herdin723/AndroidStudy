package com.herdin.android.player.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.AbsListViewBindingAdapter;

import com.herdin.android.player.R;
import com.herdin.android.player.databinding.PlayerControlViewBinding;

/**
 * Copyright © 2014-2021, ArcVideo 杭州当虹科技股份有限公司
 *
 * @author: herdin
 * @email： heding@arcvideo.com
 * @date: 2021/8/27
 * @desc:
 * @version: V-1.0.0
 **/
public class PlayerControlView extends ConstraintLayout implements View.OnTouchListener {

    public static final String TAG = PlayerControlView.class.getSimpleName();
    
    private Context mContext;
    private PlayerControlViewBinding mBinding;
    private GesturePlayerListener mGesturePlayerListener;
    private GesturePlayOnGestureListener mGesturePlayOnGestureListener;
    private GestureDetector mGestureDetector;


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

        mGesturePlayOnGestureListener = new GesturePlayOnGestureListener();
        mGestureDetector = new GestureDetector(mContext, mGesturePlayOnGestureListener);
//        //取消长按，不然会影响滑动
//        mGestureDetector.setIsLongpressEnabled(false);

//        setOnTouchListener(new OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                //监听触摸事件
//                return mGestureDetector.onTouchEvent(event);
//            }
//        });

        mBinding.textureView.setOnTouchListener(this);
    }

    private int getLayoutId() {
        return R.layout.player_control_view;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouchEvent: "+event.getAction());
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_MOVE:


                break;
            case MotionEvent.ACTION_UP:

                break;

            default:
                break;

        }
        return false;
    }




    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.d(TAG, "onTouch: "+event.getAction());
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "onTouch: ");

                break;
            case MotionEvent.ACTION_UP:

                break;

            default:
                break;

        }
        mGestureDetector.onTouchEvent(event);
        return false;
    }


    /**
     * 手势监听
     */
    public class GesturePlayOnGestureListener extends GestureDetector.SimpleOnGestureListener {

        /**
         * 用户按下屏幕就会触发；
         * @param e
         * @return
         */
        @Override
        public boolean onDown(MotionEvent e) {
            Log.d(TAG, "onDown: ");
            return super.onDown(e);
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            Log.d(TAG, "onScroll: ");
            return super.onScroll(e1, e2, distanceX, distanceY);
        }
        @Override
        public boolean onContextClick(MotionEvent e) {
            Log.d(TAG, "onContextClick: ");
            return super.onContextClick(e);
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            Log.d(TAG, "onDoubleTap: ");
            return super.onDoubleTap(e);
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            Log.d(TAG, "onDoubleTapEvent: ");
            return super.onDoubleTapEvent(e);
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            Log.d(TAG, "onSingleTapUp: ");
            return super.onSingleTapUp(e);
        }

        /**
         * 长按触摸屏，超过一定时长，就会触发这个事件
         * @param e
         */
        @Override
        public void onLongPress(MotionEvent e) {
            Log.d(TAG, "onLongPress: ");
            super.onLongPress(e);
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            Log.d(TAG, "onFling: ");
            return super.onFling(e1, e2, velocityX, velocityY);
        }

        /**
         * 如果是按下的时间超过瞬间，而且在按下的时候没有松开或者是拖动的
         * @param e
         */
        @Override
        public void onShowPress(MotionEvent e) {
            super.onShowPress(e);
            Log.d(TAG, "onShowPress: ");
        }


        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            Log.d(TAG, "onSingleTapConfirmed: ");
            return super.onSingleTapConfirmed(e);
        }

    }

}
