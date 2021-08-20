package com.herdin.android.base.vm

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel

/**
 * Copyright © 2014-2021, ArcVideo 杭州当虹科技股份有限公司
 *
 * @author: herdin
 * @email： heding@arcvideo.com
 * @date: 2021/8/18
 * @desc:
 * @version: V-1.0.0
 **/
open class BaseViewModel : ViewModel(), LifecycleObserver {

    private val TAG = BaseViewModel::class.java.simpleName

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreateX() {
        Log.d(TAG, "onCreateX: ")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStartX() {
        Log.d(TAG, "onStartX: ")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResumeX() {
        Log.d(TAG, "onResumeX: ")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPauseX() {
        Log.d(TAG, "onPauseX: ")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStopX() {
        Log.d(TAG, "onStopX: ")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroyX() {
        Log.d(TAG, "onDestroyX: ")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAnyX() {
//        Log.d(TAG, "onAnyX: ")
    }
}