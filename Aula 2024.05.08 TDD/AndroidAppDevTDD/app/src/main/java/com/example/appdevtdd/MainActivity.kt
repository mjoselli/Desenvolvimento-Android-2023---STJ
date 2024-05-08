package com.example.appdevtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.resultTextView).text = ""
        findViewById<Button>(R.id.sumButton).setOnClickListener {
            val num1 = findViewById<EditText>(R.id.num1EditText).text.toString()
            val num2 = findViewById<EditText>(R.id.num2EditText).text.toString()
            findViewById<TextView>(R.id.resultTextView).text = SumCalculator.calculate(num1,num2)
        }
        findViewById<Button>(R.id.subtractionButton).setOnClickListener {
            val num1 = findViewById<EditText>(R.id.num1EditText).text.toString()
            val num2 = findViewById<EditText>(R.id.num2EditText).text.toString()
            findViewById<TextView>(R.id.resultTextView).text = SubtractionCalculator.calculate(num1,num2)
        }
    }
}