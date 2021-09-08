//package com.herdin.android.player.widget.control;
//
//import android.app.Activity;
//import android.content.Context;
//import android.media.AudioManager;
//import android.util.AttributeSet;
//import android.util.DisplayMetrics;
//import android.util.Log;
//import android.view.GestureDetector;
//import android.view.LayoutInflater;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.WindowManager;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.databinding.DataBindingUtil;
//
//import com.herdin.android.base.ViewExtKt;
//import com.herdin.android.player.R;
//import com.herdin.android.player.widget.GesturePlayerListener;
//import com.herdin.android.player.widget.PlayerViewGroup;
//
///**
// * Copyright © 2014-2021, ArcVideo 杭州当虹科技股份有限公司
// *
// * @author: herdin
// * @email： heding@arcvideo.com
// * @date: 2021/8/30
// * @desc:
// * @version: V-1.0.0
// **/
//public class AdvancedControlView extends PlayerViewGroup {
//
//    private GesturePlayerListener mGesturePlayerListener;
//    private PlayerControlView.GesturePlayOnGestureListener mGesturePlayOnGestureListener;
//    private GestureDetector mGestureDetector;
//
//    //手势偏差值
//    protected int mThreshold = 80;
//
//    //触摸的X
//    protected float mDownX;
//
//    //触摸的Y
//    protected float mDownY;
//
//    //移动的Y
//    protected float mMoveY;
//
//    //亮度
//    protected float mBrightnessData = -1;
//
//    //手势调节音量的大小
//    protected int mGestureDownVolume;
//
//    //是否改变音量
//    protected boolean mChangeVolume = false;
//
//    //是否改变播放进度
//    protected boolean mChangePosition = false;
//
//    //是否改变亮度
//    protected boolean mBrightness = false;
//
//    //手动滑动的起始偏移位置
//    protected int mSeekEndOffset = 50;
////    //触摸显示虚拟按键
////    protected boolean mShowVKey = false;
//
//
//    //音频焦点的监听
//    protected AudioManager mAudioManager;
//
//
//    public AdvancedControlView(@NonNull Context context) {
//        this(context,null);
//    }
//
//    public AdvancedControlView(@NonNull Context context, @Nullable AttributeSet attrs) {
//        this(context, attrs,0);
//    }
//
//    public AdvancedControlView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//    }
//
//
//    private void init() {
////        inflate(mContext, getLayoutId(), this);
//        mBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),
//                getLayoutId(), this, true);
//
//        mGesturePlayOnGestureListener = new GesturePlayOnGestureListener();
//        mGestureDetector = new GestureDetector(mContext, mGesturePlayOnGestureListener);
////        //取消长按，不然会影响滑动
////        mGestureDetector.setIsLongpressEnabled(false);
//
////        setOnTouchListener(new OnTouchListener() {
////            @Override
////            public boolean onTouch(View v, MotionEvent event) {
////                //监听触摸事件
////                return mGestureDetector.onTouchEvent(event);
////            }
////        });
//
//        mBinding.getRoot().setOnTouchListener(this);
//
//        mAudioManager = (AudioManager) mContext.getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
//
//    }
//
//    private int getLayoutId() {
//        return R.layout.player_control_view;
//    }
//
//
//    @Override
//    public boolean onTouch(View v, MotionEvent event) {
//        Log.d(TAG, "onTouch: "+event.getAction());
//        float x = event.getX();
//        float y = event.getY();
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                touchSurfaceDown(x,y);
//                break;
//            case MotionEvent.ACTION_MOVE:
//                float deltaX = x - mDownX;
//                float deltaY = y - mDownY;
//                float absDeltaX = Math.abs(deltaX);
//                float absDeltaY = Math.abs(deltaY);
//                touchMoveFullLogic(absDeltaX, absDeltaY);
//
//                if (mBrightness){
//                    if (Math.abs(deltaY) > mThreshold) {
//                        float percent = (-deltaY / getScreenHeight(mContext));
//                        onBrightnessSlide(percent);
//                        mDownY = y;
//                    }
//                }
//                if (mChangeVolume){
//                    deltaY = -deltaY;
//                    int max = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
//                    int deltaV = (int) (max * deltaY * 3 / getScreenHeight(mContext));
//                    mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, mGestureDownVolume + deltaV, 0);
//                    int volumePercent = (int) (mGestureDownVolume * 100 / max + deltaY * 3 * 100 / getScreenHeight(mContext));
//                }
//                break;
//            case MotionEvent.ACTION_UP:
//
//                break;
//
//            default:
//                break;
//
//        }
//        mGestureDetector.onTouchEvent(event);
//        return true;
//    }
//
//    private void touchMoveFullLogic(float absDeltaX, float absDeltaY) {
//        int curWidth = getScreenWidth(mContext);
//
//        if (absDeltaX > mThreshold || absDeltaY > mThreshold) {
//            if (absDeltaX >= mThreshold) {
//                //防止全屏虚拟按键
////                int screenWidth = CommonUtil.getScreenWidth(getContext());
////                if (Math.abs(screenWidth - mDownX) > mSeekEndOffset) {
////                    mChangePosition = true;
////                    mDownPosition = getCurrentPositionWhenPlaying();
////                } else {
////                    mShowVKey = true;
////                }
//            } else {
//                int screenHeight = getScreenHeight(getContext());
//                boolean noEnd = Math.abs(screenHeight - mDownY) > mSeekEndOffset;
//                mBrightness = (mDownX < curWidth * 0.5f) && noEnd;
//
//                if (!mBrightness) {
//                    mChangeVolume = noEnd;
//                    mGestureDownVolume = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
//                }
//            }
//        }
//    }
//
//    protected void touchSurfaceDown(float x, float y) {
//        mDownX = x;
//        mDownY = y;
//        mMoveY = 0;
//    }
//
//    /**
//     * 滑动改变亮度
//     *
//     * @param percent
//     */
//    protected void onBrightnessSlide(float percent) {
//        mBrightnessData = ((Activity) (mContext)).getWindow().getAttributes().screenBrightness;
//        if (mBrightnessData <= 0.00f) {
//            mBrightnessData = 0.50f;
//        } else if (mBrightnessData < 0.01f) {
//            mBrightnessData = 0.01f;
//        }
//        WindowManager.LayoutParams lpa = ((Activity) (mContext)).getWindow().getAttributes();
//        lpa.screenBrightness = mBrightnessData + percent;
//        if (lpa.screenBrightness > 1.0f) {
//            lpa.screenBrightness = 1.0f;
//        } else if (lpa.screenBrightness < 0.01f) {
//            lpa.screenBrightness = 0.01f;
//        }
////        showBrightnessDialog(lpa.screenBrightness);
//        ((Activity) (mContext)).getWindow().setAttributes(lpa);
//    }
//
//    /**
//     * 手势监听
//     */
//    public class GesturePlayOnGestureListener extends GestureDetector.SimpleOnGestureListener {
//
//        @Override
//        public boolean onDown(MotionEvent e) {
//            Log.d(TAG, "onDown: ");
//            return super.onDown(e);
//        }
//
//        /**
//         * 如果是按下的时间超过瞬间，而且在按下的时候没有松开或者是拖动的
//         * @param e
//         */
//        @Override
//        public void onShowPress(MotionEvent e) {
//            super.onShowPress(e);
//            Log.d(TAG, "onShowPress: ");
//        }
//
//        @Override
//        public boolean onSingleTapUp(MotionEvent e) {
//            Log.d(TAG, "onSingleTapUp: ");
//            return super.onSingleTapUp(e);
//        }
//
//        @Override
//        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
//            Log.d(TAG, "onScroll: ");
//            return super.onScroll(e1, e2, distanceX, distanceY);
//        }
//
//
//        /**
//         * 长按触摸屏，超过一定时长，就会触发这个事件
//         * @param e
//         */
//        @Override
//        public void onLongPress(MotionEvent e) {
//            Log.d(TAG, "onLongPress: ");
//            super.onLongPress(e);
//        }
//
//        @Override
//        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
//            Log.d(TAG, "onFling: ");
//            return super.onFling(e1, e2, velocityX, velocityY);
//        }
//
//        @Override
//        public boolean onSingleTapConfirmed(MotionEvent e) {
//            Log.d(TAG, "onSingleTapConfirmed: ");
//            return super.onSingleTapConfirmed(e);
//        }
//
//        @Override
//        public boolean onDoubleTap(MotionEvent e) {
//            Log.d(TAG, "onDoubleTap: ");
//            ViewExtKt.showToast(mContext,"onDoubleTap");
//            return super.onDoubleTap(e);
//        }
//
//        @Override
//        public boolean onDoubleTapEvent(MotionEvent e) {
//            Log.d(TAG, "onDoubleTapEvent: ");
//            ViewExtKt.showToast(mContext,"onDoubleTapEvent");
//            return super.onDoubleTapEvent(e);
//        }
//
//    }
//
//
//    /**
//     * 获取屏幕的宽度px
//     *
//     * @param context 上下文
//     * @return 屏幕宽px
//     */
//    public static int getScreenWidth(Context context) {
//        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
//        DisplayMetrics outMetrics = new DisplayMetrics();// 创建了一张白纸
//        windowManager.getDefaultDisplay().getMetrics(outMetrics);// 给白纸设置宽高
//        return outMetrics.widthPixels;
//    }
//
//    /**
//     * 获取屏幕的高度px
//     *
//     * @param context 上下文
//     * @return 屏幕高px
//     */
//    public static int getScreenHeight(Context context) {
//        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
//        DisplayMetrics outMetrics = new DisplayMetrics();// 创建了一张白纸
//        windowManager.getDefaultDisplay().getMetrics(outMetrics);// 给白纸设置宽高
//        return outMetrics.heightPixels;
//    }
//
//}
