package com.example.helloworld

import android.graphics.Paint
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class TextViewActivity : AppCompatActivity() {
    lateinit var tv: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_view)
        tv = findViewById<TextView>(R.id.tx_3)
        var icon :Drawable = resources.getDrawable(R.drawable.more_unfold);
        icon.setBounds(0,0,80,100);
        tv.setCompoundDrawables(null,null,icon,null)//icon

        val tx4 :TextView = findViewById<TextView>(R.id.tx_4)
        tx4.paint.flags=(Paint.STRIKE_THRU_TEXT_FLAG)//中划线
        tx4.paint.isAntiAlias= true

        val tx5 :TextView = findViewById<TextView>(R.id.tx_5)
        tx5.paint.flags = Paint.UNDERLINE_TEXT_FLAG//下划线

        val tx6 :TextView = findViewById<TextView>(R.id.tx_6)
        tx6.text="<u>ddddddddd</u>"
    }
}