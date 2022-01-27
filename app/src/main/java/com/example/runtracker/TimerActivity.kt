package com.example.runtracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.Handler
import android.widget.TextView
import com.example.runtracker.databinding.ActivityTimerBinding
import java.util.*


private lateinit var binding: ActivityTimerBinding
var time = 0
var started = false

class TimerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTimerBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)



        binding.imageButton4.setOnClickListener {
            val intent = Intent(this@TimerActivity, MainActivity::class.java)
            startActivity(intent)
        }

        binding.imageButton2.setOnClickListener {
            runTimer()
        }

        binding.textView8.setOnClickListener {
            time = 0
            started = false
            updateText()
        }
        binding.imageButton3.setOnClickListener {
            time = 0
            started = false
            updateText()
        }

    }

    private fun pause() {
        started = false
        val startLabel = findViewById<TextView>(R.id.start_label)
        startLabel.text = "Start"
    }


    fun updateText() {
        val minutes: Int = time / 360000
        val secs: Int = time % 6000 / 100
        val milli: Int = time % 100
        var timeString: String = java.lang.String
            .format(
                Locale.getDefault(),
                "%02d:%02d:%02d",
                minutes, secs, milli
            )
        val timerText = findViewById<TextView>(R.id.timer_text)
        timerText.text = timeString
    }


    private fun runTimer() {
        if(started)   {
            return pause()
        }
        val startLabel = findViewById<TextView>(R.id.start_label)
        startLabel.text = "Pause"
        started = true
        val handler = Handler()
        handler.post(object : Runnable {
            override fun run() {
                updateText()
                if (started) {
                    time+=1
                    handler.postDelayed(this, 10)
                }
            }
        })
    }
}

