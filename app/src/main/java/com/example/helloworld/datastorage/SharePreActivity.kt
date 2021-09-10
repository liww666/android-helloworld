package com.example.helloworld.datastorage

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.helloworld.R


/**
 * SharedPreferences 轻量级数据存储
 * 数据存在/data/data/{applicationId}/shared_prefs
 */
class SharePreActivity : AppCompatActivity() {
    lateinit var nameET: EditText
    lateinit var saveBtn: Button
    lateinit var showBtn: Button
    lateinit var showTv: TextView
    lateinit var sharePre:SharedPreferences
    lateinit var spEditor:SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_pre)


        sharePre = getSharedPreferences("data", MODE_PRIVATE)
        spEditor = sharePre.edit()


        nameET = findViewById(R.id.et_name)
        saveBtn = findViewById(R.id.btn_save)

        showBtn = findViewById(R.id.btn_show)
        showTv = findViewById(R.id.tv_show)
        saveBtn.setOnClickListener{
            spEditor.putString("name",nameET.text.toString())
            // spEditor.commit()//存内存和存磁盘同步的
            spEditor.apply()//存内存和存磁盘是异步的(优先使用)
        }
        showBtn.setOnClickListener{
            showTv.text = sharePre.getString("name","")
        }



    }
}