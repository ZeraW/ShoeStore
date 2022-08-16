package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

//the shoeListViewModel was the Activity lvl view model i just didn't change it name
class MainActivityViewModel : ViewModel() {
     var shoeList = MutableLiveData<MutableList<Shoe>>()

    init {
        initList()
    }

    private fun initList() {
        shoeList.value = mutableListOf(
            Shoe(
                "Kyrie 4",
                "42.0",
                "Nike",
                "Among the most popular signature shoes in the NBA, the Kyrie silhouette has reliably produced high-performing mid-top sneakers that focus on traction, cushioning and explosiveness.",
                "https://cdn.ballershoesdb.com/wp-content/uploads/2017/12/Nike-Kyrie-4-768x480.jpg",
                "70.0"
            ),
            Shoe(
                "Kobe AD NXT",
                "44.0",
                "Nike",
                "The Nike Kobe AD NXT is Kobe Bryant’s second post-retirement shoe. Designed in collaboration with Nike’s Eric Avar and released on April 3, 2017, the NXT’s silhouette is inspired by Hindu and Buddhist storytelling.",
                "https://cdn.ballershoesdb.com/wp-content/uploads/2017/03/kobeadnxt-Cropped-768x480.jpg",
                "77.0"
            ),
            Shoe(
                "KD Trey 5 VII",
                "45.0",
                "Nike",
                "The 7th iteration of Kevin Durant’s down-market signature shoe, the KD Trey 5 VII strikes a fine balance between affordability and performance with good cushioning via Nike Renew foam, a solid rubber outsole and a reinforced toe.",
                "https://cdn.ballershoesdb.com/wp-content/uploads/2019/07/NikeKDTrey5VII-Cropped-650x406.jpg",
                "85.0"
            ),
            Shoe(
                "LeBron 19",
                "44.0",
                "Nike",
                "The LeBron 19 made its debut in the 2021 film Space Jam: A New Legacy. The shoe features a double-chambered Air Max unit in the heel and a newly sculpted Zoom Air forefoot unit.",
                "https://cdn.ballershoesdb.com/wp-content/uploads/Lebron19Release-Cropped-650x406.jpg",
                "120.0"
            ),
        )
    }





}