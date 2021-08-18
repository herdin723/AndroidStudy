package com.herdin.android.room.app

import android.app.Application
import android.util.Log
import com.herdin.android.base.BaseActivity
import com.herdin.android.base.BaseApplication

/**
 * Copyright © 2014-2021, ArcVideo 杭州当虹科技股份有限公司
 *
 * @author: herdin
 * @email： heding@arcvideo.com
 * @date: 2021/8/18
 * @desc:
 * @version: V-1.0.0
 **/
class RoomApp:BaseApplication() {

    private val TAG = RoomApp::class.java.simpleName

    override fun onCreate() {
        super.onCreate()

        Log.d(TAG, "onCreate: room ")
    }
    override fun initModuleApp(application: Application?) {
        Log.d(TAG, "initModuleApp: init room ")
    }

    override fun initModuleData(application: Application?) {

    }
}