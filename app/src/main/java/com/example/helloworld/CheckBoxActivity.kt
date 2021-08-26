package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.Toast

class CheckBoxActivity : AppCompatActivity() {

    lateinit var cb1: CheckBox
    lateinit var cb2: CheckBox
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_box)
        cb1 = findViewById(R.id.cb_1)
        cb2 = findViewById(R.id.cb_2)
        cb1.setOnCheckedChangeListener { buttonView, isChecked ->
            var text :String = if (isChecked) "选中" else "未选中"
            Toast.makeText(this, buttonView.text.toString().plus(text), Toast.LENGTH_SHORT).show()
        }

        cb2.setOnCheckedChangeListener { buttonView, isChecked ->
            var text :String = if (isChecked) "选中" else "未选中"
            Toast.makeText(this, buttonView.text.toString().plus(text), Toast.LENGTH_SHORT).show()
        }
    }
}