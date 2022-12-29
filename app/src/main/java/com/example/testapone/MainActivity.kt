package com.example.testapone

import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var weightTF = findViewById<EditText>(R.id.weightTF)
        var heightTF = findViewById<EditText>(R.id.heightTF)
        var calculateBtn = findViewById<Button>(R.id.calculateBTN)

        calculateBtn.setOnClickListener(){
            if(validateInput(weightTF.text, heightTF.text)){
                var weight = weightTF.text.toString()
                var height = heightTF.text.toString()
                var bmi = weight.toFloat()/(((height.toFloat())*(height.toFloat()))/10000)
                bmi = String.format("%.2f", bmi).toFloat()
                displayResult(bmi)
            }
        }
    }

    private fun validateInput(weight: Editable, height: Editable): Boolean{
        return when{
            weight.isNullOrEmpty()-> {
                Toast.makeText(this@MainActivity, "Weight is empty", Toast.LENGTH_LONG).show()
                return false
            }
            height.isNullOrEmpty()->{
                Toast.makeText(this@MainActivity, "Height is empty", Toast.LENGTH_LONG).show()
                return false
            }
            else -> {
                return true
            }
        }
    }

    private fun displayResult(bmi: Float){
        var bmiResultTV = findViewById<TextView>(R.id.bmiResultTV)
        var bmiResultCommentTV = findViewById<TextView>(R.id.bmiResultCommentTV)

        bmiResultTV.setText(bmi.toString())
        var comment: String = ""
        when{
            bmi<18 ->{
                comment="Underweight"
            }
            bmi in 19.00..24.00->{
                comment="Healthy"
            }
            bmi in 24.00..29.00->{
                comment="Overweight"
            }
            bmi>29.00->{
                comment="Obese"
            }
        }
        bmiResultCommentTV.text=comment
    }
}


//Done till 4:26:00
//Link https://www.youtube.com/watch?v=BCSlZIUj18Y&t=44s&ab_channel=AppDevNotes