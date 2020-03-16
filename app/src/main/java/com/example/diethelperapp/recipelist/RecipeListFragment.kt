package com.example.diethelperapp.recipelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diethelperapp.db2.models.DishesModel
import com.example.diethelperapp.R
import com.example.diethelperapp.databinding.FragmentRecipelistBinding
import kotlinx.android.synthetic.main.fragment_dietlist.*

class RecipeListFragment : Fragment() {
    private val viewModel: RecipeListViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                RecipeListViewModel(RecipeListRepositoryMocked()) as T
        }
    }

    private lateinit var dataBinding: FragmentRecipelistBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding = FragmentRecipelistBinding.inflate(inflater, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //viewModel.navigator = this
        dataBinding.viewModel = viewModel
        dataBinding.lifecycleOwner = viewLifecycleOwner

        recyclerViewDiet.layoutManager = LinearLayoutManager(requireContext())

        val recipesNameObserver = Observer<List<DishesModel>> { it ->
            recyclerViewDiet.adapter = RecipeListAdapter(it, viewModel)

        }
        viewModel.recipesNames.observe(viewLifecycleOwner, recipesNameObserver)


        dataBinding.bottomNavigationBar.setOnNavigationItemSelectedListener {
            if (it.itemId != dataBinding.bottomNavigationBar.selectedItemId)
            when (it.itemId) {
                R.id.bottomNavigationItemUserRecipes -> {
                    //if !(dataBinding.bottomNavigationBar.menu.findItem())
                    viewModel.selectUserRecipes()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.bottomNavigationItemWebRecipes -> {
                    viewModel.selectWebRecipes()
                    return@setOnNavigationItemSelectedListener true
                }
                else -> {
                    viewModel.selectStandartRecipes()
                    return@setOnNavigationItemSelectedListener true
                }
            }
            else
                return@setOnNavigationItemSelectedListener false

        }
    }


}