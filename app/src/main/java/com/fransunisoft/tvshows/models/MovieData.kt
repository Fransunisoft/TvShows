package com.fransunisoft.tvshow.models

import com.google.gson.annotations.SerializedName

data class MovieData(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("vote_average") val rating: Float,
)
