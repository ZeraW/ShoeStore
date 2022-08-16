package com.udacity.shoestore.screens.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainActivityViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentDetailsBinding
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private val viewModel: MainActivityViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)
        binding.detailsViewModel = viewModel


        viewModel.submitted.observe(viewLifecycleOwner) { isSubmitted ->
            if (isSubmitted != null) {
                if (isSubmitted) {
                    findNavController().popBackStack()
                    viewModel.submitted.value =null
                } else {
                    Toast.makeText(context, "You must fill all the fields", Toast.LENGTH_LONG).show()
                    viewModel.submitted.value =null
                }
            }
        }

        return binding.root
    }

}