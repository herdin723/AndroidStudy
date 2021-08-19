package com.herdin.android.network.data

import com.herdin.android.network.bean.BaseResponse
import com.herdin.android.network.exception.ExceptionEngine
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope

/**
 * Copyright © 2014-2021, ArcVideo 杭州当虹科技股份有限公司
 *
 * @author: herdin
 * @email： heding@arcvideo.com
 * @date: 2021/8/18
 * @desc:
 * @version: V-1.0.0
 **/
object HttpManager {

    /**
     * 网络请求
     */
    suspend fun <T> launchRequest(
        tryBlock: suspend CoroutineScope.() -> BaseResponse<T>?,
        successBlock: suspend CoroutineScope.(T?) -> Unit,
        catchBlock: suspend CoroutineScope.(String?) -> Unit,
        finallyBlock: suspend CoroutineScope.() -> Unit
    ) {

        requestTryCatch(tryBlock, successBlock, catchBlock, finallyBlock)

    }

    /**
     * 异常捕获处理
     */
    private suspend fun <T> requestTryCatch(
        responseBlock: suspend CoroutineScope.() -> BaseResponse<T>?,
        successBlock: suspend CoroutineScope.(T?) -> Unit,
        catchBlock: suspend CoroutineScope.(String?) -> Unit,
        finallyBlock: suspend CoroutineScope.() -> Unit
    ) {
        coroutineScope {
            try {
                val response = responseBlock()
                callResponse(
                    response, {
                        if (response?.data == null){
                            successBlock(Any() as T)
                        }else{
                            successBlock(response?.data)
                        }
                    }, {
                        catchBlock(response?.message)
                    }
                )
            } catch (e: Throwable) {
                catchBlock(ExceptionEngine.handleException(e))
            } finally {
                finallyBlock()
            }
        }
    }

    /**
     * 服务器请求数据处理
     */
    private suspend fun <T> callResponse(
        response: BaseResponse<T>?,
        successBlock: suspend CoroutineScope.() -> Unit,
        errorBlock: suspend CoroutineScope.() -> Unit
    ) {
        coroutineScope {
            when {
                response == null -> errorBlock()
                response.code == 0 -> successBlock()
                else -> errorBlock()
            }
        }
    }
}