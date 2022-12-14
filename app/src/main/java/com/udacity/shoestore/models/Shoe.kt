package com.udacity.shoestore.models

import android.os.Parcelable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(var name: String, var size: String, var company: String, var description: String,  var image:String, var price:String):Parcelable
{
    companion object {
        @JvmStatic //todo idk what this do ( remember to ask )
        @BindingAdapter("image")
        fun setImage(image: ImageView, url: String?) {

            if (!url.isNullOrEmpty()){

                Glide.with(image.context).load(url).fitCenter().into(image)
            }

        }
    }
}


