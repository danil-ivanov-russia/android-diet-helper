package com.example.diethelperapp.dietlist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diethelperapp.db2.App
import com.example.diethelperapp.db2.models.DietModel
import com.example.diethelperapp.databinding.FragmentDietlistBinding
import kotlinx.android.synthetic.main.fragment_dietlist.*

class DietListFragment :  Fragment(), DietListItemClickNavigator {
    private val viewModel: DietListViewModel by viewModels {
        object: ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                DietListViewModel(App.repositories.diet(), this@DietListFragment) as T
        }
    }

    private lateinit var dataBinding: FragmentDietlistBinding



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding = FragmentDietlistBinding.inflate(inflater, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.navigator = this
        dataBinding.viewModel = viewModel
        dataBinding.lifecycleOwner = viewLifecycleOwner

        recyclerViewDiet.layoutManager = LinearLayoutManager(requireContext())

        val dietNameObserver = Observer<List<DietModel>> { it ->
            recyclerViewDiet.adapter = DietListAdapter(it, viewModel)

        }
        viewModel.dietsNames.observe(viewLifecycleOwner, dietNameObserver)
    }

    override fun onItemClick(id: Int) {
        val action = DietListFragmentDirections
                .actionDietListFragmentToDietFragment(id)
        this.findNavController().navigate(action)
    }


}