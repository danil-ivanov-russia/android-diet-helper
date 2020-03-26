package com.example.diethelperapp.recipecreate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diethelperapp.R
import com.example.diethelperapp.databinding.FragmentRecipecreateBinding
import com.example.diethelperapp.db2.App
import com.example.diethelperapp.db2.DietDAO
import com.example.diethelperapp.ingredientlist.IngredientListFragmentDirections

class RecipeCreateFragment:  Fragment(), RecipeCreateClickNavigator {


    private val viewModel: RecipeCreateViewModel by navGraphViewModels(R.id.recipe_create_navigation) {
        object: ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                RecipeCreateViewModel(App.repositories.recipeCreate(), this@RecipeCreateFragment) as T
        }
    }


    /*
    private val viewModel: RecipeCreateViewModel by navGraphViewModels(R.id.recipe_create_navigation) {
        object: ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                RecipeCreateViewModel(RecipeCreateRepositoryMocked(), this@RecipeCreateFragment) as T
        }
    }*/

    private lateinit var dataBinding: FragmentRecipecreateBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding = FragmentRecipecreateBinding.inflate(inflater, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding.viewModel = viewModel
        dataBinding.lifecycleOwner = viewLifecycleOwner


        dataBinding.recyclerViewCurrentIngredients.layoutManager = LinearLayoutManager(requireContext())

        val ingredientObserver = Observer<List<DietDAO.Ingredients>> { it ->
            dataBinding.recyclerViewCurrentIngredients.adapter = RecipeCreateIngredientsAdapter(it, viewModel)

        }
        viewModel.thisIngredientsList.observe(viewLifecycleOwner, ingredientObserver)
    }

    override fun onIngredientAddClick() {
        val action = RecipeCreateFragmentDirections
            .actionRecipeCreateFragmentToIngredientListFragment()
        this.findNavController().navigate(action)
    }

    override fun onIngredientChooseClick() {
        val action = IngredientListFragmentDirections
            .actionIngredientListFragmentToRecipeCreateFragment()
        this.findNavController().navigate(action)
    }
}