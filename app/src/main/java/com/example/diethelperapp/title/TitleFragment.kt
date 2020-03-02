package com.example.diethelperapp.title

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.diethelperapp.R
import com.example.diethelperapp.databinding.FragmentTitleBinding
import kotlinx.android.synthetic.main.fragment_title.*

class TitleFragment : Fragment() {

    private lateinit var binding: FragmentTitleBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTitleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonToDietList.setOnClickListener {
            val action = TitleFragmentDirections
                .actionTitleFragmentToDietListFragment()
            this.findNavController().navigate(action)
        }


        binding.buttonToTestRecipe.setOnClickListener {
            val action = TitleFragmentDirections
                .actionTitleFragmentToRecipeFragment()
            this.findNavController().navigate(action)
        }

    }


}