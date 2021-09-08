package com.example.helloworld.fragment

import android.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

import com.example.helloworld.R
import org.w3c.dom.Text
import kotlin.concurrent.fixedRateTimer

class ContainerActivity : AppCompatActivity() ,AFragment.IOnMsgClick{
    lateinit var fgmtA: Fragment
    lateinit var changeBtn: Button
    lateinit var fgmtB: Fragment;

    lateinit var tv:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container)
//        changeBtn = findViewById(R.id.btn_change)
//        changeBtn.setOnClickListener { v ->
//            if (!this::fgmtB.isInitialized) {
//                fgmtB = BFragment();
//            }
//            fragmentManager.beginTransaction().replace(R.id.fl_container, fgmtB)
//                .commitAllowingStateLoss()
//        }
        fgmtA = AFragment.newInstance("我是参数")
        fragmentManager.beginTransaction().add(R.id.fl_container, fgmtA,"a").commitAllowingStateLoss()
        tv = findViewById(R.id.tv_title)
    }

    fun setData(title:String){
        tv.setText(title)
    }

    override fun onClick(text: String) {

        tv.setText(text)
    }
}