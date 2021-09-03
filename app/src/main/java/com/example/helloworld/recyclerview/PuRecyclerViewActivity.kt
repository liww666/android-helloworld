package com.example.helloworld.recyclerview

import android.content.res.Resources
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.helloworld.R

class PuRecyclerViewActivity : AppCompatActivity() {

    lateinit var puRv : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pu_recycler_view)
        puRv = findViewById(R.id.pu_rv)
        puRv.addItemDecoration(MyPuDecoration())
        var layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        puRv.layoutManager =layoutManager
        puRv.adapter = PuAdapter(this)
    }
}

class MyPuDecoration : RecyclerView.ItemDecoration(){
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.set(2,2,2,2,)
    }
}