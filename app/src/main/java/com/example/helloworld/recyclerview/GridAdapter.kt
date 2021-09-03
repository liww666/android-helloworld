package com.example.helloworld.recyclerview

import android.content.Context
import androidx.recyclerview.widget.RecyclerView

import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.helloworld.R
import org.w3c.dom.Text


class GridAdapter(context:Context) : RecyclerView.Adapter<GridVH>() {

//    private var dataList: List<Char>? = null

    var context: Context

    init {
        this.context = context
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridVH {
        return GridVH(LayoutInflater.from(context).inflate(R.layout.layout_grid_item, parent, false))
    }

    override fun onBindViewHolder(holder: GridVH, position: Int) {
        holder.tv.text= "hello GridRecyclerView";
        holder.tv.setOnClickListener{v->
            Toast.makeText(this.context,"click..."+position,Toast.LENGTH_SHORT).show()
        }
//        val c = dataList!![position]
//        holder.tv1.setText(c.toString())
//        holder.tv2.setText(Integer.valueOf(c.toInt()).toString())
    }

    override fun getItemCount(): Int {
        return 30
    }

}

class GridVH(itemView: View) :RecyclerView.ViewHolder(itemView){

     var tv: TextView = itemView.findViewById(R.id.tv_title)
}