package com.herdin.android.network.test


import com.herdin.android.network.RetrofitManager
import com.herdin.android.network.bean.BaseResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path


/**
 * @author: dpq
 * @date: 2020/8/20
 * @email: dpq@arcvideo.com
 * @version: 2.5.0
 * @desc:
 */
interface ApiService {

    companion object{
        val apiService by lazy {
            RetrofitManager.createApi(ApiService::class.java)
        }

    }

    @GET("/v2/sms/{phone}")
    suspend fun getCode(@Path("phone") phone: String): Deferred<BaseResponse<Any>>
}


