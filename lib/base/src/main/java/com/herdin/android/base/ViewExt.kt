package com.herdin.android.base

import android.content.Context
import android.view.Gravity
import android.view.View
import android.widget.Toast

/**
 * Copyright © 2014-2021, ArcVideo 杭州当虹科技股份有限公司
 *
 * @author: herdin
 * @email： heding@arcvideo.com
 * @date: 2021/8/19
 * @desc:
 * @version: V-1.0.0
 **/
fun View.toVisible() {
    this.visibility = View.VISIBLE
}

fun View.toGone() {
    this.visibility = View.GONE
}

fun View.toInvisible() {
    this.visibility = View.INVISIBLE
}

fun Context.showToast(msg: String) {
    var toast: Toast? = null
    if (toast == null) {
        toast = Toast.makeText(this,msg,Toast.LENGTH_SHORT)
    } else {
        toast.setText(msg)
    }
    toast?.setGravity(Gravity.CENTER, 0, 0)
    toast?.show()
}