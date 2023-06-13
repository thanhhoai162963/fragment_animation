package com.example.higher.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.example.higher.R
import com.example.higher.databinding.LayoutToolbarBinding


class HigherToolbar : LinearLayout {
    private lateinit var mBinding: LayoutToolbarBinding
    private var mListener1 : (()->Unit)? = null
    private var mListener2 : (()->Unit)? = null
    private var mListener3 : OnCLickListener1? = null

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        mBinding = LayoutToolbarBinding.inflate(LayoutInflater.from(context), this, true)
        val typeArray = context.obtainStyledAttributes(attributeSet, R.styleable.HigherToolbar)
        mBinding.txtTitle.text = typeArray.getString(R.styleable.HigherToolbar_toolbar_title)
        mBinding.imgButtonLeft.setImageResource(typeArray.getResourceId(R.styleable.HigherToolbar_toolbar_image_left,R.drawable.ic_black_back))
        mBinding.imgButtonRight.setImageResource(typeArray.getResourceId(R.styleable.HigherToolbar_toolbar_image_right,R.drawable.ic_black_back))

        mBinding.imgButtonLeft.setOnClickListener {
            mListener1?.invoke()
            mListener3?.clickLeft()
        }
        mBinding.imgButtonRight.setOnClickListener {
            mListener2?.invoke()
        }
        typeArray.recycle()
    }

    fun setOnListener(listenerLeft: () -> Unit,listenerRight: () -> Unit){
       mListener1 = listenerLeft
       mListener2 = listenerRight
    }
    fun setOnListener2(listener3: OnCLickListener1){
        mListener3 =listener3
    }
    interface OnCLickListener1{
        fun clickLeft()
        fun clickRight()
    }
}