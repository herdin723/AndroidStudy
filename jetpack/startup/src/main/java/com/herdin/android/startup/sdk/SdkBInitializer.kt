package com.herdin.android.startup.sdk

import android.content.Context
import android.util.Log
import androidx.startup.Initializer
import com.herdin.android.startup.INIT_TAG


/**
 * Copyright © 2014-2021, ArcVideo 杭州当虹科技股份有限公司
 *
 * @author: herdin
 * @email： heding@arcvideo.com
 * @date: 2021/9/10
 * @desc:
 * @version: V-1.0.0
 **/
class SdkBInitializer:Initializer<SdkB> {


    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        Log.d(INIT_TAG, "dependencies: SdkB")
        //TODO SdkB 的初始化需要SdkC 的依赖，所以这里 dependencies 先初始化 SdkC。
        return mutableListOf(SdkCInitializer::class.java)
    }

    override fun create(context: Context): SdkB {
        Log.d(INIT_TAG, "create: SdkB")
        return SdkB.getInstance()
    }


}