package com.herdin.android.study.app

import android.app.Application
import android.util.Log
import com.herdin.android.base.app.AppConfig
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
class MainApp: BaseApplication() {

    private val TAG = MainApp::class.java.simpleName

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate: main")
        initModuleApp(this)
    }
    override fun initModuleApp(application: Application?) {
        Log.d(TAG, "initModuleApp: init main")
        AppConfig.APPS.forEach { appName->
            try {
                val clazz = Class.forName(appName)
                val baseApp = clazz.newInstance() as BaseApplication
                baseApp.initModuleApp(this)
                Log.d(TAG, "initModuleApp: success :")
            }catch (e:Exception){
                e.printStackTrace()
                Log.d(TAG, "initModuleApp: error :"+e.message)
            }

        }
    }

    override fun initModuleData(application: Application?) {

    }
}