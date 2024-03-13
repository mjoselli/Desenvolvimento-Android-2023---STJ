package com.example.myrecyclerview

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myrecyclerview.databinding.ActivityMainBinding
import java.io.IOException

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        loadCitiesFromFile(this, "cities.txt")

        binding.mainRecyclerView.adapter = CityAdapter(object : CityAdapter.OnCityClickListener {
            override fun onCityClick(view: android.view.View, position: Int) {
                Singleton.indexSelected = position
                val intent = Intent(this@MainActivity, CityDetailActivity::class.java)
                startActivity(intent)
            }

            override fun onCityLongClick(view: android.view.View, position: Int) {
                Singleton.cities.removeAt(position)
                binding.mainRecyclerView.adapter?.notifyItemRemoved(position)
                //Exercicio: Colocar um dialog para ter certeza que o usuário quer deletar
                //que deve realizar isso com uma snackbar
                //e migrar o save/load para o singleton
            }
        })

        binding.mainRecyclerView.layoutManager = LinearLayoutManager(this)

        binding.addItemButton.setOnClickListener {
            val intent = Intent(this, CityDetailActivity::class.java)
            Singleton.indexSelected = -1
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        saveCitiesToFile(this, "cities.txt")
        binding.mainRecyclerView.adapter?.notifyDataSetChanged()
    }

    private fun loadCitiesFromFile(context: Context, fileName: String) {
        val fileContents = loadFromFile(fileName)
        fileContents?.let {
            val cities = it.split("\n").map {
                val cityData = it.split(",")
                if (cityData.size != 3) {
                    return
                }
                City(cityData[0], cityData[1].toInt(), cityData[2].toBoolean())
            }
            Singleton.cities.clear()
            Singleton.cities.addAll(cities)
        }
    }

    private fun loadFromFile(filename:String) : String? {
        return try {
            applicationContext.openFileInput(filename).use {
                it.bufferedReader().use {
                    it.readText()
                }
            }
        } catch (e: IOException) {
            null
        }
    }

    private fun saveCitiesToFile(context: Context, fileName: String) {
        val fileContents = Singleton.cities.joinToString("\n") {
            "${it.name},${it.population},${it.isCapital}"
        }
        saveToFile(fileName, fileContents)
    }

    private fun saveToFile(filename:String, fileContents:String){
        applicationContext.openFileOutput(filename, Context.MODE_PRIVATE).use {
            it.write(fileContents.toByteArray())
        }
    }
}