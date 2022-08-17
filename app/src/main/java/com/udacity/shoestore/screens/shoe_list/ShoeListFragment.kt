package com.udacity.shoestore.screens.shoe_list

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainActivityViewModel
import com.udacity.shoestore.PrefsHelper
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeCardBinding
import com.udacity.shoestore.models.Shoe
import timber.log.Timber


class ShoeListFragment : Fragment() {
    private lateinit var binding: FragmentShoeListBinding
    private lateinit var shoeCardBinding: ShoeCardBinding
    private val viewModel: MainActivityViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShoeListBinding.inflate(inflater,container,false)
        shoeCardBinding = DataBindingUtil.inflate(inflater, R.layout.shoe_card, container, false)
        binding.mainViewModel = viewModel


        viewModel.shoeList.observe(viewLifecycleOwner) { list ->
            binding.shoeListLinear.removeAllViewsInLayout()
            for (shoe in list) {
                val shoeCardBinding1: ShoeCardBinding =
                    DataBindingUtil.inflate(inflater, R.layout.shoe_card, container, false)
                shoeCardBinding1.listItem = shoe
                binding.shoeListLinear.addView(shoeCardBinding1.root)
            }
        }

        //go to Details Fragment
        binding.addShoeFab.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToDetailsFragment())
        }



        setHasOptionsMenu(true)
        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.log_out, menu)

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.logout -> {
                PrefsHelper.write("status", "out")
                findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())

                false
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}