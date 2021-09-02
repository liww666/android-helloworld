package com.example.helloworld.listview

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.example.helloworld.R

class ListViewActivity : Activity() {

    lateinit var listView1 :ListView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        listView1 = findViewById(R.id.lv_1)
        listView1.adapter= MyListAdapter(this)
        listView1.setOnItemClickListener{ _: AdapterView<*>, _: View, i: Int, _: Long ->
            Toast.makeText(this, "点击 pos:$i",Toast.LENGTH_SHORT).show()
        }
        listView1.onItemLongClickListener= AdapterView.OnItemLongClickListener{
                adapterView: AdapterView<*>, view1: View, i: Int, l: Long ->
            Toast.makeText(this, "长按 pos:$i",Toast.LENGTH_SHORT).show()
            true

        }
    }
}