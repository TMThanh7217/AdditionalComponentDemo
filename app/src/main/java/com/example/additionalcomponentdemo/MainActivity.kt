package com.example.additionalcomponentdemo

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.ProgressBar
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Radio Button
        val radioButtonGroup = findViewById<RadioGroup>(R.id.radioGroupDemo)
        radioButtonGroup.setOnCheckedChangeListener { radioBtnGroup, optionId ->
            run {
                when (optionId) {
                    R.id.radio_btn_1 -> {
                        Toast.makeText(this, "Button 1 clicked", Toast.LENGTH_SHORT).show()
                        Log.d("Radio button clicked", "Button 1 clicked")
                    }

                    R.id.radio_btn_2 -> {
                        Toast.makeText(this, "Button 2 clicked", Toast.LENGTH_SHORT).show()
                        Log.d("Radio button clicked", "Button 2 clicked")
                    }

                    R.id.radio_btn_3 -> {
                        Toast.makeText(this, "Button 3 clicked", Toast.LENGTH_SHORT).show()
                        Log.d("Radio button clicked", "Button 3 clicked")
                    }

                    R.id.radio_btn_4 -> {
                        Toast.makeText(this, "Button 4 clicked", Toast.LENGTH_SHORT).show()
                        Log.d("Radio button clicked", "Button 4 clicked")
                    }

                    R.id.radio_btn_5 -> {
                        Toast.makeText(this, "Button 5 clicked", Toast.LENGTH_SHORT).show()
                        Log.d("Radio button clicked", "Button 5 clicked")
                    }
                }
            }
        }

        val radioButtonGroup2 = findViewById<RadioGroup>(R.id.tip_options)
        radioButtonGroup2.setOnCheckedChangeListener { radioBtnGroup2, optionId ->
            run {
                when (optionId) {
                    R.id.option_twenty_percent -> {
                        Toast.makeText(this, R.string.amazing_service, Toast.LENGTH_SHORT).show()
                        Log.d("Service clicked", R.string.amazing_service.toString())
                    }

                    R.id.option_eighteen_percent -> {
                        Toast.makeText(this, getString(R.string.good_service), Toast.LENGTH_SHORT).show()
                        Log.d("Service clicked", R.string.good_service.toString())
                    }

                    R.id.option_fifteen_percent -> {
                        Toast.makeText(this, getString(R.string.ok_service), Toast.LENGTH_SHORT).show()
                        Log.d("Service clicked", R.string.ok_service.toString())
                    }
                }
            }
        }

        // Check box

        // This R.id. is an int, was about to loop on it but I cant now
        // Can't move these either since I'm not sure what can call findViewById, but it can't be called outside the main scope
        findViewById<CheckBox>(R.id.checkbox_1)
            .setOnCheckedChangeListener { buttonView, isChecked ->
                Toast.makeText(this, "Checkbox 1 clicked", Toast.LENGTH_SHORT).show()
                Log.d("check box clicked", "Checkbox 1 clicked")
            }

        findViewById<CheckBox>(R.id.checkbox_2)
            .setOnCheckedChangeListener { buttonView, isChecked ->
                Toast.makeText(this, "Checkbox 2 clicked", Toast.LENGTH_SHORT).show()
                Log.d("check box clicked", "Checkbox 2 clicked")
            }

        findViewById<CheckBox>(R.id.checkbox_3)
            .setOnCheckedChangeListener { buttonView, isChecked ->
                Toast.makeText(this, "Checkbox 3 clicked", Toast.LENGTH_SHORT).show()
                Log.d("check box clicked", "Checkbox 3 clicked")
            }

        findViewById<CheckBox>(R.id.checkbox_4)
            .setOnCheckedChangeListener { buttonView, isChecked ->
                Toast.makeText(this, "Checkbox 4 clicked", Toast.LENGTH_SHORT).show()
                Log.d("check box clicked", "Checkbox 4 clicked")
            }

        findViewById<CheckBox>(R.id.checkbox_5)
            .setOnCheckedChangeListener { buttonView, isChecked ->
                Toast.makeText(this, "Checkbox 5 clicked", Toast.LENGTH_SHORT).show()
                Log.d("check box clicked", "Checkbox 5 clicked")
            }

        // Progress bar
        val progressBarDuration = findViewById<TextView>(R.id.progressBarText)
        val progressBarBtn = findViewById<Button>(R.id.progressBarButton)
        val progressBarDemo = findViewById<ProgressBar>(R.id.progressBar)
        var index = progressBarDemo.progress

        progressBarBtn.setOnClickListener {
            Thread(Runnable {
                while (index < 100) {
                    index++
                    handler.post(Runnable {
                        progressBarDemo.progress = index
                        progressBarDuration!!.text = index.toString() + "/" + progressBarDemo.max
                    })
                    try {
                        Thread.sleep(100)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }
            }).start()
        }

        // Switch
        val roundUpSwitch = findViewById<Switch>(R.id.round_up_switch)
        /*if (roundUpSwitch.isChecked) {
            Toast.makeText(this, "Checked", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(this, "Unchecked", Toast.LENGTH_SHORT).show()
        }*/
        roundUpSwitch.setOnCheckedChangeListener() { btn, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "Checked", Toast.LENGTH_SHORT).show()
                Log.d("Round up switch", "checked")
            } else {
                Toast.makeText(this, "Unchecked", Toast.LENGTH_SHORT).show()
                Log.d("Round up switch", "unchecked")
            }
        }
    }
}

fun checkBoxDemo() {

}
