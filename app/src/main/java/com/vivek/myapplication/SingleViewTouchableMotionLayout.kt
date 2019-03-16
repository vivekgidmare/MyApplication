package com.vivek.myapplication

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.constraintlayout.motion.widget.MotionLayout

class SingleViewTouchableMotionLayout(context: Context, attributeSet: AttributeSet? = null) : MotionLayout(context, attributeSet) {

    private val viewToDetectTouch by lazy {
        findViewById<View>(R.id.content)
    }
    private var touchStarted = false
    private val viewRect = Rect()

    init {
        setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {

            }

            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {

            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {

            }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                touchStarted = false
            }
        })
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event?.let {

            when (it.actionMasked) {
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                    touchStarted = true
                    return super.onTouchEvent(it)
                }
            }
            if (!touchStarted) {
                viewToDetectTouch.getHitRect(viewRect)
                touchStarted = viewRect.contains(it.x.toInt(), it.y.toInt())
            }
        }
        return touchStarted && super.onTouchEvent(event)
    }
}