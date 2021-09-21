package com.example.helloworld.map

import android.os.Bundle
import android.app.Fragment
import android.os.Build
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.amap.api.services.core.PoiItem
import com.amap.api.services.poisearch.PoiResult
import com.amap.api.services.poisearch.PoiSearch
import com.example.helloworld.R
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.util.Log.e
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amap.api.services.help.Inputtips
import com.amap.api.services.help.Tip
import com.example.helloworld.recyclerview.LinerAdapter
import com.example.helloworld.recyclerview.MyDecoration
import java.util.*
import java.util.logging.Logger
import kotlin.collections.ArrayList as ArrayList1
import com.amap.api.services.help.InputtipsQuery





// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchFragment : Fragment(), PoiSearch.OnPoiSearchListener, Inputtips.InputtipsListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var searchButton:Button
    lateinit var searchEt :EditText
    lateinit var rv:RecyclerView
    lateinit var adapter :MapDataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)

    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchButton = view.findViewById(R.id.btn_serach)
        searchEt = view.findViewById(R.id.et_1)
        rv = view.findViewById(R.id.search_recyclerview)
        rv.layoutManager = LinearLayoutManager(this.context)
        var mapDataAdapter= MapDataAdapter(this.context)
        mapDataAdapter.rv = rv
        rv.adapter= mapDataAdapter
        var activity =  activity as MapActivity
        mapDataAdapter.mAMap = activity.mapView.map
        searchEt.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                return
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                return
            }

            override fun afterTextChanged(s: Editable?) {
//                Toast.makeText(getActivity().applicationContext,s,Toast.LENGTH_SHORT).show()
                val inputquery = InputtipsQuery(s.toString(), null)
                inputquery.cityLimit = true //限制在当前城市
                val inputTips = Inputtips(getActivity().applicationContext, inputquery)
                inputTips.setInputtipsListener(this@SearchFragment)
                inputTips.requestInputtipsAsyn()
            }

        })


        searchButton.setOnClickListener{
//            var query = PoiSearch.Query("朗坤", "", "0551")
//keyWord表示搜索字符串，
//第二个参数表示POI搜索类型，二者选填其一，选用POI搜索类型时建议填写类型代码，码表可以参考下方（而非文字）
//cityCode表示POI搜索区域，可以是城市编码也可以是城市名称，也可以传空字符串，空字符串代表全国在全国范围内进行搜索
//keyWord表示搜索字符串，
//第二个参数表示POI搜索类型，二者选填其一，选用POI搜索类型时建议填写类型代码，码表可以参考下方（而非文字）
//cityCode表示POI搜索区域，可以是城市编码也可以是城市名称，也可以传空字符串，空字符串代表全国在全国范围内进行搜索
//            query.setPageSize(30) // 设置每页最多返回多少条poiitem
//
//            query.setPageNum(0)
//            var poiSearch = PoiSearch(this.context, query)
//            poiSearch.setOnPoiSearchListener(this)
//            poiSearch.searchPOIAsyn();
            searchLocationPoi()
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SearchFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SearchFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onPoiSearched(p0: PoiResult?, p1: Int) {
        Log.e("map",p0?.getPois().toString().toString() + "" + p1)
        if (p1 === 1000) {
            var datas = ArrayList<PositionEntity>()
            val pois = p0?.getPois()
            if (pois != null) {
                for (i in 0 until pois.size) {
                    val locationBean = PositionEntity()
                    locationBean.latitue = pois[i].latLonPoint.latitude
                    locationBean.longitude = pois[i].latLonPoint.longitude
                    locationBean.address = pois[i].title
                    locationBean.city = pois[i].cityName
                    datas.add(locationBean)
                }
                var adapter = rv.adapter as MapDataAdapter
                adapter.datas = datas
                adapter.notifyDataSetChanged();
            }

        }
    }

    override fun onPoiItemSearched(p0: PoiItem?, p1: Int) {
        TODO("Not yet implemented")
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun searchLocationPoi() {
        //关闭键盘
//        KeyBoardUtils.closeKeybord(poiSearchInMaps, BaseApplication.mContext)
        if (TextUtils.isEmpty(searchEt.getText().toString().trim())) {
            Toast.makeText(this.context,"内容为空!",Toast.LENGTH_SHORT).show()
        } else {
            var query = PoiSearch.Query(
                searchEt.getText().toString().trim(),
                "",
                ""
            ) // 第一个参数表示搜索字符串，第二个参数表示poi搜索类型，第三个参数表示poi搜索区域（空字符串代表全国）
            query.setPageSize(20) // 设置每页最多返回多少条poiitem
            query.setPageNum(0) // 设置查第一页
            var poiSearch = PoiSearch(activity, query)
            poiSearch.setOnPoiSearchListener(this)
            poiSearch.searchPOIAsyn()
        }
    }

    override fun onGetInputtips(p0: MutableList<Tip>?, p1: Int) {
        Log.d("amap",p0.toString())
        Log.d("amap",p1.toString())

    }
}