package com.example.myrecyclerview.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.myrecyclerview.R
import com.example.myrecyclerview.databinding.ActivityCityDetailBinding
import com.example.myrecyclerview.model.City
import com.example.myrecyclerview.model.Singleton

class CityDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.
        setContentView<ActivityCityDetailBinding>(this, R.layout.activity_city_detail)

        Singleton.citySelected?.apply {
            binding.nameEditText.setText(name)
            binding.populationEditText.setText(population.toString())
            binding.capitalCheckBox.isChecked = isCapital
        }

        binding.saveButton.setOnClickListener {
            val name = binding.nameEditText.text.toString()
            val population = binding.populationEditText.text.toString().toInt()
            val isCapital = binding.capitalCheckBox.isChecked
            if (Singleton.citySelected == null) {
                Singleton.add(City(0, name, population, isCapital))
            }else {
                Singleton.citySelected?.apply {
                    this.name = name
                    this.population = population
                    this.isCapital = isCapital
                    Singleton.update(this)
                }
            }

            finish()
        }
    }
}