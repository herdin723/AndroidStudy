package com.herdin.android.base.utils

import android.util.Log
import androidx.lifecycle.MutableLiveData

/**
 * Copyright © 2014-2021, ArcVideo 杭州当虹科技股份有限公司
 *
 * @author: herdin
 * @email： heding@arcvideo.com
 * @date: 2021/8/19
 * @desc:
 * @version: V-1.0.0
 **/
object LiveDataBus {

    private val mBus: MutableMap<String, MutableLiveData<Any>>

    init {
        mBus = HashMap()
        Log.d("LiveDataBus", "init: ")
    }

    /**
     * 注册
     */
    @Synchronized
    fun <T> with(key: String, type: Class<T>): MutableLiveData<Any>? {
        Log.d("LiveDataBus", "with: ")
        if (!mBus.containsKey(key)) {
            mBus[key] = MutableLiveData<Any>()
        }
        return mBus[key]
    }
}