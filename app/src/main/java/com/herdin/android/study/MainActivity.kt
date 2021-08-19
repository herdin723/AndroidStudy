package com.herdin.android.study

import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.herdin.android.base.RouterPage
import com.herdin.android.base.activty.BaseActivity
import com.herdin.android.base.vm.BaseViewModel
import com.herdin.android.study.databinding.ActivityMainBinding

@Route(path = RouterPage.MAIN_MAIN)
class MainActivity : BaseActivity<ActivityMainBinding,BaseViewModel>() {

    fun onClick(view: View) {

        ARouter.getInstance().build(RouterPage.HINT_MAIN).navigation()
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        mBinding.text.text = "你好世界"
    }

    override fun initData() {

    }

    override fun initObservable() {

    }

    override fun isFullScreen(): Boolean {
        return true
    }
}