package com.herdin.android.study.activity

import android.content.Context
import android.content.pm.PackageManager
import android.view.View
import androidx.lifecycle.Observer
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.herdin.android.base.RouterPage
import com.herdin.android.base.activty.BaseActivity
import com.herdin.android.study.R
import com.herdin.android.study.adapter.CategoryAdapter
import com.herdin.android.study.bean.CategoryBean
import com.herdin.android.study.databinding.ActivityMainBinding
import com.herdin.android.study.vm.MainViewModel


@Route(path = RouterPage.MAIN_MAIN)
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    fun onClick(view: View) {

        ARouter.getInstance().build(RouterPage.DATASTORE_MAIN).navigation()
    }


    private val mAdapter by lazy {
        CategoryAdapter(R.layout.item_category)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        mBinding.adapter = mAdapter

        mAdapter.setOnItemClickListener { _, _, position ->
            when (position) {
                0 -> ARouter.getInstance().build(RouterPage.HINT_MAIN).navigation()
                1 -> ARouter.getInstance().build(RouterPage.ROOM_MAIN).navigation()
                2 -> ARouter.getInstance().build(RouterPage.DATASTORE_MAIN).navigation()
                3 -> ARouter.getInstance().build(RouterPage.WORK_MAIN).navigation()
                4 -> ARouter.getInstance().build(RouterPage.EVENT_MAIN).navigation()
                5 -> ARouter.getInstance().build(RouterPage.DSL_MAIN).navigation()
                6 -> ARouter.getInstance().build(RouterPage.FLOW_MAIN).navigation()
            }
        }
    }

    override fun initData() {
        mBinding.textChannel.text = getChannelName(this)
        mViewModel.postValue()
    }

    override fun initObservable() {
//        LiveDataBus.with("1111", String::class.java)?.postValue("22222")
//
//        LiveDataBus.with("1111", String::class.java)?.observe(this, Observer {
//            showToast(it.toString())
//        })
//        lifecycle.addObserver(mViewModel)

        val observer = Observer<MutableList<CategoryBean>> {
            mAdapter.setNewInstance(list = it)
        }
        mViewModel.getList()?.observe(this, observer)
    }


    override fun isFullScreen(): Boolean {
        return true
    }

    //获取当前渠道
    private fun getChannelName(context: Context): String? {
        var channelName: String? = null
        val packageManager = context.packageManager
        if (packageManager != null) {
            val applicationInfo =
                packageManager.getApplicationInfo(context.packageName, PackageManager.GET_META_DATA)
            if (applicationInfo != null) {
                if (applicationInfo.metaData != null) {
                    channelName = applicationInfo.metaData["CHANNEL"].toString()
                }
            }
        }
        return channelName
    }

}