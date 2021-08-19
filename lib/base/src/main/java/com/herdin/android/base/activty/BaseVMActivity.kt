package com.herdin.android.base.activty

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.herdin.android.base.vm.BaseViewModel
import java.lang.reflect.ParameterizedType

/**
 * Copyright © 2014-2021, ArcVideo 杭州当虹科技股份有限公司
 *
 * @author: herdin
 * @email： heding@arcvideo.com
 * @date: 2021/8/18
 * @desc:
 * @version: V-1.0.0
 **/
class BaseVMActivity<VM : BaseViewModel> : RootActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        return (obj.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as VM
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}