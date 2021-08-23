package com.herdin.android.study.utils;

import com.herdin.android.study.BuildConfig;

/**
 * Copyright © 2014-2021, ArcVideo 杭州当虹科技股份有限公司
 *
 * @author: herdin
 * @email： heding@arcvideo.com
 * @date: 2021/8/23
 * @desc:
 * @version: V-1.0.0
 **/
public class FlavorUtils {

    public static boolean isMain() {
        return "main".equals(BuildConfig.FLAVOR);
    }


    public static boolean isApp2() {
        return "app2".equals(BuildConfig.FLAVOR);
    }
}
