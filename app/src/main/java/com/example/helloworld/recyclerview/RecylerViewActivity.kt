package com.example.helloworld.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.helloworld.R

class RecylerViewActivity : AppCompatActivity() {

    lateinit var linerBtn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_revycler_view)
        linerBtn = findViewById(R.id.btn_liner)
        linerBtn.setOnClickListener{ v->
            var intent = Intent(this,LinerRecyclerViewActivity::class.java)
            startActivity(intent)
        }
    }
}