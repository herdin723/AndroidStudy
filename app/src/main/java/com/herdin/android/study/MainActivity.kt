package com.herdin.android.study

import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.herdin.android.base.BaseActivity
import com.herdin.android.base.RouterPage

@Route(path = RouterPage.MAIN_MAIN)
class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(view: View) {
        ARouter.getInstance().build(RouterPage.HINT_MAIN).navigation()
    }
}