package com.herdin.android.base.activty

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.launcher.ARouter

/**
 * Copyright © 2014-2021, ArcVideo 杭州当虹科技股份有限公司
 *
 * @author: herdin
 * @email： heding@arcvideo.com
 * @date: 2021/8/18
 * @desc:
 * @version: V-1.0.0
 **/
open class RootActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        if (isFullScreen()) {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        super.onCreate(savedInstanceState)

        ARouter.getInstance().inject(this)
    }

    open fun isFullScreen(): Boolean {
        return false
    }
    /**
     * 打开等待框 在这里实现你的等待框展示
     */
    open fun showLoading(message: String) {
        //...
    }

    /**
     * 关闭等待框 在这里实现你的等待框关闭
     */
    open fun dismissLoading() {
        //...
    }

    override fun onDestroy() {
        super.onDestroy()
        ARouter.getInstance().destroy()
    }


}