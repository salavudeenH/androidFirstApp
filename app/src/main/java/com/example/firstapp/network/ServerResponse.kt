package com.example.firstapp.network

import com.example.firstapp.ui.model.Product
import com.google.gson.annotations.SerializedName

data class ServerResponse(
    @SerializedName("error")
    val error: String?,
    @SerializedName("response")
    val response: Response?
) {
    data class Response(
        @SerializedName("additives")
        val additives: Map<String, String>,
        @SerializedName("allergens")
        val allergens: List<String>,
        @SerializedName("altName")
        val altName: String,
        @SerializedName("barcode")
        val barcode: String,
        @SerializedName("brands")
        val brands: List<String>,
        @SerializedName("containsPalmOil")
        val containsPalmOil: Boolean,
        @SerializedName("ingredients")
        val ingredients: List<String>,
        @SerializedName("manufacturingCountries")
        val manufacturingCountries: List<String>,
        @SerializedName("name")
        val name: String,
        @SerializedName("novaScore")
        val novaScore: String,
        @SerializedName("nutriScore")
        val nutriScore: String,
        @SerializedName("nutritionFacts")
        val nutritionFacts: NutritionFacts,
        @SerializedName("picture")
        val picture: String,
        @SerializedName("quantity")
        val quantity: String,
        @SerializedName("traces")
        val traces: List<String>
    ) {

        fun toProduct(): Product {
            return Product(
                nom = name,
                marque = brands.joinToString(", "),
                code_barres = barcode,
                nutriscores = nutriScore,
                url_image = picture,
                quantite = quantity,
                list_pays_vendu = manufacturingCountries.joinToString(", "),
                list_ingredients = ingredients,
                list_substance = allergens.joinToString(", "),
                list_additif = additives.toString(),
            )
        }

    }

    data class NutritionFacts(
        @SerializedName("calories")
        val calories: NutritionFact?,
        @SerializedName("carbohydrate")
        val carbohydrate: NutritionFact?,
        @SerializedName("energy")
        val energy: NutritionFact?,
        @SerializedName("fat")
        val fat: NutritionFact?,
        @SerializedName("fiber")
        val fiber: NutritionFact?,
        @SerializedName("proteins")
        val proteins: NutritionFact?,
        @SerializedName("salt")
        val salt: NutritionFact?,
        @SerializedName("saturatedFat")
        val saturatedFat: NutritionFact?,
        @SerializedName("servingSize")
        val servingSize: String?,
        @SerializedName("sodium")
        val sodium: NutritionFact?,
        @SerializedName("sugar")
        val sugar: NutritionFact?
    ) {
        data class NutritionFact(
            @SerializedName("per100g")
            val per100g: String?,
            @SerializedName("perServing")
            val perServing: String?,
            @SerializedName("unit")
            val unit: String?
        )
    }
}