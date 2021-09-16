package com.example.helloworld.map

import android.content.Context
import androidx.recyclerview.widget.RecyclerView

import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.amap.api.maps.AMap
import com.example.helloworld.R
import org.w3c.dom.Text

import com.amap.api.maps.CameraUpdateFactory

import com.amap.api.maps.CameraUpdate
import com.amap.api.maps.model.*
import com.amap.api.navi.AmapNaviPage
import com.amap.api.navi.AmapNaviParams
import com.amap.api.navi.AmapNaviType
import com.amap.api.navi.AmapPageType


class MapDataAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

//    private var dataList: List<Char>? = null

    var context: Context

    var datas: ArrayList<PositionEntity> = ArrayList()

    lateinit  var mAMap : AMap
    lateinit var rv :RecyclerView

    init {
        this.context = context
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return VH(
            LayoutInflater.from(context).inflate(R.layout.activity_linear_item, parent, false)
        )

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == 0) {
            holder as VH
            holder.tv.text = datas[position].address;
            holder.tv.setOnClickListener { v ->
                Toast.makeText(this.context, "click..." + position, Toast.LENGTH_SHORT).show()
                doLocate(position)
                startNavigation(this.context,datas[position])
                datas = ArrayList();
                this.notifyDataSetChanged()

            }
        } else {
            holder as VH2
            holder.tv1.text = "hello LinearRecyclerView2";
            holder.tv1.setOnClickListener { v ->
                Toast.makeText(this.context, "click..." + position, Toast.LENGTH_SHORT).show()
            }
        }

//        val c = dataList!![position]
//        holder.tv1.setText(c.toString())
//        holder.tv2.setText(Integer.valueOf(c.toInt()).toString())
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun getItemViewType(position: Int): Int {
//        if(position%2==0){
//            return 0;
//        }
        return 0;
    }
    fun doLocate(position: Int){
        var positionEntity = datas[position]
        val cameraPosition = CameraPosition(LatLng(positionEntity.latitue, positionEntity.longitude), 15f, 0f, 30f)
        val cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition)
        mAMap.moveCamera(cameraUpdate)
        drawMarkers(positionEntity.latitue,positionEntity.longitude)
    }

    fun drawMarkers(latitude:Double,longitude:Double) {
        val markerOptions = MarkerOptions()
            .position(LatLng(latitude, longitude))
            .icon(BitmapDescriptorFactory.fromResource(R.drawable.smile))
            .draggable(true)
        val marker: Marker = mAMap.addMarker(markerOptions)
        marker.showInfoWindow()
    }

    fun startNavigation(applicationContext:Context,loaction:PositionEntity){
        //构建导航组件配置类，没有传入起点，所以起点默认为 “我的位置”
        //构建导航组件配置类，没有传入起点，所以起点默认为 “我的位置”
        val params = AmapNaviParams(null, null, null, AmapNaviType.DRIVER, AmapPageType.ROUTE)
//启动导航组件
//启动导航组件
        AmapNaviPage.getInstance().showRouteActivity(applicationContext, params, null)
        //起点
        //起点
//        val start = Poi("北京首都机场", LatLng(40.080525, 116.603039), "B000A28DAE")
//途经点
//途经点
        val poiList: MutableList<Poi> = ArrayList()
//        poiList.add(Poi("故宫", LatLng(39.918058, 116.397026), "B000A8UIN8"))
//终点
//终点
        val end = Poi(loaction.address, LatLng(loaction.latitue, loaction.longitude),null)
// 组件参数配置
// 组件参数配置
        val params2 = AmapNaviParams(null, poiList, end, AmapNaviType.DRIVER, AmapPageType.ROUTE)
// 启动组件
// 启动组件
        AmapNaviPage.getInstance().showRouteActivity(applicationContext, params2, null)
    }
}

class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var tv: TextView = itemView.findViewById(R.id.tv_title)
}

class VH2(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var tv1: TextView = itemView.findViewById(R.id.tv_title)
    var iv: ImageView = itemView.findViewById(R.id.linar_iv)
}