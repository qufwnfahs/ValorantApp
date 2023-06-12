package com.kjs.valorant.data.service

import com.kjs.valorant.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class ValorantInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request().newBuilder()
            .addHeader("X-Riot-Token", BuildConfig.X_RIOT_TOKEN)
            .build()

        return chain.proceed(newRequest)
    }

}
