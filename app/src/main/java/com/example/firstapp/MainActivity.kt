package com.example.firstapp

import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.firstapp.databinding.*
import kotlinx.android.synthetic.main.details_tab_summary.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Utiliser le layout nutritional_facts
       // val binding = ProductDetailsFragmentBinding.inflate(layoutInflater)
        //val view = binding.root
        //setContentView(view)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<ProductDetailsFragment>(R.id.product_details_nav_host)
            }
        }

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
       /* val product = Product( "Carrotes","Clem","367830373833","E","https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg","400g","France, Japon, Suisse", listOf("Sel", "carootes","cvnfjnvf"),"Aucune","Aucun")
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


*/
        Debug.startMethodTracing("sample")

    }
}


// Adapter = que dois-je afficher ?
class ListAdapter(val products: List<Product>) : RecyclerView.Adapter<ProductViewHolder>() {

    // Combien y a-t-il d'éléments dans la liste
    override fun getItemCount(): Int {
        return products.size
    }

    // Comment créer 1 cellule
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        // Donner le XML
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context))
        return ProductViewHolder(binding)
    }

    // Que faut-il afficher à la position [position]
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bindProduct(products[position], position)
    }

}

// 1 cellule
class ProductViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bindProduct(product: Product, position: Int) {
        binding.TPois.text=product.nom
        binding.subTitle.text=product.marque
        binding.tcodebar.text=product.code_barres
        binding.tvendu.text=product.list_pays_vendu
        binding.tingredient.text=product.list_ingredients.joinToString  (" , " )
        binding.tsubstances.text=product.list_substance
        binding.tadditifs.text=product.list_additif

    }

}

