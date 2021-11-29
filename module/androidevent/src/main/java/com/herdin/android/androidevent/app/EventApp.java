package com.herdin.android.androidevent.app;

import android.app.Application;
import android.util.Log;

import com.herdin.android.base.app.BaseApplication;

/**
 * Copyright © 2014-2021, ArcVideo 杭州当虹科技股份有限公司
 *
 * @author: herdin
 * @email： heding@arcvideo.com
 * @date: 2021/8/30
 * @desc:
 * @version: V-1.0.0
 **/
public class EventApp extends BaseApplication {
    public static final String TAG = EventApp.class.getSimpleName();
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: event ");
        initModuleApp(this);
    }

    @Override
    public void initModuleApp(Application application) {
        Log.d(TAG, "initModuleApp: init event ");
    }

    @Override
    public void initModuleData(Application application) {

    }
}
