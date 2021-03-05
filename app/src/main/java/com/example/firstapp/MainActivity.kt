package com.example.firstapp

import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.bumptech.glide.Glide
import com.example.firstapp.databinding.DetailsTabSummaryBinding
import com.example.firstapp.databinding.NutritionalFactsBinding
import kotlinx.android.synthetic.main.details_tab_summary.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Utiliser le layout nutritional_facts
        val binding = DetailsTabSummaryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Récupérer nutritional_facts_item_fat
//        binding.nutritionalFactsItemFat.nutritionalFactsItemText.text = "0.8g de Matières grasses"
//        binding.nutritionalFactsItemGras.nutritionalFactsItemText.text = "0.1g d'acides gras"
//        binding.nutritionalFactsItemSugar.nutritionalFactsItemText.text = "5.2g de sucres"
//        binding.nutritionalFactsItemSalt.nutritionalFactsItemText.text = "0.75g de sel"
//
//        //changer couleur du rond
//        DrawableCompat.setTintList(binding.nutritionalFactsItemFat.nutritionalFactsItemIndicator.background, ColorStateList.valueOf(ContextCompat.getColor(this, R.color.nutrient_level_low)))
//        DrawableCompat.setTintList(binding.nutritionalFactsItemGras.nutritionalFactsItemIndicator.background, ColorStateList.valueOf(ContextCompat.getColor(this, R.color.nutrient_level_low)))
//        DrawableCompat.setTintList(binding.nutritionalFactsItemSugar.nutritionalFactsItemIndicator.background, ColorStateList.valueOf(ContextCompat.getColor(this, R.color.nutrient_level_moderate)))
//        DrawableCompat.setTintList(binding.nutritionalFactsItemSalt.nutritionalFactsItemIndicator.background, ColorStateList.valueOf(ContextCompat.getColor(this, R.color.nutrient_level_high)))
        val product = Product( "Carrotes","Clem","367830373833","E","https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg","400g","France, Japon, Suisse", listOf("Sel", "carootes","cvnfjnvf"),"Aucune","Aucun")
        binding.TPois.text=product.nom
        binding.subTitle.text=product.marque
        binding.tcodebar.text=product.code_barres
        binding.tvendu.text=product.list_pays_vendu
        binding.tingredient.text=product.list_ingredients.joinToString  (" , " )
        binding.tsubstances.text=product.list_substance
        binding.tadditifs.text=product.list_additif

        Glide.with(this)
            .load("https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg")
            .into(binding.plat)

    }

}

   data class Product (val nom: String, val marque: String,val code_barres:String, val nutriscores:String,val url_image:String,val quantite:String, val list_pays_vendu:String,val list_ingredients:List<String>, val list_substance:String,val list_additif:String) {



    }
