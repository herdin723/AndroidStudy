package com.herdin.android.network.bean

/**
 * @author: dpq
 * @date: 2020/8/20
 * @email: dpq@arcvideo.com
 * @version: 2.5.0
 * @desc: 网络请求返回的数据基类
 */
data class BaseResponse<Any>( val code :Int = -1, val message:String = "", val data:Any? = null)


