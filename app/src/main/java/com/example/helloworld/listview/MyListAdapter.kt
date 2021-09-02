package com.example.helloworld.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.helloworld.R

class MyListAdapter(context: Context) : BaseAdapter() {
    lateinit var context: Context

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
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var viewHolder: ViewHolder? = null
        var view: View? = null
        if(convertView==null){
            view = mLayoutInflater.inflate(R.layout.activity_list_item,null)
            viewHolder = ViewHolder()
            viewHolder.imageView = view.findViewById(R.id.lv_iv)
            viewHolder.tvTime = view.findViewById(R.id.lv_tv_2)
            viewHolder.tvContent = view.findViewById(R.id.lv_tv_3)
            viewHolder.tvTitle = view.findViewById(R.id.lv_tv_1)
            view.tag = viewHolder
        }else{
            view  = convertView
            viewHolder = view.tag as ViewHolder
        }
//        viewHolder.tvTitle
        return view!!
    }
}

class ViewHolder {
    lateinit var imageView: ImageView
    lateinit var tvTitle: TextView
    lateinit var tvTime: TextView
    lateinit var tvContent: TextView

}