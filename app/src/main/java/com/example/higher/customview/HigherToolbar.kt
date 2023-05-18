package com.example.higher.customview

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import com.example.higher.R
import com.example.higher.databinding.LayoutToolbarBinding

class HigherToolbar(context: Context, attributeSet: AttributeSet) :
    RelativeLayout(context, attributeSet) {
    private lateinit var highToolbarBinding: LayoutToolbarBinding

    init {
        initView(context, attributeSet)
    }


    private fun initView(context: Context, attributeSet: AttributeSet) {
        highToolbarBinding = LayoutToolbarBinding.inflate(LayoutInflater.from(context), this, true)
        val typeArray = context.obtainStyledAttributes(attributeSet, R.styleable.HigherToolbar)
        typeArray.run {
            highToolbarBinding.txtTitle.text =
                this.getString(R.styleable.HigherToolbar_toolbar_title)
        }

        highToolbarBinding.txtTitle.setTextColor(
            typeArray.getColor(
                R.styleable.HigherToolbar_toolbar_color_title, Color.WHITE
            )
        )
        highToolbarBinding.imgButtonLeft.setImageResource(
            typeArray.getResourceId(
                R.styleable.HigherToolbar_toolbar_image_left, R.drawable.ic_black_back
            )
        )
        highToolbarBinding.imgButtonRight.setImageResource(
            typeArray.getResourceId(
                R.styleable.HigherToolbar_toolbar_image_right, R.drawable.ic_black_back
            )
        )
        highToolbarBinding.viewToolbar.setBackgroundColor(
            typeArray.getColor(
                R.styleable.HigherToolbar_toolbar_background,
                ContextCompat.getColor(context, android.R.color.transparent)
            )
        )
        typeArray.recycle()
    }

}
