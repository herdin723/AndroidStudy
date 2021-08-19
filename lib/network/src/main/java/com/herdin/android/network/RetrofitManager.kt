package com.herdin.android.network

import com.herdin.android.network.contact.BASE_URL
import com.herdin.android.network.contact.TIME_OUT
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Copyright © 2014-2021, ArcVideo 杭州当虹科技股份有限公司
 *
 * @author: herdin
 * @email： heding@arcvideo.com
 * @date: 2021/8/18
 * @desc:
 * @version: V-1.0.0
 **/
object RetrofitManager {

    private var mRetrofit: Retrofit? = null

    private var mRetrofitBuilder: Retrofit.Builder? = null

    init {
        initRetrofit()
    }

    private fun initRetrofit() {
        mRetrofitBuilder = Retrofit.Builder()
        mRetrofit = mRetrofitBuilder?.run {
            baseUrl(BASE_URL)
//                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient())
                .build()
            build()
        }
    }

    private fun getOkHttpClient(): OkHttpClient {
        val mOkHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()

        mOkHttpClientBuilder.run {
            connectTimeout(TIME_OUT, TimeUnit.SECONDS)
            readTimeout(TIME_OUT, TimeUnit.SECONDS)
            writeTimeout(TIME_OUT, TimeUnit.SECONDS)
            //设置同时连接的个数和时间，我这里8个，和每个保持时间为10s
            connectionPool(ConnectionPool(8, 15, TimeUnit.SECONDS))
            //错误重连
            retryOnConnectionFailure(true)

            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            //设置 Debug Log 模式
            addInterceptor(loggingInterceptor)
//            addInterceptor(CacheInterceptor())
//            addInterceptor(HeaderInterceptor())
//            addInterceptor(MultiUrlInterceptor())
//            dns()
//            cache()
        }
        return mOkHttpClientBuilder.build()
    }

    fun <T> createApi(clazz: Class<T>): T? {
        return mRetrofit?.create(clazz)
    }
}