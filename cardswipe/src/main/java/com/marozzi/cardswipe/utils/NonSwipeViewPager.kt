package com.marozzi.requestactions.utils

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

/**
 * Created by amarozzi on 08/01/18.
 */
class NonSwipeViewPager : ViewPager {

    var enabledSwipe = true

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context) : super(context)

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return if (this.enabledSwipe) {
            super.onTouchEvent(event)
        } else false
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        return if (this.enabledSwipe) {
            super.onInterceptTouchEvent(event)
        } else false
    }
}