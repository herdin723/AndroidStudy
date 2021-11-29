package com.herdin.android.startup.sdk

import android.content.Context
import android.util.Log
import androidx.startup.Initializer
import com.herdin.android.startup.INIT_TAG
import java.util.*

/**
 * Copyright © 2014-2021, ArcVideo 杭州当虹科技股份有限公司
 *
 * @author: herdin
 * @email： heding@arcvideo.com
 * @date: 2021/9/10
 * @desc:
 * @version: V-1.0.0
 **/
class SdkAInitializer:Initializer<SdkA> {


    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        Log.d(INIT_TAG, "dependencies: SdkA")
        //SdkA 的初始化不需要其他库的依赖，所以这里 dependencies 方法返回一个空列表。
        return Collections.emptyList()
    }

    override fun create(context: Context): SdkA {
        Log.d(INIT_TAG, "create: SdkA")
        return SdkA.getInstance()
    }


}