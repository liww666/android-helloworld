package com.example.helloworld

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.helloworld.boardcast.BoardcastActivity
import com.example.helloworld.datastorage.DataStorageActivity
import com.example.helloworld.fragment.ContainerActivity
import com.example.helloworld.jump.AActivity
import com.example.helloworld.listview.ListViewActivity
import com.example.helloworld.map.MapActivity
import com.example.helloworld.recyclerview.RecylerViewActivity
import com.amap.api.navi.AmapNaviPage

import com.amap.api.navi.AmapPageType

import com.amap.api.navi.AmapNaviType

import com.amap.api.navi.AmapNaviParams
import com.amap.api.maps.model.LatLng

import com.amap.api.maps.model.Poi








class SecondActivity : AppCompatActivity() {

    lateinit var btn_1: Button

    lateinit var btn2: Button

    lateinit var editTextBtn: Button

    lateinit var radioBtn: Button

    lateinit var checkBox: Button

    lateinit var imageViewBtn: Button

    lateinit var mapBtn: Button

    lateinit var listViewBtn: Button

    lateinit var recyclerViewBtn: Button

    lateinit var webViewBtn: Button

    lateinit var dialogBtn: Button

    lateinit var jumpBtn: Button

    lateinit var fgmtBtn: Button

    lateinit var eventBtn: Button

    lateinit var handlerBtn :Button

    lateinit var dataBtn :Button

    lateinit var boardcastBtn :Button

    lateinit var navBtn :Button

    lateinit var gaodeBtn:Button

    lateinit var retBtn:Button

    val tag: String = "SecondActivity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(tag, "on create")
        setContentView(R.layout.activity_second)
        btn_1 = findViewById<Button>(R.id.btn_1)
        btn_1.setOnClickListener { v ->
            var intnet = Intent(this@SecondActivity, TextViewActivity::class.java)
            v.setBackgroundColor(Color.RED)
            startActivity(intnet)
        }

        btn2 = findViewById<Button>(R.id.btn_2)
        btn2.setOnClickListener { v ->
            var intnet = Intent(this@SecondActivity, ButtonActivity::class.java)
            v.setBackgroundColor(Color.RED)
            startActivity(intnet)
        }

        editTextBtn = findViewById<Button>(R.id.btn_edittext)
        editTextBtn.setOnClickListener { v ->
            var intnet = Intent(this@SecondActivity, EditTextActivity::class.java)
            startActivity(intnet)
        }

        radioBtn = findViewById<Button>(R.id.btn_radio)
        radioBtn.setOnClickListener { v ->
            var intnet = Intent(this@SecondActivity, RadioButtonActivity::class.java)
            startActivity(intnet)
        }

        checkBox = findViewById(R.id.btn_checkbox)
        checkBox.setOnClickListener {
            var intnet = Intent(this@SecondActivity, CheckBoxActivity::class.java)
            startActivity(intnet)
        }

        imageViewBtn = findViewById(R.id.btn_imageview)
        imageViewBtn.setOnClickListener { v ->
            Log.d("ddd", v.toString())
            var intent = Intent(this@SecondActivity, ImageViewActivity::class.java)
            startActivity(intent)
        }

        mapBtn = findViewById(R.id.btn_map)
        mapBtn.setOnClickListener { v ->
            Log.d("map", v.toString())
            var intent = Intent(this@SecondActivity, MapActivity::class.java)
            startActivity(intent)
        }


        listViewBtn = findViewById(R.id.btn_listview)
        listViewBtn.setOnClickListener() { v ->
            var intent = Intent(this@SecondActivity, ListViewActivity::class.java)
            startActivity(intent)
        }

        recyclerViewBtn = findViewById(R.id.btn_recyclerview)
        recyclerViewBtn.setOnClickListener { v ->
            var intent = Intent(this, RecylerViewActivity::class.java)
            startActivity(intent)
        }

