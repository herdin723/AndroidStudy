package com.arcvideo.android.flow.app

import android.app.Application
import com.herdin.android.base.app.BaseApplication

/**
 * Copyright © 2014-2021, ArcVideo 杭州当虹科技股份有限公司
 *
 * @author: herdin
 * @email： heding@arcvideo.com
 * @date: 2021/9/9
 * @desc:
 * @version: V-1.0.0
 **/
class FlowApp :BaseApplication() {


    override fun onCreate() {
        super.onCreate()
        initModuleApp(this)
    }
    override fun initModuleApp(application: Application?) {

    }

    override fun initModuleData(application: Application?) {

    }
}