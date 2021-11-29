package com.herdin.android.startup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.startup.AppInitializer
import com.herdin.android.startup.sdk.SdkDInitializer

class StartupMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.startup_activity_main)

        initSdkD()
    }

    private fun initSdkD() {
        Log.d(INIT_TAG, "Activity onCreate: ")
        //手动初始化 需配置node="remove"
        AppInitializer.getInstance(this).initializeComponent(SdkDInitializer::class.java)
    }
}