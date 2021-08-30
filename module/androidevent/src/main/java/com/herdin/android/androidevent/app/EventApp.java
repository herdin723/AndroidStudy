package com.herdin.android.androidevent.app;

import android.app.Application;

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
    @Override
    public void onCreate() {
        super.onCreate();
        initModuleApp(this);
    }

    @Override
    public void initModuleApp(Application application) {

    }

    @Override
    public void initModuleData(Application application) {

    }
}
