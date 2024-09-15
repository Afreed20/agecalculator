package com.kdr.agecalculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date


class MainActivity : AppCompatActivity() {
        private var nameEditText: EditText? = null
        private var dobEditText: EditText? = null
        private var calculateButton: Button? = null
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            nameEditText = findViewById(R.id.nameEditText)
            dobEditText = findViewById(R.id.dobEditText)
            calculateButton = findViewById(R.id.calculateButton)

            calculateButton?.setOnClickListener(View.OnClickListener {
                val name = nameEditText?.getText().toString()
                val dob = dobEditText?.getText().toString()

                val sdf = SimpleDateFormat("mm/dd/yyyy")

                    val birthDate: Date = sdf.parse(dob)
                    val age = calculateAge(birthDate)

                    // Navigate to ResultActivity with the age and name
                    val intent = Intent(
                        this@MainActivity,
                        ResultActivity::class.java
                    )
                    intent.putExtra("name", name)
                    intent.putExtra("age", age)
                    startActivity(intent)
                })
            }
    }

        private fun calculateAge(birthDate: Date): Int {
            val birthCalendar: Calendar = Calendar.getInstance()
            birthCalendar.setTime(birthDate)
            val today: Calendar = Calendar.getInstance()
            var age: Int = today.get(Calendar.YEAR) - birthCalendar.get(Calendar.YEAR)
            if (today.get(Calendar.DAY_OF_YEAR) < birthCalendar.get(Calendar.DAY_OF_YEAR)) {
                age--
            }
            return age
        }









