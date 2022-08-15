package com.udacity.shoestore.screens.shoe_list

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.udacity.shoestore.PrefsHelper
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe

class ShoeListFragment : Fragment() {
    private lateinit var binding: FragmentShoeListBinding
    private lateinit var xadapter: RecyclerAdapter
    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        viewModel.shoeList.observe(viewLifecycleOwner) { list ->
            xadapter = RecyclerAdapter(list)
            if (list != null) {
                //init the recycler
                binding.shoeListRecycler.apply {
                    adapter = xadapter
                    layoutManager = LinearLayoutManager(context)
                }
            }
        }

        //go to Details Fragment
        binding.addShoeFab.setOnClickListener {
             findNavController()
                 .navigate(ShoeListFragmentDirections.actionShoeListFragmentToDetailsFragment())
        }



        //get data from Detail Fragment
        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<Shoe>("key")?.observe(viewLifecycleOwner) {shoe->
                if(shoe!=null){
                    updateList(shoe)
                }
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
                PrefsHelper.write("status","out")
                findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())

                false
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateList(shoe: Shoe){
        viewModel.updateList(shoe)
        xadapter.notifyDataSetChanged()
    }
}