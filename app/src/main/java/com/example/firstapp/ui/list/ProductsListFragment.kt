package com.example.firstapp.ui.list

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.R
import com.example.firstapp.databinding.ListBinding
import com.example.firstapp.databinding.ListItemBinding
import com.example.firstapp.ui.model.Product

class ProductsListFragment : Fragment(), ProductsListAdapter.OnProductItemClicked {

    companion object {

        private const val REQUEST_CODE_SCAN = 100

    }

    private lateinit var binding: ListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

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
                nom = "Twix",
                marque = "Marque du produit",
                list_additif = "aucune",
                code_barres = "5000159484695",
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
        binding.recyclerView.adapter =
            ProductsListAdapter(products, this)

    }

    override fun onProductClicked(product: Product) {
        openDetails(product.code_barres)
    }

    private fun openDetails(barcode: String) {
        findNavController().navigate(
            ProductsListFragmentDirections.actionProductsListFragmentToProductDetailsFragment(
                barcode
            )
        )
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.product_list, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.scan_product) {
            startActivityForResult(Intent().apply {
                action = "com.google.zxing.client.android.SCAN"
                putExtra("SCAN_FORMATS", "EAN_13")
            }, REQUEST_CODE_SCAN)

            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_SCAN && data != null) {
            data.getStringExtra("SCAN_RESULT")?.let { barcode ->
                openDetails(barcode)
            }
        }
    }
}


// Adapter = que dois-je afficher ?
class ProductsListAdapter(val products: List<Product>, val callback: OnProductItemClicked) : RecyclerView.Adapter<ProductViewHolder>() {

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
        products[position].let { product ->
            holder.bindProduct(product, position)
            holder.itemView.setOnClickListener {
                callback.onProductClicked(product)
            }
        }
    }

    interface OnProductItemClicked {
        fun onProductClicked(product: Product)
    }
}

// 1 cellule
class ProductViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bindProduct(product: Product, position: Int) {
        binding.TPois.text = product.nom
        binding.subTitle.text = product.marque
        binding.tcodebar.text = product.code_barres
        binding.tvendu.text = product.list_pays_vendu
        binding.tingredient.text = product.list_ingredients.joinToString(" , ")
        binding.tsubstances.text = product.list_substance
        binding.tadditifs.text = product.list_additif

    }

}

