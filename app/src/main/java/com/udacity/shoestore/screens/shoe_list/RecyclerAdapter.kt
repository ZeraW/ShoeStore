package com.udacity.shoestore.screens.shoe_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.udacity.shoestore.databinding.ShoeCardBinding
import com.udacity.shoestore.models.Shoe

class RecyclerAdapter(private var data: List<Shoe>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //inflate shoe card with recycler
        val inflater = LayoutInflater.from(parent.context)
        val listItemBinding = ShoeCardBinding.inflate(inflater, parent, false)
        return ViewHolder(listItemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        //get list size
        return data.size
    }

    inner class ViewHolder(val binding: ShoeCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Shoe) {
            binding.listItem = item
        }
    }
}