package com.kjs.valorant.data.service

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

object ApiService {

    private val json = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
    }

    val valorant: ValorantApiService by lazy {
        val client = OkHttpClient.Builder()
            .addInterceptor(ValorantInterceptor())
            .addNetworkInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS))
            .build()

        Retrofit.Builder()
            .baseUrl("https://kr.api.riotgames.com")
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .client(client)
            .build()
            .create(ValorantApiService::class.java)
    }

}
