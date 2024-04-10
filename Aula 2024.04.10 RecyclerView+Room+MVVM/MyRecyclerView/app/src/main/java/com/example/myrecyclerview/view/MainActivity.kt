package com.example.myrecyclerview.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myrecyclerview.R
import com.example.myrecyclerview.databinding.ActivityMainBinding
import com.example.myrecyclerview.model.Singleton
import com.example.myrecyclerview.viewmodel.MainViewModel
import com.example.myrecyclerview.viewmodel.MainViewModelFactory
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        Singleton.setContext(this)
        viewModel = MainViewModelFactory().create(MainViewModel::class.java)

        viewModel.citiesLiveData.observe(this, Observer {
            binding.mainRecyclerView.adapter?.notifyDataSetChanged()
        })

        binding.mainRecyclerView.adapter = CityAdapter(object : CityAdapter.OnCityClickListener {
            override fun onCityClick(view: View, position: Int) {
                Singleton.citySelected = Singleton.cities[position]
                val intent = Intent(this@MainActivity, CityDetailActivity::class.java)
                startActivity(intent)
            }

            override fun onCityLongClick(view: View, position: Int) {
                val deletedItem = Singleton.cities[position]
                viewModel.delete(deletedItem)
                //getString(R.string.item_deleted)
                Snackbar.make(view, R.string.item_deleted, Snackbar.LENGTH_LONG)
                    .setAction(R.string.undo) {
                        viewModel.add(deletedItem)
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
    }
}