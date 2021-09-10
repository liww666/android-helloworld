package com.example.helloworld.datastorage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.helloworld.R

/**
 * 安卓存储分为内部存储和外部存储
 * 内部存储：随应用卸载被删除，如SharedPreferences ，存在/data/data/{applicationId}/shared_prefs
 *          还有/data/data/{applicationId}/database
 *              /data/data/{applicationId}/files
 *              /data/data/{applicationId}/cache
 * 外部存储：分为公有目录和私有目录
 */
class DataStorageActivity : AppCompatActivity() , View.OnClickListener{
    lateinit var shareRefBtn :Button
    lateinit var fileBtn :Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_storage)

        shareRefBtn = findViewById(R.id.btn_sharedpreferences)
        shareRefBtn.setOnClickListener(this)
        fileBtn = findViewById(R.id.btn_file)
        fileBtn.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_sharedpreferences->{
                var intent = Intent(v.context,SharePreActivity::class.java)
                startActivity(intent)
            }

            R.id.btn_file->{
                var intent = Intent(v.context,FileActivity::class.java)
                startActivity(intent)
            }
        }
    }
}