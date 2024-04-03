package com.example.myrecyclerview.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myrecyclerview.R
import com.example.myrecyclerview.databinding.ActivityMainBinding
import com.example.myrecyclerview.model.Singleton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        Singleton.setContext(this)

        binding.mainRecyclerView.adapter = CityAdapter(object : CityAdapter.OnCityClickListener {
            override fun onCityClick(view: View, position: Int) {
                Singleton.citySelected = Singleton.cities[position]
                val intent = Intent(this@MainActivity, CityDetailActivity::class.java)
                startActivity(intent)
            }

            override fun onCityLongClick(view: View, position: Int) {
                val deletedItem = Singleton.cities[position]
                Singleton.delete(deletedItem)
                binding.mainRecyclerView.adapter?.notifyItemRemoved(position)
                //getString(R.string.item_deleted)
                Snackbar.make(view, R.string.item_deleted, Snackbar.LENGTH_LONG)
                    .setAction(R.string.undo) {
                        Singleton.add(deletedItem)
                        binding.mainRecyclerView.adapter?.notifyItemInserted(position)
                    }
                    .show()
            }
        })

        binding.mainRecyclerView.layoutManager = LinearLayoutManager(this)

        binding.addItemButton.setOnClickListener {
            val intent = Intent(this, CityDetailActivity::class.java)
            Singleton.citySelected = null
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        binding.mainRecyclerView.adapter?.notifyDataSetChanged()
    }
}