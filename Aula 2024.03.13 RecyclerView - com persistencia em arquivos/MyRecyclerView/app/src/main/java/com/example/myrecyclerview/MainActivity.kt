package com.example.myrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.mainRecyclerView.adapter = CityAdapter(object : CityAdapter.OnCityClickListener {
            override fun onCityClick(view: android.view.View, position: Int) {
                Singleton.cities[position].apply {
                    name = name + " clicked"
                }
                binding.mainRecyclerView.adapter?.notifyItemChanged(position)
            }

            override fun onCityLongClick(view: android.view.View, position: Int) {
                Singleton.cities.removeAt(position)
                binding.mainRecyclerView.adapter?.notifyItemRemoved(position)
            }
        })

        Singleton.cities.add(City("Tokyo", 13929286, true))
        Singleton.cities.add(City("Delhi", 12952100, true))
        Singleton.cities.add(City("Shanghai", 12600000, true))
        Singleton.cities.add(City("Sao Paulo", 12106920, true))
        Singleton.cities.add(City("Mumbai", 12442373, true))
        Singleton.cities.add(City("Mexico City", 12294193, true))
        Singleton.cities.add(City("Cairo", 11922948, true))
        Singleton.cities.add(City("Beijing", 11716620, true))
        Singleton.cities.add(City("Dhaka", 11174297, true))
        Singleton.cities.add(City("Osaka", 11294000, true))
        Singleton.cities.add(City("Curitiba", 1100430, true))
        binding.mainRecyclerView.layoutManager = LinearLayoutManager(this)

        binding.addItemButton.setOnClickListener {
            val intent = Intent(this, CityDetailActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        binding.mainRecyclerView.adapter?.notifyDataSetChanged()
    }
}