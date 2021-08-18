package com.herdin.android.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.herdin.android.base.RouterPage


@Route(path = RouterPage.ROOM_MAIN)
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.room_activity_main)
    }
}