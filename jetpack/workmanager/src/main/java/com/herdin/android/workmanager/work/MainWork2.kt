package com.herdin.android.workmanager.work

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.work.Data
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
class MainWork2(private val context: Context, private val workerParams: WorkerParameters) :
    Worker(context, workerParams) {


    private val TAG: String? = MainWork2::class.java.simpleName

    @SuppressLint("RestrictedApi")
    override fun doWork(): Result {
        Log.d(TAG, "doWork: start")

        //
        val name = workerParams.inputData.getString("kungfu")
        Log.d(TAG, "doWork: input data = $name")

        val outputData = Data.Builder()
            .putString("kungfu", "万剑归宗")
            .build()
        Log.d(TAG, "doWork: end")
        return Result.Success(outputData)
    }
}