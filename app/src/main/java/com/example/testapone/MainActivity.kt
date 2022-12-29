package com.example.testapone

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var userNameTF: EditText
    private lateinit var numberTF: EditText
    private lateinit var saveBTN: Button

    private lateinit var sharedPref:SharedPreferences
    private lateinit var editor:SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userNameTF = findViewById<EditText>(R.id.userNameTF)
        numberTF = findViewById<EditText>(R.id.numberTF)
        saveBTN = findViewById<Button>(R.id.saveBTN)

        sharedPref = getSharedPreferences("my_sharedPref", MODE_PRIVATE,)
        editor=sharedPref.edit()
    }

    override fun onPause() {
        super.onPause()
        val name = userNameTF.text.toString()
        val number = numberTF.text.toString().toInt()
        editor.apply{
            putString("sf_name", name)
            putInt("sf_number", number)
            commit()
        }
    }

    override fun onResume() {
        super.onResume()
        val name = sharedPref.getString("sf_name", null)
        val number = sharedPref.getInt("sf_number", 0)

        userNameTF.setText(name)
        if(number!=0){
            numberTF.setText(number.toString())
        }else{
            numberTF.setText("")
        }
    }
}


//Done till 3:26:00
//Link https://www.youtube.com/watch?v=BCSlZIUj18Y&t=44s&ab_channel=AppDevNotes