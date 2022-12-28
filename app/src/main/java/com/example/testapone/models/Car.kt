package com.example.testapone.models

import android.util.Log

class Car {
    var maxSpeed = 30

    fun start(){
        Log.i("TestTag", "Car starts")
        Log.i("TestTag", "Max speed is $maxSpeed")

    }


}