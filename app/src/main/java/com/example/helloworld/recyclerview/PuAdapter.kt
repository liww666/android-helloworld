package com.example.helloworld.recyclerview

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.recyclerview.widget.RecyclerView

import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.helloworld.R
import org.w3c.dom.Text


class PuAdapter(context:Context) : RecyclerView.Adapter<PuVH>() {

//    private var dataList: List<Char>? = null

    var context: Context

    init {
        this.context = context
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PuVH {
        return PuVH(LayoutInflater.from(context).inflate(R.layout.pu_rv_item, parent, false))
    }

    override fun onBindViewHolder(holder: PuVH, position: Int) {
       if(position%2==0){
          holder.iv.setImageResource(R.drawable.zrrtd)
       }else{
           holder.iv.setImageResource(R.drawable.smile)
       }
        holder.iv.setOnClickListener{v->
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

class PuVH(itemView: View) :RecyclerView.ViewHolder(itemView){

     var iv: ImageView = itemView.findViewById(R.id.iv)
}