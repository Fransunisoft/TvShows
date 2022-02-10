package com.fransunisoft.tvshow.network

import com.fransunisoft.tvshow.models.GetMovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("tv/top_rated")
    fun getTopRated(
        @Query("api_key") apiKey: String = "a718ab28db6b947ba6f7fd7395e773d5",
        @Query("page") page: Int,
    ): Call<GetMovieResponse>
}