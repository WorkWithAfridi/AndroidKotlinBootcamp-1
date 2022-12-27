package com.example.testapone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var usernameTV = findViewById<TextView>(R.id.userNameTV)
        val userName = intent.getStringExtra("User")
        usernameTV.text = "Here are your offers $userName"
    }
}