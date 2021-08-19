package com.herdin.android.network.exception

import com.google.gson.JsonSerializer
import com.google.gson.JsonSyntaxException
import org.json.JSONException
import retrofit2.HttpException
import java.io.InterruptedIOException
import java.io.NotSerializableException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.net.UnknownServiceException
import java.text.ParseException
import javax.net.ssl.SSLHandshakeException

/**
 * Copyright © 2014-2021, ArcVideo 杭州当虹科技股份有限公司
 *
 * @author: herdin
 * @email： heding@arcvideo.com
 * @date: 2021/8/18
 * @desc:
 * @version: V-1.0.0
 **/
class ExceptionEngine {
    companion object {
        fun handleException(e: Throwable): String {
            var errMsg = "未知错误"
            when (e) {
                is HttpException -> {
                    errMsg = "网络异常"
                }
                is ConnectException -> errMsg = "连接失败"
                is SocketTimeoutException -> errMsg = "连接超时"
                is InterruptedIOException -> errMsg = "连接中断"
                is SSLHandshakeException -> errMsg = "证书验证失败"
                is UnknownHostException -> errMsg = "无法解析该域名"
                is UnknownServiceException -> errMsg = "无法解析该域名"

                is JSONException -> errMsg = "数据解析错误"
                is JsonSyntaxException -> errMsg = "数据解析错误"
                is JsonSerializer<*> -> errMsg = "数据解析错误"
                is ParseException -> errMsg = "数据解析错误"
                is NotSerializableException -> errMsg = "数据解析错误"

                is NullPointerException -> errMsg = "NullPointer"
                is ClassCastException -> errMsg = "类型转换错误"
                is NumberFormatException -> errMsg = "NumberFormat"
                else ->
                    errMsg = e.message.toString()
            }
            return errMsg
        }
    }
}