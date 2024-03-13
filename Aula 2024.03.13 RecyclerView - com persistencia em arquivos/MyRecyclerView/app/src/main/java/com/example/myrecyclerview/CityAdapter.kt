package com.example.myrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myrecyclerview.databinding.ItemViewBinding

class CityAdapter(val clickListener: OnCityClickListener?) : RecyclerView.Adapter<CityAdapter.ViewHolder>(){
    interface OnCityClickListener{
        fun onCityClick(view: View, position: Int)
        fun onCityLongClick(view: View, position: Int)
    }

    inner class ViewHolder(val binding: ItemViewBinding) :RecyclerView.ViewHolder(binding.root){
        fun bind(city: City){
            binding.textView1.text = city.name
            binding.textView2.text = city.population.toString()
            binding.root.setOnClickListener {
                clickListener?.onCityClick(it, adapterPosition)
            }
            binding.root.setOnLongClickListener {
                clickListener?.onCityLongClick(it, adapterPosition)
                true
            }
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
        Singleton.cities[position].apply {
            holder.bind(this)
        }
    }

    override fun getItemCount() = Singleton.cities.size
}