package com.example.helloworld.boardcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.helloworld.R

class BoardcastActivity : AppCompatActivity() {
    lateinit var btn1 :Button
    lateinit var tvTest:TextView
    private lateinit var  myBoardcast: MyBoardcast
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boardcast)

        btn1 = findViewById(R.id.btn_1)
        tvTest = findViewById(R.id.tv_test)
        btn1.setOnClickListener{
            var intent = Intent(this,Boardcast2Activity::class.java)
            startActivity(intent)
        }
        myBoardcast = MyBoardcast(tvTest)
        var intentFiter = IntentFilter()
        intentFiter.addAction("com.example.update")
        LocalBroadcastManager.getInstance(this).registerReceiver(myBoardcast,intentFiter)
        //实际可以用startActivityForResult
    }

    private class MyBoardcast(val tvTest: TextView) : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            when(intent?.action){
                "com.example.update"-> tvTest.text = "123"
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        LocalBroadcastManager.getInstance(this).unregisterReceiver(myBoardcast)
    }
}