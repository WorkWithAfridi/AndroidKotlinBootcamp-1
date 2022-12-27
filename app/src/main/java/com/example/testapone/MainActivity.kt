package com.example.testapone

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val greetingTextView = findViewById<TextView>(R.id.nameTV)
        val inputField = findViewById<EditText>(R.id.nameTF)
        val button = findViewById<Button>(R.id.saveBTN)
        val viewOffersButton = findViewById<Button>(R.id.viewOffersBTN)

        var name = "";
        button.setOnClickListener(){
            if(inputField.text.isNotEmpty()){
                val enteredName = inputField.text.toString();
                name = enteredName;
                greetingTextView.text = "Welcome $enteredName"
                inputField.text.clear()
                viewOffersButton.visibility= VISIBLE
            }else{
                greetingTextView.text = "Greetings"
                viewOffersButton.visibility= INVISIBLE
                Toast.makeText(
                    this@MainActivity,
                    "Please, enter your name!",
                    Toast.LENGTH_LONG,
                ).show()
            }
        }

        viewOffersButton.setOnClickListener(){
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("User", name, )
            startActivity(intent)
        }

    }
}