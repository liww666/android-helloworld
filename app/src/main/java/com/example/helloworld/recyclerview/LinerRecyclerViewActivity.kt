package com.example.helloworld.recyclerview

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.helloworld.R

class LinerRecyclerViewActivity : AppCompatActivity() {

    lateinit var rv :RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_liner_recycler_view)
        rv = findViewById(R.id.rv_main)
        rv.layoutManager = LinearLayoutManager(this)
        rv.addItemDecoration(MyDecoration())
        rv.adapter = LinerAdapter(this)
    }
}
class MyDecoration : RecyclerView.ItemDecoration(){
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.set(0,0,0,1)
    }
}