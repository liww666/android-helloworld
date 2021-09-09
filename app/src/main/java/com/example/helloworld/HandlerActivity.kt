package com.example.helloworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.widget.Toast

class HandlerActivity : AppCompatActivity() {

    lateinit var handler:Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handler)
//        handler = Handler();
//        handler.postDelayed(Runnable {
//            var intent = Intent(this,ButtonActivity::class.java)
//            startActivity(intent)
//        },3000)
        handler = Handler{
            msg->
            run {
                when (msg.what) {
                    1 -> {
                        Toast.makeText(this, "线程通信成功", Toast.LENGTH_SHORT).show()
                    }
                }

            }
            return@Handler true
        }

        var t = Thread{
            var msg = Message()
            msg.what=1
            handler.sendMessage(msg)
        }
        t.start()
    }
}