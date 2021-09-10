package com.example.helloworld.datastorage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.helloworld.R

class DataStorageActivity : AppCompatActivity() , View.OnClickListener{
    lateinit var shareRefBtn :Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_storage)

        shareRefBtn = findViewById(R.id.btn_sharedpreferences)
        shareRefBtn.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_sharedpreferences->{
                var intent = Intent(v.context,SharePreActivity::class.java)
                startActivity(intent)
            }
        }
    }
}