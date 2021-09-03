package com.example.helloworld.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.helloworld.R

class RecylerViewActivity : AppCompatActivity() {

    lateinit var linerBtn: Button
    lateinit var horBtn: Button
    lateinit var gridBtn :Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_revycler_view)
        linerBtn = findViewById(R.id.btn_liner)
        linerBtn.setOnClickListener { v ->
            var intent = Intent(this, LinerRecyclerViewActivity::class.java)
            startActivity(intent)
        }

        horBtn = findViewById(R.id.btn_hor)
        horBtn.setOnClickListener { v ->

            var intent = Intent(this, HorRecyclerViewActivity::class.java)
            startActivity(intent)

        }

        gridBtn = findViewById(R.id.btn_grid_rv)
        gridBtn.setOnClickListener { v ->

            var intent = Intent(this, GridRecyclerViewActivity::class.java)
            startActivity(intent)

        }
    }
}