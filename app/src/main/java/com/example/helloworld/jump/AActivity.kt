package com.example.helloworld.jump

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.helloworld.R

class AActivity : AppCompatActivity() {
    lateinit var jumpBtn :Button
    lateinit var jump2ABtn :Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aactivity)
        Log.d("AActivity","-----------onCreate-----------")
        Log.d("AActivity","taskId:"+taskId+",hash:"+hashCode())
        logtaskName()
        jumpBtn = findViewById(R.id.btn_jumpB)
        jumpBtn.setOnClickListener{v->
            //显示跳转1
            var intent = Intent(this,BActivity::class.java)
            var bundle = Bundle();
            bundle.putString("name","liweiwu")
            bundle.putInt("age",30)
            intent.putExtras(bundle)
            startActivity(intent)
            startActivityForResult(intent,0)
            //显示跳转2
//            var intent = Intent()
//            intent.setClass(this,BActivity::class.java)
//            startActivity(intent)

            //隐式
//            var intent = Intent()
//            intent.setAction("com.example.helloworld.jump.BActivity")
//            startActivity(intent)
        }

        jump2ABtn = findViewById(R.id.btn_jumpA)
        jump2ABtn.setOnClickListener{v->
            var intent = Intent(this,AActivity::class.java)
            startActivity(intent)

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Toast.makeText(this,data?.extras?.getString("title"),Toast.LENGTH_SHORT).show()
    }


    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d("AActivity","-----------onNewIntent-----------")
        Log.d("AActivity","taskId:"+taskId+",hash:"+hashCode())
        logtaskName()
    }
    fun logtaskName(){
        var info = packageManager.getActivityInfo(componentName,PackageManager.GET_META_DATA)
        Log.d("AActivity",info.taskAffinity)
    }
}