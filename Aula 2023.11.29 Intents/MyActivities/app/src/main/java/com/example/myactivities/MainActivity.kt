package com.example.myactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.myactivities.databinding.ActivityMainBinding
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    var information: String = "Hello"

    val resultLauncer = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val data: Intent? = result.data
            val result = data?.getStringExtra("second")
            findViewById<TextView>(R.id.titleTextView).apply {
                text = result
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*findViewById<TextView>(R.id.titleTextView).apply {
            text = "Hello"
        }*/
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        binding.titleTextView.text = "hello"

        binding.button.apply {
            text = "go To second activity"
            setOnClickListener {
                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                intent.putExtra("buttonText", information)
                //startActivity(intent)
                resultLauncer.launch(intent)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        binding.button.text = Singleton.information
    }
}