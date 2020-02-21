package com.example.diethelperapp.recipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.R
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.diethelperapp.databinding.FragmentRecipeBinding

class RecipeFragment : Fragment() {
    private val viewModel: RecipeViewModel by viewModels {
        object: ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                RecipeViewModel("Яичница с беконом", RecipeRepositoryMocked()) as T
        }
    }

    private lateinit var dataBinding: FragmentRecipeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = FragmentRecipeBinding.inflate(inflater, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataBinding.viewModel = viewModel
        dataBinding.lifecycleOwner = viewLifecycleOwner
    }
}