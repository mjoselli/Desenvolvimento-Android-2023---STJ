package com.example.myactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class SecondActivity : AppCompatActivity() {
    var buttonText: String = "Hello"
    lateinit var adapter: ArrayAdapter<String>
    var list: ArrayList<String> = arrayListOf("a","b","c")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        buttonText = intent.getStringExtra("buttonText").toString()
        findViewById<Button>(R.id.button2).apply {
            text = buttonText
            setOnClickListener {
                val intent = Intent()
                intent.putExtra("second", "muito legal")
                setResult(RESULT_OK, intent)
                Singleton.information = "go To second activity 2"
                finish()
            }
        }
        val listView = findViewById<ListView>(R.id.listView)
        adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list)
        listView.adapter = adapter
        listView.setOnItemClickListener { parent, view, position, id ->
            list.removeAt(position)
            adapter.notifyDataSetChanged()
        }
        listView.setOnItemLongClickListener { adapterView, view, i, l ->
            list.set(i, "e")
            adapter.notifyDataSetChanged()
            return@setOnItemLongClickListener true
        }

        findViewById<Button>(R.id.buttonAdd).apply {
            setOnClickListener {
                list.add("d")
                adapter.notifyDataSetChanged()
            }
        }
    }
}