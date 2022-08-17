package com.udacity.shoestore.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.PrefsHelper
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater,container,false)

        //pref
        val status: String? = PrefsHelper.read("status", "out-first")

        binding.login.setOnClickListener { navigateToWelcomeOrShoeList(status ?: "out-first") }
        binding.register.setOnClickListener { navigateToWelcomeOrShoeList(status ?: "out-first") }

        return binding.root
    }

    private fun navigateToWelcomeOrShoeList(status: String) {
        when (status) {
            "out" -> {
                PrefsHelper.write("status", "in")
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToShoeListFragment())
            }
            else -> {
                PrefsHelper.write("status", "in-first")
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            }
        }
    }

}