package com.example.helloworld

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import com.amap.api.location.AMapLocation

import com.amap.api.maps.model.MyLocationStyle
import com.amap.api.location.AMapLocationClientOption

import com.amap.api.location.AMapLocationClient
import com.amap.api.location.AMapLocationListener
import com.amap.api.maps.*

import com.amap.api.maps.model.Marker

import com.amap.api.maps.LocationSource.OnLocationChangedListener
import com.amap.api.maps.model.BitmapDescriptorFactory
import android.widget.Toast

import com.amap.api.maps.model.LatLng

import com.amap.api.maps.CameraUpdateFactory
import java.text.SimpleDateFormat
import java.util.*


class MapActivity : AppCompatActivity(), LocationSource, AMapLocationListener{
    lateinit var  mapView :MapView

    private var aMap: AMap? = null

    private var mListener: OnLocationChangedListener? = null

    //private LocationManagerProxy mAMapLocationManager;
    private val marker // 定位雷达小图标
            : Marker? = null

    private var mLocationClient: AMapLocationClient? = null
    private var mLocationOption: AMapLocationClientOption? = null //定位参数

    private var isFirstLoc = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        mapView= findViewById(R.id.map) //找到地图控件

//在activity执行onCreate时执行mMapView.onCreate(savedInstanceState)，创建地图
//在activity执行onCreate时执行mMapView.onCreate(savedInstanceState)，创建地图
        mapView.onCreate(savedInstanceState)
        val aMap = mapView.map //初始化地图控制器对象

        //设置成中文地图
        //设置成中文地图
        aMap.setMapLanguage(AMap.CHINESE)
// 自定义系统定位小蓝点
// 自定义系统定位小蓝点
        val myLocationStyle = MyLocationStyle()
//        myLocationStyle.myLocationIcon(
//            BitmapDescriptorFactory
//                .fromResource(R.drawable.local)
//        ) // 设置小蓝点的图标
        myLocationStyle.interval(2000)
        myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE)
//        myLocationStyle.strokeColor(Color.BLACK) // 设置圆形的边框颜色
//
//        myLocationStyle.radiusFillColor(Color.argb(100, 0, 0, 180)) // 设置圆形的填充颜色

// myLocationStyle.anchor(int,int)//设置小蓝点的锚点
// myLocationStyle.anchor(int,int)//设置小蓝点的锚点
//        myLocationStyle.strokeWidth(2.0f) // 设置圆形的边框粗细

        aMap.myLocationStyle=myLocationStyle// 将自定义的 myLocationStyle 对象添加到地图上
        aMap.uiSettings.isMyLocationButtonEnabled = true
//        aMap.setLocationSource() // 设置定位监听  ,会实现两个方法activate（）、 deactivate（），在两个方法中进行操作
        aMap.isMyLocationEnabled = true
        aMap.moveCamera(CameraUpdateFactory.zoomTo(15f))
        init()

    }

    fun init(){

        //初始化定位

        //初始化定位
        mLocationClient = AMapLocationClient(applicationContext)
        //设置定位回调监听
        //设置定位回调监听
        mLocationClient!!.setLocationListener(this)
        //初始化定位参数
        //初始化定位参数
        mLocationOption = AMapLocationClientOption()
        //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption!!.locationMode = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy
        //设置是否返回地址信息（默认返回地址信息）
        //设置是否返回地址信息（默认返回地址信息）
        mLocationOption!!.isNeedAddress = true
        //设置是否只定位一次,默认为false
        //设置是否只定位一次,默认为false
        mLocationOption!!.isOnceLocation = false
        //设置是否强制刷新WIFI，默认为强制刷新
        //mLocationOption.setWifiActiveScan(true);
        //设置是否强制刷新WIFI，默认为强制刷新
        //mLocationOption.setWifiActiveScan(true);
        mLocationOption!!.isWifiScan = true
        //设置是否允许模拟位置,默认为false，不允许模拟位置
        //设置是否允许模拟位置,默认为false，不允许模拟位置
        mLocationOption!!.isMockEnable = false
        //设置定位间隔,单位毫秒,默认为2000ms
        //设置定位间隔,单位毫秒,默认为2000ms
        mLocationOption!!.interval = 2000
        //给定位客户端对象设置定位参数
        //给定位客户端对象设置定位参数
        mLocationClient!!.setLocationOption(mLocationOption)

        //启动定位

        //启动定位
        mLocationClient!!.startLocation()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun activate(listener: OnLocationChangedListener?) {
        mListener = listener;
    }

    override fun deactivate() {
        mListener = null;
    }

    override fun onLocationChanged(amapLocation: AMapLocation?) {
        if (amapLocation != null) {
            if (amapLocation.getErrorCode() === 0) {
                //定位成功回调信息，设置相关消息
                amapLocation.getLocationType() //获取当前定位结果来源，如网络定位结果，详见官方定位类型表
                amapLocation.getLatitude() //获取纬度
                amapLocation.getLongitude() //获取经度
                amapLocation.getAccuracy() //获取精度信息
                val df = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                val date = Date(amapLocation.getTime())
                df.format(date) //定位时间
                amapLocation.getAddress() //地址，如果option中设置isNeedAddress为false，则没有此结果，网络定位结果中会有地址信息，GPS定位不返回地址信息。
                amapLocation.getCountry() //国家信息
                amapLocation.getProvince() //省信息
                amapLocation.getCity() //城市信息
                amapLocation.getDistrict() //城区信息
                amapLocation.getStreet() //街道信息
                amapLocation.getStreetNum() //街道门牌号信息
                amapLocation.getCityCode() //城市编码
                amapLocation.getAdCode() //地区编码

                // 如果不设置标志位，此时再拖动地图时，它会不断将地图移动到当前的位置
                if (isFirstLoc) {
                    //设置缩放级别
                    aMap!!.moveCamera(CameraUpdateFactory.zoomTo(17f))
                    //将地图移动到定位点
                    aMap!!.moveCamera(
                        CameraUpdateFactory.changeLatLng(
                            LatLng(
                                amapLocation.getLatitude(),
                                amapLocation.getLongitude()
                            )
                        )
                    )
                    //点击定位按钮 能够将地图的中心移动到定位点
                    mListener!!.onLocationChanged(amapLocation)
                    //添加图钉
//                    aMap.addMarker(getMarkerOptions(amapLocation));
                    //获取定位信息
                    val buffer = StringBuffer()
                    buffer.append(
                        amapLocation.getCountry()
                            .toString() + "" + amapLocation.getProvince() + "" + amapLocation.getCity() + "" + amapLocation.getProvince() + "" + amapLocation.getDistrict() + "" + amapLocation.getStreet() + "" + amapLocation.getStreetNum()
                    )
                    Toast.makeText(applicationContext, buffer.toString(), Toast.LENGTH_LONG).show()
                    isFirstLoc = false
                }
            } else {
                //显示错误信息ErrCode是错误码，errInfo是错误信息，详见错误码表。
                Log.e(
                    "AmapError", ("location Error, ErrCode:"
                            + amapLocation.getErrorCode()) + ", errInfo:"
                            + amapLocation.getErrorInfo()
                )
                Toast.makeText(applicationContext, "定位失败", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        mapView.onSaveInstanceState(outState)
    }
}