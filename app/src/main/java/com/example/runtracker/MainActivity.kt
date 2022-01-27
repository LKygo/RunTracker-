package com.example.runtracker


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun goToApp(view: View) {
//        Navigate to timing activity on button click
        val intent = Intent(this, TimerActivity::class.java)
        startActivity(intent)
    }

}


