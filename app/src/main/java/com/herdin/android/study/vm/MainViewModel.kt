package com.herdin.android.study.vm

import androidx.lifecycle.MutableLiveData
import com.herdin.android.base.vm.BaseViewModel
import com.herdin.android.study.bean.CategoryBean

/**
 * Copyright © 2014-2021, ArcVideo 杭州当虹科技股份有限公司
 *
 * @author: herdin
 * @email： heding@arcvideo.com
 * @date: 2021/8/19
 * @desc:
 * @version: V-1.0.0
 **/
class MainViewModel : BaseViewModel() {

    private var list: MutableLiveData<MutableList<CategoryBean>>? = null


    fun getList(): MutableLiveData<MutableList<CategoryBean>>? {
        if (list == null) {
            list = MutableLiveData<MutableList<CategoryBean>>()
        }
        return list
    }

    fun postValue(){
        val list = ArrayList<CategoryBean>()
        for(i in 0..10){
            val categoryBean = CategoryBean()
            categoryBean.name = "类别$i"
            list.add(categoryBean)
        }
        getList()?.postValue(list)
    }

}