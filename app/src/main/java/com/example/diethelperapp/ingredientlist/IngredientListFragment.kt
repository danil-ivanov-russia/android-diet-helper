package com.example.diethelperapp.ingredientlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diethelperapp.R
import com.example.diethelperapp.databinding.FragmentIngredientlistBinding
import com.example.diethelperapp.db2.DietDAO
import com.example.diethelperapp.recipecreate.RecipeCreateViewModel

class IngredientListFragment:  Fragment() {
    private val viewModel: RecipeCreateViewModel by navGraphViewModels(R.id.recipe_create_navigation)

    private lateinit var dataBinding: FragmentIngredientlistBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding = FragmentIngredientlistBinding.inflate(inflater, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding.viewModel = viewModel
        dataBinding.lifecycleOwner = viewLifecycleOwner

        dataBinding.recyclerViewIngredients.layoutManager = LinearLayoutManager(requireContext())

        val ingredientObserver = Observer<List<DietDAO.Ingredients>> { it ->
            dataBinding.recyclerViewIngredients.adapter = IngredientListAdapter(it, viewModel)

        }
        viewModel.allIngredientsList.observe(viewLifecycleOwner, ingredientObserver)
    }
}