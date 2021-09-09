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

    fun postValue() {
        val data = ArrayList<CategoryBean>()

        val categoryBean = CategoryBean()
        categoryBean.name = "Jetpack Hint"
        data.add(categoryBean)

        val categoryBean1 = CategoryBean()
        categoryBean1.name = "Jetpack Room"
        data.add(categoryBean1)

        val categoryBean2 = CategoryBean()
        categoryBean2.name = "Jetpack Datastore"
        data.add(categoryBean2)

        val categoryBean3 = CategoryBean()
        categoryBean3.name = "Android Event"
        data.add(categoryBean3)

        val categoryBean4 = CategoryBean()
        categoryBean4.name = "Kotlin DSL"
        data.add(categoryBean4)

        val categoryBean5 = CategoryBean()
        categoryBean5.name = "Kotlin Flow"
        data.add(categoryBean5)

        getList()?.postValue(data)
    }

}