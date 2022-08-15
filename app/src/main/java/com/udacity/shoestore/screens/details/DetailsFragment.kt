package com.udacity.shoestore.screens.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentDetailsBinding
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private lateinit var viewModel: DetailsViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)
        viewModel = ViewModelProvider(this)[DetailsViewModel::class.java]
        binding.detailsViewModel = viewModel

        viewModel.shoe.observe(viewLifecycleOwner) { getShoe ->
            if (getShoe != null) {
                //pop the page and pass the data to List fragment
                val navController = findNavController()
                navController.previousBackStackEntry?.savedStateHandle?.set("key", getShoe)
                navController.popBackStack()
            } else {
                Toast.makeText(context, "You must fill all the fields", Toast.LENGTH_LONG).show()
            }
        }

        return binding.root
    }

}