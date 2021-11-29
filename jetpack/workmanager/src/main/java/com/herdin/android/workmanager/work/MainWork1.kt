package com.herdin.android.workmanager.work

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

/**
 *
 *
 * @author: herdin
 * @email： herdin@163.com
 * @date: 2021/11/26
 * @desc:
 * @version: V-1.0.0
 **/
class MainWork1(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {


    private val TAG: String? = MainWork1::class.java.simpleName

    override fun doWork(): Result {
        Log.d(TAG, "doWork: start")


        Log.d(TAG, "doWork: end")
        return Result.success()
    }
}