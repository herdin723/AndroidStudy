package com.herdin.android.startup.sdk

/**
 * Copyright © 2014-2021, ArcVideo 杭州当虹科技股份有限公司
 *
 * @author: herdin
 * @email： heding@arcvideo.com
 * @date: 2021/9/10
 * @desc:
 * @version: V-1.0.0
 **/

class SdkD {

    private object Instance {
        val instance = SdkD()
    }

    companion object {
        fun getInstance(): SdkD {
            return Instance.instance
        }

    }
}