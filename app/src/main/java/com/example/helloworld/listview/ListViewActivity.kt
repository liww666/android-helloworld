package com.example.helloworld.listview

import android.app.Activity
import android.os.Bundle
import android.widget.ListView
import com.example.helloworld.R

class ListViewActivity : Activity() {

    lateinit var listView1 :ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
        listView1 = findViewById(R.id.lv_1)
    }
}