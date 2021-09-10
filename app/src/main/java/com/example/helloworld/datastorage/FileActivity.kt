package com.example.helloworld.datastorage

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.helloworld.R
import java.io.FileOutputStream
import java.io.IOException
import java.lang.StringBuilder

class FileActivity : AppCompatActivity() {
    lateinit var nameET: EditText
    lateinit var saveBtn: Button
    lateinit var showBtn: Button
    lateinit var showTv: TextView
    lateinit var sharePre: SharedPreferences
    lateinit var spEditor: SharedPreferences.Editor
    var fileName:String ="test.txt"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file)


        sharePre = getSharedPreferences("data", MODE_PRIVATE)
        spEditor = sharePre.edit()


        nameET = findViewById(R.id.et_name)
        saveBtn = findViewById(R.id.btn_save)

        showBtn = findViewById(R.id.btn_show)
        showTv = findViewById(R.id.tv_show)
        saveBtn.setOnClickListener{
            save(nameET.text.toString())

        }
        showBtn.setOnClickListener{
            showTv.setText(read())
        }
    }

    private fun save(content:String){
         lateinit var outputStream :FileOutputStream
        try {
             outputStream = openFileOutput(fileName, MODE_PRIVATE)
            outputStream.write(content.encodeToByteArray())
        }catch (e:IOException){

        }finally {
            outputStream?.close()

        }

    }

    private fun read(): String?{
        var inputStreamReader = openFileInput(fileName)
//        var buff:ByteArray = ByteArray(1024)
//        var sb:StringBuilder = StringBuilder("")
//        var len:Int = 0
//        while ((inputStreamReader.read(buff).also { len = it })>0){
//            sb.append(String(buff,0,len))
//        }
//        return sb.toString()
        return String(inputStreamReader.readBytes())
    }
}