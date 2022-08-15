package com.udacity.shoestore.screens.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class DetailsViewModel : ViewModel() {
    private var _shoe = MutableLiveData<Shoe?>()
    val shoe: LiveData<Shoe?> get() = _shoe

    fun onSubmitClick(
        name: String?,
        company: String?,
        description: String?,
        size: String?,
        price: String?,
        url: String?
    ) {
        if (name != null && company != null && description != null && size != null && price != name && url != null && price != null) {
            _shoe.value = Shoe(name, size.toDouble(), company, description, url, price.toDouble())
        }else{
            _shoe.value = null
        }

    }
}