package com.example.helloworld.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.helloworld.R

class HorRecyclerViewActivity : AppCompatActivity() {
    lateinit var  rvHor :RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hor_recycler_view)
        rvHor = findViewById(R.id.rv_hor)
         var layoutManager= LinearLayoutManager(this);
        layoutManager.orientation =  LinearLayoutManager.HORIZONTAL
        rvHor.layoutManager = layoutManager
        rvHor.adapter=HorAdapter(this)
    }
}