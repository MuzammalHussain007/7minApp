package com.blinkedge.drawingapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    private lateinit var linear: LinearLayout;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        linear = findViewById(R.id.start_stop);
        linear.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, ExcerciseActivity::class.java);
            startActivity(intent)

        })
    }
}