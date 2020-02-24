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
import kotlinx.android.synthetic.main.fragment_title.*

class TitleFragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return inflater.inflate(R.layout.fragment_title, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonToDietList.setOnClickListener{
            val action =
                TitleFragmentDirections
                    .actionTitleFragmentToDietListFragment()
            this.findNavController().navigate(action)
        }

        buttonToTestRecipe.setOnClickListener{
            val action =
                TitleFragmentDirections
                    .actionTitleFragmentToRecipeFragment()
            this.findNavController().navigate(action)
        }

    }





}