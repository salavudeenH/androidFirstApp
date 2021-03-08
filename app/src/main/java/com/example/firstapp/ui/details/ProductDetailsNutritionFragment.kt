package com.example.firstapp.ui.details

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.fragment.app.Fragment
import com.example.firstapp.R
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

        // Récupérer nutritional_facts_item_fat
        binding.nutritionalFactsItemFat.nutritionalFactsItemText.text = "0.8g de Matières grasses"
        binding.nutritionalFactsItemGras.nutritionalFactsItemText.text = "0.1g d'acides gras"
        binding.nutritionalFactsItemSugar.nutritionalFactsItemText.text = "5.2g de sucres"
        binding.nutritionalFactsItemSalt.nutritionalFactsItemText.text = "0.75g de sel"

        //changer couleur du rond
        DrawableCompat.setTintList(
            binding.nutritionalFactsItemFat.nutritionalFactsItemIndicator.background,
            ColorStateList.valueOf(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.nutrient_level_low
                )
            )
        )
        DrawableCompat.setTintList(
            binding.nutritionalFactsItemGras.nutritionalFactsItemIndicator.background,
            ColorStateList.valueOf(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.nutrient_level_low
                )
            )
        )
        DrawableCompat.setTintList(
            binding.nutritionalFactsItemSugar.nutritionalFactsItemIndicator.background,
            ColorStateList.valueOf(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.nutrient_level_moderate
                )
            )
        )
        DrawableCompat.setTintList(
            binding.nutritionalFactsItemSalt.nutritionalFactsItemIndicator.background,
            ColorStateList.valueOf(
                ContextCompat.getColor(requireContext(),
                    R.color.nutrient_level_high
                )
            )
        )
    }
}