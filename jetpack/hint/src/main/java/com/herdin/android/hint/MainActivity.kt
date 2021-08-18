package com.herdin.android.hint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.herdin.android.base.RouterPage

@Route(path = RouterPage.HINT_MAIN)
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hint_activity_main)
    }

    fun onClick(view: View) {
        ARouter.getInstance().build(RouterPage.ROOM_MAIN).navigation()
    }
}