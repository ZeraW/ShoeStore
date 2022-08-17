package com.udacity.shoestore.screens.splash

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.PrefsHelper
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentSplashBinding
import com.udacity.shoestore.screens.login.LoginFragmentDirections
import timber.log.Timber


class SplashFragment : Fragment() {



    private lateinit var binding: FragmentSplashBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSplashBinding.inflate(inflater,container,false)

        //sharedPref
        val status: String? = PrefsHelper.read("status","out-first")


        val timer: CountDownTimer = object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                navigateToWelcomeOrShoeList(status ?: "out-first")
            }
        }
        timer.start()

        return binding.root
    }


    private fun navigateToWelcomeOrShoeList(status: String) {
        when (status) {
            "in-first" -> findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToWelcomeFragment())
            "in" -> findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToShoeListFragment())
            else -> findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToLoginFragment())
        }


    }


}