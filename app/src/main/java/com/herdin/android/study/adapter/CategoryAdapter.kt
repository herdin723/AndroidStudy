package com.herdin.android.study.adapter

import android.graphics.Color
import androidx.annotation.ColorInt
import androidx.cardview.widget.CardView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.herdin.android.study.bean.CategoryBean
import com.herdin.android.study.databinding.ItemCategoryBinding
import java.util.*

/**
 * Copyright © 2014-2021, ArcVideo 杭州当虹科技股份有限公司
 *
 * @author: herdin
 * @email： heding@arcvideo.com
 * @date: 2021/8/19
 * @desc:
 * @version: V-1.0.0
 **/
class CategoryAdapter(layoutId: Int) :
    BaseQuickAdapter<CategoryBean, BaseDataBindingHolder<ItemCategoryBinding>>(
        layoutId,
        data = null
    ) {
    override fun convert(holder: BaseDataBindingHolder<ItemCategoryBinding>, item: CategoryBean) {
        holder.dataBinding?.let { binding ->
            binding.bean = item
            binding.executePendingBindings()

            val cardView = binding.root as CardView
            cardView.setCardBackgroundColor(randomColor())
        }
    }

    @ColorInt
    fun randomColor(): Int{
        val random = Random()
        val r: Int = random.nextInt(256)
        val g: Int = random.nextInt(256)
        val b: Int = random.nextInt(256)
        if (Color.argb(255, r, g, b) == Color.BLACK) {
            return Color.WHITE
        }else if (Color.argb(255, r, g, b) == Color.BLACK){

        }
        return Color.argb(255, r, g, b)
    }

}