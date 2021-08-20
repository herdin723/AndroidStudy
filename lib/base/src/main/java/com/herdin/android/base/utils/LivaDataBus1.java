package com.herdin.android.base.utils;

import androidx.lifecycle.MutableLiveData;

import java.util.Map;

/**
 * Copyright © 2014-2021, ArcVideo 杭州当虹科技股份有限公司
 *
 * @author: herdin
 * @email： heding@arcvideo.com
 * @date: 2021/8/19
 * @desc:
 * @version: V-1.0.0
 **/
public class LivaDataBus1 {

    private Map<String, MutableLiveData<Object>> bus;

    private static LivaDataBus1 sLivaDataBus = new LivaDataBus1();

    public static LivaDataBus1 getInstance(){
        return sLivaDataBus;
    }

    public synchronized <T> MutableLiveData<Object> with(String key,Class<T> type){
        if (!bus.containsKey(key)){
            bus.put(key,new MutableLiveData<Object>());
        }
        return bus.get(key);
    }
}
