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
import com.example.myrecyclerview.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar
import androidx.activity.viewModels
import com.example.myrecyclerview.model.CityRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val viewModel: MainViewModel by viewModels()
    @Inject lateinit var cityRepository:CityRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        viewModel.citiesLiveData.observe(this, Observer {
            binding.mainRecyclerView.adapter?.notifyDataSetChanged()
        })

        binding.mainRecyclerView.adapter = CityAdapter(cityRepository,object : CityAdapter.OnCityClickListener {
            override fun onCityClick(view: View, position: Int) {
                val intent = Intent(this@MainActivity, CityDetailActivity::class.java)
                intent.putExtra("cityPosition",position)
                startActivity(intent)
            }

            override fun onCityLongClick(view: View, position: Int) {
                val deletedItem = viewModel.get(position)
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
            //CityRepository.citySelected = null
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.refresh()
    }
}