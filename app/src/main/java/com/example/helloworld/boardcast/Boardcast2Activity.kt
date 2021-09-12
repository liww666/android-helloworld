package com.example.helloworld.boardcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.helloworld.R

class Boardcast2Activity : AppCompatActivity() {

    lateinit var btn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boardcast2)

        btn = findViewById(R.id.btn_click)
        btn.setOnClickListener{
            var intent = Intent("com.example.update")
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
        }
    }


}