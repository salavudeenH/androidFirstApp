package com.example.firstapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.databinding.ListBinding

class ProductsListFragmentListFragment : Fragment() {

    private lateinit var binding: ListBinding

    // Equivalent du setContentView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ListBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val products = listOf(
            Product(
                nom = "Nom du produit 1",
                marque = "Marque du produit",
                list_additif = "aucune",
                code_barres = "029388383838",
                list_ingredients = listOf("Ingr1", "Ingr2"),
                list_pays_vendu = "France",
                list_substance = "Aucune",
                url_image = "https://www.aprifel.com/wp-content/uploads/2019/02/carotte.jpg",
                quantite = "20g",
                nutriscores = "E"

            ),
            Product(
                nom = "Nom du produit 1",
                marque = "Marque du produit",
                list_additif = "aucune",
                code_barres = "029388383838",
                list_ingredients = listOf("Ingr1", "Ingr2"),
                list_pays_vendu = "France",
                list_substance = "Aucune",
                url_image = "https://www.aprifel.com/wp-content/uploads/2019/02/carotte.jpg",
                quantite = "20g",
                nutriscores = "F"

            ),
            Product(
                nom = "Nom du produit 1",
                marque = "Marque du produit",
                list_additif = "aucune",
                code_barres = "029388383838",
                list_ingredients = listOf("Ingr1", "Ingr2"),
                list_pays_vendu = "France",
                list_substance = "Aucune",
                url_image = "https://www.aprifel.com/wp-content/uploads/2019/02/carotte.jpg",
                quantite = "20g",
                nutriscores = "F"

            )
        )

        binding.recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        binding.recyclerView.adapter = ListAdapter(products)

    }
}