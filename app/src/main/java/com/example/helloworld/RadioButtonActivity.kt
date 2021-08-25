package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.annotation.RequiresPermission

class RadioButtonActivity : AppCompatActivity() {

    private lateinit var rg1: RadioGroup

    private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_button)
        rg1 = findViewById(R.id.rg_1)
        button = findViewById(R.id.button)
        rg1.setOnCheckedChangeListener { group, checkId ->
            var radio: RadioButton = findViewById(checkId)
            Toast.makeText(
                applicationContext, "On checked change:${radio.text}",
                Toast.LENGTH_SHORT
            ).show()
        }

        button.setOnClickListener {
            // Get the checked radio button id from radio group
            var id: Int = rg1.checkedRadioButtonId
            if (id != -1) { // If any radio button checked from radio group
                // Get the instance of radio button using id
                val radio: RadioButton = findViewById(id)
//                Toast.makeText(
//                    applicationContext, "On button click : ${radio.text}",
//                    Toast.LENGTH_SHORT
//                ).show()
                radioButtonClick(radio)
            } else {
                // If no radio button checked in this radio group
                Toast.makeText(
                    applicationContext, "On button click : nothing selected",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }


    // Get the selected radio button text using radio button on click listener
    fun radioButtonClick(view: View) {
        // Get the clicked radio button instance
        val radio: RadioButton = findViewById(rg1.checkedRadioButtonId)
        Toast.makeText(
            applicationContext, "On click : ${radio.text}",
            Toast.LENGTH_SHORT
        ).show()
    }

}