        webViewBtn = findViewById(R.id.btn_webview)
        webViewBtn.setOnClickListener { v ->
            var intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)
        }

        dialogBtn = findViewById(R.id.btn_dialog)
        dialogBtn.setOnClickListener { v ->
            var intent = Intent(this, DialogActivity::class.java)
            startActivity(intent)
        }

        jumpBtn = findViewById(R.id.btn_jump)
        jumpBtn.setOnClickListener { v ->
            var intent = Intent(this, AActivity::class.java)
            startActivity(intent)
        }

        fgmtBtn = findViewById(R.id.btn_fgmt)
        fgmtBtn.setOnClickListener { v ->
            var intent = Intent(this, ContainerActivity::class.java)
            startActivity(intent)
        }

        eventBtn = findViewById(R.id.btn_event)
        eventBtn.setOnClickListener { v ->
            var intent = Intent(this, EventActivity::class.java)
            startActivity(intent)
        }

        handlerBtn = findViewById(R.id.btn_handler)
        handlerBtn.setOnClickListener { v ->
            var intent = Intent(this, HandlerActivity::class.java)
            startActivity(intent)
        }

        dataBtn = findViewById(R.id.btn_data)
        dataBtn.setOnClickListener { v ->
            var intent = Intent(this, DataStorageActivity::class.java)
            startActivity(intent)
        }

        navBtn = findViewById(R.id.btn_navigation)
        navBtn.setOnClickListener{
            startNavigation()

        }

        gaodeBtn = findViewById(R.id.btn_gaodenav)
        gaodeBtn.setOnClickListener{
            //startGaodeNav("39.941823", "116.426319")
            var dlat="39.941823"
            var dlon = "116.426319"
            if(isInstallApp(applicationContext,"com.autonavi.minimap")){
                var intent = Intent(Intent.ACTION_VIEW)
                intent.addCategory(Intent.CATEGORY_DEFAULT)
                intent.setPackage("com.autonavi.minimap")
                var url = "androidamap://route?"+"sourceApplication"+applicationContext.getString(R.string.app_name)
                url+="&dlat="+dlat+"&dlon="+dlon+"&dev="+0+"&t="+0+"&t="+0
                intent.setData(Uri.parse(url))
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK )
                applicationContext.startActivity(intent)
            }else{
                var url = "https://uri.amap.com/navigation?"
                url+="&to="+dlon+","+dlat+",终点"+"&mode=car"
                var intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );
                applicationContext.startActivity(intent)
            }

        }

        boardcastBtn = findViewById(R.id.btn_boardcast)
        boardcastBtn.setOnClickListener {
            var intent = Intent(this, BoardcastActivity::class.java)
            startActivity(intent)
        }

        retBtn = findViewById(R.id.btn_retrofit)
        retBtn.setOnClickListener{
            var intent = Intent(this,RetrofitActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setListener() {
        var onclick: Onclick = Onclick()
        btn_1.setOnClickListener(onclick)
        btn2.setOnClickListener(onclick)
        editTextBtn.setOnClickListener(onclick)
        radioBtn.setOnClickListener(onclick)
    }

    class Onclick : View.OnClickListener {
        override fun onClick(p0: View?) {
            var intnet: Intent = Intent()

            when (p0?.id) {
                R.id.btn_1 -> {
                    intnet.setClass(p0.context, TextViewActivity::class.java)
//                        startActivity(intnet)
                }
                R.id.btn_2 -> {
                    intnet.setClass(p0.context, ButtonActivity::class.java)
                }
                R.id.btn_edittext -> {
                    intnet.setClass(p0.context, EditTextActivity::class.java)
                }
                R.id.btn_radio -> {
                    intnet.setClass(p0.context, RadioButtonActivity::class.java)

                }
                else -> {
                }
            }


        }


    }

    override fun onStart() {
        super.onStart()
        Log.i(tag, "on start")
    }

    override fun onResume() {
        super.onResume()
        Log.i(tag, "on resume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(tag, "on pause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(tag, "on stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(tag, "on destroy")
        AmapNaviPage.getInstance().exitRouteActivity();
    }

    fun startNavigation(){
        //构建导航组件配置类，没有传入起点，所以起点默认为 “我的位置”
        //构建导航组件配置类，没有传入起点，所以起点默认为 “我的位置”
        val params = AmapNaviParams(null, null, null, AmapNaviType.DRIVER, AmapPageType.ROUTE)
//启动导航组件
//启动导航组件
        AmapNaviPage.getInstance().showRouteActivity(applicationContext, params, null)
        //起点
        //起点
        val start = Poi("北京首都机场", LatLng(40.080525, 116.603039), "B000A28DAE")
//途经点
//途经点
        val poiList: MutableList<Poi> = ArrayList()
        poiList.add(Poi("故宫", LatLng(39.918058, 116.397026), "B000A8UIN8"))
//终点
//终点
        val end = Poi("北京大学", LatLng(39.941823, 116.426319), "B000A816R6")
// 组件参数配置
// 组件参数配置
        val params2 = AmapNaviParams(start, poiList, end, AmapNaviType.DRIVER, AmapPageType.ROUTE)
// 启动组件
// 启动组件
        AmapNaviPage.getInstance().showRouteActivity(applicationContext, params2, null)
    }

    fun startGaodeNav(dlat:String,dlon:String){
        if(isInstallApp(applicationContext,"com.autonavi.minimap")){
            var intent = Intent(Intent.ACTION_VIEW)
            intent.addCategory(Intent.CATEGORY_DEFAULT)
            intent.setPackage("com.autonavi.minimap")
            var url = "androidamap://route?"+"sourceApplication"+applicationContext.getString(R.string.app_name)
            url+="&dlat="+dlat+"&dlon="+dlon+"&dev="+0+"&t="+0+"&t="+0
            intent.setData(Uri.parse(url))
            applicationContext.startActivity(intent)
        }else{
            var url = "https://uri.amap.com/navigation?"
            url+="&to="+dlon+","+dlat+",终点"+"&mode=car"
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            applicationContext.startActivity(intent)
        }
    }

    fun isInstallApp(context: Context, packageName:String) :Boolean{
        var packageInfo = context.packageManager.getPackageInfo(packageName,0)
        return packageInfo!=null
    }
}