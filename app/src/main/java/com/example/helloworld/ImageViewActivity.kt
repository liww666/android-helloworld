package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide

class ImageViewActivity : AppCompatActivity() {

    lateinit var imgView4 : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_view)
        imgView4 = findViewById(R.id.iv_4)
        Glide.with(this).load("http://121.196.56.55:22000/group1/M00/00/00/rBDmLmEekDuALPFrAAAYGFmsPPQ137.jpg").into(imgView4)
    }
}