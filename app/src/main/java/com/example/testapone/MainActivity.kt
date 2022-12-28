package com.example.testapone

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.testapone.models.Car
import com.example.testapone.models.Driver

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var myCar = Car()
        myCar.start()

        var driver = Driver("Mike")
        driver.showDetails()

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

        Log.i("TestTag", "Currently on onCreate")
    }
    override fun onStart() {
        super.onStart()
        Log.i("TestTag", "Currently on onStart")
    }
    override fun onResume() {
        super.onResume()
        Log.i("TestTag", "Currently on onResume")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.i("TestTag", "Currently on onDestroy")
    }
    override fun onRestart() {
        super.onRestart()
        Log.i("TestTag", "Currently on onRestart")
    }
    override fun onPause() {
        super.onPause()
        Log.i("TestTag", "Currently on onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.i("TestTag", "Currently on onStop")
    }
}


//Done till 3:26:00
//Link https://www.youtube.com/watch?v=BCSlZIUj18Y&t=44s&ab_channel=AppDevNotes