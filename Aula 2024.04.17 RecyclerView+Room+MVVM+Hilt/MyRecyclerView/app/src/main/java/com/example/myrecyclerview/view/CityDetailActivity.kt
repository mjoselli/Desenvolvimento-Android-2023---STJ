package com.example.myrecyclerview.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.myrecyclerview.R
import com.example.myrecyclerview.databinding.ActivityCityDetailBinding
import com.example.myrecyclerview.model.City
import com.example.myrecyclerview.model.CityRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CityDetailActivity : AppCompatActivity() {
    @Inject lateinit var cityRepository: CityRepository
    var city:City? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.
        setContentView<ActivityCityDetailBinding>(this, R.layout.activity_city_detail)

        var cityPosition = intent.getIntExtra("cityPosition",-1)

        if (cityPosition >=0) {
            cityRepository.cities[cityPosition].apply {
                city = this
                binding.nameEditText.setText(name)
                binding.populationEditText.setText(population.toString())
                binding.capitalCheckBox.isChecked = isCapital
            }
        }

        binding.saveButton.setOnClickListener {
            val name = binding.nameEditText.text.toString()
            val population = binding.populationEditText.text.toString().toInt()
            val isCapital = binding.capitalCheckBox.isChecked
            if (city == null) {
                cityRepository.add(City(0, name, population, isCapital))
            }else {
                city?.apply {
                    this.name = name
                    this.population = population
                    this.isCapital = isCapital
                    cityRepository.update(this)
                }
            }

            finish()
        }
    }
}