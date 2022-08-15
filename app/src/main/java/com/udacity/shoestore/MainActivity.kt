package com.udacity.shoestore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.ActivityMainBinding
import com.udacity.shoestore.screens.shoe_list.ShoeListViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var viewModel: ShoeListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this)[ShoeListViewModel::class.java]

        supportActionBar?.hide()
        navController = this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if(destination.id == R.id.shoeListFragment) {
                supportActionBar?.show()
                supportActionBar?.setDisplayHomeAsUpEnabled(false)
            } else if(destination.id == R.id.welcomeFragment || destination.id == R.id.loginFragment) {
                supportActionBar?.hide()
                supportActionBar?.setDisplayHomeAsUpEnabled(false)
            }
        }


    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }


}
