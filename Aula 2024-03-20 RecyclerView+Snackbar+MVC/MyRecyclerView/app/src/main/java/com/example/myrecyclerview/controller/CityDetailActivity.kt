package com.example.myrecyclerview.controller

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

        if (Singleton.indexSelected >= 0) {
            binding.nameEditText.setText(Singleton.cities[Singleton.indexSelected].name)
            binding.populationEditText.setText(Singleton.cities[Singleton.indexSelected].population.toString())
            binding.capitalCheckBox.isChecked = Singleton.cities[Singleton.indexSelected].isCapital
        }

        binding.saveButton.setOnClickListener {
            val name = binding.nameEditText.text.toString()
            val population = binding.populationEditText.text.toString().toInt()
            val isCapital = binding.capitalCheckBox.isChecked
            if (Singleton.indexSelected >= 0) {
                Singleton.cities[Singleton.indexSelected] = City(name, population, isCapital)
            } else {
                Singleton.cities.add(City(name, population, isCapital))
            }
            Singleton.saveCitiesToFile(this)
            finish()
        }
    }
}