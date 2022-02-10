package com.fransunisoft.tvshows

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fransunisoft.tvshows.network.MoviesRepository

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MoviesRepository.getTopRatedMovies()

    }
}