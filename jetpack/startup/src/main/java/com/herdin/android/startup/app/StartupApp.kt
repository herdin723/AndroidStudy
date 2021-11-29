package com.herdin.android.startup.app

import android.app.Application
import android.content.Context
import android.util.Log
import com.herdin.android.base.app.BaseApplication
import com.herdin.android.startup.INIT_TAG

/**
 * Copyright © 2014-2021, ArcVideo 杭州当虹科技股份有限公司
 *
 * @author: herdin
 * @email： heding@arcvideo.com
 * @date: 2021/9/10
 * @desc:  TODO  实现一种在应用启动时初始化组件的简单、高效方法。
 * @version: V-1.0.0
 **/
class StartupApp :BaseApplication() {


    override fun initModuleApp(application: Application?) {

    }

    override fun initModuleData(application: Application?) {

    }

    /**
     * 首先调用Application的attachBaseContext()方法，
     * 然后调用ContentProvider的onCreate()方法，
     * 接下来调用Application的onCreate()方法。
     * App StartUp的本质是在ContentProvider中进行了初始化（获取到Context），
     * 它可以将所有用于初始化的ContentProvider合并成一个，从而使App的启动速度变得更快。
     */
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        Log.d(INIT_TAG, "App attachBaseContext: ")
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(INIT_TAG, "App onCreate: ")
    }
}