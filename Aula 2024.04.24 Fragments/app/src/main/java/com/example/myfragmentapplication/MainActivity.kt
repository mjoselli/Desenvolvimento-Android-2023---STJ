package com.example.myfragmentapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.fragment.app.replace

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("ciclo","Activity onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.fragmentButton1).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView,FirstFragment(),"First")
                .commit()
        }
        findViewById<Button>(R.id.fragmentButton2).setOnClickListener {
            val bundle = bundleOf(
                "text" to "Hello Second Fragment"
            )
            supportFragmentManager.beginTransaction()
                .replace<SecondFragment>(R.id.fragmentContainerView,args = bundle)
                .commit()

            Log.i("ciclo","start Fragment")

        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("ciclo","Activity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("ciclo","Activity onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("ciclo","Activity onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("ciclo","Activity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("ciclo","Activity onDestroy")
    }
}