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
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diethelperapp.R
import com.example.diethelperapp.common.models.DishesModel
import com.example.diethelperapp.databinding.FragmentRecipelistBinding
import com.example.diethelperapp.db2.App
import kotlinx.android.synthetic.main.fragment_recipelist.*

class RecipeListFragment : Fragment(), RecipeListClickNavigator {


    val args: RecipeListFragmentArgs by navArgs()

    private val viewModel: RecipeListViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                RecipeListViewModel(App.repositories.recipeList(), this@RecipeListFragment) as T
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

        recyclerViewRecipes.layoutManager = LinearLayoutManager(requireContext())

        when (args.preopenedCategory){
            2 -> {
                dataBinding.bottomNavigationBar.selectedItemId = R.id.bottomNavigationItemUserRecipes
                viewModel.selectUserRecipes()
            }
            else -> {
                dataBinding.bottomNavigationBar.selectedItemId = R.id.bottomNavigationItemStandartRecipes
                viewModel.selectStandartRecipes()
            }
        }


        val recipesNameObserver = Observer<List<DishesModel>> { it ->
            recyclerViewRecipes.adapter = RecipeListAdapter(it, viewModel)

        }
        viewModel.recipesNames.observe(viewLifecycleOwner, recipesNameObserver)

        dataBinding.bottomNavigationBar.setOnNavigationItemSelectedListener {
            if (it.itemId != dataBinding.bottomNavigationBar.selectedItemId)
                when (it.itemId) {
                    R.id.bottomNavigationItemUserRecipes -> {
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

        dataBinding.addDishButton.setOnClickListener {
            val action = RecipeListFragmentDirections
                .actionRecipeListFragmentToRecipeCreateNavigation(args.day, args.timeOfDay)
            this.findNavController().navigate(action)
        }

    }

    override fun onRecipeCreateClick() {
    }


}