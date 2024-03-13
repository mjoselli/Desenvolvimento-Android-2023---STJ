package com.example.myrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.myrecyclerview.databinding.ActivityCityDetailBinding

class CityDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.
                    setContentView<ActivityCityDetailBinding>(this, R.layout.activity_city_detail)
        binding.saveButton.setOnClickListener {
            val name = binding.nameEditText.text.toString()
            val population = binding.populationEditText.text.toString().toInt()
            val isCapital = binding.capitalCheckBox.isChecked
            Singleton.cities.add(City(name, population, isCapital))
            finish()
        }
    }
}