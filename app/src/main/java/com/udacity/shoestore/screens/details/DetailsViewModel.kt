package com.udacity.shoestore.screens.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class DetailsViewModel : ViewModel() {
    val name = MutableLiveData<String>()
    val company = MutableLiveData<String>()
    val description = MutableLiveData<String>()
    val size = MutableLiveData<String>()
    val price = MutableLiveData<String>()
    val url = MutableLiveData<String>()

    private var _shoe = MutableLiveData<Shoe?>()
    val shoe: LiveData<Shoe?> get() = _shoe


    fun onSubmitClick() {
        if (name.value != null && company.value != null && description.value != null && size.value != null && url.value != null && price.value != null) {
            _shoe.value =Shoe(name.value!!, size.value!!, company.value!!, description.value!!, url.value!!, price.value!!)


        } else {
            _shoe.value =null
        }

    }
}