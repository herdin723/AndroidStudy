package com.herdin.android.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.work.Data
import androidx.work.OneTimeWorkRequest
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.herdin.android.base.RouterPage
import com.herdin.android.workmanager.work.*
import java.util.concurrent.TimeUnit


@Route(path = RouterPage.WORK_MAIN)
class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.work_activity_main)
    }

    fun onClick1(view: android.view.View) {
        //单个任务:ENQUEUED  RUNNING  SUCCESS
        val work = OneTimeWorkRequest.Builder(MainWork1::class.java).build()
        WorkManager.getInstance(this)
            .enqueue(work)
    }

    fun onClick2(view: android.view.View) {

        val inputData = Data.Builder()
            .putString("kungfu", "九阳神功")
            .build()
        val work = OneTimeWorkRequest.Builder(MainWork2::class.java)
            .setInputData(inputData)
            .build()

        WorkManager.getInstance(this)
            .getWorkInfoByIdLiveData(work.id)
            .observe(this) {
                if (it.state.isFinished) {
                    val name = it.outputData.getString("kungfu")
                    Toast.makeText(this, name, Toast.LENGTH_SHORT).show()
                    Log.d(TAG, "onClick2: output data = $name")
                }
            }
        WorkManager.getInstance(this).enqueue(work)

    }

    fun onClick3(view: android.view.View) {
        val work3 = OneTimeWorkRequest.Builder(MainWork3::class.java).build()
        val work4 = OneTimeWorkRequest.Builder(MainWork4::class.java).build()
        val work5 = OneTimeWorkRequest.Builder(MainWork5::class.java).build()
        val work6 = OneTimeWorkRequest.Builder(MainWork6::class.java).build()
//        WorkManager.getInstance(this)
//            .beginWith(work3)
//            .then(work4)
//            .then(work5)
//            .then(work6)
//            .enqueue()


        val list = mutableListOf<OneTimeWorkRequest>()
        list.add(work3)
        list.add(work4)
        list.add(work5)
        WorkManager.getInstance(this)
            .beginWith(list)
            .then(work6)
            .enqueue()
    }

    fun onClick4(view: android.view.View) {
        //轮循任务:ENQUEUED  RUNNING  至少15分钟一次
        val work = PeriodicWorkRequest.Builder(MainWork3::class.java, 10, TimeUnit.SECONDS)
            .build()

        WorkManager.getInstance(this)
            .getWorkInfoByIdLiveData(work.id)
            .observe(this) {

                Log.d(TAG, "onClick4: " + it.state.name)
                if (it.state.isFinished) {
                    Log.d(TAG, "onClick4:Finished " + it.state.name)
                }
            }
        WorkManager.getInstance(this).enqueue(work)

        //cancel task
//        WorkManager.getInstance(this).cancelWorkById(work.id)

    }

    fun onClick5(view: android.view.View) {

    }

    fun onClick6(view: android.view.View) {

        //源码分析
        /**
         * 第一次
         * initialize --->构建new WorkManagerImpl(Context,Configuration,TaskExecutor,WorkDatabase)
         *
         * context, configuration, workTaskExecutor, database, schedulers, processor
         * 1.上下文环境:
         * 2.配置信息:（执行信息，线程池任务）
         * 3.线程池:
         * 4.数据库:持久性保存任务，所以App杀死重启，一定会执行
         * 5.调度器:GreedyScheduler
         * 6.处理器:
         */
        val work = OneTimeWorkRequest.Builder(MainWork1::class.java).build()
        //第二次getInstance 首次在ContentProvider
        WorkManager.getInstance(this)
            //执行流程
            .enqueue(work)
    }
}