package com.example.contadorapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var editText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById<TextView>(R.id.textView)
        textView.text = "Hello World!"
        Log.i("MainActivity", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i("MainActivity", "onStart")
    }
    override fun onResume() {
        super.onResume()
        Log.i("MainActivity", "onResume")
    }
    override fun onPause() {
        super.onPause()
        Log.i("MainActivity", "onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.i("MainActivity", "onStop")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity", "onDestroy")
    }
    override fun onRestart() {
        super.onRestart()
        Log.i("MainActivity", "onRestart")
    }
    public fun buttonClick(view: View){
        editText = findViewById<TextView>(R.id.editText)
        textView = findViewById<TextView>(R.id.textView)
        val text = editText.text.toString()
        textView.text = text
        val number = text.toInt()
        val result = number + 1
        editText.text = result.toString()
    }
    public fun buttonClick2(view: View){
        Log.d("MainActivity", "buttonClick")
    }
}