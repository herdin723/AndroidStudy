package com.herdin.android.network.test

import com.herdin.android.network.RetrofitManager
import com.herdin.android.network.data.HttpManager
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

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


    fun test() {
        GlobalScope.launch {
            HttpManager.launchRequest(
                {
                    ApiService.apiService?.getCode("phone")!!.await()
                }, { _ ->
                    println("success")
                }, { errorMsg ->
                    println(errorMsg)
                }, {
                    println("finish")
                })
        }
    }

}