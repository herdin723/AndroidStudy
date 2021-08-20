package com.herdin.android.base.app;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Copyright © 2014-2021, ArcVideo 杭州当虹科技股份有限公司
 *
 * @author: herdin
 * @email： heding@arcvideo.com
 * @date: 2021/8/18
 * @desc:
 * @version: V-1.0.0
 **/
public abstract class BaseApplication extends Application {

    public static final String TAG = BaseApplication.class.getSimpleName();
    protected Context mContext;
    private boolean mIsDebug = true;
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: base");
        mContext = this;
        // 这两行必须写在init之前，否则这些配置在init过程中将无效
        if (isDebug()) {
            // 打印日志
            ARouter.openLog();
            // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.openDebug();
        }
        // 尽可能早，推荐在Application中初始化
        ARouter.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        ARouter.getInstance().destroy();
    }

    public boolean isDebug(){
        return mIsDebug;
    }

    public void setDebug(boolean debug) {
        mIsDebug = debug;
    }

    /**
     * Application 初始化
     * @param application
     */
    public abstract void initModuleApp(Application application);

    /**
     * 所有 Application 初始化后的自定义操作
     *  @param application
     */
    public abstract void initModuleData(Application application);
}
