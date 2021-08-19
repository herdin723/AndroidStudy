package com.herdin.android.base.activty

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.herdin.android.base.vm.BaseViewModel

import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.lifecycle.ViewModelProvider
import java.lang.reflect.ParameterizedType


/**
 * Copyright © 2014-2021, ArcVideo 杭州当虹科技股份有限公司
 *
 * @author: herdin
 * @email： heding@arcvideo.com
 * @date: 2021/8/18
 * @desc:
 * @version: V-1.0.0
 */
abstract class BaseActivity<DB : ViewDataBinding , VM : BaseViewModel> : RootActivity() {

    protected lateinit var mBinding: DB
    protected lateinit var mViewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, getLayoutId())
        mBinding?.run {
            executePendingBindings()
            lifecycleOwner = this@BaseActivity
        }
        mViewModel = createViewModel()
        initView()
        initData()
        initObservable()
    }


    /**
     * 创建viewModel
     */
    private fun createViewModel(): VM {
        return ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory(application)
        ).get(getVM(this))

    }

    private fun <VM> getVM(obj: Any): VM {
        return (obj.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[1] as VM
    }


    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun initView()

    abstract fun initData()

    abstract fun initObservable()





}