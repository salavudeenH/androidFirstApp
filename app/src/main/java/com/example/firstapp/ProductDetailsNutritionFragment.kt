package com.example.firstapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.firstapp.databinding.ProductDetailsNutritionBinding


class ProductDetailsNutritionFragment : Fragment() {
    private lateinit var binding: ProductDetailsNutritionBinding

    // Equivalent du setContentView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ProductDetailsNutritionBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}