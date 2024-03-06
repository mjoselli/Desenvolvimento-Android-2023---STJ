package com.example.myrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myrecyclerview.databinding.ItemViewBinding

class CityAdapter : RecyclerView.Adapter<CityAdapter.ViewHolder>(){
    inner class ViewHolder(val binding: ItemViewBinding) :RecyclerView.ViewHolder(binding.root){
        fun bind(city: City){
            binding.textView1.text = city.name
            binding.textView2.text = city.population.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemViewBinding.
            inflate(
                LayoutInflater.from(parent.context),
                parent,
                false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = Singleton.cities.size
}