package com.herdin.android.network.test

import com.herdin.android.network.RetrofitManager
import com.herdin.android.network.data.HttpManager

/**
 * Copyright © 2014-2021, ArcVideo 杭州当虹科技股份有限公司
 *
 * @author: herdin
 * @email： heding@arcvideo.com
 * @date: 2021/8/18
 * @desc:
 * @version: V-1.0.0
 **/
class Test {


    suspend fun test() {
        HttpManager.launchRequest(
            {
                val createApi = RetrofitManager.createApi(ApiService::class.java)
                createApi?.getCode("phone")!!.await()
            }, { result ->
                println("success")
            }, { errorMsg ->
                println(errorMsg)
            }, {
                println("finish")
            })
    }
}