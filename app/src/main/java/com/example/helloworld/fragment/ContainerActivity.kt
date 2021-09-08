package com.example.helloworld.fragment

import android.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

import com.example.helloworld.R
import kotlin.concurrent.fixedRateTimer

class ContainerActivity : AppCompatActivity() {
    lateinit var fgmtA: Fragment
    lateinit var changeBtn: Button
    lateinit var fgmtB: Fragment;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container)
        changeBtn = findViewById(R.id.btn_change)
        changeBtn.setOnClickListener { v ->
            if (!this::fgmtB.isInitialized) {
                fgmtB = BFragment();
            }
            fragmentManager.beginTransaction().replace(R.id.fl_container, fgmtB)
                .commitAllowingStateLoss()
        }
        fgmtA = AFragment()
        fragmentManager.beginTransaction().add(R.id.fl_container, fgmtA).commitAllowingStateLoss()
    }
}