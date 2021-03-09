package com.example.firstapp.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.firstapp.R
import com.example.firstapp.databinding.ProductDetailsFragmentBinding

class ProductDetailsFragment : Fragment() {
    private lateinit var binding: ProductDetailsFragmentBinding

    // Equivalent du setContentView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ProductDetailsFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //val navHost = childFragmentManager.findFragmentById(R.id.product_details_nav_host) as NavHostFragment
        //NavigationUI.setupWithNavController(binding.productDetailsBottomNav, navHost.navController)
    }

}