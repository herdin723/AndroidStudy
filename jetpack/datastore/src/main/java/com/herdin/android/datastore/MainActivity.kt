package com.herdin.android.datastore

import android.os.Bundle
import com.herdin.android.base.activty.BaseActivity
import com.herdin.android.base.activty.RootActivity

class MainActivity : RootActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ds_activity_main)
    }
}