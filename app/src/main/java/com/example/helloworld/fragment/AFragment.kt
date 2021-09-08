package com.example.helloworld.fragment

import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.icu.text.CaseMap
import android.os.Bundle
import android.util.Log

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.helloworld.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AFragment() : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var tv: TextView
    lateinit var mActivity: Activity

    lateinit var changeBtn: Button
    lateinit var resetBtn: Button
    lateinit var msgBtn: Button
    lateinit var bFragment: BFragment

    lateinit var listener: IOnMsgClick

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv = view.findViewById(R.id.fgmt_tv)
        tv.setText(arguments.getString("title"))

        changeBtn = view.findViewById(R.id.btn_change)
        changeBtn.setOnClickListener { v ->
            bFragment = BFragment()

            var fragment = fragmentManager.findFragmentByTag("a")
            if (fragment != null) {
                fragmentManager.beginTransaction().hide(fragment).add(R.id.fl_container, bFragment)
                    .addToBackStack(null).commitAllowingStateLoss()
            } else {
                //直接replace会替换原来fragment的view
                fragmentManager.beginTransaction().replace(R.id.fl_container, bFragment)
                    .addToBackStack(null).commitAllowingStateLoss()
            }
        }
        resetBtn = view.findViewById(R.id.btn_reset)
        resetBtn.setOnClickListener { v ->
            tv.setText("我是新文字")
        }

        msgBtn = view.findViewById(R.id.btn_message)
        msgBtn.setOnClickListener { v ->
            var containerActivity = activity as ContainerActivity
            // containerActivity.setData("你好")
            listener.onClick("aaaaa")
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("AFragment", "-----------onCreateView-------------")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = context as Activity
        listener = context as IOnMsgClick
    }

    override fun onDetach() {
        super.onDetach()
    }

    override fun onDestroy() {
        super.onDestroy()
        //取消异步
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }

        fun newInstance(title: String): AFragment {
            var aFragment = AFragment()
            var bundle = Bundle()
            bundle.putString("title", title)
            aFragment.arguments = bundle
            return aFragment
        }
    }

    interface IOnMsgClick {
        fun onClick(text: String)
    }
}