package com.example.diethelperapp.dietList

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.diethelperapp.DB.App
import com.example.diethelperapp.DB2.Models.DietModel
import com.example.diethelperapp.R
import com.example.diethelperapp.databinding.FragmentDietlistBinding
import com.example.diethelperapp.diet.DietRepositoryMocked
import com.example.diethelperapp.recipe.RecipeRepositoryMocked
import com.example.diethelperapp.recipe.RecipeViewModel
import com.example.diethelperapp.title.TitleFragmentDirections
import kotlinx.android.synthetic.main.fragment_dietlist.*

class DietListFragment :  Fragment(), DietListItemClickNavigator  {
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

        dataBinding.viewModel = viewModel
        dataBinding.lifecycleOwner = viewLifecycleOwner

        recyclerViewDiet.apply{
            layoutManager = LinearLayoutManager(requireContext())
        }
        val dietNameObserver = Observer<List<DietModel>> { it ->
            recyclerViewDiet.apply{
                adapter = DietListAdapter(it, viewModel)
            }
        }
        viewModel.dietsNames.observe(viewLifecycleOwner, dietNameObserver)
    }

    override fun onItemClick(id: Int) {
        val action =
            DietListFragmentDirections
                .actionDietListFragmentToDietFragment(id)
        this.findNavController().navigate(action)
    }


}