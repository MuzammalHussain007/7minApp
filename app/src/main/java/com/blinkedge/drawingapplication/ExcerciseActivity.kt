package com.blinkedge.drawingapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import kotlin.math.log

class ExcerciseActivity : AppCompatActivity() {
    private var restTime: CountDownTimer? = null;
    private var restProgress = 0;
    private lateinit var progressBar: ProgressBar;
    private lateinit var tvshowTime: TextView;
    private lateinit var startTimeBtn: TextView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_excercise)
        innit();

        setupRestView()
    }

    override fun onDestroy() {
        if (restTime != null) {
            restTime!!.cancel()
            restProgress = 0

        }
        super.onDestroy()
    }

    private fun setupRestView() {
        if (restTime != null) {
            restTime!!.cancel()
            restProgress = 0
        }
        restProgress()
    }

    private fun restProgress() {
       progressBar.progress = restProgress
        restTime = object : CountDownTimer(12000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                Log.d("andeee__","$restProgress");
                progressBar.progress = 10 - restProgress
                tvshowTime.text = (10- restProgress).toString()
                restProgress++
            }

            override fun onFinish() {
                Toast.makeText(
                    this@ExcerciseActivity,
                    "Here we start Excercise",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }.start();
    }

    private fun innit() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar_exercise_activity);
        setSupportActionBar(toolbar);
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener(View.OnClickListener {
            finish()
        })
        progressBar = findViewById(R.id.progressBar)
        tvshowTime = findViewById(R.id.tvTimer);
        startTimeBtn = findViewById(R.id.tvExerciseTimer);
    }
}