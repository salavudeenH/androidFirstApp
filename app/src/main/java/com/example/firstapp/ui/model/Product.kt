package com.example.firstapp.ui.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(
    val nom: String,
    val marque: String,
    val code_barres: String,
    val nutriscores: String,
    val url_image: String,
    val quantite: String,
    val list_pays_vendu: String,
    val list_ingredients: List<String>,
    val list_substance: String,
    val list_additif: String
) : Parcelable