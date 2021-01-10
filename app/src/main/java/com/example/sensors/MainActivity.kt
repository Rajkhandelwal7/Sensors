package com.example.sensors

import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.getSystemService

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.KITKAT_WATCH)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sensorManager=getSystemService<SensorManager>()
        if(sensorManager==null)
        {
            Toast.makeText(this,"could not get sensors",Toast.LENGTH_SHORT).show()
        }
        else{
            val sensor=sensorManager.getSensorList(Sensor.TYPE_ALL)
            sensor.forEach{
                Log.d("HESENS",""" ${it.name}|${it.stringType}|${it.vendor}""".trimIndent())
            }
        }

    }
}