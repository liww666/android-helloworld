package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class EditTextActivity : AppCompatActivity() {

    lateinit var loginBtn :Button
    lateinit var et :EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_text)

        loginBtn = findViewById<Button>(R.id.login_btn)
        loginBtn.setOnClickListener{
            v->Toast.makeText(this.baseContext,"登录成功",Toast.LENGTH_SHORT).show()
        }

        et = findViewById<EditText>(R.id.et_1)
        et?.addTextChangedListener(
            object:TextWatcher{
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    Log.d("EditTextActivity", p0.toString());
                }

                override fun afterTextChanged(p0: Editable?) {

                }

            }
        )

    }
}