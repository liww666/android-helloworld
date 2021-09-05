package com.example.helloworld.recyclerview

import android.content.Context
import androidx.recyclerview.widget.RecyclerView

import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.helloworld.R
import org.w3c.dom.Text


class LinerAdapter(context:Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

//    private var dataList: List<Char>? = null

    var context: Context

    init {
        this.context = context
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType==0){
            return VH(LayoutInflater.from(context).inflate(R.layout.activity_linear_item, parent, false))
        }
        return VH2(LayoutInflater.from(context).inflate(R.layout.layout_linear_item_2, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(getItemViewType(position)==0){
            holder as VH
            holder.tv.text= "hello LinearRecyclerView";
            holder.tv.setOnClickListener{v->
                Toast.makeText(this.context,"click..."+position,Toast.LENGTH_SHORT).show()
            }
        }else{
            holder as VH2
            holder.tv1.text= "hello LinearRecyclerView2";
            holder.tv1.setOnClickListener{v->
                Toast.makeText(this.context,"click..."+position,Toast.LENGTH_SHORT).show()
            }
        }

//        val c = dataList!![position]
//        holder.tv1.setText(c.toString())
//        holder.tv2.setText(Integer.valueOf(c.toInt()).toString())
    }

    override fun getItemCount(): Int {
        return 30
    }

    override fun getItemViewType(position: Int): Int {
        if(position%2==0){
            return 0;
        }
        return 1;
    }
}

class VH(itemView: View) :RecyclerView.ViewHolder(itemView){

     var tv: TextView = itemView.findViewById(R.id.tv_title)
}

class VH2(itemView:View):RecyclerView.ViewHolder(itemView){
    var tv1:TextView = itemView.findViewById(R.id.tv_title)
    var iv: ImageView = itemView.findViewById(R.id.linar_iv)
}