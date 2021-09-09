package com.example.helloworld.widget

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatButton

class MyButton(context : Context) :AppCompatButton(context) {
    var c: Context? = null
    init {
        this.c = context
    }

    /**
     * 自定义组件
     * 须实现三个构造函数
     */
    constructor(context : Context,str:String):this(context){}
    constructor(context: Context,attrs :AttributeSet):this(context)
    constructor(context: Context,attrs: AttributeSet,defStyle:Int):this(context)
    /**
     * 基于回调
     */
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        super.onTouchEvent(event)
        when(event?.action){
            MotionEvent.ACTION_DOWN->
            { Log.d("MyButton","-----onTouchEvent-----")}
        }
        //return true表示事件不继续传播
        return false
    }
}