package com.example.helloworld

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class SecondActivity : AppCompatActivity() {

    lateinit var btn_1: Button

    lateinit var btn2: Button

    lateinit var editTextBtn : Button
    val tag:String = "SecondActivity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(tag,"on create")
        setContentView(R.layout.activity_second)
        btn_1 = findViewById<Button>(R.id.btn_1)
        btn_1.setOnClickListener { v ->
            var intnet = Intent(this@SecondActivity, TextViewActivity::class.java)
            v.setBackgroundColor(Color.RED)
            startActivity(intnet)
        }

        btn2 = findViewById<Button>(R.id.btn_2)
        btn2.setOnClickListener { v ->
            var intnet = Intent(this@SecondActivity, ButtonActivity::class.java)
            v.setBackgroundColor(Color.RED)
            startActivity(intnet)
        }

        editTextBtn = findViewById<Button>(R.id.btn_edittext)
        editTextBtn.setOnClickListener { v ->
            var intnet = Intent(this@SecondActivity, EditTextActivity::class.java)
            startActivity(intnet)
        }



    }

    override fun onStart() {
        super.onStart()
        Log.i(tag,"on start")
    }

    override fun onResume() {
        super.onResume()
        Log.i(tag,"on resume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(tag,"on pause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(tag,"on stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(tag,"on destroy")
    }
}