package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var minusButton:Button
    lateinit var firstEditText:EditText
    lateinit var secondEditText:EditText
    lateinit var resultTextView:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firstEditText = findViewById(R.id.firstEditText)
        secondEditText = findViewById(R.id.secondEditText)
        resultTextView = findViewById(R.id.resultTextView)
        minusButton = findViewById(R.id.minusButton)
        minusButton.setOnClickListener{
            val result = firstEditText.text.toString().toDouble() - secondEditText.text.toString().toDouble()
            resultTextView.text = result.toString()
        }
        findViewById<Button>(R.id.multiButton).apply {
            this.setOnClickListener(object : View.OnClickListener{
                override fun onClick(v: View?) {
                    val result =
                        firstEditText.text.toString().toDouble() * secondEditText.text.toString()
                            .toDouble()
                    resultTextView.text = result.toString()
                }
            })
        }



    }
    public fun plusButtonPressed(view:View){
        val result = firstEditText.text.toString().toDouble() + secondEditText.text.toString().toDouble()
        resultTextView.text = result.toString()
    }

    public fun divideButtonPressed(view:View){
        val firstNumber = firstEditText.text.toString().toDouble()
        val secondNumber = secondEditText.text.toString().toDouble()
        if(secondNumber == 0.0){
            Toast.makeText(this,"Cannot divide by zero",Toast.LENGTH_LONG).show()
            resultTextView.text = "NaN"
            return
        }
        val result =
                firstNumber / secondNumber
        resultTextView.text = result.toString()

    }
}