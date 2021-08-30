package com.example.helloworld.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class MyListAdapter(context: Context): BaseAdapter() {
    lateinit var context :Context

    lateinit var mLayoutInflater: LayoutInflater

    init {
        mLayoutInflater = LayoutInflater.from(context)
    }

    override fun getCount(): Int {
        return 10
    }

    override fun getItem(position: Int): Any {
        TODO("Not yet implemented")
    }

    override fun getItemId(position: Int): Long {
        TODO("Not yet implemented")
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        TODO("Not yet implemented")
    }
}