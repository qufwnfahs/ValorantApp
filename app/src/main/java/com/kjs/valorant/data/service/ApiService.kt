package com.kjs.valorant.data.service

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

object ApiService {

    private val json = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
    }

    val valorant: ValorantApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://kr.api.riotgames.com")
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
            .create(ValorantApiService::class.java)
    }

}
