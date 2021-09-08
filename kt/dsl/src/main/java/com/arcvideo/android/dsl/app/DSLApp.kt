package com.arcvideo.android.dsl.app

import android.app.Application
import com.herdin.android.base.app.BaseApplication

/**
 * Copyright © 2014-2021, ArcVideo 杭州当虹科技股份有限公司
 *
 * @author: herdin
 * @email： heding@arcvideo.com
 * @date: 2021/9/6
 * @desc:
 * @version: V-1.0.0
 **/
class DSLApp :BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        initModuleApp(this)
    }
    override fun initModuleApp(application: Application?) {
        TODO("Not yet implemented")
    }

    override fun initModuleData(application: Application?) {
        TODO("Not yet implemented")
    }
}