package com.example.gesture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.core.view.GestureDetectorCompat
import androidx.databinding.DataBindingUtil
import com.example.gesture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener,
GestureDetector.OnDoubleTapListener {
    private lateinit var mDetector: GestureDetector
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        mDetector = GestureDetector(this,this)
        mDetector.setOnDoubleTapListener(this)
        /*binding.textView.setOnTouchListener { view, motionEvent ->
            mDetector.onTouchEvent(motionEvent)
        }*/
    }
    override fun onTouchEvent(event: MotionEvent): Boolean {
        return if (mDetector.onTouchEvent(event)) {
            true
        } else {
            super.onTouchEvent(event)
        }
    }

    override fun onDown(event: MotionEvent): Boolean {
        binding.textView.text = "Down"
        Log.d("Gestures Android", "Down")
        return true
    }

    override fun onFling(
        p0: MotionEvent?,
        event1: MotionEvent,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        binding.textView.text = "onFling: $p0 $event1"
        Log.d("Gestures Android", "onFling: $p0 $event1")
        return true
    }

    override fun onLongPress(event: MotionEvent) {
        binding.textView.text = "onLongPress: $event"
        Log.d("Gestures Android", "onLongPress: $event")
    }

    override fun onScroll(
        p0: MotionEvent?,
        event1: MotionEvent,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        binding.textView.text = "onScroll: $p0 $event1"
        Log.d("Gestures Android", "onScroll: $p0 $event1")
        return true
    }

    override fun onShowPress(event: MotionEvent) {
        binding.textView.text = "onShowPress: $event"
        Log.d("Gestures Android", "onShowPress: $event")
    }

    override fun onSingleTapUp(event: MotionEvent): Boolean {
        binding.textView.text = "onSingleTapUp: $event"
        Log.d("Gestures Android", "onSingleTapUp: $event")
        return true
    }

    override fun onDoubleTap(event: MotionEvent): Boolean {
        binding.textView.text = "onDoubleTap: $event"
        Log.d("Gestures Android", "onDoubleTap: $event")
        return true
    }

    override fun onDoubleTapEvent(event: MotionEvent): Boolean {
        binding.textView.text = "onDoubleTapEvent: $event"
        Log.d("Gestures Android", "onDoubleTapEvent: $event")
        return true
    }

    override fun onSingleTapConfirmed(event: MotionEvent): Boolean {
        binding.textView.text = "onSingleTapConfirmed: $event"
        Log.d("Gestures Android", "onSingleTapConfirmed: $event")
        return true
    }
}