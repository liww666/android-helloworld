package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.Toast

/**
 * 监听三要素：事件源、事件、事件监听器
 */
class EventActivity : AppCompatActivity(),View.OnClickListener {
    lateinit var  eventBtn : Button

    var  myBtn :Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)
        eventBtn = findViewById(R.id.btn_event)
        //当同一个事件源添加相同的监听器，系统只执行最后一个监听器，而且布局文件的onClick优先级最低
        //回调是先button后activity
        //监听器优先与回调
        eventBtn.setOnClickListener(OnClick())
        eventBtn.setOnClickListener{
            v->
            Toast.makeText(this,"click2222",Toast.LENGTH_SHORT).show()
        }
        eventBtn.setOnClickListener(this)

        myBtn = findViewById(R.id.btn_my)

    }
    class OnClick : View.OnClickListener{
        override fun onClick(v: View?) {
            when(v?.id){
                R.id.btn_event->{
                    Toast.makeText(v.context,"click...",Toast.LENGTH_SHORT).show()
                }

            }
        }

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_event->{
                Toast.makeText(v.context,"click333.",Toast.LENGTH_SHORT).show()
            }

        }
    }

    fun show(v:View?){
        when(v?.id){
            R.id.btn_event->{
                Toast.makeText(v.context,"click444",Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action){
            MotionEvent.ACTION_DOWN->{
                Log.d("EventActivity","-----onTouchEvent-----")
            }
        }

            return false
    }
}