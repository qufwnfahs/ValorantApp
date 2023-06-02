package com.kjs.valorant.data.service

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ValorantApiService {

    @GET("val/ranked/v1/leaderboards/by-act/{actId}")
    fun getLeaderboard(
        @Path("actId") actId: String,
        @Query("size") size: Int = 200,
        @Query("startIndex") startIndex: Int
    ): Any

}
