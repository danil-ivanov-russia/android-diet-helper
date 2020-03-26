package com.example.diethelperapp.diet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.diethelperapp.databinding.FragmentDietBinding
import com.example.diethelperapp.db2.App

class DietFragment : Fragment() {


    val args: DietFragmentArgs by navArgs()


    private val viewModel: DietViewModel by viewModels {

        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                DietViewModel(args.dietId, App.repositories.diet()) as T
        }
    }

    private lateinit var dataBinding: FragmentDietBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = FragmentDietBinding.inflate(inflater, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataBinding.viewModel = viewModel
        dataBinding.lifecycleOwner = viewLifecycleOwner

        dataBinding.buttonToWeekPlan.setOnClickListener {
            val action = DietFragmentDirections.
                actionDietFragmentToDietPlanFragment(viewModel.diet.value!!.dietId)
            this.findNavController().navigate(action)
        }
    }
}