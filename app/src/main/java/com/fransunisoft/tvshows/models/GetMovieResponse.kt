package com.fransunisoft.tvshow.models

import com.fransunisoft.tvshow.models.MovieData
import com.google.gson.annotations.SerializedName

data class GetMovieResponse (
    @SerializedName("page") val page: Int,
    @SerializedName("results") val movies: List<MovieData>,
    @SerializedName("total_pages") val pages: Int
)