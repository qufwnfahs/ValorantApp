package com.kjs.valorant.data.service

import retrofit2.http.GET
import retrofit2.http.Path

interface ValorantApiService {

    @GET("val/ranked/v1/leaderboards/by-act/{actId}")
    fun getLeaderboard(
        @Path("actId") actId: String
    ): Any

}
