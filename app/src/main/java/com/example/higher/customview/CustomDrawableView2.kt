package com.example.higher.customview

import android.app.ActionBar.LayoutParams
import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import com.example.higher.R


class CustomDrawableView2 : View {
    private val mPaint: Paint = Paint()
    private val mRect: Rect = Rect()

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        val typeArray = context.obtainStyledAttributes(attributeSet, R.styleable.CustomDrawableView2)
        typeArray.recycle()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)
        Log.d("widthMode",widthMode.toString())
        Log.d("heightMode",heightMode.toString())
        Log.d("widthSize",widthSize.toString())
        Log.d("heightSize",heightSize.toString())

        var widthMeasured = 0
        var heightMeasured = 0
        when (widthMode) {
            MeasureSpec.EXACTLY -> {
                widthMeasured = widthSize
            }
            MeasureSpec.AT_MOST -> {
                widthMeasured = suggestedMinimumWidth.coerceAtMost(widthSize)
            }
            MeasureSpec.UNSPECIFIED -> {

            }
        }

        when (heightMode) {
            MeasureSpec.EXACTLY -> {
                heightMeasured = heightSize
            }
            MeasureSpec.AT_MOST -> {
                heightMeasured = suggestedMinimumHeight.coerceAtMost(heightSize)
            }
            MeasureSpec.UNSPECIFIED -> {

            }
        }
        setMeasuredDimension(widthMeasured, heightMeasured)
        mRect.set(0, 0, widthMeasured, heightMeasured)
        mPaint.color = Color.BLUE
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.drawRect(mRect!!, mPaint!!)
        super.onDraw(canvas)
    }
}