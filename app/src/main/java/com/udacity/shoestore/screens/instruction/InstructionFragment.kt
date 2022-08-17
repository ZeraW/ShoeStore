package com.udacity.shoestore.screens.instruction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.PrefsHelper
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionBinding


class InstructionFragment : Fragment() {

    private lateinit var binding: FragmentInstructionBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentInstructionBinding.inflate(inflater,container,false)

        binding.enterBtn.setOnClickListener { v: View ->
            PrefsHelper.write("status","in")
            v.findNavController().navigate(InstructionFragmentDirections.actionInstructionFragmentToShoeListFragment())
        }
        binding.prevBtn.setOnClickListener { v: View ->
            v.findNavController().popBackStack()
        }


        return binding.root
    }


}