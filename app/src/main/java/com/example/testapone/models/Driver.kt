package com.example.testapone.models

import android.util.Log

class Driver(var driverName:String) {
//    var driverName = name

//    init {
//        driverName=name
//    }

    fun showDetails(){
        Log.i("TestTag", "Driver is $driverName")
    }
}