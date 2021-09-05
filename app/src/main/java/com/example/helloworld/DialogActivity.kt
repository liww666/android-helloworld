package com.example.helloworld

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class DialogActivity : AppCompatActivity() {

    lateinit var dialog1Btn: Button

    lateinit var dialog2Btn: Button

    lateinit var dialog3Btn: Button

    lateinit var dialog4Btn: Button

    lateinit var dialog5Btn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)

        dialog1Btn = findViewById(R.id.btn_dialog1)
        dialog1Btn.setOnClickListener { v ->
            var dialogBuilder = AlertDialog.Builder(this)
            dialogBuilder.setTitle("请回答").setMessage("你觉得课程如何？")
                .setIcon(R.drawable.smile)
                .setPositiveButton(
                    "棒",
                    { dialogInterface: DialogInterface, i: Int ->
                        run {
                            Toast.makeText(this, "你很诚实", Toast.LENGTH_SHORT).show()
                        }
                    }
                ).setNeutralButton("还行", { dialogInterface: DialogInterface, i: Int ->
                    run {
                        Toast.makeText(this, "你再瞅瞅~", Toast.LENGTH_SHORT).show()
                    }
                }).setNegativeButton("不好", { dialogInterface: DialogInterface, i: Int ->
                    run {
                        Toast.makeText(this, "睁眼说瞎话", Toast.LENGTH_SHORT).show()
                    }
                }).show();
        }

        dialog2Btn = findViewById(R.id.btn_dialog2)
        dialog2Btn.setOnClickListener { v ->
            var builder = AlertDialog.Builder(this)
            var arr = arrayOf("男", "女")
            builder.setTitle("选择性别").setItems(arr, { dialogInterface: DialogInterface, i: Int ->
                run {
                    Toast.makeText(this, arr[i], Toast.LENGTH_SHORT).show()
                }
            }).show()
        }

        dialog3Btn = findViewById(R.id.btn_dialog3)
        dialog3Btn.setOnClickListener { v ->
            var builder = AlertDialog.Builder(this)
            var arr = arrayOf("男", "女")
            builder.setTitle("选择性别")
                .setSingleChoiceItems(arr, 0, { dialogInterface: DialogInterface, i: Int ->
                    run {
                        Toast.makeText(this, arr[i], Toast.LENGTH_SHORT).show()
                        dialogInterface.dismiss()
                    }
                }).show()
        }

        dialog4Btn = findViewById(R.id.btn_dialog4)
        dialog4Btn.setOnClickListener { v ->
            var builder = AlertDialog.Builder(this)
            var arr = arrayOf("唱歌", "跳舞")
            var isSelected = booleanArrayOf(false, true)
            builder.setTitle("选择兴趣").setMultiChoiceItems(arr, isSelected,
                { dialogInterface: DialogInterface, i: Int, isSelected: Boolean ->
                    run {
                        Toast.makeText(this, arr[i], Toast.LENGTH_SHORT).show()

                    }
                }
            ).show()
        }

        dialog5Btn = findViewById(R.id.btn_dialog5)
        dialog5Btn.setOnClickListener { v ->
            var builder = AlertDialog.Builder(this)
            var view = LayoutInflater.from(this).inflate(R.layout.layout_linear_item_2, null)
            builder.setTitle("自定义样式").setView(view).show()
        }


    }
}