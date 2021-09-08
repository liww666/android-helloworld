package com.example.helloworld.jump

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.helloworld.R

class BActivity : AppCompatActivity() {

    lateinit var titleTv :TextView

    lateinit var finishBtn :Button

    lateinit var btn2:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bactivity)

        Log.d("BActivity","-----------onCreate-----------")
        Log.d("BActivity","taskId:"+taskId+",hash:"+hashCode())
        logtaskName()

        titleTv = findViewById(R.id.tv_title)
        var bundle = intent.extras
        var name = bundle?.get("name")
        var age = bundle?.get("age")
        titleTv.setText(name.toString()+":"+age)

        finishBtn = findViewById(R.id.btn_finish)
        finishBtn.setOnClickListener{v->
            var bu = Bundle()
            bu.putString("title","我回来了")

            var intent = Intent()
            intent.putExtras(bu)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }

        btn2 = findViewById(R.id.btn_jumpA)
        btn2.setOnClickListener{v->
            var intent = Intent(this,AActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d("BActivity","-----------onNewIntent-----------")
        Log.d("BActivity","taskId:"+taskId+",hash:"+hashCode())
        logtaskName()
    }
    fun logtaskName(){
        var info = packageManager.getActivityInfo(componentName, PackageManager.GET_META_DATA)
        Log.d("BActivity",info.taskAffinity)
    }
}