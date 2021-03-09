package com.example.firstapp.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.firstapp.databinding.ProductDetailsSummaryFragmentBinding
import com.example.firstapp.network.NetworkManager
import kotlinx.coroutines.*
import java.util.concurrent.TimeUnit


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

        val barcode = ProductDetailsFragmentArgs.fromBundle(
            requireParentFragment().requireParentFragment().requireArguments())
            .barcode

        binding.progressBar.visibility = View.VISIBLE

        GlobalScope.launch(Dispatchers.Default) {
            delay(TimeUnit.SECONDS.toMillis(5))

            NetworkManager.launchProductRequest(
                barcode
            ).response?.toProduct()?.let { product ->
                withContext(Dispatchers.Main) {
                    binding.TPois.text = product.nom
                    binding.subTitle.text = product.marque
                    binding.tcodebar.text = product.code_barres
                    binding.tvendu.text = product.list_pays_vendu
                    binding.tingredient.text = product.list_ingredients.joinToString(" , ")
                    binding.tsubstances.text = product.list_substance
                    binding.tadditifs.text = product.list_additif

                    Glide.with(requireActivity())
                        .load(product.url_image)
                        .into(binding.plat)

                    binding.progressBar.visibility = View.GONE
                }
            }
        }
    }
}