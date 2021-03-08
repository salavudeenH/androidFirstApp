package com.example.firstapp.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.firstapp.model.Product
import com.example.firstapp.databinding.ProductDetailsSummaryFragmentBinding


class ProductDetailsSummaryFragment : Fragment() {

    private lateinit var binding: ProductDetailsSummaryFragmentBinding

    // Equivalent du setContentView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ProductDetailsSummaryFragmentBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val product = Product(
            "Carrotes",
            "Clem",
            "367830373833",
            "E",
            "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg",
            "400g",
            "France, Japon, Suisse",
            listOf("Sel", "carootes", "cvnfjnvf"),
            "Aucune",
            "Aucun"
        )
        binding.TPois.text = product.nom
        binding.subTitle.text = product.marque
        binding.tcodebar.text = product.code_barres
        binding.tvendu.text = product.list_pays_vendu
        binding.tingredient.text = product.list_ingredients.joinToString(" , ")
        binding.tsubstances.text = product.list_substance
        binding.tadditifs.text = product.list_additif

        Glide.with(this)
            .load("https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg")
            .into(binding.plat)
    }
}