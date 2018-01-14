package com.winision.temperatureconversion

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    lateinit var typeSpin: Spinner
    val types = arrayOf("Celsius", "Kelvin", "Fahrenheit")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val convert = findViewById<View>(R.id.convert) as Button
        typeSpin = findViewById<View>(R.id.type) as Spinner
        val typeAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, types)
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        typeSpin!!.setAdapter(typeAdapter)
        convert.setOnClickListener {
            view: View? -> convertFunc()
        }
    }
    private fun convertFunc() {
        val temperatureTxt = findViewById<View>(R.id.temperature) as EditText
        val temperature = temperatureTxt.text.toString().trim()
        val tempNo = Integer.parseInt(temperature)
        val format = typeSpin.selectedItem.toString().trim()
        val answer1 = findViewById<View>(R.id.answer1) as TextView
        val answer2 = findViewById<View>(R.id.answer2) as TextView
        val ans1 = findViewById<View>(R.id.ans1) as TextView
        val ans2 = findViewById<View>(R.id.ans2) as TextView

        if (!temperature.isEmpty()) {
            if (format == "Celsius") {
                ans1.text = "Fahrenheit"
                ans2.text = "Kelvin"
                answer1.text = ((tempNo * 9/5) + 32).toString()
                answer2.text = (tempNo + 273.15).toString()
            }else if (format == "Kelvin") {
                ans1.text = "Fahrenheit"
                ans2.text = "Celsius"
                answer1.text = ((tempNo - 273.15) * 9/5 + 32	).toString()
                answer2.text = (tempNo - 273.15	).toString()
            }else if (format == "Fahrenheit") {
                ans1.text = "Celsius"
                ans2.text = "Kelvin"
                answer1.text = ((tempNo - 52) * 5/9).toString()
                answer2.text = ((tempNo - 32) * 5/9 + 273.15).toString()
            }
        }

    }
}
