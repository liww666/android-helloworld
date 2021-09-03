package com.example.helloworld.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.helloworld.R

class GridRecyclerViewActivity : AppCompatActivity() {

    lateinit var gridRv : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_recycler_view)
        gridRv  = findViewById(R.id.rv_grid)
        var layoutManager = GridLayoutManager(this,3)
        gridRv.layoutManager = layoutManager
        gridRv.adapter = GridAdapter(this)
    }
}