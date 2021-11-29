package com.herdin.android.study.app;

import com.herdin.android.hint.app.HintApp;

/**
 * Copyright © 2014-2021, ArcVideo 杭州当虹科技股份有限公司
 *
 * @author: herdin
 * @email： heding@arcvideo.com
 * @date: 2021/8/18
 * @desc:
 * @version: V-1.0.0
 **/
public class AppConfig2 {
    public static final String[] APPS = {
            HintApp.class.getPackage().getName(),
//            "com.herdin.android.hint.app.HintApp",
            "com.herdin.android.room.app.RoomApp",
            "com.herdin.android.datastore.app.DataStoreApp",
            "com.herdin.android.workmanager.app.WorkManagerApp",
            "com.herdin.android.androidevent.app.EventApp",
            "com.herdin.android.dsl.app.DSLApp",
            "com.herdin.android.flow.app.FlowApp",
    };
}
