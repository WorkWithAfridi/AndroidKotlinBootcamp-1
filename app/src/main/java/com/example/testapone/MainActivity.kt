package com.example.testapone

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var weightTF = findViewById<EditText>(R.id.weightTF)
        var heightTF = findViewById<EditText>(R.id.heightTF)
        var calculateBtn = findViewById<Button>(R.id.calculateBTN)

        calculateBtn.setOnClickListener(){
            if(weightTF.text.isNotEmpty() || weightTF.text!=null || heightTF.text.isNotEmpty() || heightTF.text!=null){
                var weight = weightTF.text.toString()
                var height = heightTF.text.toString()
                var bmi = weight.toFloat()/(((height.toFloat())*(height.toFloat()))/10000)
                bmi = String.format("%.2f", bmi).toFloat()
                displayResult(bmi)
            }
        }
    }

    private fun displayResult(bmi: Float){
        var bmiResultTV = findViewById<TextView>(R.id.bmiResultTV)
        var bmiResultCommentTV = findViewById<TextView>(R.id.bmiResultCommentTV)

        bmiResultTV.setText(bmi.toString())
    }
}


//Done till 4:26:00
//Link https://www.youtube.com/watch?v=BCSlZIUj18Y&t=44s&ab_channel=AppDevNotes