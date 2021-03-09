package com.example.firstapp.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object NetworkManager {

    val api = Retrofit.Builder()
        .baseUrl("https://api.formation-android.fr")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
        .create(API::class.java)

    suspend fun launchProductRequest(barcode: String): ServerResponse {
        return api.getProduct(barcode).await()
    }

}

interface API {
    @GET("getProduct")
    fun getProduct(@Query("barcode") barcode: String):
            Deferred<ServerResponse>
}