package com.example.helloworld

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class ButtonActivity : AppCompatActivity() {

    lateinit var btn3: Button
    lateinit var tv1 :TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button)
        btn3 = findViewById<Button>(R.id.btn_inner_3)
        btn3.setOnClickListener { v ->
            Toast.makeText(this,"btn3被点击了",Toast.LENGTH_SHORT).show()
        }

        tv1 = findViewById<Button>(R.id.tv_1)
        tv1.setOnClickListener { v ->
            Toast.makeText(this,"tv1被点击了",Toast.LENGTH_SHORT).show()
        }
    }

    fun showToast(view:View){
        Toast.makeText(this,"我被草了",Toast.LENGTH_LONG).show()
    }
}