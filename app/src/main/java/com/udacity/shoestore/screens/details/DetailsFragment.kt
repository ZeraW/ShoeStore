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
    private val mainViewModel: MainActivityViewModel by activityViewModels()
    private lateinit var detailsViewModel: DetailsViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater,container,false)
        detailsViewModel = ViewModelProvider(this)[DetailsViewModel::class.java]
        binding.detailsViewModel = detailsViewModel
        binding.lifecycleOwner = this
        binding.cancel.setOnClickListener {
            findNavController().popBackStack()
        }

        detailsViewModel.shoe.observe(viewLifecycleOwner) { shoe ->
            if (shoe != null) {
                mainViewModel.shoeList.value?.add(shoe)
                findNavController().popBackStack()
            } else {
                Toast.makeText(context, "You must fill all the fields", Toast.LENGTH_LONG).show()
            }

        }

        return binding.root
    }

}