package com.example.helloworld

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat.startActivity

class SecondActivity : AppCompatActivity() {

    lateinit var btn_1: Button

    lateinit var btn2: Button

    lateinit var editTextBtn : Button

    lateinit var radioBtn : Button

    lateinit var checkBox :Button

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

        radioBtn = findViewById<Button>(R.id.btn_radio)
        radioBtn.setOnClickListener { v ->
            var intnet = Intent(this@SecondActivity, RadioButtonActivity::class.java)
            startActivity(intnet)
        }

        checkBox = findViewById(R.id.btn_checkbox)
        checkBox.setOnClickListener { v ->
            var intnet = Intent(this@SecondActivity, CheckBoxActivity::class.java)
            startActivity(intnet)
        }


    }

    private  fun setListener(){
        var onclick : Onclick = Onclick()
        btn_1.setOnClickListener(onclick)
        btn2.setOnClickListener(onclick)
        editTextBtn.setOnClickListener(onclick)
        radioBtn.setOnClickListener(onclick)
    }

    class Onclick : View.OnClickListener{
        override fun onClick(p0: View?) {
            var intnet :Intent= Intent()

                when(p0?.id){
                    R.id.btn_1->{
                        intnet.setClass(p0.context, TextViewActivity::class.java)
//                        startActivity(intnet)
                    }
                    R.id.btn_2->{
                        intnet.setClass(p0.context, ButtonActivity::class.java)
                    }
                    R.id.btn_edittext->{
                        intnet.setClass(p0.context, EditTextActivity::class.java)
                    }
                    R.id.btn_radio->{
                        intnet.setClass(p0.context, RadioButtonActivity::class.java)

                    }
                    else->{}
                }






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