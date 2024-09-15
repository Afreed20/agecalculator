package com.kdr.agecalculator


import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class ResultActivity : AppCompatActivity() {
    private var resultTextView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        resultTextView = findViewById(R.id.resultTextView)

        val intent = intent
        val name = intent.getStringExtra("name")
        val age = intent.getIntExtra("age", 0)

        val result = "Hello $name, You are $age years old."
        resultTextView?.setText(result);

    }
}