package com.herdin.android.hint.app

import android.app.Application
import android.util.Log
import com.herdin.android.base.app.BaseApplication

/**
 * Copyright © 2014-2021, ArcVideo 杭州当虹科技股份有限公司
 *
 * @author: herdin
 * @email： heding@arcvideo.com
 * @date: 2021/8/18
 * @desc:
 * @version: V-1.0.0
 **/
class HintApp: BaseApplication() {

    private val TAG = HintApp::class.java.simpleName

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate: hint ")
        initModuleApp(this)
    }
    override fun initModuleApp(application: Application?) {
        Log.d(TAG, "initModuleApp: init hint ")
    }

    override fun initModuleData(application: Application?) {

    }
}