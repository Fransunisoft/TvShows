package com.fransunisoft.tvshows

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.fransunisoft.tvshow.models.MovieData
import com.fransunisoft.tvshows.network.MoviesRepository

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MoviesRepository.getTopRatedMovies(
            onSuccess = ::fetchMovies,
            onError = ::onError
        )
    }

    private fun fetchMovies(movieData: List<MovieData>) {
        Log.d("MainActivity", "Movies: $movieData")
    }

    private fun onError() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
    }

}